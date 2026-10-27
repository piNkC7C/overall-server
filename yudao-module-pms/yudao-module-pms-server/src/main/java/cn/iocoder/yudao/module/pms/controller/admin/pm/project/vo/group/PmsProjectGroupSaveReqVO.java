package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - PMS item group create / edit request.")
@Data
public class PmsProjectGroupSaveReqVO {

    @Schema(description = "Item group code.", example = "1024")
    private Long id;

    @Schema(description = "Group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Key project")
    @NotBlank(message = "Group name is required.")
    @Size(max = 100, message = "Group name cannot exceed 100 characters.")
    private String name;

}
