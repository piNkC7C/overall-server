package cn.iocoder.yudao.module.mes.controller.admin.pro.workrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES current userworkstation bind status response.")
@Data
@Accessors(chain = true)
public class MesProWorkRecordRespVO {

    @Schema(description = "User ID.", example = "1")
    private Long userId;

    @Schema(description = "Nickname", example = "John.")
    private String userNickname;

    @Schema(description = "Workstation code.", example = "1")
    private Long workstationId;

    @Schema(description = "Workstation code.", example = "WS-001")
    private String workstationCode;

    @Schema(description = "Workstation name.", example = "Injection workstation")
    private String workstationName;

    @Schema(description = "Current status.", example = "1")
    private Integer type;

    @Schema(description = "Clock-in time.")
    private LocalDateTime clockInTime;

    @Schema(description = "Clock-out time.")
    private LocalDateTime clockOutTime;

}
