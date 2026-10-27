package cn.iocoder.yudao.module.iot.gateway.protocol.websocket.handler.downstream;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.module.iot.core.mq.message.IotDeviceMessage;
import cn.iocoder.yudao.module.iot.gateway.protocol.websocket.manager.IotWebSocketConnectionManager;
import cn.iocoder.yudao.module.iot.gateway.serialize.IotMessageSerializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * IoT 网关 WebSocket 下行消息处理器
 *
 * @author 芋道源码
 */
@Slf4j
@RequiredArgsConstructor
public class IotWebSocketDownstreamHandler {

    private final IotMessageSerializer serializer;

    private final IotWebSocketConnectionManager connectionManager;

    /**
     * 处理下行消息
     */
    public void handle(IotDeviceMessage message) {
        try {
            log.info("[handle][处理下行消息，设备 ID: {}，方法: {}，消息 ID: {}]",
                    message.getDeviceId(), message.getMethod(), message.getId());

            // 1. get connect info
            IotWebSocketConnectionManager.ConnectionInfo connectionInfo = connectionManager.getConnectionInfoByDeviceId(
                    message.getDeviceId());
            if (connectionInfo == null) {
                log.error("[handle][ connect info was not found, device ID: {}].", message.getDeviceId());
                return;
            }

            // 2. 序列化
            byte[] bytes = serializer.serialize(message);
            String bytesContent = StrUtil.utf8Str(bytes);

            // 3. send to device
            boolean success = connectionManager.sendToDevice(connectionInfo.getDeviceId(), bytesContent);
            if (!success) {
                throw new RuntimeException("Downlink message send failed.");
            }
            log.info("[handle][下行消息发送成功，设备 ID: {}，方法: {}，消息 ID: {}，数据长度: {} 字节]",
                    message.getDeviceId(), message.getMethod(), message.getId(), bytes.length);
        } catch (Exception e) {
            log.error("[handle][处理下行消息失败，设备 ID: {}，方法: {}，消息内容: {}]",
                    message.getDeviceId(), message.getMethod(), message, e);
        }
    }

}
