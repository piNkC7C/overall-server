package cn.iocoder.yudao.module.system.controller.admin.social.vo.user;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - social user page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SocialUserPageReqVO extends PageParam {

    @Schema(description = "Social platform type", example = "30")
    private Integer type;

    @Schema(description = "Nickname", example = "Jane.")
    private String nickname;

    @Schema(description = "Social openid.", example = "oz-Jdt0kd_jdhUxJHQdBJMlOFN7w")
    private String openid;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
