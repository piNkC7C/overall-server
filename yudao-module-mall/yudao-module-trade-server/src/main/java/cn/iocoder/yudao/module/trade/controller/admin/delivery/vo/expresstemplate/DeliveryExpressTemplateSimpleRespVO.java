package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.expresstemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema(description = "Admin - template simple info response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryExpressTemplateSimpleRespVO {

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test template")
    private String name;

}
