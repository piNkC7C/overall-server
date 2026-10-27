package cn.iocoder.yudao.module.fms.controller.admin.config.vo.financeindicator;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.config.FmsFinanceIndicatorTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

// TODO DONE @AI：字段空行已对齐现有 SaveReqVO。
@Schema(description = "Admin - FMS finance KPIsave request.")
@Data
public class FmsFinanceIndicatorSaveReqVO {

    @Schema(description = "Metric code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Metric name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cash")
    @NotBlank(message = "Metric name is required.")
    @Size(max = 100, message = "Metric name length cannot exceed 100 characters.")
    private String name;

    @Schema(description = "Metric code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "cash")
    @NotBlank(message = "Metric code is required.")
    @Size(max = 64, message = "Metric code length cannot exceed 64 characters.")
    private String code;

    @Schema(description = "Source report type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Source report type cannot be empty.")
    @InEnum(FmsFinanceIndicatorTypeEnum.class)
    private Integer type;

    @Schema(description = "Metric formula. Supports L1+L2 or account-formula JSON.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Metric formula cannot be empty.")
    @Size(max = 2000, message = "Metric formula cannot exceed 2000 characters.")
    private String formula;

    @Schema(description = "Display order.", example = "10")
    @NotNull(message = "Display order cannot be empty.")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
