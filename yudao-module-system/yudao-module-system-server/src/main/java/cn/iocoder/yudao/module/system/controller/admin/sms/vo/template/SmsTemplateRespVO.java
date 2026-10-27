package cn.iocoder.yudao.module.system.controller.admin.sms.vo.template;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - SMS template response.")
@Data
@ExcelIgnoreUnannotated
public class SmsTemplateRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "SMS type, see SmsTemplateTypeEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "SMS Signature", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_TEMPLATE_TYPE)
    private Integer type;

    @Schema(description = "Enable status, see CommonStatusEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Enabled", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test_01")
    @ExcelProperty("Template Code")
    private String code;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @ExcelProperty("Template Name")
    private String name;

    @Schema(description = "Template content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hi, {name}. You look so {like}!")
    @ExcelProperty("Template Content")
    private String content;

    @Schema(description = "Template params", example = "name,code")
    private List<String> params;

    @Schema(description = "Notes.", example = "Haha")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "SMS API template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4383920")
    @ExcelProperty("SMS API Template ID")
    private String apiTemplateId;

    @Schema(description = "SMS channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty("SMS Channel ID")
    private Long channelId;

    @Schema(description = "SMS channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ALIYUN")
    @ExcelProperty(value = "SMS Channel Code", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_CHANNEL_CODE)
    private String channelCode;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
