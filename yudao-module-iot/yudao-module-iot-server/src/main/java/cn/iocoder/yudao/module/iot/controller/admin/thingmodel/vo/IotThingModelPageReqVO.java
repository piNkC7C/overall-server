package cn.iocoder.yudao.module.iot.controller.admin.thingmodel.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.enums.thingmodel.IotThingModelTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - IoT product thing model page request.")
@Data
public class IotThingModelPageReqVO extends PageParam {

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Product code is required.")
    private Long productId;

    @Schema(description = "Feature key.", example = "temperature")
    private String identifier;

    @Schema(description = "Feature name.", example = "Temperature")
    private String name;

    @Schema(description = "Feature type.", example = "1")
    @InEnum(IotThingModelTypeEnum.class)
    private Integer type;

}