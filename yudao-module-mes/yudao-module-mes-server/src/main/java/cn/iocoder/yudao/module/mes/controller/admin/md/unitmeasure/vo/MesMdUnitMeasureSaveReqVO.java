package cn.iocoder.yudao.module.mes.controller.admin.md.unitmeasure.vo;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES unit of measure create / edit request.")
@Data
public class MesMdUnitMeasureSaveReqVO {

    @Schema(description = "Order characters code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Order characters code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "KG")
    @NotEmpty(message = "Order characters code is required.")
    private String code;

    @Schema(description = "Order characters name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "kg")
    @NotEmpty(message = "Order characters name is required.")
    private String name;

    @Schema(description = "Is not primary unit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not primary unit is required.")
    private Boolean primaryFlag;

    @Schema(description = "Primary unit code.", example = "200")
    private Long primaryId;

    @Schema(description = "Conversion to the base unit.", example = "1000.0000")
    private BigDecimal changeRate;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }
