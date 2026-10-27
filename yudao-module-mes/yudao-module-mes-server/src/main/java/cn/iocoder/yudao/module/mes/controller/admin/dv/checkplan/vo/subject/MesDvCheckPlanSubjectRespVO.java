package cn.iocoder.yudao.module.mes.controller.admin.dv.checkplan.vo.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES inspection and maintenance plan item response.")
@Data
public class MesDvCheckPlanSubjectRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long planId;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long subjectId;

    @Schema(description = "Item code.", example = "CHK001")
    private String subjectCode;

    @Schema(description = "Item name.", example = "Oil temperature check")
    private String subjectName;

    @Schema(description = "Item type.", example = "1")
    private Integer subjectType;

    @Schema(description = "Item content.", example = "Check whether oil temperature is normal")
    private String subjectContent;

    @Schema(description = "Standard.", example = "40-60°C")
    private String subjectStandard;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
