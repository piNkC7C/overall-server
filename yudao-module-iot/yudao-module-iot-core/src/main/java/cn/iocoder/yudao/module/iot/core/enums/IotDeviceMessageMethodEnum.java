package cn.iocoder.yudao.module.iot.core.enums;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.framework.common.util.collection.SetUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Set;

/**
 * IoT 设备消息的方法枚举
 *
 * @author haohao
 */
@Getter
@AllArgsConstructor
public enum IotDeviceMessageMethodEnum implements ArrayValuable<String> {

    // ========== device status ==========

    STATE_UPDATE("thing.state.update", "Device statusupdate", true),

    // TODO 芋艿：要不要加个 ping 消息；

    // ========== topology admin ==========
    // 可参考：https://help.aliyun.com/zh/iot/user-guide/manage-topological-relationships

    TOPO_ADD("thing.topo.add", "Add topology", true),
    TOPO_DELETE("thing.topo.delete", "Remove topology", true),
    TOPO_GET("thing.topo.get", "Get topology", true),
    TOPO_CHANGE("thing.topo.change", "Topology change notice", false),

    // ========== device register ==========
    // 可参考：https://help.aliyun.com/zh/iot/user-guide/unique-certificate-per-product-verification

    DEVICE_REGISTER("thing.auth.register", "Device dynamic registration", true),
    SUB_DEVICE_REGISTER("thing.auth.register.sub", "Child device dynamic registration", true),

    // ========== device attribute ==========
    // 可参考：https://help.aliyun.com/zh/iot/user-guide/device-properties-events-and-services

    PROPERTY_POST("thing.property.post", "Property report", true),
    PROPERTY_SET("thing.property.set", "Attribute set", false),

    PROPERTY_PACK_POST("thing.event.property.pack.post", "Batch report (property + event + child device)", true), // 网关独有

    // ========== deviceEvent ==========
    // 可参考：https://help.aliyun.com/zh/iot/user-guide/device-properties-events-and-services

    EVENT_POST("thing.event.post", "Event report", true),

    // ========== device service call ==========
    // 可参考：https://help.aliyun.com/zh/iot/user-guide/device-properties-events-and-services

    SERVICE_INVOKE("thing.service.invoke", "Service call", false),

    // ========== devicesetting ==========
    // 可参考：https://help.aliyun.com/zh/iot/user-guide/remote-configuration-1

    CONFIG_PUSH("thing.config.push", "Config push", false),

    // ========== OTA firmware ==========
    // 可参考：https://help.aliyun.com/zh/iot/user-guide/perform-ota-updates

    OTA_UPGRADE("thing.ota.upgrade", "OTA firmware push", false),
    OTA_PROGRESS("thing.ota.progress", "OTA upgrade progress report", true),

    ;

    public static final String[] ARRAYS = Arrays.stream(values()).map(IotDeviceMessageMethodEnum::getMethod)
            .toArray(String[]::new);

    /**
     * 不进行 reply 回复的方法集合
     */
    public static final Set<String> REPLY_DISABLED = SetUtils.asSet(
            STATE_UPDATE.getMethod(),
            OTA_PROGRESS.getMethod() // 参考阿里云，OTA 升级进度上报，不进行回复
    );

    private final String method;

    private final String name;

    private final Boolean upstream;

    @Override
    public String[] array() {
        return ARRAYS;
    }

    public static IotDeviceMessageMethodEnum of(String method) {
        return ArrayUtil.firstMatch(item -> item.getMethod().equals(method),
                IotDeviceMessageMethodEnum.values());
    }

    public static boolean isReplyDisabled(String method) {
        return REPLY_DISABLED.contains(method);
    }

}
