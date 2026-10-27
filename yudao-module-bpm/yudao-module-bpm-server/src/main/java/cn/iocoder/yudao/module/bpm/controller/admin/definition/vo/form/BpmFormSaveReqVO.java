package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - dynamic form create or update request.")
@Data
public class BpmFormSaveReqVO {

    @Schema(description = "Form code.", example = "1024")
    private Long id;

    @Schema(description = "Form name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotNull(message = "Form name is required.")
    private String name;

    @Schema(description = "Form setting-JSON String.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Form setting is required.")
    private String conf;

    @Schema(description = "Form item Array-JSON String Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Form item Array is required.")
    private List<String> fields;

    @Schema(description = "Form status- see CommonStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Form status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Sample notes")
    private String remark;

}
