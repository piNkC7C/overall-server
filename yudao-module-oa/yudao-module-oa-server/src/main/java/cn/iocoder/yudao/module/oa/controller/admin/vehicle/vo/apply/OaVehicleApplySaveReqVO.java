package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo.apply;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 用车申请新增/修改 Request VO")
@Data
public class OaVehicleApplySaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "车辆编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Vehicle is required.")
    private Long vehicleId;

    @Schema(description = "预计出车时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Expected departure time cannot be empty.")
    private LocalDateTime startTime;

    @Schema(description = "预计回车时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "Expected return time cannot be empty.")
    private LocalDateTime endTime;

    @Schema(description = "出车地点", requiredMode = Schema.RequiredMode.REQUIRED, example = "Company parking lot")
    @NotBlank(message = "Departure Location is required.")
    @Size(max = 255, message = "Departure Location length cannot exceed {max} characters.")
    private String startLocation;

    @Schema(description = "预计回车地点", requiredMode = Schema.RequiredMode.REQUIRED, example = "Company parking lot")
    @NotBlank(message = "Expected return location cannot be empty.")
    @Size(max = 255, message = "Expected return location cannot exceed {max} characters.")
    private String endLocation;

    @Schema(description = "用车事由", requiredMode = Schema.RequiredMode.REQUIRED, example = "Visit the customer site for a project review")
    @NotBlank(message = "Vehicle reason is required.")
    @Size(max = 500, message = "Vehicle reason length cannot exceed {max} characters.")
    private String reason;

    @Schema(description = "随行人", example = "John、Jane.")
    @Size(max = 500, message = "Companion length cannot exceed 500 characters.")
    private String passenger;

    @Schema(description = "备注", example = "Contact Admin in advance to confirm.")
    @Size(max = 500, message = "Notes length cannot exceed {max} characters.")
    private String remark;

    @Schema(description = "附件地址列表", example = "[\"https://example.com/file.pdf\"]")
    @Size(max = 5, message = "Upload at most 5 attachments.")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 2048, message = "AttachmentAddress length cannot exceed {max} characters.") String> fileUrls;

}
