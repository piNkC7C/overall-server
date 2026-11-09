package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.receive;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.constraints.*;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.dict.validation.InDict;
import cn.iocoder.yudao.module.oa.enums.DictTypeConstants;
import cn.iocoder.yudao.module.oa.enums.officialdoc.OaOfficialDocReceiveTypeEnum;

@Schema(description = "管理后台 - 公文收文新增/修改 Request VO")
@Data
public class OaOfficialDocReceiveSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "公文标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Notice: Office supply inventory")
    @NotBlank(message = "Document Title is required.")
    @Size(max = 255, message = "Document Title length cannot exceed {max} characters.")
    private String title;

    @Schema(description = "来文字号", example = "OA-2026-1")
    @Size(max = 64, message = "Incoming Doc No. length cannot exceed {max} characters.")
    private String documentNo;

    @Schema(description = "密级", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Classification is required.")
    @InDict(type = DictTypeConstants.OFFICIAL_DOC_SECRET_LEVEL, message = "Classification must be {value}.")
    private Integer secrecyLevel;

    @Schema(description = "紧急程度", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Urgency is required")
    @InDict(type = DictTypeConstants.OFFICIAL_DOC_URGENCY_LEVEL, message = "Urgency must be {value}.")
    private Integer urgencyLevel;

    @Schema(description = "收文类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Incoming Type is required.")
    @InEnum(value = OaOfficialDocReceiveTypeEnum.class, message = "Incoming Type must be {value}.")
    private Integer receiveType;

    @Schema(description = "收文时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Received time cannot be empty.")
    private LocalDateTime receiveTime;

    @Schema(description = "收文部门编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Incoming Dept is required.")
    private Long receiveDeptId;

    @Schema(description = "主办人用户编号", example = "1024")
    private Long handlerUserId;

    @Schema(description = "领导批示", example = "Please have Admin lead this")
    @Size(max = 2000, message = "Leader comment cannot exceed {max} characters.")
    private String instruction;

    @Schema(description = "办理结果", example = "Count completed and archived")
    @Size(max = 2000, message = "Handle result length cannot exceed {max} characters.")
    private String result;

    @Schema(description = "办理期限", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime deadlineTime;

    @Schema(description = "内容摘要", example = "Finished this week's office-supply count")
    private String summary;

    @Schema(description = "备注", example = "Contact Admin in advance to confirm.")
    @Size(max = 500, message = "Notes length cannot exceed {max} characters.")
    private String remark;

    @Schema(description = "附件地址列表", example = "[\"https://example.com/file.pdf\"]")
    private List<@NotBlank(message = "AttachmentAddress is required.") String> fileUrls;

    @Schema(description = "正式公文地址", example = "https://example.com/file.pdf")
    @Size(max = 2048, message = "Official DocumentAddress length cannot exceed {max} characters.")
    private String formalFileUrl;

}
