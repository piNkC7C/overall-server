package cn.iocoder.yudao.module.system.controller.admin.permission.vo.role;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.Set;

@Schema(description = "Admin - role info response.")
@Data
@ExcelIgnoreUnannotated
public class RoleRespVO {

    @Schema(description = "Role code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Role Sequence")
    private Long id;

    @Schema(description = "Role name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Admin.")
    @ExcelProperty("Role Name")
    private String name;

    @Schema(description = "Role key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "admin")
    @NotBlank(message = "Role key cannot be empty.")
    @ExcelProperty("Role Key")
    private String code;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Role Sort")
    private Integer sort;

    @Schema(description = "Status, see CommonStatusEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Role Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Role type, see RoleTypeEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Notes.", example = "Me is one role.")
    private String remark;

    @Schema(description = "Data Range, see DataScopeEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Data Scope", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.DATA_SCOPE)
    private Integer dataScope;

    @Schema(description = "Custom dept IDs", example = "1")
    private Set<Long> dataScopeDeptIds;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    private LocalDateTime createTime;

}
