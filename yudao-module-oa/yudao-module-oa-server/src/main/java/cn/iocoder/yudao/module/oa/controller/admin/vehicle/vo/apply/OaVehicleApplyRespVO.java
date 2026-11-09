package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo.apply;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 用车申请 Response VO")
@Data
public class OaVehicleApplyRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "申请单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "YC202609140001")
    private String no;

    @Schema(description = "车辆编号", example = "1024")
    private Long vehicleId;

    @Schema(description = "车牌号", example = "CA12345")
    private String vehicleNo;

    @Schema(description = "申请人用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "申请部门编号", example = "1024")
    private Long deptId;

    @Schema(description = "预计出车时间", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "预计回车时间", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "出车地点", example = "Company parking lot")
    private String startLocation;

    @Schema(description = "预计回车地点", example = "Company parking lot")
    private String endLocation;

    @Schema(description = "用车事由", example = "Visit the customer site for a project review")
    private String reason;

    @Schema(description = "随行人", example = "John、Jane.")
    private String passenger;


    @Schema(description = "审批状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "-1")
    private Integer status;

    @Schema(description = "还车状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer returnStatus;

    @Schema(description = "流程实例编号", example = "1024")
    private String processInstanceId;

    @Schema(description = "备注", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "附件地址列表", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "申请人姓名", example = "John.")
    private String userName;

    @Schema(description = "申请部门", example = "Administration.")
    private String deptName;

}
