package cn.iocoder.yudao.module.iot.controller.admin.product.vo.product;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.iot.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - IoT product response.")
@Data
@ExcelIgnoreUnannotated
public class IotProductRespVO {

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "26087")
    @ExcelProperty("Product Code")
    private Long id;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @ExcelProperty("Product Name")
    private String name;

    @Schema(description = "Product key.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Product Key")
    private String productKey;

    @Schema(description = "Product secret.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String productSecret;

    @Schema(description = "Is not enable dynamic registration.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean registerEnabled;

    @Schema(description = "Product category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long categoryId;

    @Schema(description = "Product category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Product Category")
    private String categoryName;

    @Schema(description = "ProductIcon.", example = "https://iocoder.cn/1.svg")
    @ExcelProperty("Product Icon")
    private String icon;

    @Schema(description = "ProductImage.", example = "https://iocoder.cn/1.png")
    @ExcelProperty("Product Image")
    private String picUrl;

    @Schema(description = "ProductDescription.", example = "Example.")
    @ExcelProperty("Product Description")
    private String description;

    @Schema(description = "Product status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Product Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PRODUCT_STATUS)
    private Integer status;

    @Schema(description = "Device type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty(value = "Device Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PRODUCT_DEVICE_TYPE)
    private Integer deviceType;

    @Schema(description = "Network mode.", example = "2")
    @ExcelProperty(value = "Network Mode", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.NET_TYPE)
    private Integer netType;

    @Schema(description = "Protocol type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "mqtt")
    @ExcelProperty(value = "Protocol Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PROTOCOL_TYPE)
    private String protocolType;

    @Schema(description = "Serialization type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "json")
    @ExcelProperty(value = "Serializer Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SERIALIZE_TYPE)
    private String serializeType;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
