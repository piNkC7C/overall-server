package cn.iocoder.yudao.module.oa.enums.schedule;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * OA 日程执行状态（对齐意向 CRM：未执行/执行中/已结束/已取消）
 */
@Getter
@AllArgsConstructor
public enum OaScheduleStatusEnum implements ArrayValuable<Integer> {

    NOT_STARTED(0, "未执行"),
    IN_PROGRESS(1, "执行中"),
    FINISHED(2, "已结束"),
    CANCELLED(3, "已取消");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(OaScheduleStatusEnum::getStatus).toArray(Integer[]::new);

    private final Integer status;
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
