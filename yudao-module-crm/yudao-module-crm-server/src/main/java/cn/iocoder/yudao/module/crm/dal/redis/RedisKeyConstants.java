package cn.iocoder.yudao.module.crm.dal.redis;

/**
 * CRM Redis Key 枚举类
 *
 * @author 芋道源码
 */
public interface RedisKeyConstants {

    /**
     * 序号的缓存
     *
     * KEY 格式：trade_no:{prefix}
     * VALUE 数据格式：编号自增
     */
    String NO = "crm:seq_no:";

    /**
     * 每日 CRM 待办站内信去重
     *
     * KEY 格式：crm:todo_daily_remind:{tenantId}:{userId}:{yyyyMMdd}
     * VALUE：1
     */
    String TODO_DAILY_REMIND = "crm:todo_daily_remind:%s:%s:%s";

}
