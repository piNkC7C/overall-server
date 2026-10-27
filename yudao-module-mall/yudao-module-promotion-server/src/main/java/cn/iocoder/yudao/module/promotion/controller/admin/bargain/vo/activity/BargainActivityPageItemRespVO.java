package cn.iocoder.yudao.module.promotion.controller.admin.bargain.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - bargain campaign page item response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BargainActivityPageItemRespVO extends BargainActivityBaseVO {

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22901")
    private Long id;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Summer Sale")
    private String spuName;
    @Schema(description = "Product main image.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
    private String picUrl;

    @Schema(description = "Campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Campaign status is required.")
    private Integer status;

    @Schema(description = "Campaign total stock.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23")
    private Integer totalStock;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2022-07-01 23:59:59")
    private LocalDateTime createTime;

    // ========== Statsfield ==========

    @Schema(description = "Bargain user count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "999")
    private Integer recordUserCount;

    @Schema(description = "Succeeded bargain user quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "500")
    private Integer recordSuccessUserCount;

    @Schema(description = "Bargain helper count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
    private Integer helpUserCount;

}
