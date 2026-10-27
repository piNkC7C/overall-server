package cn.iocoder.yudao.module.report.controller.admin.goview.vo.project;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Admin - GoView item create request.")
@Data
public class GoViewProjectCreateReqVO {

    @Schema(description = "Item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @NotEmpty(message = "Item name is required.")
    private String name;

}
