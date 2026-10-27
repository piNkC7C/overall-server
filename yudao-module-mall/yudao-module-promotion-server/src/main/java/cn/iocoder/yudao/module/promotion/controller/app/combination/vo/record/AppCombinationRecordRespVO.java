package cn.iocoder.yudao.module.promotion.controller.app.combination.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "User App - group buy record response.")
@Data
public class AppCombinationRecordRespVO {

    @Schema(description = "Group buy record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Group buy campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long activityId;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String nickname;

    @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String avatar;

    @Schema(description = "Expires at", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime expireTime;

    @Schema(description = "Group-buy capacity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer userSize;

    @Schema(description = "Joined group-buy count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer userCount;

    @Schema(description = "Group buy status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long orderId;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "I am Big Soybean")
    private String spuName;

    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String picUrl;

    @Schema(description = "Purchased quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer count;

    @Schema(description = "Group buy amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer combinationPrice;

}
