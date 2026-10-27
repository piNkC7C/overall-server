package cn.iocoder.yudao.module.promotion.controller.admin.point.vo.activity;

import cn.iocoder.yudao.module.promotion.controller.admin.point.vo.product.PointProductSaveReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - points shop campaign create / edit request.")
@Data
public class PointActivitySaveReqVO {

    @Schema(description = "Points shop campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11373")
    private Long id;

    @Schema(description = "Points shop campaignproduct.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19509")
    @NotNull(message = "Points shop campaignproduct is required.")
    private Long spuId;

    @Schema(description = "Notes.", example = "Looks good.")
    private String remark;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Points shop product.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PointProductSaveReqVO> products;

}