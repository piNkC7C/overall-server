package cn.iocoder.yudao.module.mes.controller.admin.md.unitmeasure.vo;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 计量单位新增/修改 Request VO")
@Data
public class MesMdUnitMeasureSaveReqVO {

    @Schema(description = "单位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "单位编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "KG")
    @NotEmpty(message = "Order characters code is required.")
    private String code;

    @Schema(description = "单位名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "kg")
    @NotEmpty(message = "Order characters name is required.")
    private String name;

    @Schema(description = "是否主单位", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not primary unit is required.")
    private Boolean primaryFlag;

    @Schema(description = "主单位编号", example = "200")
    private Long primaryId;

    @Schema(description = "与主单位换算比例", example = "1000.0000")
    private BigDecimal changeRate;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }
