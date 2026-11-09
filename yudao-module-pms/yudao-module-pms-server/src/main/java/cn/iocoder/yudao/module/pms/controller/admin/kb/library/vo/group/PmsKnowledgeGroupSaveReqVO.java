package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - PMS 知识库分组新增/修改 Request VO")
@Data
public class PmsKnowledgeGroupSaveReqVO {

    @Schema(description = "知识库分组编号", example = "1024")
    private Long id;

    @Schema(description = "分组名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product knowledge base.")
    @NotBlank(message = "Group name is required.")
    @Size(max = 100, message = "Group name cannot exceed 100 characters.")
    private String name;

}
