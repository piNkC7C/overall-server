package cn.iocoder.yudao.module.iot.controller.admin.product.vo.product;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.core.enums.IotProtocolTypeEnum;
import cn.iocoder.yudao.module.iot.core.enums.IotSerializeTypeEnum;
import cn.iocoder.yudao.module.iot.enums.product.IotNetTypeEnum;
import cn.iocoder.yudao.module.iot.enums.product.IotProductDeviceTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - IoT 产品新增/修改 Request VO")
@Data
public class IotProductSaveReqVO {

    @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;

    @Schema(description = "产品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Temperature and humidity")
    @NotEmpty(message = "Product name is required.")
    private String name;

    @Schema(description = "产品 Key", requiredMode = Schema.RequiredMode.AUTO, example = "12345abc")
    private String productKey;

    @Schema(description = "产品分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product category code is required.")
    private Long categoryId;

    @Schema(description = "产品图标", example = "https://iocoder.cn/1.svg")
    private String icon;

    @Schema(description = "产品图片", example = "https://iocoder.cn/1.png")
    private String picUrl;

    @Schema(description = "产品描述", example = "Description")
    private String description;

    @Schema(description = "设备类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @InEnum(value = IotProductDeviceTypeEnum.class, message = "Device type must be {value}.")
    @NotNull(message = "Device type is required.")
    private Integer deviceType;

    @Schema(description = "联网方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @InEnum(value = IotNetTypeEnum.class, message = "Network mode must be {value}.")
    private Integer netType;

    @Schema(description = "协议类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "mqtt")
    @InEnum(value = IotProtocolTypeEnum.class, message = "Protocol type must be {value}.")
    @NotEmpty(message = "Protocol type cannot be empty.")
    private String protocolType;

    @Schema(description = "序列化类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "json")
    @InEnum(value = IotSerializeTypeEnum.class, message = "Serialization type must be {value}.")
    @NotEmpty(message = "Serialization type cannot be empty.")
    private String serializeType;

    @Schema(description = "是否开启动态注册", example = "false")
    @NotNull(message = "Is not enable dynamic registration is required.")
    private Boolean registerEnabled;

}