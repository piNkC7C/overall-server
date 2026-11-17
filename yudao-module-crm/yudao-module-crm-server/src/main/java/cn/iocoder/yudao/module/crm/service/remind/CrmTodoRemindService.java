package cn.iocoder.yudao.module.crm.service.remind;

/**
 * @deprecated 日报汇总站内信已废弃，请使用 {@link CrmEntityRemindService}
 */
@Deprecated
public interface CrmTodoRemindService {

    /**
     * @deprecated 无实现，保留兼容旧调用
     */
    @Deprecated
    default int sendDailyTodoRemind() {
        return 0;
    }

}
