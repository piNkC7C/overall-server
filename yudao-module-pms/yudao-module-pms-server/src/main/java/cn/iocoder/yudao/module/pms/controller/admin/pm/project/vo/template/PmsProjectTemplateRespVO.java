package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS item template response.")
@Data
public class PmsProjectTemplateRespVO {

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Agile template")
    private String name;

    @Schema(description = "TemplateDescription.", example = "For standard agile R&D projects")
    private String description;

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer projectType;

    @Schema(description = "Template status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer sort;

    @Schema(description = "Enabled work item type list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Integer> itemTypes;

    @Schema(description = "Work item statustemplate list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PmsProjectTemplateSaveReqVO.StatusTemplate> statuses;

    @Schema(description = "Board columnstemplatelist.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PmsProjectTemplateSaveReqVO.BoardTemplate> boards;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
