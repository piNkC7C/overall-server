package cn.iocoder.yudao.module.infra.controller.admin.demo.demo02.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - sample category create / edit request.")
@Data
public class Demo02CategorySaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10304")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Name is required.")
    private String name;

    @Schema(description = "Parent code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6080")
    @NotNull(message = "Parent code is required.")
    private Long parentId;

}