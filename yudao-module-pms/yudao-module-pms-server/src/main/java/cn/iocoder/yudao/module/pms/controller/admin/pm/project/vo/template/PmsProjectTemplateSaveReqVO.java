package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.template;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.project.PmsProjectTypeEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemStatusTypeEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS item template create / edit request.")
@Data
public class PmsProjectTemplateSaveReqVO {

    @Schema(description = "Template code.", example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Agile template")
    @NotBlank(message = "Template name is required.")
    @Size(max = 100, message = "Template name cannot exceed 100 characters.")
    private String name;

    @Schema(description = "TemplateDescription.", example = "For standard agile R&D projects")
    @Size(max = 500, message = "TemplateDescription cannot exceed 500 characters.")
    private String description;

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Item type is required.")
    @InEnum(PmsProjectTypeEnum.class)
    private Integer projectType;

    @Schema(description = "Template status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Template status is required.")
    private Integer status;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Enabled work item type list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[2, 3, 4]")
    @NotEmpty(message = "Work item type is required.")
    private List<Integer> itemTypes;

    @Schema(description = "Work item statustemplate list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Work item status is required.")
    private List<StatusTemplate> statuses;

    @Schema(description = "Board columnstemplatelist.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Board columns cannot be empty.")
    private List<BoardTemplate> boards;

    @Schema(description = "Work item statustemplate.")
    @Data
    public static class StatusTemplate {

        @Schema(description = "Stable template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "task_todo")
        @NotBlank(message = "Status code is required.")
        @Size(max = 50, message = "Status code cannot exceed 50 characters.")
        private String code;

        @Schema(description = "Status name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pending")
        @NotBlank(message = "Status name is required.")
        @Size(max = 50, message = "Status name cannot exceed 50 characters.")
        private String name;

        @Schema(description = "Work item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        @NotNull(message = "Status work item type is required.")
        @InEnum(PmsWorkItemTypeEnum.class)
        private Integer workItemType;

        @Schema(description = "Semantic status", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Semantic status is required.")
        @InEnum(PmsWorkItemStatusTypeEnum.class)
        private Integer statusType;

        @Schema(description = "Is not is initial status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        @NotNull(message = "Is not is initial status is required.")
        private Boolean defaultStatus;

        @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
        @NotNull(message = "StatusSort is required.")
        private Integer sort;

        @Schema(description = "Board column key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "todo")
        @NotBlank(message = "Status board column cannot be empty.")
        private String boardCode;
    }

    @Schema(description = "Board columnstemplate.")
    @Data
    public static class BoardTemplate {

        @Schema(description = "Stable template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "todo")
        @NotBlank(message = "Board column code cannot be empty.")
        @Size(max = 50, message = "Board column code cannot exceed 50 characters.")
        private String code;

        @Schema(description = "Board column name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pending")
        @NotBlank(message = "Board column name cannot be empty.")
        @Size(max = 50, message = "Board column name cannot exceed 50 characters.")
        private String name;

        @Schema(description = "Work item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        @NotNull(message = "Board-column work-item type cannot be empty.")
        @InEnum(PmsWorkItemTypeEnum.class)
        private Integer workItemType;

        @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
        @NotNull(message = "Board-column sort order cannot be empty.")
        private Integer sort;

        @Schema(description = "Relation status code list.", requiredMode = Schema.RequiredMode.REQUIRED,
                example = "[\"task_todo\"]")
        @NotEmpty(message = "Board-column statuses cannot be empty.")
        private List<String> statusCodes;
    }

}
