package cn.iocoder.yudao.module.system.controller.admin.social.vo.client;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - social client page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SocialClientPageReqVO extends PageParam {

    @Schema(description = "App name.", example = "Yudao shop.")
    private String name;

    @Schema(description = "Social platform type", example = "31")
    private Integer socialType;

    @Schema(description = "User type.", example = "2")
    private Integer userType;

    @Schema(description = "Client code.", example = "145442115")
    private String clientId;

    @Schema(description = "Status.", example = "1")
    private Integer status;

}
