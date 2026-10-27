package cn.iocoder.yudao.module.crm.controller.admin.product.vo.category;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - CRM product category create or update request.")
@Data
public class CrmProductCategoryCreateReqVO{

    @Schema(description = "Category code.", example = "23902")
    private Long id;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    @NotNull(message = "Category name is required.")
    @DiffLogField(name = "Category name.")
    private String name;

    @Schema(description = "Parent code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4680")
    @NotNull(message = "Parent code is required.")
    private Long parentId;

}
