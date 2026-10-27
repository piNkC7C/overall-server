package cn.iocoder.yudao.module.trade.service.aftersale.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * 售后日志的创建 Request BO
 *
 * @author 陈賝
 * @since 2023/6/19 09:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfterSaleLogCreateReqBO {

    /**
     * 用户编号
     */
    @NotNull(message = "User ID is required.")
    private Long userId;
    /**
     * 用户类型
     */
    @NotNull(message = "User type is required.")
    private Integer userType;

    /**
     * 售后编号
     */
    @NotNull(message = "After-sales code is required.")
    private Long afterSaleId;
    /**
     * 操作前状态
     */
    private Integer beforeStatus;
    /**
     * 操作后状态
     */
    @NotNull(message = "Action after status is required.")
    private Integer afterStatus;

    /**
     * 操作类型
     */
    @NotNull(message = "Action type is required.")
    private Integer operateType;
    /**
     * 操作明细
     */
    @NotEmpty(message = "Actiondetail is required.")
    private String content;
}
