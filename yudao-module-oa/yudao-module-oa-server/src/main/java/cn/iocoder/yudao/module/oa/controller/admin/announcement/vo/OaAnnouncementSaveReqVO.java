package cn.iocoder.yudao.module.oa.controller.admin.announcement.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.announcement.OaAnnouncementTypeEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaPriorityEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - OA announcement create / edit request.")
@Data
public class OaAnnouncementSaveReqVO {

    @Schema(description = "Announcement code.", example = "1024")
    private Long id;

    @Schema(description = "Announcement type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Announcement type is required.")
    @InEnum(value = OaAnnouncementTypeEnum.class, message = "Announcement type must be {value}.")
    private Integer type;

    @Schema(description = "Priority", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Priority is required.")
    @InEnum(value = OaPriorityEnum.class, message = "Priority must be {value}.")
    private Integer priority;

    @Schema(description = "Announcement title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "National Day holiday notice")
    @NotBlank(message = "Announcement title is required.")
    @Size(max = 255, message = "Announcement title length cannot exceed 255 characters.")
    private String title;

    @Schema(description = "Announcement content.", example = "Please arrange holiday coverage in advance.")
    private String content;

    @Schema(description = "Related URL.", example = "https://www.iocoder.cn")
    @Size(max = 512, message = "Related URL cannot exceed 512 characters.")
    private String url;

    @Schema(description = "Is not Pin.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not Pin is required.")
    private Boolean top;

}
