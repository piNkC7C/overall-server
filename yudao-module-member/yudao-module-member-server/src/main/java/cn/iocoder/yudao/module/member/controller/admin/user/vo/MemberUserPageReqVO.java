package cn.iocoder.yudao.module.member.controller.admin.user.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - memberuser page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberUserPageReqVO extends PageParam {

    @Schema(description = "Phone number.", example = "15601691300")
    private String mobile;

    @Schema(description = "Email", example = "member@iocoder.cn")
    private String email;

    @Schema(description = "Nickname", example = "Jane.")
    private String nickname;

    @Schema(description = "Last sign-in time")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] loginDate;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "Membertag code list.", example = "[1, 2]")
    private List<Long> tagIds;

    @Schema(description = "Member level code.", example = "1")
    private Long levelId;

    @Schema(description = "User group code.", example = "1")
    private Long groupId;

    // TODO Overall： register user type

    // TODO Overall： sign-in user type

}
