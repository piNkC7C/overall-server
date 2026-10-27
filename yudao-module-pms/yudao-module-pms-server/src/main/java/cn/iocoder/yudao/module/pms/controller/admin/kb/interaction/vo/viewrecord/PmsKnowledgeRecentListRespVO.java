package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.viewrecord;

import cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.PmsKnowledgeInteractionItemRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS knowledge Recently Viewed response.")
@Data
public class PmsKnowledgeRecentListRespVO {

    @Schema(description = "TodayViews list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PmsKnowledgeInteractionItemRespVO> todayItems;

    @Schema(description = "YesterdayViews list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PmsKnowledgeInteractionItemRespVO> yesterdayItems;

    @Schema(description = "Older 30-day view list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PmsKnowledgeInteractionItemRespVO> recent30DayItems;

}
