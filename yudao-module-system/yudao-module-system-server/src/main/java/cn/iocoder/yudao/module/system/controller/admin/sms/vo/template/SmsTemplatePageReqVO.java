package cn.iocoder.yudao.module.system.controller.admin.sms.vo.template;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - SMS template page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SmsTemplatePageReqVO extends PageParam {

    @Schema(description = "SMS signature.", example = "1")
    private Integer type;

    @Schema(description = "Enable status.", example = "1")
    private Integer status;

    @Schema(description = "Template code, fuzzy match.", example = "test_01")
    private String code;

    @Schema(description = "Template content, fuzzy match.", example = "Hi, {name}. You look so {like}!")
    private String content;

    @Schema(description = "SMS API template code, fuzzy match.", example = "4383920")
    private String apiTemplateId;

    @Schema(description = "SMS channel code.", example = "10")
    private Long channelId;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;

}
