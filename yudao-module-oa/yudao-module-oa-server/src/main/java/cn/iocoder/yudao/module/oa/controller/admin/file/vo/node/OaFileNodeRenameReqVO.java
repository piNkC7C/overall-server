package cn.iocoder.yudao.module.oa.controller.admin.file.vo.node;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "Cloud-drive rename request VO.")
@Data
public class OaFileNodeRenameReqVO {

    @Schema(description = "Node code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Node code is required.")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "office-supply-count.pdf")
    @NotBlank(message = "Name is required.")
    @Size(max = 255, message = "Name length cannot exceed 255 characters.")
    private String name;

}
