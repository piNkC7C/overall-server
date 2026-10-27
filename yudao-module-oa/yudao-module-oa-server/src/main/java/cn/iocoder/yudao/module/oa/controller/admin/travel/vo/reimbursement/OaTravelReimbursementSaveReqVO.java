package cn.iocoder.yudao.module.oa.controller.admin.travel.vo.reimbursement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cn.iocoder.yudao.framework.dict.validation.InDict;
import cn.iocoder.yudao.module.oa.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Travel expense create / update request VO.")
@Data
public class OaTravelReimbursementSaveReqVO {

    @Schema(description = "ID. Omit when creating.", example = "1024")
    private Long id;

    @Schema(description = "Travel Reason", requiredMode = Schema.RequiredMode.REQUIRED, example = "Travel to Beijing for customer acceptance")
    @NotBlank(message = "Travel Reason is required.")
    private String reason;

    @Schema(description = "Start Date.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Start Date is required.")
    private LocalDateTime startTime;

    @Schema(description = "End Date.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "End Date is required.")
    private LocalDateTime endTime;

    @Schema(description = "Related Travel RequestID.", example = "1024")
    private Long travelApplyId;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "Expense details.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Add at least one valid line.")
    private List<@NotNull(message = "Detail is required.") @Valid Item> items;

    @Schema(description = "AttachmentAddress list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[\"https://example.com/file.pdf\"]")
    @NotEmpty(message = "Upload a reimbursement attachment.")
    private List<@NotBlank(message = "AttachmentAddress is required.") String> fileUrls;

    @AssertTrue(message = "End Date cannot earlier than start Date.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null
                || !endTime.isBefore(startTime);
    }

    @Schema(description = "Travel expense detail request VO.")
    @Data
    public static class Item {

        @Schema(description = "Expense Type", example = "1")
        @InDict(type = DictTypeConstants.EXPENSE_TYPE, message = "Expense Type must be {value}.")
        private Integer expenseType;

        @Schema(description = "Occurred On.", type = "integer", format = "int64", example = "1789347600000")
        private LocalDateTime expenseTime;

        @Schema(description = "From.", example = "Shanghai")
        private String departureCity;

        @Schema(description = "To.", example = "Beijing")
        private String arrivalCity;

        @Schema(description = "Amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Expense line amount cannot be empty.")
        @DecimalMin(value = "0", message = "Amount cannot be less than 0.")
        private BigDecimal price;

        @Schema(description = "Expense Notes", example = "Customer acceptance travel expense")
        private String description;

    }

}
