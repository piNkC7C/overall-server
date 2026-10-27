package cn.iocoder.yudao.module.mes.controller.admin.cal.holiday.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES holiday set create / edit request.")
@Data
public class MesCalHolidaySaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Date is required.")
    private LocalDateTime day;

    @Schema(description = "Date type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Date type is required.")
    private Integer type;

    @Schema(description = "Notes.")
    private String remark;

}
