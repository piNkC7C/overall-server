package cn.iocoder.yudao.module.iot.controller.admin.device.vo.device;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Schema(description = "Admin - IoT device create / edit request.")
@Data
public class IotDeviceSaveReqVO {

    @Schema(description = "Device code.", example = "177")
    private Long id;

    @Schema(description = "Device name.", requiredMode = Schema.RequiredMode.AUTO, example = "Alex.")
    private String deviceName;

    @Schema(description = "Notes name.", example = "John.")
    private String nickname;

    @Schema(description = "Device serial number.", example = "123456")
    private String serialNumber;

    @Schema(description = "DeviceImage.", example = "https://iocoder.cn/1.png")
    private String picUrl;

    @Schema(description = "Device group ID list.", example = "1,2")
    private Set<Long> groupIds;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "26202")
    private Long productId;

    @Schema(description = "Gateway device ID.", example = "16380")
    private Long gatewayId;

    @Schema(description = "Devicesetting.", example = "{\"abc\": \"efg\"}")
    private String config;

    @Schema(description = "DeviceLocation Latitude.", example = "39.915")
    @DecimalMin(value = "-90", message = "LatitudeRange is -90 to 90.")
    @DecimalMax(value = "90", message = "LatitudeRange is -90 to 90.")
    private BigDecimal latitude;

    @Schema(description = "DeviceLocation Longitude.", example = "116.404")
    @DecimalMin(value = "-180", message = "LongitudeRange is -180 to 180.")
    @DecimalMax(value = "180", message = "LongitudeRange is -180 to 180.")
    private BigDecimal longitude;

}