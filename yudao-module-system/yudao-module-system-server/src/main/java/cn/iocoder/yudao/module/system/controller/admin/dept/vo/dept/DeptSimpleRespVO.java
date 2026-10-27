package cn.iocoder.yudao.module.system.controller.admin.dept.vo.dept;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Admin - department simple info response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptSimpleRespVO {

    @Schema(description = "Department code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Department name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Parent department ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long parentId;

}
