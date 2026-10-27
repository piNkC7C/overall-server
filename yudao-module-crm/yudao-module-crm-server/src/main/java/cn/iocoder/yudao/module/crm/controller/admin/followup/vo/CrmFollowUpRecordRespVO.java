package cn.iocoder.yudao.module.crm.controller.admin.followup.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.module.crm.controller.admin.business.vo.business.CrmBusinessRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.module.crm.enums.DictTypeConstants.CRM_FOLLOW_UP_TYPE;

@Schema(description = "Admin - Follow-uprecord response.")
@Data
@ExcelIgnoreUnannotated
public class CrmFollowUpRecordRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28800")
    private Long id;

    @Schema(description = "Data type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer bizType;

    @Schema(description = "Data code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5564")
    private Long bizId;

    @Schema(description = "Follow-up type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @DictFormat(CRM_FOLLOW_UP_TYPE)
    private Integer type;

    @Schema(description = "Follow-up content.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(description = "Next Contact Time", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime nextTime;

    @Schema(description = "Relation opportunity ID list.")
    private List<Long> businessIds;
    @Schema(description = "Relation opportunityArray.")
    private List<CrmBusinessRespVO> businesses;

    @Schema(description = "Relation contact ID list.")
    private List<Long> contactIds;
    @Schema(description = "Relation contact nameArray.")
    private List<CrmBusinessRespVO> contacts;

    @Schema(description = "Image")
    private List<String> picUrls;
    @Schema(description = "Attachment")
    private List<String> fileUrls;

    @Schema(description = "Creator.", example = "1024")
    @ExcelProperty("Creator")
    private String creator;
    @Schema(description = "Creator name.", example = "Overall.")
    @ExcelProperty("Creator Name")
    private String creatorName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}