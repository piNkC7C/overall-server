package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.scene;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - IoT scene automation update status request.")
@Data
public class IotSceneRuleUpdateStatusReqVO {

    @Schema(description = "Scene automation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Scene automation code is required.")
    private Long id;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Edit status must be {value}.")
    private Integer status;

}
