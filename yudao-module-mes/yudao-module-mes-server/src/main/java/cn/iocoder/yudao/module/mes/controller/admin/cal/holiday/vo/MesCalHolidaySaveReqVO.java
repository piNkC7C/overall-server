package cn.iocoder.yudao.module.mes.controller.admin.cal.holiday.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 假期设置新增/修改 Request VO")
@Data
public class MesCalHolidaySaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Date is required.")
    private LocalDateTime day;

    @Schema(description = "日期类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Date type is required.")
    private Integer type;

    @Schema(description = "备注")
    private String remark;

}
