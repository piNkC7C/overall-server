package cn.iocoder.yudao.module.mp.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - Official Accountfollower response.")
@Data
public class MpUserRespVO  {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Official Accountfollower key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "o6_bmjrPTlm6_2sgVt7hMZOPfL2M")
    private String openid;

    @Schema(description = "WeChat ecosystem unique ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "o6_bmjrPTlm6_2sgVt7hMZOPfL2M")
    private String unionId;

    @Schema(description = "Follow status see CommonStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer subscribeStatus;
    @Schema(description = "Follow time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime subscribeTime;
    @Schema(description = "Cancel follow time.")
    private LocalDateTime unsubscribeTime;

    @Schema(description = "Nickname", example = "Overall.")
    private String nickname;
    @Schema(description = "AvatarAddress.", example = "https://www.iocoder.cn/1.png")
    private String headImageUrl;
    @Schema(description = "Language.", example = "zh_CN")
    private String language;
    @Schema(description = "Country.", example = "China")
    private String country;
    @Schema(description = "Province.", example = "California")
    private String province;
    @Schema(description = "City.", example = "San Jose")
    private String city;
    @Schema(description = "Notes.", example = "Are you a potato?")
    private String remark;

    @Schema(description = "Tag ID list.", example = "1,2,3")
    private List<Long> tagIds;

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long accountId;
    @Schema(description = "Official Account account appId.", requiredMode = Schema.RequiredMode.REQUIRED, example = "wx1234567890")
    private String appId;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
