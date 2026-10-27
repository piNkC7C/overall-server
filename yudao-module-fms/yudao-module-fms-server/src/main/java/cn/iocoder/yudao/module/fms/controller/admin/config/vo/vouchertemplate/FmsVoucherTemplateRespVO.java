package cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - FMS journal entrytemplate response.")
@Data
public class FmsVoucherTemplateRespVO {

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long accountSetId;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long categoryId;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String categoryName;

    @Schema(description = "Journal entrytemplate entry Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<FmsVoucherTemplateEntryVO> entries;

}
