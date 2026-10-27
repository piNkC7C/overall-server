package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.status.PmsWorkItemStatusRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS work itemBoard columns response.")
@Data
public class PmsWorkItemBoardRespVO {

    @Schema(description = "Board columnsID.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Board column name.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Statuses mapped to this column.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PmsWorkItemStatusRespVO> statuses;

    @Schema(description = "Work item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PmsWorkItemRespVO> items;

}
