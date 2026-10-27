package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS knowledge base group response.")
@Data
public class PmsKnowledgeGroupRespVO {

    @Schema(description = "Knowledge base group code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product knowledge base.")
    private String name;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Group type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer type;

    @Schema(description = "Knowledge bases in the group.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer libraryCount;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
