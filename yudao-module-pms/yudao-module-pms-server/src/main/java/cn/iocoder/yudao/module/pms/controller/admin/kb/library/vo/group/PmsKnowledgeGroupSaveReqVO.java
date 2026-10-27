package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - PMS knowledge base group create / edit request.")
@Data
public class PmsKnowledgeGroupSaveReqVO {

    @Schema(description = "Knowledge base group code.", example = "1024")
    private Long id;

    @Schema(description = "Group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product knowledge base.")
    @NotBlank(message = "Group name is required.")
    @Size(max = 100, message = "Group name cannot exceed 100 characters.")
    private String name;

}
