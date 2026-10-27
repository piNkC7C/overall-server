package cn.iocoder.yudao.module.mp.controller.admin.message.vo.message;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - Official Accountmessage page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpMessagePageReqVO extends PageParam {

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Official Account account code is required.")
    private Long accountId;

    @Schema(description = "Message type see WxConsts.XmlMsgType enum.", example = "text")
    private String type;

    @Schema(description = "Official Accountfollower key.", example = "o6_bmjrPTlm6_2sgVt7hMZOPfL2M")
    private String openid;

    @Schema(description = "Official Accountfollower UserId.", example = "1")
    private String userId;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;

}
