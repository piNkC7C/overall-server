package cn.iocoder.yudao.module.product.controller.app.history.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Schema(description = "Delete product browse history request VO.")
@Data
public class AppProductBrowseHistoryDeleteReqVO {

    @Schema(description = "Product SPU ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29502")
    @NotEmpty(message = "Product SPU ID list is required.")
    private List<Long> spuIds;

}
