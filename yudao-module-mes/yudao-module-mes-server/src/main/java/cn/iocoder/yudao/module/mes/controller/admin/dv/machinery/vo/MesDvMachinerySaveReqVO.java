package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 设备台账新增/修改 Request VO")
@Data
public class MesDvMachinerySaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "设备编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "EQ-001")
    @NotEmpty(message = "Device code is required.")
    private String code;

    @Schema(description = "设备名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "CNC center")
    @NotEmpty(message = "Device name is required.")
    private String name;

    @Schema(description = "品牌", example = "Siemens")
    private String brand;

    @Schema(description = "规格型号", example = "S7-300")
    private String specification;

    @Schema(description = "设备类型编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Device type is required.")
    private Long machineryTypeId;

    @Schema(description = "所属车间编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "Workshop is required.")
    private Long workshopId;

    @Schema(description = "设备状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Device status is required.")
    private Integer status;

    @Schema(description = "最近保养时间")
    private LocalDateTime lastMaintenTime;

    @Schema(description = "最近点检时间")
    private LocalDateTime lastCheckTime;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }
