package cn.iocoder.yudao.module.iot.core.topic.auth;

import cn.iocoder.yudao.module.iot.core.enums.IotDeviceMessageMethodEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * IoT 设备动态注册 Request DTO
 * <p>
 * 用于 {@link IotDeviceMessageMethodEnum#DEVICE_REGISTER} 消息的 params 参数
 * <p>
 * 直连设备/网关的一型一密动态注册：使用 productSecret 验证，返回 deviceSecret
 *
 * @author 芋道源码
 * @see <a href="https://help.aliyun.com/zh/iot/user-guide/unique-certificate-per-product-verification">阿里云 - 一型一密</a>
 */
@Data
public class IotDeviceRegisterReqDTO {

    /**
     * 产品标识
     */
    @NotEmpty(message = "Product key is required.")
    private String productKey;

    /**
     * 设备名称
     */
    @NotEmpty(message = "Device name is required.")
    private String deviceName;

    /**
     * 注册签名
     *
     * @see cn.iocoder.yudao.module.iot.core.util.IotProductAuthUtils#buildSign(String, String, String)
     */
    @NotEmpty(message = "Signature is required.")
    private String sign;

}
