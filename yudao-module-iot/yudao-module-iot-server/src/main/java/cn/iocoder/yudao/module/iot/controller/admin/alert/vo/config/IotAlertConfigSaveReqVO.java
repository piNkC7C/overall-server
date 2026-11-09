package cn.iocoder.yudao.module.iot.controller.admin.alert.vo.config;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - IoT 告警配置新增/修改 Request VO")
@Data
public class IotAlertConfigSaveReqVO {

    @Schema(description = "配置编号", example = "3566")
    private Long id;

    @Schema(description = "配置名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    @NotEmpty(message = "Setting name is required.")
    private String name;

    @Schema(description = "配置描述", example = "Example.")
    private String description;

    @Schema(description = "告警级别", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Alert level is required.")
    private Integer level;

    @Schema(description = "配置状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Setting status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "关联的场景联动规则编号数组")
    @NotEmpty(message = "Relation scene automation rule ID list is required.")
    private List<Long> sceneRuleIds;

    @Schema(description = "接收的用户编号数组")
    @NotEmpty(message = "Receive user ID list is required.")
    private List<Long> receiveUserIds;

    @Schema(description = "接收的类型数组")
    @NotEmpty(message = "Receive typeArray is required.")
    private List<Integer> receiveTypes;

    @Schema(description = "短信模板编号", example = "iot_alert_sms")
    private String smsTemplateCode;

    @Schema(description = "邮件模板编号", example = "iot_alert_mail")
    private String mailTemplateCode;

    @Schema(description = "站内信模板编号", example = "iot_alert_notify")
    private String notifyTemplateCode;
}