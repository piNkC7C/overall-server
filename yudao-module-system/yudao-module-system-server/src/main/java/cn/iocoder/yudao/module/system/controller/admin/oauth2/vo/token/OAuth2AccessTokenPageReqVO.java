package cn.iocoder.yudao.module.system.controller.admin.oauth2.vo.token;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - access token page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OAuth2AccessTokenPageReqVO extends PageParam {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    private Long userId;

    @Schema(description = "User type. See UserTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer userType;

    @Schema(description = "Client code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private String clientId;

}
