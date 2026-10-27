package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.label;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS work item tag response.")
@Data
public class PmsWorkItemLabelRespVO {

    @Schema(description = "Tag code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Tag name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Urgent")
    private String name;

    @Schema(description = "Tag color.", requiredMode = Schema.RequiredMode.REQUIRED, example = "#409EFF")
    private String color;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
