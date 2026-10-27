package cn.iocoder.yudao.module.system.controller.admin.mail.vo.log;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Email log page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailLogPageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "30883")
    private Long userId;

    @Schema(description = "User type. See UserTypeEnum.", example = "2")
    private Integer userType;

    @Schema(description = "ReceiveemailAddress, fuzzy match.", example = "76854@qq.com")
    private String toMail;

    @Schema(description = "Email account code.", example = "18107")
    private Long accountId;

    @Schema(description = "Template code.", example = "5678")
    private Long templateId;

    @Schema(description = "Send status, see MailSendStatusEnum enum.", example = "1")
    private Integer sendStatus;

    @Schema(description = "Send time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] sendTime;

}
