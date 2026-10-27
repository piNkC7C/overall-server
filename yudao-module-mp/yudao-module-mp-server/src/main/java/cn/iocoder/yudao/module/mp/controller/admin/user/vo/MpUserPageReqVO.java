package cn.iocoder.yudao.module.mp.controller.admin.user.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Official Accountfollower page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpUserPageReqVO extends PageParam {

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Official Account account code is required.")
    private Long accountId;

    @Schema(description = "Official Accountfollower key, fuzzy match.", example = "o6_bmjrPTlm6_2sgVt7hMZOPfL2M")
    private String openid;

    @Schema(description = "WeChat ecosystem unique ID, fuzzy match.", example = "o6_bmjrPTlm6_2sgVt7hMZOPfL2M")
    private String unionId;

    @Schema(description = "Official AccountfollowerNickname, fuzzy match.", example = "Overall.")
    private String nickname;

}
