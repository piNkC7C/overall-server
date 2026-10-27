package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.sink;

import cn.iocoder.yudao.module.iot.dal.dataobject.rule.config.IotAbstractDataSinkConfig;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT data flow destination response.")
@Data
public class IotDataSinkRespVO {

    @Schema(description = "Data destination code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18564")
    private Long id;

    @Schema(description = "Data destination name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    private String name;

    @Schema(description = "Data destination Description.", example = "Sample.")
    private String description;

    @Schema(description = "Data destination status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Data destination type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Data destination setting.")
    private IotAbstractDataSinkConfig config;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}