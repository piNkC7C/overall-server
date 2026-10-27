package cn.iocoder.yudao.module.crm.controller.admin.followup.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - Follow-uprecord create / edit request.")
@Data
public class CrmFollowUpRecordSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28800")
    private Long id;

    @Schema(description = "Data type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Data type is required.")
    private Integer bizType;

    @Schema(description = "Data code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5564")
    @NotNull(message = "Data code is required.")
    private Long bizId;

    @Schema(description = "Follow-up type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Follow-up type is required.")
    private Integer type;

    @Schema(description = "Follow-up content.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Follow-up content is required.")
    private String content;

    @Schema(description = "Next Contact Time", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Next Contact Time is required.")
    private LocalDateTime nextTime;

    @Schema(description = "Relation opportunity ID list.")
    private List<Long> businessIds;
    @Schema(description = "Relation contact ID list.")
    private List<Long> contactIds;

    @Schema(description = "Image")
    private List<String> picUrls;
    @Schema(description = "Attachment")
    private List<String> fileUrls;

}