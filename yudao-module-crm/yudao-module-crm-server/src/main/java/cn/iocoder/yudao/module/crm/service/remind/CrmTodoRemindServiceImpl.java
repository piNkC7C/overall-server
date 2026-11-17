package cn.iocoder.yudao.module.crm.service.remind;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.tenant.core.context.TenantContextHolder;
import cn.iocoder.yudao.module.crm.dal.redis.RedisKeyConstants;
import cn.iocoder.yudao.module.crm.service.clue.CrmClueService;
import cn.iocoder.yudao.module.crm.service.contract.CrmContractService;
import cn.iocoder.yudao.module.crm.service.customer.CrmCustomerService;
import cn.iocoder.yudao.module.crm.service.receivable.CrmReceivablePlanService;
import cn.iocoder.yudao.module.crm.service.receivable.CrmReceivableService;
import cn.iocoder.yudao.module.system.api.notify.NotifyMessageSendApi;
import cn.iocoder.yudao.module.system.api.notify.dto.NotifySendSingleToUserReqDTO;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CRM 待办每日提醒：按类型推送站内信（跟进 / 审批 / 合同到期 / 回款）
 * <p>
 * 模板文案以实体 {name} 为主；日报 Job 暂无逐条实体时，用汇总名称占位并跳转到待办列表。
 */
@Service
@Slf4j
public class CrmTodoRemindServiceImpl implements CrmTodoRemindService {

    public static final String TEMPLATE_AUDIT = "crm_audit_remind";
    public static final String TEMPLATE_CONTRACT_EXPIRY = "crm_contract_expiry";
    public static final String TEMPLATE_CUSTOMER_FOLLOW_TODAY = "crm_customer_follow_today";
    public static final String TEMPLATE_CLUE_FOLLOW_TODAY = "crm_clue_follow_today";
    public static final String TEMPLATE_CUSTOMER_POOL = "crm_customer_pool_remind";
    public static final String TEMPLATE_BUSINESS_FOLLOW_TODAY = "crm_business_follow_today";
    public static final String TEMPLATE_CONTRACT_FOLLOW_TODAY = "crm_contract_follow_today";

    @Resource
    private AdminUserApi adminUserApi;
    @Resource
    private NotifyMessageSendApi notifyMessageSendApi;
    @Resource
    private CrmCustomerService customerService;
    @Resource
    private CrmClueService clueService;
    @Resource
    private CrmContractService contractService;
    @Resource
    private CrmReceivableService receivableService;
    @Resource
    private CrmReceivablePlanService receivablePlanService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public int sendDailyTodoRemind() {
        List<AdminUserRespDTO> users = adminUserApi.getUserListByStatus(CommonStatusEnum.ENABLE.getStatus())
                .getCheckedData();
        if (CollUtil.isEmpty(users)) {
            return 0;
        }
        Long tenantId = TenantContextHolder.getTenantId();
        String day = LocalDateTimeUtil.format(LocalDate.now(), DatePattern.PURE_DATE_PATTERN);
        int sent = 0;
        for (AdminUserRespDTO user : users) {
            if (user == null || user.getId() == null) {
                continue;
            }
            try {
                sent += sendForUser(tenantId, user.getId(), day);
            } catch (Exception ex) {
                log.warn("[sendDailyTodoRemind][tenantId({}) userId({}) 发送失败]", tenantId, user.getId(), ex);
            }
        }
        return sent;
    }

    private int sendForUser(Long tenantId, Long userId, String day) {
        long todayCount = nvl(customerService.getTodayContactCustomerCount(userId));
        long followCustomerCount = nvl(customerService.getFollowCustomerCount(userId));
        long followClueCount = nvl(clueService.getFollowClueCount(userId));
        long poolCount = nvl(customerService.getPutPoolRemindCustomerCount(userId));
        long contractAuditCount = nvl(contractService.getAuditContractCount(userId));
        long contractRemindCount = nvl(contractService.getRemindContractCount(userId));
        long receivableAuditCount = nvl(receivableService.getAuditReceivableCount(userId));

        int sent = 0;
        if (todayCount > 0 || followCustomerCount > 0) {
            long count = todayCount > 0 ? todayCount : followCustomerCount;
            if (trySend(tenantId, userId, day, TEMPLATE_CUSTOMER_FOLLOW_TODAY,
                    nameParams("今日待跟进客户共" + count + "个", "/crm/backlog?menu=customerTodayContact"))) {
                sent++;
            }
        }
        if (followClueCount > 0) {
            if (trySend(tenantId, userId, day, TEMPLATE_CLUE_FOLLOW_TODAY,
                    nameParams("今日待跟进线索共" + followClueCount + "条", "/crm/backlog?menu=clueFollow"))) {
                sent++;
            }
        }
        if (poolCount > 0) {
            if (trySend(tenantId, userId, day, TEMPLATE_CUSTOMER_POOL,
                    nameParams("即将入公海客户共" + poolCount + "个", "/crm/backlog?menu=customerPutPoolRemind"))) {
                sent++;
            }
        }
        if (contractRemindCount > 0) {
            if (trySend(tenantId, userId, day, TEMPLATE_CONTRACT_EXPIRY,
                    nameParams("即将到期合同共" + contractRemindCount + "份", "/crm/backlog?menu=contractRemind"))) {
                sent++;
            }
        }
        // 待审批：汇总占位（真正审批节点由 BPM 推送带 processInstanceName 的站内信）
        long auditTotal = contractAuditCount + receivableAuditCount;
        if (auditTotal > 0) {
            Map<String, Object> params = new HashMap<>();
            params.put("processInstanceName", "CRM审批待办");
            params.put("taskName", "共" + auditTotal + "项");
            params.put("startUserNickname", "系统");
            params.put("processInstanceId", "");
            params.put("route", "/crm/backlog?menu=contractAudit");
            if (trySend(tenantId, userId, day, TEMPLATE_AUDIT, params)) {
                sent++;
            }
        }
        return sent;
    }

    private static Map<String, Object> nameParams(String name, String route) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("id", "");
        params.put("route", route);
        return params;
    }

    private boolean trySend(Long tenantId, Long userId, String day, String templateCode, Map<String, Object> params) {
        String lockKey = String.format(RedisKeyConstants.TODO_DAILY_REMIND,
                tenantId != null ? tenantId : 0L, userId + ":" + templateCode, day);
        Boolean locked = stringRedisTemplate.opsForValue()
                .setIfAbsent(lockKey, "1", Duration.ofHours(26));
        if (!Boolean.TRUE.equals(locked)) {
            return false;
        }
        try {
            notifyMessageSendApi.sendSingleMessageToAdmin(new NotifySendSingleToUserReqDTO()
                    .setUserId(userId)
                    .setTemplateCode(templateCode)
                    .setTemplateParams(params)).checkError();
            return true;
        } catch (RuntimeException ex) {
            stringRedisTemplate.delete(lockKey);
            throw ex;
        }
    }

    private static long nvl(Long value) {
        return value == null ? 0L : value;
    }

}
