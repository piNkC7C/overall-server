package cn.iocoder.yudao.module.mes.enums.wm;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.module.mes.enums.MesOrderStatusConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * MES 转移单状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum MesWmTransferStatusEnum implements ArrayValuable<Integer> {

    /**
     * 草稿
     *
     * 对应 MesWmTransferService#createTransfer 方法
     */
    PREPARE(MesOrderStatusConstants.PREPARE, "Draft."),
    /**
     * 待确认（仅配送模式）
     *
     * 对应 MesWmTransferService#submitTransfer 方法
     */
    UNCONFIRMED(MesOrderStatusConstants.CONFIRMED, "Pending confirm"),
    /**
     * 待上架
     *
     * 对应 MesWmTransferService#submitTransfer 方法、MesWmTransferService#confirmTransfer 方法
     */
    APPROVING(MesOrderStatusConstants.APPROVING, "Waiting to put away."),
    /**
     * 待执行
     *
     * 对应 MesWmTransferService#stockTransfer 方法
     */
    APPROVED(MesOrderStatusConstants.APPROVED, "Pending"),
    /**
     * 已完成
     *
     * 对应 MesWmTransferService#finishTransfer 方法
     */
    FINISHED(MesOrderStatusConstants.FINISHED, "Completed."),
    /**
     * 已取消
     *
     * 对应 MesWmTransferService#cancelTransfer 方法
     */
    CANCELED(MesOrderStatusConstants.CANCELLED, "Canceled.");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(MesWmTransferStatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态值
     */
    private final Integer status;
    /**
     * 状态名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
