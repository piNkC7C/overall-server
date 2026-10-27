package cn.iocoder.yudao.module.iot.controller.admin.device.vo.device;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelProperty;

/**
 * 设备 Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IotDeviceImportExcelVO {

    @ExcelProperty("Device Name")
    @NotEmpty(message = "Device name is required.")
    private String deviceName;

    @ExcelProperty("Parent Device Name")
    @Schema(description = "Parent device name.", example = "Gateway 001.")
    private String parentDeviceName;

    @ExcelProperty("Product Key")
    @NotEmpty(message = "Product key is required.")
    private String productKey;

    @ExcelProperty("Device Group")
    private String groupNames;

}
