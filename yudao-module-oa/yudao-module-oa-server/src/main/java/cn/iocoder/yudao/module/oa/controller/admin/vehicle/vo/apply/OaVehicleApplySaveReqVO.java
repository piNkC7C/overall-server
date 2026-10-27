package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo.apply;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - Vehicle requestcreate/update request.")
@Data
public class OaVehicleApplySaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Vehicle code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Vehicle is required.")
    private Long vehicleId;

    @Schema(description = "Expected departure time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Expected departure time cannot be empty.")
    private LocalDateTime startTime;

    @Schema(description = "Expected return time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "Expected return time cannot be empty.")
    private LocalDateTime endTime;

    @Schema(description = "Departure Location", requiredMode = Schema.RequiredMode.REQUIRED, example = "Company parking lot")
    @NotBlank(message = "Departure Location is required.")
    @Size(max = 255, message = "Departure Location length cannot exceed {max} characters.")
    private String startLocation;

    @Schema(description = "Expected return location.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Company parking lot")
    @NotBlank(message = "Expected return location cannot be empty.")
    @Size(max = 255, message = "Expected return location cannot exceed {max} characters.")
    private String endLocation;

    @Schema(description = "Vehicle reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Visit the customer site for a project review")
    @NotBlank(message = "Vehicle reason is required.")
    @Size(max = 500, message = "Vehicle reason length cannot exceed {max} characters.")
    private String reason;

    @Schema(description = "Companion", example = "John、Jane.")
    @Size(max = 500, message = "Companion length cannot exceed 500 characters.")
    private String passenger;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    @Size(max = 500, message = "Notes length cannot exceed {max} characters.")
    private String remark;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    @Size(max = 5, message = "Upload at most 5 attachments.")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 2048, message = "AttachmentAddress length cannot exceed {max} characters.") String> fileUrls;

}
