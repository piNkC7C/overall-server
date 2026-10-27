package cn.iocoder.yudao.module.infra.controller.admin.demo.demo03.erp.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - studentcreate/update request.")
@Data
public class Demo03StudentErpSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8525")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Name is required.")
    private String name;

    @Schema(description = "Gender", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Gender is required.")
    private Integer sex;

    @Schema(description = "Date of birth", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Date of birth is required.")
    private LocalDateTime birthday;

    @Schema(description = "Bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sample.")
    @NotEmpty(message = "Bio is required.")
    private String description;

}