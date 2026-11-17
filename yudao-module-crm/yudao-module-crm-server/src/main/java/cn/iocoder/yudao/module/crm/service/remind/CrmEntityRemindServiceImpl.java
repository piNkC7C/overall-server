package cn.iocoder.yudao.module.crm.service.remind;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.iocoder.yudao.module.crm.dal.dataobject.business.CrmBusinessDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.clue.CrmClueDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.contract.CrmContractConfigDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.contract.CrmContractDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.customer.CrmCustomerDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.customer.CrmCustomerPoolConfigDO;
import cn.iocoder.yudao.module.crm.dal.mysql.business.CrmBusinessMapper;
import cn.iocoder.yudao.module.crm.dal.mysql.clue.CrmClueMapper;
import cn.iocoder.yudao.module.crm.dal.mysql.contract.CrmContractMapper;
import cn.iocoder.yudao.module.crm.dal.mysql.customer.CrmCustomerMapper;
import cn.iocoder.yudao.module.crm.enums.common.CrmAuditStatusEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmBizTypeEnum;
import cn.iocoder.yudao.module.crm.service.contract.CrmContractConfigService;
import cn.iocoder.yudao.module.crm.service.customer.CrmCustomerPoolConfigService;
import cn.iocoder.yudao.module.system.api.notify.NotifyMessageSendApi;
import cn.iocoder.yudao.module.system.api.notify.dto.NotifySendSingleToUserReqDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * CRM 实体事件驱动站内信：跟进 / 公海 / 合同到期（仿 OA 日程：到点窗口 + reminded 打标）
 */
@Service
@Slf4j
public class CrmEntityRemindServiceImpl implements CrmEntityRemindService {

    public static final String TEMPLATE_CLUE_FOLLOW = "crm_clue_follow_today";
    public static final String TEMPLATE_CUSTOMER_FOLLOW = "crm_customer_follow_today";
    public static final String TEMPLATE_BUSINESS_FOLLOW = "crm_business_follow_today";
    public static final String TEMPLATE_CONTRACT_FOLLOW = "crm_contract_follow_today";
    public static final String TEMPLATE_CUSTOMER_POOL = "crm_customer_pool_remind";
    public static final String TEMPLATE_CONTRACT_EXPIRY = "crm_contract_expiry";

    @Resource
    private NotifyMessageSendApi notifyMessageSendApi;
    @Resource
    private CrmCustomerMapper customerMapper;
    @Resource
    private CrmClueMapper clueMapper;
    @Resource
    private CrmBusinessMapper businessMapper;
    @Resource
    private CrmContractMapper contractMapper;
    @Resource
    private CrmCustomerPoolConfigService customerPoolConfigService;
    @Resource
    private CrmContractConfigService contractConfigService;

    @Override
    public int sendDueEntityReminds() {
        LocalDateTime now = LocalDateTime.now();
        int sent = 0;
        for (CrmCustomerDO customer : customerMapper.selectListByFollowRemindDue(now)) {
            try {
                sent += getSelf().trySendFollowIfDue(CrmBizTypeEnum.CRM_CUSTOMER.getType(), customer.getId()) ? 1 : 0;
            } catch (Exception ex) {
                log.warn("[sendDueEntityReminds][客户跟进提醒失败 id={}]", customer.getId(), ex);
            }
        }
        for (CrmClueDO clue : clueMapper.selectListByFollowRemindDue(now)) {
            try {
                sent += getSelf().trySendFollowIfDue(CrmBizTypeEnum.CRM_CLUE.getType(), clue.getId()) ? 1 : 0;
            } catch (Exception ex) {
                log.warn("[sendDueEntityReminds][线索跟进提醒失败 id={}]", clue.getId(), ex);
            }
        }
        for (CrmBusinessDO business : businessMapper.selectListByFollowRemindDue(now)) {
            try {
                sent += getSelf().trySendFollowIfDue(CrmBizTypeEnum.CRM_BUSINESS.getType(), business.getId()) ? 1 : 0;
            } catch (Exception ex) {
                log.warn("[sendDueEntityReminds][商机跟进提醒失败 id={}]", business.getId(), ex);
            }
        }
        for (CrmContractDO contract : contractMapper.selectListByFollowRemindDue(now)) {
            try {
                sent += getSelf().trySendFollowIfDue(CrmBizTypeEnum.CRM_CONTRACT.getType(), contract.getId()) ? 1 : 0;
            } catch (Exception ex) {
                log.warn("[sendDueEntityReminds][合同跟进提醒失败 id={}]", contract.getId(), ex);
            }
        }
        for (CrmCustomerDO customer : customerMapper.selectListByPoolRemindCandidate()) {
            try {
                sent += getSelf().trySendPoolIfDue(customer.getId()) ? 1 : 0;
            } catch (Exception ex) {
                log.warn("[sendDueEntityReminds][公海提醒失败 id={}]", customer.getId(), ex);
            }
        }
        for (CrmContractDO contract : contractMapper.selectListByExpiryRemindCandidate()) {
            try {
                sent += getSelf().trySendExpiryIfDue(contract.getId()) ? 1 : 0;
            } catch (Exception ex) {
                log.warn("[sendDueEntityReminds][合同到期提醒失败 id={}]", contract.getId(), ex);
            }
        }
        return sent;
    }

