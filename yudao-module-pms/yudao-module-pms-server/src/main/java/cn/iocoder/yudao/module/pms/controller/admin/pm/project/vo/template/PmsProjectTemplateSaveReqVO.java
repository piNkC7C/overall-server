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

@Schema(description = "管理后台 - PMS 项目模板新增/修改 Request VO")
@Data
public class PmsProjectTemplateSaveReqVO {

    @Schema(description = "模板编号", example = "1024")
    private Long id;

    @Schema(description = "模板名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Agile template")
    @NotBlank(message = "Template name is required.")
    @Size(max = 100, message = "Template name cannot exceed 100 characters.")
    private String name;

    @Schema(description = "模板描述", example = "For standard agile R&D projects")
    @Size(max = 500, message = "TemplateDescription cannot exceed 500 characters.")
    private String description;

    @Schema(description = "项目类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Item type is required.")
    @InEnum(PmsProjectTypeEnum.class)
    private Integer projectType;

    @Schema(description = "模板状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Template status is required.")
    private Integer status;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "启用的工作项类型列表", requiredMode = Schema.RequiredMode.REQUIRED, example = "[2, 3, 4]")
    @NotEmpty(message = "Work item type is required.")
    private List<Integer> itemTypes;

    @Schema(description = "工作项状态模板列表", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Work item status is required.")
    private List<StatusTemplate> statuses;

    @Schema(description = "看板列模板列表", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Board columns cannot be empty.")
    private List<BoardTemplate> boards;

    @Schema(description = "工作项状态模板")
    @Data
    public static class StatusTemplate {

        @Schema(description = "模板内稳定编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "task_todo")
        @NotBlank(message = "Status code is required.")
        @Size(max = 50, message = "Status code cannot exceed 50 characters.")
        private String code;

        @Schema(description = "状态名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pending")
        @NotBlank(message = "Status name is required.")
        @Size(max = 50, message = "Status name cannot exceed 50 characters.")
        private String name;

        @Schema(description = "工作项类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        @NotNull(message = "Status work item type is required.")
        @InEnum(PmsWorkItemTypeEnum.class)
        private Integer workItemType;

        @Schema(description = "语义状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Semantic status is required.")
        @InEnum(PmsWorkItemStatusTypeEnum.class)
        private Integer statusType;

        @Schema(description = "是否为初始状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        @NotNull(message = "Is not is initial status is required.")
        private Boolean defaultStatus;

        @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
        @NotNull(message = "StatusSort is required.")
        private Integer sort;

        @Schema(description = "所属看板列编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "todo")
        @NotBlank(message = "Status board column cannot be empty.")
        private String boardCode;
    }

    @Schema(description = "看板列模板")
    @Data
    public static class BoardTemplate {

        @Schema(description = "模板内稳定编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "todo")
        @NotBlank(message = "Board column code cannot be empty.")
        @Size(max = 50, message = "Board column code cannot exceed 50 characters.")
        private String code;

        @Schema(description = "看板列名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pending")
        @NotBlank(message = "Board column name cannot be empty.")
        @Size(max = 50, message = "Board column name cannot exceed 50 characters.")
        private String name;

        @Schema(description = "工作项类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        @NotNull(message = "Board-column work-item type cannot be empty.")
        @InEnum(PmsWorkItemTypeEnum.class)
        private Integer workItemType;

        @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
        @NotNull(message = "Board-column sort order cannot be empty.")
        private Integer sort;

        @Schema(description = "关联的状态编码列表", requiredMode = Schema.RequiredMode.REQUIRED,
                example = "[\"task_todo\"]")
        @NotEmpty(message = "Board-column statuses cannot be empty.")
        private List<String> statusCodes;
    }

}
