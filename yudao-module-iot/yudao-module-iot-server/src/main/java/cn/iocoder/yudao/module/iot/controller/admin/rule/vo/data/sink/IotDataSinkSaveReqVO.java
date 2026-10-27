package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.sink;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.dal.dataobject.rule.config.IotAbstractDataSinkConfig;
import cn.iocoder.yudao.module.iot.enums.rule.IotDataSinkTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - IoT data flow destination create / edit request.")
@Data
public class IotDataSinkSaveReqVO {

    @Schema(description = "Data destination code.", example = "18564")
    private Long id;

    @Schema(description = "Data destination name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    @NotEmpty(message = "Data destination name is required.")
    private String name;

    @Schema(description = "Data destination Description.", example = "Sample.")
    private String description;

    @Schema(description = "Data destination status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Data destination status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Data destination type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Data destination type is required.")
    @InEnum(IotDataSinkTypeEnum.class)
    private Integer type;

    @Schema(description = "Data destination setting.")
    @NotNull(message = "Data destination setting is required.")
    private IotAbstractDataSinkConfig config;

}