package cn.iocoder.yudao.module.crm.service.remind;

/**
 * CRM 实体事件驱动站内信（跟进 / 公海 / 合同到期）
 */
public interface CrmEntityRemindService {

    /**
     * 扫描并发送当前租户内到期的实体提醒
     *
     * @return 成功发送条数
     */
    int sendDueEntityReminds();

    /**
     * 下次跟进时间变更后：事务提交后再尝试补发
     *
     * @param bizType {@link cn.iocoder.yudao.module.crm.enums.common.CrmBizTypeEnum}
     * @param bizId   实体编号
     */
    void scheduleFollowRemindAfterCommit(Integer bizType, Long bizId);

    /**
     * 合同到期相关字段变更后：事务提交后再尝试补发
     *
     * @param contractId 合同编号
     */
    void scheduleExpiryRemindAfterCommit(Long contractId);

    /**
     * 发送单条跟进提醒（已到期才发）
     *
     * @param bizType 业务类型
     * @param bizId   实体编号
     * @return 是否发送成功
     */
    boolean trySendFollowIfDue(Integer bizType, Long bizId);

    /**
     * 发送单条公海提醒（已到期才发）
     *
     * @param customerId 客户编号
     * @return 是否发送成功
     */
    boolean trySendPoolIfDue(Long customerId);

    /**
     * 发送单条合同到期提醒（已到期才发）
     *
     * @param contractId 合同编号
     * @return 是否发送成功
     */
    boolean trySendExpiryIfDue(Long contractId);

}
