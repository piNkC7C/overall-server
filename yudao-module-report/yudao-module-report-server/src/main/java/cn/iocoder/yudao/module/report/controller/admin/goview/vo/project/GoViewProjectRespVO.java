package cn.iocoder.yudao.module.report.controller.admin.goview.vo.project;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Schema(description = "Admin - GoView item response.")
@Data
public class GoViewProjectRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18993")
    private Long id;

    @Schema(description = "Item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    private String name;

    @Schema(description = "Published.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Report content.") // JSON
    private String content;

    @Schema(description = "Preview image URL.", example = "https://www.iocoder.cn")
    private String picUrl;

    @Schema(description = "Item notes.", example = "Example.")
    private String remark;

    @Schema(description = "Creator code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private String creator;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
