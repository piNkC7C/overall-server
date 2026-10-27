package cn.iocoder.yudao.module.system.mq.message.sms;

import cn.iocoder.yudao.framework.common.core.KeyValue;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * 短信发送消息
 *
 * @author 芋道源码
 */
@Data
public class SmsSendMessage {

    /**
     * 短信日志编号
     */
    @NotNull(message = "SMS Log ID is required.")
    private Long logId;
    /**
     * 手机号
     */
    @NotNull(message = "Phone number is required.")
    private String mobile;
    /**
     * 短信渠道编号
     */
    @NotNull(message = "SMS channel code is required.")
    private Long channelId;
    /**
     * 短信 API 的模板编号
     */
    @NotNull(message = "SMS API template code is required.")
    private String apiTemplateId;
    /**
     * 短信模板参数
     */
    private List<KeyValue<String, Object>> templateParams;

}
