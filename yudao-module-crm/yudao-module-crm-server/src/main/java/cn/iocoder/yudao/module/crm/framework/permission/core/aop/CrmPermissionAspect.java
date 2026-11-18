package cn.iocoder.yudao.module.crm.framework.permission.core.aop;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.util.spring.SpringExpressionUtils;
import cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils;
import cn.iocoder.yudao.module.crm.enums.common.CrmBizTypeEnum;
import cn.iocoder.yudao.module.crm.enums.permission.CrmPermissionLevelEnum;
import cn.iocoder.yudao.module.crm.framework.permission.core.annotations.CrmPermission;
import cn.iocoder.yudao.module.crm.service.permission.CrmPermissionService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.*;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.module.crm.enums.ErrorCodeConstants.CRM_PERMISSION_DENIED;

/**
 * Crm 数据权限校验 AOP 切面
 *
 * @author HUIHUI
 */
@Component
@Aspect
@Slf4j
public class CrmPermissionAspect {

    @Resource
    private CrmPermissionService crmPermissionService;

    @Before("@annotation(crmPermission)")
    public void doBefore(JoinPoint joinPoint, CrmPermission crmPermission) {
        // Matching issue：https://github.com/YunaiV/ruoyi-vue-pro/pull/1221
        // 0. 系统调用（定时任务/异步线程等，无登录用户）不走数据权限校验，直接放行。
        //    数据权限是“按登录用户”的访问控制；/admin-api 外部请求必然有登录用户，
        //    故登录用户为 null 只可能是系统内部调用（如公海自动掉落定时任务），属可信进程。
        //    若在此校验，isCrmAdmin() 会以 null 用户查缓存，抛 Null key 异常导致业务失败。
        if (getUserId() == null) {
            return;
        }
        // 1.1 获取相关属性值
        Map<String, Object> expressionValues = parseExpressions(joinPoint, crmPermission);
        Integer bizType = StrUtil.isEmpty(crmPermission.bizTypeValue()) ?
                crmPermission.bizType()[0].getType() : (Integer) expressionValues.get(crmPermission.bizTypeValue()); // Module type
        // 1.2 处理兼容多个 bizId 的情况（SpeL 结果为空时跳过，避免 NPE → 系统异常）
        Object object = expressionValues.get(crmPermission.bizId()); // Module data code
        if (object == null || bizType == null) {
            return;
        }
        Set<Long> bizIds = new HashSet<>();
        if (object instanceof Collection<?>) {
            bizIds.addAll(convertSet((Collection<?>) object, item -> Long.parseLong(item.toString())));
        } else {
            bizIds.add(Long.parseLong(object.toString()));
        }
        if (bizIds.isEmpty()) {
            return;
        }
        Integer permissionLevel = crmPermission.level().getLevel(); // Need to need permission level
        CrmPermissionLevelEnum level = resolveLevel(permissionLevel);

        // 2. 逐个校验。规则与 CrmPermissionService#hasPermission 相同：下属只继承读
        Long userId = getUserId();
        bizIds.forEach(bizId -> {
            if (level != null && crmPermissionService.hasPermission(bizType, bizId, userId, level)) {
                return;
            }
            log.info("[doBefore][userId({}) bizType({}) bizId({}) 要求权限({}) 数据校验错误]",
                    userId, bizType, bizId, permissionLevel);
            throw exception(CRM_PERMISSION_DENIED, CrmBizTypeEnum.getNameByType(bizType));
        });
    }

    private static CrmPermissionLevelEnum resolveLevel(Integer permissionLevel) {
        for (CrmPermissionLevelEnum item : CrmPermissionLevelEnum.values()) {
            if (ObjUtil.equal(item.getLevel(), permissionLevel)) {
                return item;
            }
        }
        return null;
    }

    /**
     * 获得用户编号
     *
     * @return 用户编号
     */
    private static Long getUserId() {
        return WebFrameworkUtils.getLoginUserId();
    }

    private static Map<String, Object> parseExpressions(JoinPoint joinPoint, CrmPermission crmPermission) {
        // 1. 需要解析的表达式
        List<String> expressionStrings = new ArrayList<>(2);
        expressionStrings.add(crmPermission.bizId());
        if (StrUtil.isNotEmpty(crmPermission.bizTypeValue())) { // 为空则表示 bizType 有值
            expressionStrings.add(crmPermission.bizTypeValue());
        }
        // 2. 执行解析
        return SpringExpressionUtils.parseExpressions(joinPoint, expressionStrings);
    }

}