    @Override
    public void scheduleFollowRemindAfterCommit(Integer bizType, Long bizId) {
        runAfterCommit(() -> {
            try {
                getSelf().trySendFollowIfDue(bizType, bizId);
            } catch (Exception ex) {
                log.warn("[scheduleFollowRemindAfterCommit][bizType={} bizId={} 补发失败]", bizType, bizId, ex);
            }
        });
    }

    @Override
    public void scheduleExpiryRemindAfterCommit(Long contractId) {
        runAfterCommit(() -> {
            try {
                getSelf().trySendExpiryIfDue(contractId);
            } catch (Exception ex) {
                log.warn("[scheduleExpiryRemindAfterCommit][contractId={} 补发失败]", contractId, ex);
            }
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean trySendFollowIfDue(Integer bizType, Long bizId) {
        LocalDateTime now = LocalDateTime.now();
        if (Objects.equals(bizType, CrmBizTypeEnum.CRM_CUSTOMER.getType())) {
            CrmCustomerDO customer = customerMapper.selectById(bizId);
            if (!isFollowDue(customer == null ? null : customer.getContactNextTime(),
                    customer == null ? null : customer.getContactReminded(),
                    customer == null ? null : customer.getOwnerUserId(), now)) {
                return false;
            }
            sendNotify(customer.getOwnerUserId(), TEMPLATE_CUSTOMER_FOLLOW,
                    followParams(customer.getName(), customer.getId(), "/crm/customer/detail/" + customer.getId()));
            customerMapper.updateById(new CrmCustomerDO().setId(customer.getId()).setContactReminded(true));
            return true;
        }
        if (Objects.equals(bizType, CrmBizTypeEnum.CRM_CLUE.getType())) {
            CrmClueDO clue = clueMapper.selectById(bizId);
            if (clue == null || Boolean.TRUE.equals(clue.getTransformStatus())) {
                return false;
            }
            if (!isFollowDue(clue.getContactNextTime(), clue.getContactReminded(), clue.getOwnerUserId(), now)) {
                return false;
            }
            sendNotify(clue.getOwnerUserId(), TEMPLATE_CLUE_FOLLOW,
                    followParams(clue.getName(), clue.getId(), "/crm/clue/detail/" + clue.getId()));
            clueMapper.updateById(new CrmClueDO().setId(clue.getId()).setContactReminded(true));
            return true;
        }
        if (Objects.equals(bizType, CrmBizTypeEnum.CRM_BUSINESS.getType())) {
            CrmBusinessDO business = businessMapper.selectById(bizId);
            if (!isFollowDue(business == null ? null : business.getContactNextTime(),
                    business == null ? null : business.getContactReminded(),
                    business == null ? null : business.getOwnerUserId(), now)) {
                return false;
            }
            sendNotify(business.getOwnerUserId(), TEMPLATE_BUSINESS_FOLLOW,
                    followParams(business.getName(), business.getId(), "/crm/business/detail/" + business.getId()));
            businessMapper.updateById(new CrmBusinessDO().setId(business.getId()).setContactReminded(true));
            return true;
        }
        if (Objects.equals(bizType, CrmBizTypeEnum.CRM_CONTRACT.getType())) {
            CrmContractDO contract = contractMapper.selectById(bizId);
            if (!isFollowDue(contract == null ? null : contract.getContactNextTime(),
                    contract == null ? null : contract.getContactReminded(),
                    contract == null ? null : contract.getOwnerUserId(), now)) {
                return false;
            }
            sendNotify(contract.getOwnerUserId(), TEMPLATE_CONTRACT_FOLLOW,
                    followParams(contract.getName(), contract.getId(), "/crm/contract/detail/" + contract.getId()));
            contractMapper.updateById(new CrmContractDO().setId(contract.getId()).setContactReminded(true));
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean trySendPoolIfDue(Long customerId) {
        CrmCustomerPoolConfigDO config = customerPoolConfigService.getCustomerPoolConfig();
        if (config == null || !Boolean.TRUE.equals(config.getEnabled()) || !Boolean.TRUE.equals(config.getNotifyEnabled())
                || config.getNotifyDays() == null || config.getContactExpireDays() == null
                || config.getDealExpireDays() == null) {
            return false;
        }
        CrmCustomerDO customer = customerMapper.selectById(customerId);
        if (customer == null || customer.getOwnerUserId() == null || customer.getOwnerUserId() <= 0
                || Boolean.TRUE.equals(customer.getLockStatus()) || Boolean.TRUE.equals(customer.getDealStatus())
                || Boolean.TRUE.equals(customer.getPoolReminded()) || customer.getOwnerTime() == null) {
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fireAt = earliestPoolFireAt(customer, config);
        if (fireAt == null || now.isBefore(fireAt)) {
            return false;
        }
        // 已过真正入公海时刻则不再发（由自动入海 Job 处理）
        LocalDateTime poolAt = earliestPoolPutAt(customer, config);
        if (poolAt != null && !now.isBefore(poolAt)) {
            return false;
        }
        sendNotify(customer.getOwnerUserId(), TEMPLATE_CUSTOMER_POOL,
                followParams(customer.getName(), customer.getId(), "/crm/customer/detail/" + customer.getId()));
        customerMapper.updateById(new CrmCustomerDO().setId(customer.getId()).setPoolReminded(true));
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean trySendExpiryIfDue(Long contractId) {
        CrmContractConfigDO config = contractConfigService.getContractConfig();
        if (config == null || !Boolean.TRUE.equals(config.getNotifyEnabled()) || config.getNotifyDays() == null) {
            return false;
        }
        CrmContractDO contract = contractMapper.selectById(contractId);
        if (contract == null || contract.getEndTime() == null || contract.getOwnerUserId() == null
                || !Objects.equals(contract.getAuditStatus(), CrmAuditStatusEnum.APPROVE.getStatus())
                || Boolean.TRUE.equals(contract.getExpiryReminded())) {
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fireAt = LocalDateTimeUtil.beginOfDay(contract.getEndTime().minusDays(config.getNotifyDays()));
        LocalDateTime expireAt = LocalDateTimeUtil.endOfDay(contract.getEndTime()).plusSeconds(1);
        if (now.isBefore(fireAt) || !now.isBefore(expireAt)) {
            return false;
        }
        sendNotify(contract.getOwnerUserId(), TEMPLATE_CONTRACT_EXPIRY,
                followParams(contract.getName(), contract.getId(), "/crm/contract/detail/" + contract.getId()));
        contractMapper.updateById(new CrmContractDO().setId(contract.getId()).setExpiryReminded(true));
        return true;
    }

    /**
     * 公海提醒开火：跟进超时与成交超时取更早的 fireAt
     */
    static LocalDateTime earliestPoolFireAt(CrmCustomerDO customer, CrmCustomerPoolConfigDO config) {
        LocalDateTime contactFire = null;
        if (config.getContactExpireDays() != null && config.getNotifyDays() != null) {
            LocalDateTime anchor = customer.getContactLastTime() != null
                    ? customer.getContactLastTime() : customer.getOwnerTime();
            if (anchor != null) {
                contactFire = anchor.plusDays(Math.max(config.getContactExpireDays() - config.getNotifyDays(), 0));
            }
        }
        LocalDateTime dealFire = null;
        if (config.getDealExpireDays() != null && config.getNotifyDays() != null && customer.getOwnerTime() != null) {
            dealFire = customer.getOwnerTime().plusDays(Math.max(config.getDealExpireDays() - config.getNotifyDays(), 0));
        }
        if (contactFire == null) {
            return dealFire;
        }
        if (dealFire == null) {
            return contactFire;
        }
        return contactFire.isBefore(dealFire) ? contactFire : dealFire;
    }

    static LocalDateTime earliestPoolPutAt(CrmCustomerDO customer, CrmCustomerPoolConfigDO config) {
        LocalDateTime contactPut = null;
        if (config.getContactExpireDays() != null) {
            LocalDateTime anchor = customer.getContactLastTime() != null
                    ? customer.getContactLastTime() : customer.getOwnerTime();
            if (anchor != null) {
                contactPut = anchor.plusDays(config.getContactExpireDays());
            }
        }
        LocalDateTime dealPut = null;
        if (config.getDealExpireDays() != null && customer.getOwnerTime() != null) {
            dealPut = customer.getOwnerTime().plusDays(config.getDealExpireDays());
        }
        if (contactPut == null) {
            return dealPut;
        }
        if (dealPut == null) {
            return contactPut;
        }
        return contactPut.isBefore(dealPut) ? contactPut : dealPut;
    }

    private static boolean isFollowDue(LocalDateTime contactNextTime, Boolean reminded, Long ownerUserId,
                                      LocalDateTime now) {
        if (contactNextTime == null || ownerUserId == null || ownerUserId <= 0 || Boolean.TRUE.equals(reminded)) {
            return false;
        }
        LocalDateTime expireAt = contactNextTime.plusDays(1);
        return !now.isBefore(contactNextTime) && now.isBefore(expireAt);
    }

    private static Map<String, Object> followParams(String name, Long id, String route) {
        Map<String, Object> params = new HashMap<>(4);
        params.put("name", name);
        params.put("id", id);
        params.put("route", route);
        return params;
    }

    private void sendNotify(Long userId, String templateCode, Map<String, Object> params) {
        notifyMessageSendApi.sendSingleMessageToAdmin(new NotifySendSingleToUserReqDTO()
                .setUserId(userId)
                .setTemplateCode(templateCode)
                .setTemplateParams(params)).checkError();
    }

    private static void runAfterCommit(Runnable action) {
        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            action.run();
            return;
        }
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                action.run();
            }
        });
    }

    private CrmEntityRemindServiceImpl getSelf() {
        return SpringUtil.getBean(getClass());
    }

}
