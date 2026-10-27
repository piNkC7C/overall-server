package cn.iocoder.yudao.module.crm.controller.admin.product.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - CRM product category response.")
@Data
public class CrmProductCategoryRespVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23902")
    private Long id;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    private String name;

    @Schema(description = "Parent code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4680")
    private Long parentId;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
