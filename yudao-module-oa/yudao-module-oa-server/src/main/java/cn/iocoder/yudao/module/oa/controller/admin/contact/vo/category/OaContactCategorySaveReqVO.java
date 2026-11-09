package cn.iocoder.yudao.module.oa.controller.admin.contact.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - OA 联系人分类新增/修改 Request VO")
@Data
public class OaContactCategorySaveReqVO {

    @Schema(description = "分类编号", example = "1024")
    private Long id;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer.")
    @NotBlank(message = "Category name is required.")
    @Size(max = 50, message = "Category name length cannot exceed 50 characters.")
    private String name;

    @Schema(description = "显示排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Show sort is required.")
    private Integer sort;

}
