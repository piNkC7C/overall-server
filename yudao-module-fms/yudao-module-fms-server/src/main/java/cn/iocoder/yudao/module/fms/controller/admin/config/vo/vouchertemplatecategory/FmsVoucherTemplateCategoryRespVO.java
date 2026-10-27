package cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplatecategory;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - FMS journal entrytemplatecategory response.")
@Data
public class FmsVoucherTemplateCategoryRespVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long accountSetId;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Daily income and expense")
    private String name;

}
