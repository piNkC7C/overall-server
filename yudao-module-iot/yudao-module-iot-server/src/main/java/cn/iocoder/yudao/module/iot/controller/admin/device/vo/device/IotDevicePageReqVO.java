package cn.iocoder.yudao.module.iot.controller.admin.device.vo.device;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.core.enums.device.IotDeviceStateEnum;
import cn.iocoder.yudao.module.iot.enums.product.IotProductDeviceTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - IoT device page request.")
@Data
public class IotDevicePageReqVO extends PageParam {

    @Schema(description = "Device name.", example = "Alex.")
    private String deviceName;

    @Schema(description = "Notes name.", example = "John.")
    private String nickname;

    @Schema(description = "Product code.", example = "26202")
    private Long productId;

    @Schema(description = "Device type.", example = "1")
    @InEnum(IotProductDeviceTypeEnum.class)
    private Integer deviceType;

    @Schema(description = "Device status.", example = "1")
    @InEnum(IotDeviceStateEnum.class)
    private Integer status;

    @Schema(description = "Device group code.", example = "1024")
    private Long groupId;

    @Schema(description = "Gateway device ID.", example = "16380")
    private Long gatewayId;

}