package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo.returning;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - vehicle return response.")
@Data
public class OaVehicleReturnRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Return request no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "HC202609140001")
    private String no;

    @Schema(description = "Vehicle requestID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long applyId;

    @Schema(description = "Vehicle code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long vehicleId;

    @Schema(description = "Apply please person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Apply please department code.", example = "1024")
    private Long deptId;

    @Schema(description = "Actual departure time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime actualStartTime;

    @Schema(description = "ActualDeparture Location.", example = "Company parking lot")
    private String startLocation;

    @Schema(description = "Vehicle reason.", example = "Visit the customer site for a project review")
    private String reason;

    @Schema(description = "Companion", example = "John、Jane.")
    private String passenger;

    @Schema(description = "ActualReturn Time.", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime actualReturnTime;

    @Schema(description = "Actual return location.", example = "Company parking lot")
    private String returnLocation;




    @Schema(description = "Approval status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "-1")
    private Integer status;

    @Schema(description = "Workflow instance code.", example = "1024")
    private String processInstanceId;

    @Schema(description = "Return notes.", example = "The vehicle is parked in the company lot")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Apply please person Name.", example = "John.")
    private String userName;

    @Schema(description = "Apply please department.", example = "Administration.")
    private String deptName;

    @Schema(description = "Vehicle request no.", example = "YC202609140001")
    private String applyNo;

    @Schema(description = "License Plate", example = "CA12345")
    private String vehicleNo;

}
