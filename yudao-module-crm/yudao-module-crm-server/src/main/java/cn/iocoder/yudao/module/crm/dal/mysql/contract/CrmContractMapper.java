package cn.iocoder.yudao.module.crm.dal.mysql.contract;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.MPJLambdaWrapperX;
import cn.iocoder.yudao.module.crm.controller.admin.contract.vo.contract.CrmContractPageReqVO;
import cn.iocoder.yudao.module.crm.dal.dataobject.contract.CrmContractConfigDO;
import cn.iocoder.yudao.module.crm.dal.dataobject.contract.CrmContractDO;
import cn.iocoder.yudao.module.crm.enums.common.CrmAuditStatusEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmBizTypeEnum;
import cn.iocoder.yudao.module.crm.enums.common.CrmSceneTypeEnum;
import cn.iocoder.yudao.module.crm.util.CrmPermissionUtils;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * CRM 合同 Mapper
 *
 * @author dhb52
 */
@Mapper
public interface CrmContractMapper extends BaseMapperX<CrmContractDO> {

    default CrmContractDO selectByNo(String no) {
        return selectOne(CrmContractDO::getNo, no);
    }

    default PageResult<CrmContractDO> selectPageByCustomerId(CrmContractPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<CrmContractDO>()
                .eq(CrmContractDO::getCustomerId, pageReqVO.getCustomerId())
                .likeIfPresent(CrmContractDO::getNo, pageReqVO.getNo())
                .likeIfPresent(CrmContractDO::getName, pageReqVO.getName())
                .eqIfPresent(CrmContractDO::getCustomerId, pageReqVO.getCustomerId())
                .eqIfPresent(CrmContractDO::getBusinessId, pageReqVO.getBusinessId())
                .orderByDesc(CrmContractDO::getId));
    }

    default PageResult<CrmContractDO> selectPageByBusinessId(CrmContractPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<CrmContractDO>()
                .eq(CrmContractDO::getBusinessId, pageReqVO.getBusinessId())
                .likeIfPresent(CrmContractDO::getNo, pageReqVO.getNo())
                .likeIfPresent(CrmContractDO::getName, pageReqVO.getName())
                .eqIfPresent(CrmContractDO::getCustomerId, pageReqVO.getCustomerId())
                .eqIfPresent(CrmContractDO::getBusinessId, pageReqVO.getBusinessId())
                .orderByDesc(CrmContractDO::getId));
    }

    default PageResult<CrmContractDO> selectPage(CrmContractPageReqVO pageReqVO, Long userId, CrmContractConfigDO config) {
        MPJLambdaWrapperX<CrmContractDO> query = new MPJLambdaWrapperX<>();
        // 拼接数据权限的查询条件
        CrmPermissionUtils.appendPermissionCondition(query, CrmBizTypeEnum.CRM_CONTRACT.getType(),
                CrmContractDO::getId, userId, pageReqVO.getSceneType());
        // 拼接自身的查询条件
        query.selectAll(CrmContractDO.class)
                .likeIfPresent(CrmContractDO::getNo, pageReqVO.getNo())
                .likeIfPresent(CrmContractDO::getName, pageReqVO.getName())
                .eqIfPresent(CrmContractDO::getCustomerId, pageReqVO.getCustomerId())
                .eqIfPresent(CrmContractDO::getBusinessId, pageReqVO.getBusinessId())
                .eqIfPresent(CrmContractDO::getAuditStatus, pageReqVO.getAuditStatus())
                .inIfPresent(CrmContractDO::getProcessInstanceId, pageReqVO.getProcessInstanceIds())
                .betweenIfPresent(CrmContractDO::getOrderDate, pageReqVO.getOrderDate())
                .betweenIfPresent(CrmContractDO::getCreateTime, pageReqVO.getCreateTime())
                .orderByDesc(CrmContractDO::getId);

        // Backlog: 即将到期的合同
        LocalDateTime beginOfToday = LocalDateTimeUtil.beginOfDay(LocalDateTime.now());
        LocalDateTime endOfToday = LocalDateTimeUtil.endOfDay(LocalDateTime.now());
        if (CrmContractPageReqVO.EXPIRY_TYPE_ABOUT_TO_EXPIRE.equals(pageReqVO.getExpiryType())) { // 即将到期
            query.eq(CrmContractDO::getAuditStatus, CrmAuditStatusEnum.APPROVE.getStatus())
                    .between(CrmContractDO::getEndTime, beginOfToday, endOfToday.plusDays(config.getNotifyDays()));
        } else if (CrmContractPageReqVO.EXPIRY_TYPE_EXPIRED.equals(pageReqVO.getExpiryType())) { // 已到期
            query.eq(CrmContractDO::getAuditStatus, CrmAuditStatusEnum.APPROVE.getStatus())
                    .lt(CrmContractDO::getEndTime, endOfToday);
        }
        // Backlog: 今日合同跟进（与线索/客户/商机一致：下次联系 / 最近跟进）
        if (ObjUtil.isNotNull(pageReqVO.getContactStatus())) {
            if (pageReqVO.getContactStatus().equals(CrmContractPageReqVO.CONTACT_TODAY)) {
                query.between(CrmContractDO::getContactNextTime, beginOfToday, endOfToday);
            } else if (pageReqVO.getContactStatus().equals(CrmContractPageReqVO.CONTACT_EXPIRED)) {
                query.lt(CrmContractDO::getContactNextTime, beginOfToday);
            } else if (pageReqVO.getContactStatus().equals(CrmContractPageReqVO.CONTACT_ALREADY)) {
                query.between(CrmContractDO::getContactLastTime, beginOfToday, endOfToday);
            } else {
                throw new IllegalArgumentException("Unknown contact status: " + pageReqVO.getContactStatus());
            }
        }
        return selectJoinPage(pageReqVO, CrmContractDO.class, query);
    }

    default Long selectCountByContactId(Long contactId) {
        return selectCount(CrmContractDO::getSignContactId, contactId);
    }

    default Long selectCountByBusinessId(Long businessId) {
        return selectCount(CrmContractDO::getBusinessId, businessId);
    }

    default Long selectCountByProcessInstanceIds(Collection<String> processInstanceIds) {
        if (processInstanceIds == null || processInstanceIds.isEmpty()) {
            return 0L;
        }
        return selectCount(new LambdaQueryWrapperX<CrmContractDO>()
                .in(CrmContractDO::getProcessInstanceId, processInstanceIds)
                .eq(CrmContractDO::getAuditStatus, CrmAuditStatusEnum.PROCESS.getStatus()));
    }

    default Long selectCountByRemind(Long userId, CrmContractConfigDO config) {
        MPJLambdaWrapperX<CrmContractDO> query = new MPJLambdaWrapperX<>();
        // 我负责的 + 非公海
        CrmPermissionUtils.appendPermissionCondition(query, CrmBizTypeEnum.CRM_CONTRACT.getType(),
                CrmContractDO::getId, userId, CrmSceneTypeEnum.OWNER.getType());
        // 即将到期
        LocalDateTime beginOfToday = LocalDateTimeUtil.beginOfDay(LocalDateTime.now());
        LocalDateTime endOfToday = LocalDateTimeUtil.endOfDay(LocalDateTime.now());
        query.eq(CrmContractDO::getAuditStatus, CrmAuditStatusEnum.APPROVE.getStatus()) // Must approved!
                .between(CrmContractDO::getEndTime, beginOfToday, endOfToday.plusDays(config.getNotifyDays()));
        return selectCount(query);
    }

    default List<CrmContractDO> selectListByCustomerIdOwnerUserId(Long customerId, Long ownerUserId) {
        return selectList(new LambdaQueryWrapperX<CrmContractDO>()
                .eq(CrmContractDO::getCustomerId, customerId)
                .eq(CrmContractDO::getOwnerUserId, ownerUserId));
    }

    default List<CrmContractDO> selectListByFollowRemindDue(LocalDateTime now) {
        return selectList(new LambdaQueryWrapperX<CrmContractDO>()
                .isNotNull(CrmContractDO::getContactNextTime)
                .isNotNull(CrmContractDO::getOwnerUserId)
                .eq(CrmContractDO::getContactReminded, false)
                .between(CrmContractDO::getContactNextTime, now.minusDays(1), now)
                .last("LIMIT 200"));
    }

    /**
     * 合同到期提醒候选：已审批、有结束时间、未提醒
     */
    default List<CrmContractDO> selectListByExpiryRemindCandidate() {
        return selectList(new LambdaQueryWrapperX<CrmContractDO>()
                .eq(CrmContractDO::getAuditStatus, CrmAuditStatusEnum.APPROVE.getStatus())
                .isNotNull(CrmContractDO::getEndTime)
                .isNotNull(CrmContractDO::getOwnerUserId)
                .eq(CrmContractDO::getExpiryReminded, false)
                .last("LIMIT 500"));
    }

}
