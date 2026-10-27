package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.activity;

import cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.product.CombinationProductRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - group buy campaign page item response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CombinationActivityPageItemRespVO extends CombinationActivityBaseVO {

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22901")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Group buy product.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<CombinationProductRespVO> products;

    // ========== productfield ==========

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 name 读取
            example = "Summer Sale")
    private String spuName;
    @Schema(description = "Product main image.", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 picUrl 读取
            example = "https://www.iocoder.cn/xx.png")
    private String picUrl;
    @Schema(description = "Market price, in cents", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 marketPrice 读取
            example = "50")
    private Integer marketPrice;

    // ========== Statsfield ==========

    @Schema(description = "Groups Started", requiredMode = Schema.RequiredMode.REQUIRED, example = "33")
    private Integer groupCount;

    @Schema(description = "Groups Completed", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer groupSuccessCount;

    @Schema(description = "Purchase Count", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer recordCount;

}
