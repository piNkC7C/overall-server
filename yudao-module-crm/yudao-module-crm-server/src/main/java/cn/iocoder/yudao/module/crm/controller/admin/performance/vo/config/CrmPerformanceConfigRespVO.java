package cn.iocoder.yudao.module.crm.controller.admin.performance.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "CRM quota setting response VO.")
@Data
public class CrmPerformanceConfigRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Target object code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long objectId;

    @Schema(description = "Target object name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sales")
    private String objectName;

    @Schema(description = "Target object type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer objectType;

    @Schema(description = "Year.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026")
    private Integer year;

    @Schema(description = "January target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal januaryTargetPrice;

    @Schema(description = "February target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal februaryTargetPrice;

    @Schema(description = "March target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal marchTargetPrice;

    @Schema(description = "April target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal aprilTargetPrice;

    @Schema(description = "May target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal mayTargetPrice;

    @Schema(description = "June target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal juneTargetPrice;

    @Schema(description = "July target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal julyTargetPrice;

    @Schema(description = "August target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal augustTargetPrice;

    @Schema(description = "September target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal septemberTargetPrice;

    @Schema(description = "October target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal octoberTargetPrice;

    @Schema(description = "November target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal novemberTargetPrice;

    @Schema(description = "December target.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal decemberTargetPrice;

    @Schema(description = "Target type.",
            requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer bizType;

    @Schema(description = "Annual target amount.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal yearTargetPrice;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
