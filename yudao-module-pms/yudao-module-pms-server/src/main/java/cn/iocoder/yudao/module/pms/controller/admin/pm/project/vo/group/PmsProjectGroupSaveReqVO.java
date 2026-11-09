package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - PMS 项目分组新增/修改 Request VO")
@Data
public class PmsProjectGroupSaveReqVO {

    @Schema(description = "项目分组编号", example = "1024")
    private Long id;

    @Schema(description = "分组名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Key project")
    @NotBlank(message = "Group name is required.")
    @Size(max = 100, message = "Group name cannot exceed 100 characters.")
    private String name;

}
