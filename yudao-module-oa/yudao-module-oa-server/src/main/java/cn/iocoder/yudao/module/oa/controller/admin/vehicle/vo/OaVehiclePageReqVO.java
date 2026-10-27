package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.vehicle.OaVehicleStatusEnum;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - Vehicle page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaVehiclePageReqVO extends PageParam {

    @Schema(description = "License Plate", example = "CA12345")
    private String no;

    @Schema(description = "Vehicle name.", example = "Reception vehicle")
    private String name;

    @Schema(description = "Department code.", example = "103")
    private Long deptId;

    @Schema(description = "Category.", example = "Company vehicle")
    private String category;

    @Schema(description = "Status.", example = "0")
    @InEnum(value = OaVehicleStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "Vehicle Type", example = "Business vehicle")
    private String type;

    @Schema(description = "Make / Model", example = "Buick GL8")
    private String brandModel;

    @Schema(description = "Compulsory Insurance Expires", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] compulsoryInsuranceExpireTime;

    @Schema(description = "Commercial Insurance Expires", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] commercialInsuranceExpireTime;

    @Schema(description = "Inspection Expires", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] inspectionExpireTime;

}
