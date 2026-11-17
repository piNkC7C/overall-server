package cn.iocoder.yudao.module.crm.service.remind;

/**
 * CRM 待办每日提醒
 */
public interface CrmTodoRemindService {

    /**
     * 给当前租户下有待办的用户发送一条汇总站内信（每天每用户最多一次）
     *
     * @return 成功发送条数
     */
    int sendDailyTodoRemind();

}
