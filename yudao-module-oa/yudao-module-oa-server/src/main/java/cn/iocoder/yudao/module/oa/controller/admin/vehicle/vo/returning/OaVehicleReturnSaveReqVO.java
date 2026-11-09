package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo.returning;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 还车申请新增/修改 Request VO")
@Data
public class OaVehicleReturnSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "用车申请编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Vehicle request cannot be empty.")
    private Long applyId;

    @Schema(description = "实际出车时间", type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Actual departure time cannot be empty.")
    private LocalDateTime actualStartTime;

    @Schema(description = "实际出车地点", example = "Company parking lot")
    @NotBlank(message = "ActualDeparture Location is required.")
    @Size(max = 255, message = "ActualDeparture Location length cannot exceed {max} characters.")
    private String startLocation;

    @Schema(description = "用车事由", example = "Visit the customer site for a project review")
    @NotBlank(message = "Vehicle reason is required.")
    @Size(max = 500, message = "Vehicle reason length cannot exceed {max} characters.")
    private String reason;

    @Schema(description = "随行人", example = "John、Jane.")
    @Size(max = 500, message = "Companion length cannot exceed {max} characters.")
    private String passenger;

    @Schema(description = "实际回车时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "ActualReturn Time is required.")
    @PastOrPresent(message = "Actual return time cannot be later than now.")
    private LocalDateTime actualReturnTime;

    @Schema(description = "实际回车地点", requiredMode = Schema.RequiredMode.REQUIRED, example = "Company parking lot")
    @NotBlank(message = "Actual return location cannot be empty.")
    @Size(max = 255, message = "Actual return location cannot exceed {max} characters.")
    private String returnLocation;

    @Schema(description = "还车说明", example = "The vehicle is parked in the company lot")
    @Size(max = 500, message = "Return notes cannot exceed {max} characters.")
    private String remark;

    @Schema(description = "附件地址列表", example = "[\"https://example.com/file.pdf\"]")
    @Size(max = 5, message = "Upload at most 5 attachments.")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 2048, message = "AttachmentAddress length cannot exceed {max} characters.") String> fileUrls;

}
