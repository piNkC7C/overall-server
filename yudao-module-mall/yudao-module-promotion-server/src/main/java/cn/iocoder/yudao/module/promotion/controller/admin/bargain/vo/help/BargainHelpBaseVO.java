package cn.iocoder.yudao.module.promotion.controller.admin.bargain.vo.help;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 砍价助力 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class BargainHelpBaseVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5402")
    private Long userId;

    @Schema(description = "Bargain campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "16825")
    private Long activityId;

    @Schema(description = "Bargain record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1800")
    private Long recordId;

    @Schema(description = "Subtract bargain, unit: cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "32300")
    private Integer reducePrice;

}
