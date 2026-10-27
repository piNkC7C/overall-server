package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.vehicle.OaVehicleStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - Vehicle create / edit request.")
@Data
public class OaVehicleSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "License Plate", requiredMode = Schema.RequiredMode.REQUIRED, example = "CA12345")
    @NotBlank(message = "License Plate is required.")
    @Size(max = 32, message = "License Plate length cannot exceed 32 characters.")
    private String no;

    @Schema(description = "Vehicle name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Reception vehicle")
    @NotBlank(message = "Vehicle name is required.")
    @Size(max = 128, message = "Vehicle name length cannot exceed 128 characters.")
    private String name;

    @Schema(description = "Department code.", example = "103")
    private Long deptId;

    @Schema(description = "Vehicle Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "Business vehicle")
    @NotBlank(message = "Vehicle Type is required.")
    @Size(max = 64, message = "Vehicle Type length cannot exceed 64 characters.")
    private String type;

    @Schema(description = "Vehiclecategory.", example = "Company vehicle")
    @Size(max = 64, message = "Vehiclecategory length cannot exceed 64 characters.")
    private String category;

    @Schema(description = "Make / Model", example = "Buick GL8")
    @Size(max = 128, message = "Make / Model length cannot exceed 128 characters.")
    private String brandModel;

    @Schema(description = "Seats", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    @NotNull(message = "Seats is required.")
    @DecimalMin(value = "1", message = "Seat count cannot be less than 1.")
    private Integer seatCount;

    @Schema(description = "Base vehicle price (yuan).", requiredMode = Schema.RequiredMode.REQUIRED, example = "250000.00")
    @NotNull(message = "Base vehicle price (yuan) cannot be empty.")
    @DecimalMin(value = "0", message = "Base vehicle price (yuan) cannot be less than 0.")
    @Digits(integer = 16, fraction = 2, message = "Base vehicle price can have at most {integer} integer digits and {fraction} decimal places.")
    private BigDecimal barePrice;

    @Schema(description = "Compulsory Insurance Expires", example = "1789002000000", type = "integer", format = "int64")
    private LocalDateTime compulsoryInsuranceExpireTime;

    @Schema(description = "Commercial Insurance Expires", example = "1789002000000", type = "integer", format = "int64")
    private LocalDateTime commercialInsuranceExpireTime;

    @Schema(description = "Inspection Expires", example = "1789002000000", type = "integer", format = "int64")
    private LocalDateTime inspectionExpireTime;

    @Schema(description = "Vehicle Photo URL.", example = "https://example.com/vehicle.png")
    @Size(max = 2048, message = "Photo URL cannot exceed 2048 characters.")
    private String picUrl;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Vehicle status.", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Vehicle status is required.")
    @InEnum(value = OaVehicleStatusEnum.class, message = "Vehicle status must be {value}.")
    private Integer status;

    @Schema(description = "Notes.", example = "Department vehicle")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}
