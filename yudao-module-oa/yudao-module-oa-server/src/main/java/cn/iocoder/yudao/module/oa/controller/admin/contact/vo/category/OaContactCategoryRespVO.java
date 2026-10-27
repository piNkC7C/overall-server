package cn.iocoder.yudao.module.oa.controller.admin.contact.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - OA contactcategory response.")
@Data
public class OaContactCategoryRespVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer.")
    private String name;

    @Schema(description = "Show sort.", example = "10")
    private Integer sort;

    @Schema(description = "Create time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}
