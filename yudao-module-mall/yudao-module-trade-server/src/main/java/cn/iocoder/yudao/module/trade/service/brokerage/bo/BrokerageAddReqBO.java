package cn.iocoder.yudao.module.trade.service.brokerage.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * 佣金 增加 Request BO
 *
 * @author owen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrokerageAddReqBO {

    /**
     * 业务编号
     */
    @NotBlank(message = "Business code is required.")
    private String bizId;
    /**
     * 佣金基数
     */
    @NotNull(message = "Commission base cannot be empty.")
    private Integer basePrice;
    /**
     * 一级佣金（固定）
     */
    private Integer firstFixedPrice;
    /**
     * 二级佣金（固定）
     */
    private Integer secondFixedPrice;

    /**
     * 来源用户编号
     */
    @NotNull(message = "Source user ID is required.")
    private Long sourceUserId;

    /**
     * 佣金记录标题
     */
    @NotEmpty(message = "Commission title cannot be empty.")
    private String title;

}
