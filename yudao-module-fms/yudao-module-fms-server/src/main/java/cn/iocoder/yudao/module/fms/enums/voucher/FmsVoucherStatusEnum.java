package cn.iocoder.yudao.module.fms.enums.voucher;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * FMS 凭证状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum FmsVoucherStatusEnum implements ArrayValuable<Integer> {

    PENDING_REVIEW(0, "Pending review"),
    APPROVED(1, "Approved."),
    REJECTED(2, "Rejected"),
    REVIEWING(3, "Approval."),
    WITHDRAWN(4, "Already withdraw."),
    UNSUBMITTED(5, "Not submit."),
    CREATED(6, "Already create."),
    DELETED(7, "Already delete."),
    VOIDED(8, "Voided");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(FmsVoucherStatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static FmsVoucherStatusEnum valueOf(Integer status) {
        return ArrayUtil.firstMatch(item -> item.getStatus().equals(status), values());
    }

}
