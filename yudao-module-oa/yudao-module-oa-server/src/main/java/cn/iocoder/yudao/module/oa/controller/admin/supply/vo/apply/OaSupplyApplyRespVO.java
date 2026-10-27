package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.apply;

import cn.iocoder.yudao.module.oa.enums.supply.*;
import cn.iocoder.yudao.module.oa.controller.admin.supply.vo.issue.OaSupplyIssueRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Supply requisition response VO.")
@Data
public class OaSupplyApplyRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Issue date.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime applyTime;

    @Schema(description = "Used type.", example = "1")
    private Integer useType;

    @Schema(description = "Claim Method", example = "1")
    private Integer pickupMethod;

    @Schema(description = "Request Reason", example = "Issue daily office supplies to the department")
    private String reason;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "Apply please order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "YC202609140001")
    private String no;

    @Schema(description = "Apply please person code.", example = "1024")
    private String creator;

    @Schema(description = "Apply please person.", example = "John.")
    private String creatorName;

    @Schema(description = "Apply please department code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long deptId;

    @Schema(description = "Apply please department.", example = "Administration.")
    private String deptName;

    @Schema(description = "Document status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "-1")
    private Integer status;

    @Schema(description = "Workflow instance code.", example = "1024")
    private String processInstanceId;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "Issue lines.")
    private List<OaSupplyIssueRespVO> items;

}
