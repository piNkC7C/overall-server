package cn.iocoder.yudao.module.member.controller.admin.signin.vo.record;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Check-in record page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberSignInRecordPageReqVO extends PageParam {

    @Schema(description = "Check-in user.", example = "Potato.")
    private String nickname;

    @Schema(description = "Check-in day.", example = "10")
    private Integer day;

    @Schema(description = "User ID.", example = "123")
    private Long userId;

    @Schema(description = "Check-in Time")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
