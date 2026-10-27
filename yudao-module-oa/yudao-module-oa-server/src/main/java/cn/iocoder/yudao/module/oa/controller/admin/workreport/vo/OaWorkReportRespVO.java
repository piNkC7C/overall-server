package cn.iocoder.yudao.module.oa.controller.admin.workreport.vo;

import cn.iocoder.yudao.module.oa.dal.dataobject.workreport.OaWorkReportDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OA work report response.")
@Data
public class OaWorkReportRespVO {

    @Schema(description = "Report ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Report number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "HB202609140001")
    private String no;

    @Schema(description = "Report type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Report status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Report Title", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-09-14 daily report")
    private String title;

    @Schema(description = "Report cycle key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-09-14")
    private String periodKey;

    @Schema(description = "Cycle start time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "Cycle end time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "Work summary.", example = "Finished this week's inventory count and variance list")
    private String summary;

    @Schema(description = "Work-plan notes.", example = "Finish count-variance review next week")
    private String plan;

    @Schema(description = "Issues and follow-ups.", example = "Need warehouse to review count variances")
    private String problem;

    @Schema(description = "Completed work item.")
    private List<OaWorkReportDO.WorkItem> workItems;

    @Schema(description = "Work-plan items.")
    private List<OaWorkReportDO.PlanItem> planItems;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "Reporter user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Reporter nickname.", example = "John.")
    private String userName;

    @Schema(description = "Reporter department ID.", example = "1024")
    private Long deptId;

    @Schema(description = "Reporter department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime updateTime;

}
