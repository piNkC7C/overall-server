package cn.iocoder.yudao.module.bpm.controller.admin.base.dept;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Department simple info VO.")
@Data
public class DeptSimpleBaseVO {

    @Schema(description = "Department code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "Department name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Engineering")
    private String name;

}