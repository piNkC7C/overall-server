package cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - Vehicle response.")
@Data
public class OaVehicleRespVO {

    @Schema(description = "Code.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "License Plate", example = "CA12345", requiredMode = Schema.RequiredMode.REQUIRED)
    private String no;

    @Schema(description = "Vehicle name.", example = "Reception vehicle", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Department code.", example = "103")
    private Long deptId;

    @Schema(description = "Department name.", example = "R&D")
    private String deptName;

    @Schema(description = "Vehicle Type", example = "Business vehicle", requiredMode = Schema.RequiredMode.REQUIRED)
    private String type;

    @Schema(description = "Vehiclecategory.", example = "Company vehicle")
    private String category;

    @Schema(description = "Make / Model", example = "Buick GL8")
    private String brandModel;

    @Schema(description = "Seats", example = "7", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer seatCount;

    @Schema(description = "Base vehicle price (yuan).", example = "250000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal barePrice;

    @Schema(description = "Compulsory Insurance Expires", example = "1789002000000", type = "integer", format = "int64")
    private LocalDateTime compulsoryInsuranceExpireTime;

    @Schema(description = "Commercial Insurance Expires", example = "1789002000000", type = "integer", format = "int64")
    private LocalDateTime commercialInsuranceExpireTime;

    @Schema(description = "Inspection Expires", example = "1789002000000", type = "integer", format = "int64")
    private LocalDateTime inspectionExpireTime;

    @Schema(description = "Vehicle Photo URL.", example = "https://example.com/vehicle.png")
    private String picUrl;

    @Schema(description = "Vehicle ledger status.", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

    @Schema(description = "Sort", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer sort;

    @Schema(description = "Notes.", example = "Department vehicle")
    private String remark;

    @Schema(description = "Create time.", example = "1789002000000", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64")
    private LocalDateTime createTime;

}
