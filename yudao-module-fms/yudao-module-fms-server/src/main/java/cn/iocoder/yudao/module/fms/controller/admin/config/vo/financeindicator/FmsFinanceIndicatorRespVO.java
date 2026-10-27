package cn.iocoder.yudao.module.fms.controller.admin.config.vo.financeindicator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

// TODO DONE @AI：字段 Swagger 注解和空行已补齐。
@Schema(description = "Admin - FMS finance KPI response.")
@Data
public class FmsFinanceIndicatorRespVO {

    @Schema(description = "Metric code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", example = "1")
    private Long accountSetId;

    @Schema(description = "Metric name.", example = "Cash")
    private String name;

    @Schema(description = "Metric code.", example = "cash")
    private String code;

    @Schema(description = "Source report type.", example = "1")
    private Integer type;

    @Schema(description = "Metric formula.")
    private String formula;

    @Schema(description = "Display order.", example = "10")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
