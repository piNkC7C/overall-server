package cn.iocoder.yudao.module.system.controller.admin.oauth2.vo.open;

import cn.iocoder.yudao.framework.common.core.KeyValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "Authorization page info response VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2OpenAuthorizeInfoRespVO {

    /**
     * 客户端
     */
    private Client client;

    @Schema(description = "Selected scopes as an ordered list. Key is scope. Value is selected.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<KeyValue<String, Boolean>> scopes;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Client {

        @Schema(description = "App name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato.")
        private String name;

        @Schema(description = "App icon", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png")
        private String logo;

    }

}
