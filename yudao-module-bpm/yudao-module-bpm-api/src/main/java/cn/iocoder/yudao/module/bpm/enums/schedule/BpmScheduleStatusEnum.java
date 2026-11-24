package cn.iocoder.yudao.module.bpm.enums.schedule;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * BPM 日程执行状态：未执行/执行中/已结束/已取消
 */
@Getter
@AllArgsConstructor
public enum BpmScheduleStatusEnum implements ArrayValuable<Integer> {

    NOT_STARTED(0, "未执行"),
    IN_PROGRESS(1, "执行中"),
    FINISHED(2, "已结束"),
    CANCELLED(3, "已取消");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(BpmScheduleStatusEnum::getStatus).toArray(Integer[]::new);

    /** 可发站内信提醒的状态（已结束/已取消不提醒） */
    public static final Integer[] REMINDABLE_ARRAYS = new Integer[]{
            NOT_STARTED.status, IN_PROGRESS.status
    };

    private final Integer status;
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static boolean isRemindable(Integer status) {
        return status != null && (NOT_STARTED.status.equals(status) || IN_PROGRESS.status.equals(status));
    }

}
