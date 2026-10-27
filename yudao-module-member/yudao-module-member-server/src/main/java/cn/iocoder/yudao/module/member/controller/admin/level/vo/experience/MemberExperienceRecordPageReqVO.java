package cn.iocoder.yudao.module.member.controller.admin.level.vo.experience;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - member experience record page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberExperienceRecordPageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "3638")
    private Long userId;

    @Schema(description = "Business code.", example = "12164")
    private String bizId;

    @Schema(description = "Business type.", example = "1")
    private Integer bizType;

    @Schema(description = "Title.", example = "Add experience")
    private String title;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
