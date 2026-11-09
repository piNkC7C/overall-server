package cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.rule;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 编码规则新增/修改 Request VO")
@Data
public class MesMdAutoCodeRuleSaveReqVO {

    @Schema(description = "规则 ID", example = "1024")
    private Long id;

    @Schema(description = "规则编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM_CODE")
    @NotEmpty(message = "Rule code is required.")
    private String code;

    @Schema(description = "规则名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material coding rule.")
    @NotEmpty(message = "Rule name is required.")
    private String name;

    @Schema(description = "描述", example = "At create material code.")
    private String description;

    @Schema(description = "最大长度", example = "20")
    private Integer maxLength;

    @Schema(description = "是否补齐", example = "true")
    private Boolean padded;

    @Schema(description = "补齐字符", example = "0")
    private String paddedChar;

    @Schema(description = "补齐方式", example = "1")
    private Integer paddedMethod;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}
