package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "App - distribution rankinguser (based onuser count) response.")
@Data
public class AppBrokerageUserRankByUserCountRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long id;

    @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex")
    private String nickname;

    @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xxx.jpg")
    private String avatar;

    @Schema(description = "Invited user count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer brokerageUserCount;

}
