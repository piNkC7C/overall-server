package cn.iocoder.yudao.module.pay.controller.admin.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - payment app info response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayAppRespVO extends PayAppBaseVO {

    @Schema(description = "App code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "App key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    private String appKey;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
