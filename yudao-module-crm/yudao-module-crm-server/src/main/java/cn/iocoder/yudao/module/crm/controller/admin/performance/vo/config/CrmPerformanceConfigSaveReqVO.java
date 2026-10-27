package cn.iocoder.yudao.module.crm.controller.admin.performance.vo.config;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.performance.CrmPerformanceConfigBizTypeEnum;
import cn.iocoder.yudao.module.crm.enums.performance.CrmPerformanceConfigObjectTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "CRM quota setting create / update request VO.")
@Data
public class CrmPerformanceConfigSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Target object code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Target object code is required.")
    private Long objectId;

    @Schema(description = "Target object type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Target object type is required.")
    @InEnum(value = CrmPerformanceConfigObjectTypeEnum.class, message = "Target object type, must be {value}.")
    private Integer objectType;

    @Schema(description = "Year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    @NotNull(message = "Year is required.")
    private Integer year;

    @Schema(description = "January target.")
    private BigDecimal januaryTargetPrice;

    @Schema(description = "February target.")
    private BigDecimal februaryTargetPrice;

    @Schema(description = "March target.")
    private BigDecimal marchTargetPrice;

    @Schema(description = "April target.")
    private BigDecimal aprilTargetPrice;

    @Schema(description = "May target.")
    private BigDecimal mayTargetPrice;

    @Schema(description = "June target.")
    private BigDecimal juneTargetPrice;

    @Schema(description = "July target.")
    private BigDecimal julyTargetPrice;

    @Schema(description = "August target.")
    private BigDecimal augustTargetPrice;

    @Schema(description = "September target.")
    private BigDecimal septemberTargetPrice;

    @Schema(description = "October target.")
    private BigDecimal octoberTargetPrice;

    @Schema(description = "November target.")
    private BigDecimal novemberTargetPrice;

    @Schema(description = "December target.")
    private BigDecimal decemberTargetPrice;

    @Schema(description = "Target type.",
            requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Target type is required.")
    @InEnum(value = CrmPerformanceConfigBizTypeEnum.class, message = "Target type, must be {value}.")
    private Integer bizType;

}
