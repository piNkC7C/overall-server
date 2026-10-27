package cn.iocoder.yudao.module.iot.controller.admin.alert.vo.recrod;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - IoT alert record process request.")
@Data
public class IotAlertRecordProcessReqVO {

    @Schema(description = "Record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Record code is required.")
    private Long id;

    @Schema(description = "Process result ( notes ).", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alert handled. Issue resolved.")
    private String processRemark;

} 