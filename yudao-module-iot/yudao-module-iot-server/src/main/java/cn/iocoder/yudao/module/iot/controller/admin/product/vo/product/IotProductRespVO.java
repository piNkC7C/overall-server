package cn.iocoder.yudao.module.iot.controller.admin.product.vo.product;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.iot.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - IoT 产品 Response VO")
@Data
@ExcelIgnoreUnannotated
public class IotProductRespVO {

    @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "26087")
    @ExcelProperty("Product Code")
    private Long id;

    @Schema(description = "产品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @ExcelProperty("Product Name")
    private String name;

    @Schema(description = "产品标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Product Key")
    private String productKey;

    @Schema(description = "产品密钥", requiredMode = Schema.RequiredMode.REQUIRED)
    private String productSecret;

    @Schema(description = "是否开启动态注册", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean registerEnabled;

    @Schema(description = "产品分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long categoryId;

    @Schema(description = "产品分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Product Category")
    private String categoryName;

    @Schema(description = "产品图标", example = "https://iocoder.cn/1.svg")
    @ExcelProperty("Product Icon")
    private String icon;

    @Schema(description = "产品图片", example = "https://iocoder.cn/1.png")
    @ExcelProperty("Product Image")
    private String picUrl;

    @Schema(description = "产品描述", example = "Example.")
    @ExcelProperty("Product Description")
    private String description;

    @Schema(description = "产品状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Product Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PRODUCT_STATUS)
    private Integer status;

    @Schema(description = "设备类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty(value = "Device Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PRODUCT_DEVICE_TYPE)
    private Integer deviceType;

    @Schema(description = "联网方式", example = "2")
    @ExcelProperty(value = "Network Mode", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.NET_TYPE)
    private Integer netType;

    @Schema(description = "协议类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "mqtt")
    @ExcelProperty(value = "Protocol Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.PROTOCOL_TYPE)
    private String protocolType;

    @Schema(description = "序列化类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "json")
    @ExcelProperty(value = "Serializer Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SERIALIZE_TYPE)
    private String serializeType;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
