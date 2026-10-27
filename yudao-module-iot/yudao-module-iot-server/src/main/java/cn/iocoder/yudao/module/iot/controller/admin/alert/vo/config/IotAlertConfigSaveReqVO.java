package cn.iocoder.yudao.module.iot.controller.admin.alert.vo.config;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - IoT alert setting create / edit request.")
@Data
public class IotAlertConfigSaveReqVO {

    @Schema(description = "Setting code.", example = "3566")
    private Long id;

    @Schema(description = "Setting name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    @NotEmpty(message = "Setting name is required.")
    private String name;

    @Schema(description = "SettingDescription.", example = "Example.")
    private String description;

    @Schema(description = "Alert level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Alert level is required.")
    private Integer level;

    @Schema(description = "Setting status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Setting status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Relation scene automation rule ID list.")
    @NotEmpty(message = "Relation scene automation rule ID list is required.")
    private List<Long> sceneRuleIds;

    @Schema(description = "Receive user ID list.")
    @NotEmpty(message = "Receive user ID list is required.")
    private List<Long> receiveUserIds;

    @Schema(description = "Receive typeArray.")
    @NotEmpty(message = "Receive typeArray is required.")
    private List<Integer> receiveTypes;

    @Schema(description = "SMS template code.", example = "iot_alert_sms")
    private String smsTemplateCode;

    @Schema(description = "Email template code.", example = "iot_alert_mail")
    private String mailTemplateCode;

    @Schema(description = "Inbox template code.", example = "iot_alert_notify")
    private String notifyTemplateCode;
}