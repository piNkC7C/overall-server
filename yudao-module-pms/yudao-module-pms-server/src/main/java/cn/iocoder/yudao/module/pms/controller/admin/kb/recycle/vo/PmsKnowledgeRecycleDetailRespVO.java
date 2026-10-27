package cn.iocoder.yudao.module.pms.controller.admin.kb.recycle.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS knowledge base recycle bin details response.")
@Data
public class PmsKnowledgeRecycleDetailRespVO {

    @Schema(description = "Root recycle-bin record.")
    private PmsKnowledgeRecycleRespVO root;

    @Schema(description = "Cascade-deleted content.")
    private List<Item> children;

    @Data
    public static class Item {

        @Schema(description = "Content code.", requiredMode = Schema.RequiredMode.REQUIRED)
        private Long id;

        @Schema(description = "Content type.", requiredMode = Schema.RequiredMode.REQUIRED)
        private Integer type;

        @Schema(description = "Content name.", requiredMode = Schema.RequiredMode.REQUIRED)
        private String name;

        @Schema(description = "Parent document or parent folder code.")
        private Long parentId;

        @Schema(description = "Folder code.")
        private Long folderId;

        @Schema(description = "Delete time.")
        private LocalDateTime deleteTime;

    }
}
