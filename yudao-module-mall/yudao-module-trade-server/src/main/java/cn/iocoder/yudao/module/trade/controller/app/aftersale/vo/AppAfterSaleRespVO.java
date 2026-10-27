package cn.iocoder.yudao.module.trade.controller.app.aftersale.vo;

import cn.iocoder.yudao.module.trade.controller.app.base.property.AppProductPropertyValueDetailRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "User App - trade after-sales response.")
@Data
public class AppAfterSaleRespVO {

    @Schema(description = "After-sales code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "After-sales sequence number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1146347329394184195")
    private String no;

    @Schema(description = "After-sales status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "After-sales method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer way;

    @Schema(description = "After-sales type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Apply please reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String applyReason;

    @Schema(description = "Extra description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String applyDescription;

    @Schema(description = "Supporting images.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private List<String> applyPicUrls;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

    // ========== 交易订单相关 ==========

    @Schema(description = "Trade order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long orderId;

    @Schema(description = "Trade order sequence number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String orderNo;

    @Schema(description = "Trade order item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long orderItemId;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long spuId;

    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String spuName;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long skuId;

    /**
     * 属性数组
     */
    private List<AppProductPropertyValueDetailRespVO> properties;

    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/01.jpg")
    private String picUrl;

    @Schema(description = "Return product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer count;

    // ========== 审批相关 ==========

    /**
     * 审批备注
     *
     * 注意，只有审批不通过才会填写
     */
    private String auditReason;

    // ========== 退款相关 ==========

    @Schema(description = "Refund amount, order characters ：Min.", example = "100")
    private Integer refundPrice;

    @Schema(description = "Refund time.")
    private LocalDateTime refundTime;

    // ========== 退货相关 ==========

    @Schema(description = "Return carrier ID.", example = "1")
    private Long logisticsId;

    @Schema(description = "Return tracking number.", example = "SF123456789")
    private String logisticsNo;

    @Schema(description = "Return time.")
    private LocalDateTime deliveryTime;

    @Schema(description = "Receiving time.")
    private LocalDateTime receiveTime;

    @Schema(description = "Receiving notes.")
    private String receiveReason;

}
