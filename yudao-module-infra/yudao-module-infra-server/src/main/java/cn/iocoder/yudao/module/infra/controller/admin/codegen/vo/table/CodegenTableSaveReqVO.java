package cn.iocoder.yudao.module.infra.controller.admin.codegen.vo.table;

import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.module.infra.enums.codegen.CodegenSceneEnum;
import cn.iocoder.yudao.module.infra.enums.codegen.CodegenTemplateTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Admin - Codegen table create or update response.")
@Data
public class CodegenTableSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Generate scene, see CodegenSceneEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Import type is required.")
    private Integer scene;

    @Schema(description = "Table name", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @NotNull(message = "Table name is required.")
    private String tableName;

    @Schema(description = "Table comment", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotNull(message = "Table comment is required.")
    private String tableComment;

    @Schema(description = "Notes.", example = "Sample notes")
    private String remark;

    @Schema(description = "Module name", requiredMode = Schema.RequiredMode.REQUIRED, example = "system")
    @NotNull(message = "Module name is required.")
    @Pattern(regexp = "^[a-z][a-z0-9]*$", message = "Module name may contain only lowercase letters and digits, and cannot start with a digit.")
    private String moduleName;

    @Schema(description = "Business name", requiredMode = Schema.RequiredMode.REQUIRED, example = "codegen")
    @NotNull(message = "Business name is required.")
    @Pattern(regexp = "^[a-z][a-z0-9]*$", message = "Business name may contain only lowercase letters and digits, and cannot start with a digit.")
    private String businessName;

    @Schema(description = "Class name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CodegenTable")
    @NotNull(message = "Class name is required.")
    @Pattern(regexp = "^[A-Z][A-Za-z0-9]*$", message = "Class name must start with an uppercase letter and contain only letters and digits.")
    private String className;

    @Schema(description = "Class Description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Codegen table definition")
    @NotNull(message = "Class Description is required.")
    private String classComment;

    @Schema(description = "Author", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotNull(message = "Author is required.")
    private String author;

    @Schema(description = "Template type, see CodegenTemplateTypeEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Template type is required.")
    private Integer templateType;

    @Schema(description = "Frontend type, see CodegenFrontTypeEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @NotNull(message = "Frontend type is required.")
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

    @AssertTrue(message = "Parent menu is required. Open [Edit Generate Settings -> Generate Info] and set Parent Menu.")
    @JsonIgnore
    public boolean isParentMenuIdValid() {
        // 生成场景为管理后台时，必须设置上级菜单，不然生成的菜单 SQL 是无父级菜单的
        return ObjectUtil.notEqual(getScene(), CodegenSceneEnum.ADMIN.getScene())
                || getParentMenuId() != null;
    }

    @AssertTrue(message = "Related parent-table info is incomplete.")
    @JsonIgnore
    public boolean isSubValid() {
        return ObjectUtil.notEqual(getTemplateType(), CodegenTemplateTypeEnum.SUB)
                || (ObjectUtil.isAllNotEmpty(masterTableId, subJoinColumnId, subJoinMany));
    }

    @AssertTrue(message = "Related tree-table info is incomplete.")
    @JsonIgnore
    public boolean isTreeValid() {
        return ObjectUtil.notEqual(templateType, CodegenTemplateTypeEnum.TREE)
                || (ObjectUtil.isAllNotEmpty(treeParentColumnId, treeNameColumnId));
    }

}
