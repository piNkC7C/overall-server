package cn.iocoder.yudao.module.iot.controller.admin.device.vo.property;

import cn.iocoder.yudao.module.iot.dal.dataobject.thingmodel.model.dataType.ThingModelDataSpecs;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "IoT device attribute detail response VO.") // 额外增加 来自 ThingModelProperty 的变量 属性
@Data
public class IotDevicePropertyDetailRespVO extends IotDevicePropertyRespVO {

    @Schema(description = "Attribute name.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Data type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "int")
    private String dataType;

    @Schema(description = "Data Definition")
    private ThingModelDataSpecs dataSpecs;

    @Schema(description = "Data Definition list.")
    private List<ThingModelDataSpecs> dataSpecsList;

}