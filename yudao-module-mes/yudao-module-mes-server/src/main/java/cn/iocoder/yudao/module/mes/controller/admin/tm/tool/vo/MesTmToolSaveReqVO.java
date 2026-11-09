package cn.iocoder.yudao.module.mes.controller.admin.tm.tool.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 工具台账新增/修改 Request VO")
@Data
public class MesTmToolSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "工具编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "T-001")
    @NotEmpty(message = "Tool code is required.")
    @Size(max = 64, message = "Tool code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "工具名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "5mm end mill")
    @NotEmpty(message = "Tool name is required.")
    @Size(max = 255, message = "Tool name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "品牌", example = "Mitsubishi")
    @Size(max = 255, message = "Brand length cannot exceed 255 characters.")
    private String brand;

    @Schema(description = "型号规格", example = "M5-100")
    @Size(max = 255, message = "Model / Spec length cannot exceed 255 characters.")
    private String specification;

    @Schema(description = "工具类型编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Tool type is required.")
    private Long toolTypeId;

    @Schema(description = "数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quantity is required.")
    private Integer quantity;

    @Schema(description = "可用数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Can quantity is required.")
    private Integer availableQuantity;

    @Schema(description = "保养维护类型", example = "1")
    private Integer maintenType;

    @Schema(description = "下次保养周期（次数）", example = "100")
    private Integer nextMaintenPeriod;

    @Schema(description = "下次保养日期", example = "2024-06-01 00:00:00")
    private LocalDateTime nextMaintenDate;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}