package cn.iocoder.yudao.module.hrm.enums.employee.info;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.framework.common.util.collection.SetUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Set;

/**
 * HRM 员工入职状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmEmployeeEntryStatusEnum implements ArrayValuable<Integer> {

    ACTIVE(1, "Active"),
    PENDING_ENTRY(2, "Pending hire"),
    PENDING_LEAVE(3, "Pending offboard"),
    LEFT(4, "Offboarding");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmEmployeeEntryStatusEnum::getStatus).toArray(Integer[]::new);

    public static final Set<Integer> ACTIVE_STATUSES = SetUtils.asSet(
            ACTIVE.getStatus(), PENDING_LEAVE.getStatus());

    private final Integer status;
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmEmployeeEntryStatusEnum valueOf(Integer status) {
        return ArrayUtil.firstMatch(item -> item.getStatus().equals(status), values());
    }

}
