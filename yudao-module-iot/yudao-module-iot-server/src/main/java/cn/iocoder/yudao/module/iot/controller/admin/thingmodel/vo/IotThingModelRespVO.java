package cn.iocoder.yudao.module.iot.controller.admin.thingmodel.vo;

import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.ThingModelEvent;
import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.ThingModelProperty;
import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.ThingModelService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT product thing model response.")
@Data
public class IotThingModelRespVO {

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "21816")
    private Long id;

    @Schema(description = "Product key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long productId;

    @Schema(description = "Product key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "temperature_sensor")
    private String productKey;

    @Schema(description = "Feature key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "temperature")
    private String identifier;

    @Schema(description = "Feature name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Temperature")
    private String name;

    @Schema(description = "Feature Description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Measure the current ambient temperature")
    private String description;

    @Schema(description = "Feature type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Property", requiredMode = Schema.RequiredMode.REQUIRED)
    private ThingModelProperty property;

    @Schema(description = "Service", requiredMode = Schema.RequiredMode.REQUIRED)
    private ThingModelEvent event;

    @Schema(description = "Event", requiredMode = Schema.RequiredMode.REQUIRED)
    private ThingModelService service;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}