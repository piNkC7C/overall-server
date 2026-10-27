package cn.iocoder.yudao.module.iot.gateway.protocol.tcp.codec;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ReflectUtil;
import cn.iocoder.yudao.module.iot.gateway.protocol.tcp.IotTcpConfig;

/**
 * IoT TCP 帧编解码器工厂
 *
 * @author 芋道源码
 */
public class IotTcpFrameCodecFactory {

    /**
     * 根据配置创建编解码器
     *
     * @param config 拆包配置
     * @return 编解码器实例，如果配置为空则返回 null
     */
    public static IotTcpFrameCodec create(IotTcpConfig.CodecConfig config) {
        Assert.notNull(config, "CodecConfig cannot be empty");
        IotTcpCodecTypeEnum type = IotTcpCodecTypeEnum.of(config.getType());
        Assert.notNull(type, "Unsupported CodecType: " + config.getType());
        return ReflectUtil.newInstance(type.getCodecClass(), config);
    }

}
