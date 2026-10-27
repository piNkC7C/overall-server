package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo.returning;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - vehicle returncreate/update request.")
@Data
public class OaVehicleReturnSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Vehicle requestID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Vehicle request cannot be empty.")
    private Long applyId;

    @Schema(description = "Actual departure time.", type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Actual departure time cannot be empty.")
    private LocalDateTime actualStartTime;

    @Schema(description = "ActualDeparture Location.", example = "Company parking lot")
    @NotBlank(message = "ActualDeparture Location is required.")
    @Size(max = 255, message = "ActualDeparture Location length cannot exceed {max} characters.")
    private String startLocation;

    @Schema(description = "Vehicle reason.", example = "Visit the customer site for a project review")
    @NotBlank(message = "Vehicle reason is required.")
    @Size(max = 500, message = "Vehicle reason length cannot exceed {max} characters.")
    private String reason;

    @Schema(description = "Companion", example = "John、Jane.")
    @Size(max = 500, message = "Companion length cannot exceed {max} characters.")
    private String passenger;

    @Schema(description = "ActualReturn Time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "ActualReturn Time is required.")
    @PastOrPresent(message = "Actual return time cannot be later than now.")
    private LocalDateTime actualReturnTime;

    @Schema(description = "Actual return location.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Company parking lot")
    @NotBlank(message = "Actual return location cannot be empty.")
    @Size(max = 255, message = "Actual return location cannot exceed {max} characters.")
    private String returnLocation;

    @Schema(description = "Return notes.", example = "The vehicle is parked in the company lot")
    @Size(max = 500, message = "Return notes cannot exceed {max} characters.")
    private String remark;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    @Size(max = 5, message = "Upload at most 5 attachments.")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 2048, message = "AttachmentAddress length cannot exceed {max} characters.") String> fileUrls;

}
