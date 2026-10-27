package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.recrod;

import cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.activity.CombinationActivityRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - group buy record page item response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CombinationRecordPageItemRespVO extends CombinationRecordBaseVO {

    @Schema(description = "Group buyLengthNickname.", example = "Overall.")
    private String headNickname;

    // ========== 活动相关 ==========

    private CombinationActivityRespVO activity;

}
