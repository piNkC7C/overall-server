package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.status;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS work item board setting save request.")
@Data
public class PmsWorkItemBoardConfigSaveReqVO {

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "Work item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Work item type is required.")
    @InEnum(PmsWorkItemTypeEnum.class)
    private Integer workItemType;

    @Schema(description = "Board columns.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "Board columns cannot be empty.")
    private List<Board> boards;

    @Schema(description = "Admin - PMS work itemBoard columns.")
    @Data
    public static class Board {

        @Schema(description = "Board columnsID.", example = "1024")
        private Long id;

        @Schema(description = "Board column name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "In progress.")
        @NotBlank(message = "Board column name cannot be empty.")
        @Size(max = 50, message = "Board column name cannot exceed 50 characters.")
        private String name;

        @Schema(description = "Relation status code list, can is empty.", example = "[1024, 2048]")
        @NotNull(message = "Relation status code list is required.")
        private List<Long> statusIds;

    }

}
