package cn.iocoder.yudao.module.system.controller.admin.mail.vo.template;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - email template page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailTemplatePageReqVO extends PageParam {

    @Schema(description = "Status, see CommonStatusEnum enum.", example = "1")
    private Integer status;

    @Schema(description = "Key, fuzzy match.", example = "code_1024")
    private String code;

    @Schema(description = "Name, fuzzy match.", example = "Taro")
    private String name;

    @Schema(description = "Account code.", example = "2048")
    private Long accountId;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
