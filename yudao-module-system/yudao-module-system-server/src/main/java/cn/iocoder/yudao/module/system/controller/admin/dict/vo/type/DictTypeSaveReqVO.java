package cn.iocoder.yudao.module.system.controller.admin.dict.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Admin - dictionary type create or update request.")
@Data
public class DictTypeSaveReqVO {

    @Schema(description = "Dictionary type code.", example = "1024")
    private Long id;

    @Schema(description = "Dictionary name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Gender")
    @NotBlank(message = "Dictionary name is required.")
    @Size(max = 100, message = "Dictionary type name length cannot exceed 100 characters.")
    private String name;

    @Schema(description = "Dictionary type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "sys_common_sex")
    @NotNull(message = "Dictionary type is required.")
    @Size(max = 100, message = "Dictionary type type length cannot exceed 100 characters.")
    private String type;

    @Schema(description = "Status, see CommonStatusEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Happy note")
    private String remark;

}
