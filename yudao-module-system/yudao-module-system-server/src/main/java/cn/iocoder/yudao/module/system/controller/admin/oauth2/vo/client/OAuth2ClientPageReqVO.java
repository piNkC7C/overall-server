package cn.iocoder.yudao.module.system.controller.admin.oauth2.vo.client;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - OAuth2 client page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OAuth2ClientPageReqVO extends PageParam {

    @Schema(description = "App name, fuzzy match.", example = "Potato.")
    private String name;

    @Schema(description = "Status, see CommonStatusEnum enum.", example = "1")
    private Integer status;

}
