package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS knowledge base group sort request.")
@Data
public class PmsKnowledgeGroupSortReqVO {

    @Schema(description = "Knowledge base group sort item.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Knowledge base group sort item is required.")
    private List<@Valid Item> items;

    @Schema(description = "Admin - PMS knowledge base group sort item request.")
    @Data
    public static class Item {

        @Schema(description = "Knowledge base group code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Knowledge base group code is required.")
        private Long id;

        @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Sort is required.")
        @Min(value = 0, message = "Sort order cannot be less than 0.")
        private Integer sort;

    }

}
