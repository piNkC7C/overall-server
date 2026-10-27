package cn.iocoder.yudao.module.iot.controller.admin.alert.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - IoT alert setting response.")
@Data
public class IotAlertConfigRespVO {

    @Schema(description = "Setting code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3566")
    private Long id;

    @Schema(description = "Setting name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    private String name;

    @Schema(description = "SettingDescription.", example = "Example.")
    private String description;

    @Schema(description = "Alert level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer level;

    @Schema(description = "Setting status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Relation scene automation rule ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1,2,3")
    private List<Long> sceneRuleIds;

    @Schema(description = "Receive user ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100,200")
    private List<Long> receiveUserIds;

    @Schema(description = "Recipient user names.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John,Jane.")
    private List<String> receiveUserNames;

    @Schema(description = "Receive typeArray.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1,2,3")
    private List<Integer> receiveTypes;

    @Schema(description = "SMS template code.", example = "iot_alert_sms")
    private String smsTemplateCode;

    @Schema(description = "Email template code.", example = "iot_alert_mail")
    private String mailTemplateCode;

    @Schema(description = "Inbox template code.", example = "iot_alert_notify")
    private String notifyTemplateCode;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}