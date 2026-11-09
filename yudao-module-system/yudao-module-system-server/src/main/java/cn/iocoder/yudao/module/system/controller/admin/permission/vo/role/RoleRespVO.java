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

@Schema(description = "管理后台 - 角色信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class RoleRespVO {

    @Schema(description = "角色编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Role Sequence")
    private Long id;

    @Schema(description = "角色名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Admin.")
    @ExcelProperty("Role Name")
    private String name;

    @Schema(description = "角色标志", requiredMode = Schema.RequiredMode.REQUIRED, example = "admin")
    @NotBlank(message = "Role key cannot be empty.")
    @ExcelProperty("Role Key")
    private String code;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Role Sort")
    private Integer sort;

    @Schema(description = "状态，参见 CommonStatusEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Role Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "角色类型，参见 RoleTypeEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "备注", example = "Me is one role.")
    private String remark;

    @Schema(description = "数据范围，参见 DataScopeEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Data Scope", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.DATA_SCOPE)
    private Integer dataScope;

    @Schema(description = "数据范围(指定部门数组)", example = "1")
    private Set<Long> dataScopeDeptIds;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    private LocalDateTime createTime;

}
