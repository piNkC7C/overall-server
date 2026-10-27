package cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - Codegen table response.")
@Data
public class CodegenTableRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Generate scene, see CodegenSceneEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer scene;

    @Schema(description = "Table name", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    private String tableName;

    @Schema(description = "Table comment", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String tableComment;

    @Schema(description = "Notes.", example = "Sample notes")
    private String remark;

    @Schema(description = "Module name", requiredMode = Schema.RequiredMode.REQUIRED, example = "system")
    private String moduleName;

    @Schema(description = "Business name", requiredMode = Schema.RequiredMode.REQUIRED, example = "codegen")
    private String businessName;

    @Schema(description = "Class name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CodegenTable")
    private String className;

    @Schema(description = "Class Description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Codegen table definition")
    private String classComment;

    @Schema(description = "Author", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String author;

    @Schema(description = "Template type, see CodegenTemplateTypeEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer templateType;

    @Schema(description = "Frontend type, see CodegenFrontTypeEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer frontType;

    @Schema(description = "Parent menu code.", example = "1024")
    private Long parentMenuId;

    @Schema(description = "Master table ID", example = "2048")
    private Long masterTableId;
    @Schema(description = "Join column ID", example = "4096")
    private Long subJoinColumnId;
    @Schema(description = "One-to-many with master", example = "4096")
    private Boolean subJoinMany;

    @Schema(description = "Tree parent column ID", example = "8192")
    private Long treeParentColumnId;
    @Schema(description = "Tree name column ID", example = "16384")
    private Long treeNameColumnId;

    @Schema(description = "Primary key code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer dataSourceConfigId;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}
