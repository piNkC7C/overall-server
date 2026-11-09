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

@Schema(description = "管理后台 - IoT 设备 Response VO")
@Data
@ExcelIgnoreUnannotated
public class IotDeviceRespVO {

    @Schema(description = "设备编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "177")
    private Long id;

    @Schema(description = "设备名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @ExcelProperty("Device Name")
    private String deviceName;

    @Schema(description = "设备备注名称", example = "John.")
    @ExcelProperty("Device Alias")
    private String nickname;

    @Schema(description = "设备序列号", example = "1024")
    @ExcelProperty("Device Serial Number")
    private String serialNumber;

    @Schema(description = "设备图片", example = "I am a software engineer")
    @ExcelProperty("Device Image")
    private String picUrl;

    @Schema(description = "设备分组编号数组", example = "1,2")
    private Set<Long> groupIds;

    @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "26202")
    @ExcelProperty("Product Code")
    private Long productId;

    @Schema(description = "产品名称", example = "Temperature and humidity sensor")
    private String productName; // 只有部分接口返回，例如 getDeviceLocationList

    @Schema(description = "产品标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Product Key")
    private String productKey;

    @Schema(description = "设备类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Device Type")
    private Integer deviceType;

    @Schema(description = "网关设备 ID", example = "16380")
    private Long gatewayId;

    @Schema(description = "设备状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Device Status", converter = DictConvert.class)
    @DictFormat(DEVICE_STATE)
    private Integer state;

    @Schema(description = "最后上线时间")
    @ExcelProperty("Last Online Time")
    private LocalDateTime onlineTime;

    @Schema(description = "最后离线时间")
    @ExcelProperty("Last Offline Time")
    private LocalDateTime offlineTime;

    @Schema(description = "设备激活时间")
    @ExcelProperty("Device Activation Time")
    private LocalDateTime activeTime;

    @Schema(description = "设备密钥，用于设备认证")
    @ExcelProperty("Device Secret")
    private String deviceSecret;

    @Schema(description = "设备配置", example = "{\"abc\": \"efg\"}")
    private String config;

    @Schema(description = "设备位置的纬度", example = "45.000000")
    private BigDecimal latitude;

    @Schema(description = "设备位置的经度", example = "45.000000")
    private BigDecimal longitude;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}