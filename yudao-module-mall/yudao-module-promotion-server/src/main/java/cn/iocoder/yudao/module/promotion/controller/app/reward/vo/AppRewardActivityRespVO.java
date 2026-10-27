package cn.iocoder.yudao.module.promotion.controller.app.reward.vo;

import cn.iocoder.yudao.module.promotion.controller.admin.reward.vo.RewardActivityBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "User App - spend-and-save campaign response.")
@Data
public class AppRewardActivityRespVO {

    @Schema(description = "Campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer id;

    @Schema(description = "Campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Campaign title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sold out")
    private String name;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

    @Schema(description = "Condition type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer conditionType;

    @Schema(description = "ProductRange.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer productScope;

    @Schema(description = "Product SPU code Array.", example = "1,2,3")
    private List<Long> productScopeValues;

    @Schema(description = "Discount rule Array.")
    private List<Rule> rules;

    @Schema(description = "Discount rule.")
    @Data
    public static class Rule extends RewardActivityBaseVO.Rule {

        @Schema(description = "Rule Description.")
        private String description; // 通过 {@link #limit}、{@link #discountPrice} 等字段进行拼接

    }

}
