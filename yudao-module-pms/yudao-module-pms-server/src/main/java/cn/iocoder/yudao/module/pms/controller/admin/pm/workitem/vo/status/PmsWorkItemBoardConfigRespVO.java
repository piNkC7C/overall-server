package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.status;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS work item board setting response.")
@Data
public class PmsWorkItemBoardConfigRespVO {

    @Schema(description = "Board columns.")
    private List<Board> boards;

    @Schema(description = "Status IDs not on the board.")
    private List<Long> unassignedStatusIds;

    @Data
    public static class Board {

        @Schema(description = "Board columnsID.")
        private Long id;

        @Schema(description = "Board column name.")
        private String name;

        @Schema(description = "Relation status code list.")
        private List<Long> statusIds;
    }

}
