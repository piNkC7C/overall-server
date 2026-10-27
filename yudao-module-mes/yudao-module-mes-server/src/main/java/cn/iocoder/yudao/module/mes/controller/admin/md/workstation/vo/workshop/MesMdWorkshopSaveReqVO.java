package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.workshop;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES workshop create / edit request.")
@Data
public class MesMdWorkshopSaveReqVO {

    @Schema(description = "Workshop code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Workshop code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WS001")
    @NotEmpty(message = "Workshop code is required.")
    private String code;

    @Schema(description = "Workshop name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Workshop 1")
    @NotEmpty(message = "Workshop name is required.")
    private String name;

    @Schema(description = "Area", example = "1000.00")
    private BigDecimal area;

    @Schema(description = "Owner person user ID.", example = "1")
    private Long chargeUserId;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
