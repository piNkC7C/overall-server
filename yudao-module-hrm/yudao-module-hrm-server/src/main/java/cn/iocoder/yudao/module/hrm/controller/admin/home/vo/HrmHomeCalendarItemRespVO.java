package cn.iocoder.yudao.module.hrm.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Schema(description = "HRM home calendar item response VO.")
@Data
public class HrmHomeCalendarItemRespVO {

    @Schema(description = "Employee person memo code.")
    private Long personalNoteId;

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Item type name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Memo.")
    private String typeName;

    @Schema(description = "Item content.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(description = "Relation business code.")
    private Long typeId;

    @Schema(description = "Item date.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate date;

    @Schema(description = "Item time.")
    private LocalDateTime eventTime;

}
