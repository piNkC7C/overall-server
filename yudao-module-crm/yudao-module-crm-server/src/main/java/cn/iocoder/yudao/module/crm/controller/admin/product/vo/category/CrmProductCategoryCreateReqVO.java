package cn.iocoder.yudao.module.crm.controller.admin.product.vo.category;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - CRM 产品分类创建/更新 Request VO")
@Data
public class CrmProductCategoryCreateReqVO{

    @Schema(description = "分类编号", example = "23902")
    private Long id;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    @NotNull(message = "Category name is required.")
    @DiffLogField(name = "分类名称")
    private String name;

    @Schema(description = "父级编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "4680")
    @NotNull(message = "Parent code is required.")
    private Long parentId;

}
