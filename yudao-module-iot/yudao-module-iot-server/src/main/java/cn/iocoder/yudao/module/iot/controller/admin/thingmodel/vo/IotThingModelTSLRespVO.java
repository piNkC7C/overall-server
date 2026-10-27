package cn.iocoder.yudao.module.iot.controller.admin.thingmodel.vo;

import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.ThingModelEvent;
import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.ThingModelProperty;
import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.ThingModelService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - IoT product thing model TSL response.")
@Data
public class IotThingModelTSLRespVO {

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long productId;

    @Schema(description = "Product key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "temperature_sensor")
    private String productKey;

    @Schema(description = "Attribute list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ThingModelProperty> properties;

    @Schema(description = "Service list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ThingModelEvent> events;

    @Schema(description = "Event list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ThingModelService> services;

}