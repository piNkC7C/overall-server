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

@Schema(description = "管理后台 - IoT 产品物模型新增/修改 Request VO")
@Data
public class IotThingModelSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "产品ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "ProductID is required.")
    private Long productId;

    @Schema(description = "产品标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "temperature_001")
    @NotEmpty(message = "Product key is required.")
    private String productKey;

    @Schema(description = "功能标识", requiredMode = Schema.RequiredMode.REQUIRED, example = "temp_monitor")
    @NotEmpty(message = "Feature key is required.")
    private String identifier;

    @Schema(description = "功能名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Temperature monitor")
    @NotEmpty(message = "Feature name is required.")
    private String name;

    @Schema(description = "功能描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sensor for ambient temperature")
    private String description;

    @Schema(description = "功能类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Feature type is required.")
    @InEnum(IotThingModelTypeEnum.class)
    private Integer type;

    @Schema(description = "属性", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private ThingModelProperty property;

    @Schema(description = "服务", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private ThingModelService service;

    @Schema(description = "事件", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private ThingModelEvent event;

}