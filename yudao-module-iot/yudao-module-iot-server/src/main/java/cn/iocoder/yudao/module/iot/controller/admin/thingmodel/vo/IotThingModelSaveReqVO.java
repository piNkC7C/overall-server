package cn.iocoder.yudao.module.iot.controller.admin.thingmodel.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.ThingModelEvent;
import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.ThingModelProperty;
import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.ThingModelService;
import cn.iocoder.yudao.module.iot.enums.thingmodel.IotThingModelTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - IoT product thing model create / edit request.")
@Data
public class IotThingModelSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "ProductID.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "ProductID is required.")
    private Long productId;

    @Schema(description = "Product key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "temperature_001")
    @NotEmpty(message = "Product key is required.")
    private String productKey;

    @Schema(description = "Feature key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "temp_monitor")
    @NotEmpty(message = "Feature key is required.")
    private String identifier;

    @Schema(description = "Feature name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Temperature monitor")
    @NotEmpty(message = "Feature name is required.")
    private String name;

    @Schema(description = "Feature Description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sensor for ambient temperature")
    private String description;

    @Schema(description = "Feature type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Feature type is required.")
    @InEnum(IotThingModelTypeEnum.class)
    private Integer type;

    @Schema(description = "Property", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private ThingModelProperty property;

    @Schema(description = "Service", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private ThingModelService service;

    @Schema(description = "Event", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private ThingModelEvent event;

}