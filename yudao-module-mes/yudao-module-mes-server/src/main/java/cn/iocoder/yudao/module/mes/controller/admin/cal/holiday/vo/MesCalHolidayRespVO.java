package cn.iocoder.yudao.module.mes.controller.admin.cal.holiday.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES holiday set response.")
@Data
public class MesCalHolidayRespVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Date")
    private LocalDateTime day;

    @Schema(description = "Date type.")
    private Integer type;

    @Schema(description = "Notes.")
    private String remark;

}
