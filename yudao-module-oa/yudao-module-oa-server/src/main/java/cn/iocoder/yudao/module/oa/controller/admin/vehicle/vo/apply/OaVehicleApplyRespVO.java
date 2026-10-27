package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo.apply;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - Vehicle request response.")
@Data
public class OaVehicleApplyRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Apply please order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "YC202609140001")
    private String no;

    @Schema(description = "Vehicle code.", example = "1024")
    private Long vehicleId;

    @Schema(description = "License Plate", example = "CA12345")
    private String vehicleNo;

    @Schema(description = "Apply please person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Apply please department code.", example = "1024")
    private Long deptId;

    @Schema(description = "Expected departure time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "Expected return time.", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "Departure Location", example = "Company parking lot")
    private String startLocation;

    @Schema(description = "Expected return location.", example = "Company parking lot")
    private String endLocation;

    @Schema(description = "Vehicle reason.", example = "Visit the customer site for a project review")
    private String reason;

    @Schema(description = "Companion", example = "John、Jane.")
    private String passenger;


    @Schema(description = "Approval status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "-1")
    private Integer status;

    @Schema(description = "Vehicle-return status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer returnStatus;

    @Schema(description = "Workflow instance code.", example = "1024")
    private String processInstanceId;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Apply please person Name.", example = "John.")
    private String userName;

    @Schema(description = "Apply please department.", example = "Administration.")
    private String deptName;

}
