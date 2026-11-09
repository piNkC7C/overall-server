package cn.iocoder.yudao.module.im.controller.admin.group.vo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - IM 加群申请 Response VO")
@Data
public class ImGroupRequestRespVO {

    @Schema(description = "申请编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "群编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long groupId;

    @Schema(description = "申请人 / 被邀请人用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long userId;

    @Schema(description = "邀请人用户编号；NULL 表示用户主动申请", example = "200")
    private Long inviterUserId;

    @Schema(description = "处理结果", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer handleResult; // See ImGroupRequestHandleResultEnum enum

    @Schema(description = "申请理由", example = "I want to join this group")
    private String applyContent;

    @Schema(description = "处理理由（拒绝时可选填）", example = "Not approved yet")
    private String handleContent;

    @Schema(description = "处理人用户编号", example = "31460")
    private Long handleUserId;

    @Schema(description = "加入来源", example = "1")
    private Integer addSource; // See ImGroupAddSourceEnum enum

    @Schema(description = "处理时间")
    private LocalDateTime handleTime;

    @Schema(description = "申请创建时间")
    private LocalDateTime createTime;

    @Schema(description = "申请更新时间；增量拉取游标")
    private LocalDateTime updateTime;

    // ========== 下面是聚合字段，方便前端显示 ==========

    @Schema(description = "申请人 / 被邀请人昵称（实时聚合自 AdminUser）", example = "Overall.")
    private String userNickname;

    @Schema(description = "申请人 / 被邀请人头像（实时聚合自 AdminUser）")
    private String userAvatar;

    @Schema(description = "邀请人昵称（实时聚合自 AdminUser）", example = "John")
    private String inviterNickname;

    @Schema(description = "邀请人头像（实时聚合自 AdminUser）")
    private String inviterAvatar;

    @Schema(description = "群名称（实时聚合自 ImGroup）", example = "Demo tech group")
    private String groupName;

    @Schema(description = "群头像（实时聚合自 ImGroup）")
    private String groupAvatar;

}
