package cn.iocoder.yudao.module.fms.controller.admin.closing.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - FMS closing template response.")
@Data
public class FmsClosingTemplateRespVO {

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long accountSetId;

    @Schema(description = "System preset code.", example = "daily-travel-reimbursement")
    private String presetCode;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Travel reimbursement")
    private String name;

    @Schema(description = "Templatecategory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer category;

    @Schema(description = "Is not Period-end Close.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean periodEnd;

    @Schema(description = "Source account code.", example = "1024")
    private Long subjectId;

    @Schema(description = "Fetch Rule", example = "0")
    private Integer formulaRule;

    @Schema(description = "Source time type.", example = "1")
    private Integer timeType;

    @Schema(description = "Closing account ruleArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<SubjectRule> subjects;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer sort;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Admin - FMS closing templateaccount rule.")
    @Data
    public static class SubjectRule {

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long subjectId;

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "560107")
        private String subjectCode;

        @Schema(description = "Summary", requiredMode = Schema.RequiredMode.REQUIRED, example = "Travel reimbursement")
        private String digest;

        @Schema(description = "DebitCredit to.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer direction;

        @Schema(description = "Amount ratio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        private BigDecimal amountRatio;
    }

}
