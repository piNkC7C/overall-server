package cn.iocoder.yudao.module.im.controller.admin.manager.group.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - IM join-group requestpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImGroupRequestManagerPageReqVO extends PageParam {

    @Schema(description = "Group ID", example = "1024")
    private Long groupId;

    @Schema(description = "Applicant / inviteeuser ID.", example = "2048")
    private Long userId;

    @Schema(description = "Inviteruser ID.", example = "31460")
    private Long inviterUserId;

    @Schema(description = "Process result.", example = "0")
    private Integer handleResult; // See ImGroupRequestHandleResultEnum enum class

    @Schema(description = "Join source.", example = "1")
    private Integer addSource; // See ImGroupAddSourceEnum enum class

    @Schema(description = "Create time.", example = "[2026-04-01 00:00:00, 2026-04-30 23:59:59]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
