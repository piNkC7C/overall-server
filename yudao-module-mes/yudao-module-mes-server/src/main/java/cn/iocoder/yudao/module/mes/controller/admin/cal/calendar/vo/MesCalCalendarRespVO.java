package cn.iocoder.yudao.module.mes.controller.admin.cal.calendar.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "MES schedule calendar response VO.")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MesCalCalendarRespVO {

    @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED, example = "2025-01-15 00:00:00")
    private LocalDateTime day;

    @Schema(description = "Rotation method.", example = "2")
    private Integer shiftType; // 对应 MesCalShiftTypeEnum 枚举值

    @Schema(description = "Team schedule list.")
    private List<TeamShiftItem> teamShifts;

    @Schema(description = "Team schedule item.")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TeamShiftItem {

        @Schema(description = "Team code.", example = "201")
        private Long teamId;

        @Schema(description = "Team name.", example = "Injection team A")
        private String teamName;

        @Schema(description = "Shift code.", example = "1")
        private Long shiftId;

        @Schema(description = "Shift name.", example = "Day shift")
        private String shiftName;

        @Schema(description = "Sort.", example = "1")
        private Integer sort;

    }

}
