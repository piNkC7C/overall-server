package cn.iocoder.yudao.module.infra.controller.admin.demo.demo01.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - sample contact create / edit request.")
@Data
public class Demo01ContactSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "21555")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotEmpty(message = "Name is required.")
    private String name;

    @Schema(description = "Gender", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Gender is required.")
    private Integer sex;

    @Schema(description = "Birth year", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Birth year is required.")
    private LocalDateTime birthday;

    @Schema(description = "Bio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Looks good.")
    @NotEmpty(message = "Bio is required.")
    private String description;

    @Schema(description = "Avatar")
    private String avatar;

}