package cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.part;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES coding rule consist of create / edit request.")
@Data
public class MesMdAutoCodePartSaveReqVO {

    @Schema(description = "Segment ID.", example = "1024")
    private Long id;

    @Schema(description = "Rule ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Rule ID is required.")
    private Long ruleId;

    @Schema(description = "Segment No.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Segment No. is required.")
    private Integer sort;

    @Schema(description = "Segment type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Segment type is required.")
    private Integer type;

    @Schema(description = "Segment length.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    @NotNull(message = "Segment length is required.")
    private Integer length;

    @Schema(description = "Date format.", example = "yyyyMMdd")
    private String dateFormat;

    @Schema(description = "Fixed text.", example = "ITEM_")
    private String fixCharacter;

    @Schema(description = "Sequence start.", example = "1")
    private Integer serialStartNo;

    @Schema(description = "Sequence step.", example = "1")
    private Integer serialStep;

    @Schema(description = "Sequence cycles.", example = "true")
    private Boolean cycleFlag;

    @Schema(description = "Cycle mode.", example = "3")
    private Integer cycleMethod;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}
