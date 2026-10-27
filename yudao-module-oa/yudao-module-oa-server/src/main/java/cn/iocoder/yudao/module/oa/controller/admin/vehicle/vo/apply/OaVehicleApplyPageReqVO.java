package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo.apply;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.bpm.enums.task.BpmProcessInstanceStatusEnum;
import cn.iocoder.yudao.module.oa.enums.vehicle.OaVehicleReturnStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - Vehicle requestpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaVehicleApplyPageReqVO extends PageParam {

    @Schema(description = "Apply please order no.", example = "YC202609140001")
    private String no;

    @Schema(description = "License Plate", example = "CA12345")
    private String vehicleNo;

    @Schema(description = "Approval status.", example = "-1")
    @InEnum(value = BpmProcessInstanceStatusEnum.class, message = "Approval status must be {value}.")
    private Integer status;

    @Schema(description = "Vehicle-return status.", example = "0")
    @InEnum(value = OaVehicleReturnStatusEnum.class, message = "Vehicle-return status must be {value}.")
    private Integer returnStatus;

    @Schema(description = "Apply please department code.", example = "1024")
    private Long deptId;

    @Schema(description = "Create time.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
