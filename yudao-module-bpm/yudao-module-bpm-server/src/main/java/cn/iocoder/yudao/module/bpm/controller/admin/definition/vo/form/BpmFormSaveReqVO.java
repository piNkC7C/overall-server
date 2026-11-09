package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - 动态表单创建/更新 Request VO")
@Data
public class BpmFormSaveReqVO {

    @Schema(description = "表单编号", example = "1024")
    private Long id;

    @Schema(description = "表单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotNull(message = "Form name is required.")
    private String name;

    @Schema(description = "表单的配置-JSON 字符串", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Form setting is required.")
    private String conf;

    @Schema(description = "表单项的数组-JSON 字符串的数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Form item Array is required.")
    private List<String> fields;

    @Schema(description = "表单状态-参见 CommonStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Form status is required.")
    private Integer status;

    @Schema(description = "备注", example = "Sample notes")
    private String remark;

}
