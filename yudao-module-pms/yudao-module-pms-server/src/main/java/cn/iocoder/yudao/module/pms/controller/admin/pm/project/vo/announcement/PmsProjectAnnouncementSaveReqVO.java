package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.announcement;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - PMS 项目公告保存 Request VO")
@Data
public class PmsProjectAnnouncementSaveReqVO {

    @Schema(description = "公告编号", example = "1024")
    private Long id;

    @Schema(description = "项目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "公告内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Announcement content is required.")
    @Size(max = 5000, message = "Announcement content cannot exceed 5000 characters.")
    private String content;

    @Schema(description = "附件地址列表")
    private List<String> fileUrls;

}
