package cn.iocoder.yudao.module.iot.controller.admin.device.vo.device;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import static cn.iocoder.yudao.module.iot.enums.DictTypeConstants.DEVICE_STATE;

@Schema(description = "Admin - IoT device response.")
@Data
@ExcelIgnoreUnannotated
public class IotDeviceRespVO {

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "177")
    private Long id;

    @Schema(description = "Device name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @ExcelProperty("Device Name")
    private String deviceName;

    @Schema(description = "Device notes name.", example = "John.")
    @ExcelProperty("Device Alias")
    private String nickname;

    @Schema(description = "Device serial number.", example = "1024")
    @ExcelProperty("Device Serial Number")
    private String serialNumber;

    @Schema(description = "DeviceImage.", example = "I am a software engineer")
    @ExcelProperty("Device Image")
    private String picUrl;

    @Schema(description = "Device group ID list.", example = "1,2")
    private Set<Long> groupIds;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "26202")
    @ExcelProperty("Product Code")
    private Long productId;

    @Schema(description = "Product name.", example = "Temperature and humidity sensor")
    private String productName; // 只有部分接口返回，例如 getDeviceLocationList

    @Schema(description = "Product key.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Product Key")
    private String productKey;

    @Schema(description = "Device type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Device Type")
    private Integer deviceType;

    @Schema(description = "Gateway device ID.", example = "16380")
    private Long gatewayId;

    @Schema(description = "Device status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Device Status", converter = DictConvert.class)
    @DictFormat(DEVICE_STATE)
    private Integer state;

    @Schema(description = "Last Online")
    @ExcelProperty("Last Online Time")
    private LocalDateTime onlineTime;

    @Schema(description = "Last offline time.")
    @ExcelProperty("Last Offline Time")
    private LocalDateTime offlineTime;

    @Schema(description = "Device activation time.")
    @ExcelProperty("Device Activation Time")
    private LocalDateTime activeTime;

    @Schema(description = "Device secret, at device auth.")
    @ExcelProperty("Device Secret")
    private String deviceSecret;

    @Schema(description = "Devicesetting.", example = "{\"abc\": \"efg\"}")
    private String config;

    @Schema(description = "DeviceLocation Latitude.", example = "45.000000")
    private BigDecimal latitude;

    @Schema(description = "DeviceLocation Longitude.", example = "45.000000")
    private BigDecimal longitude;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}