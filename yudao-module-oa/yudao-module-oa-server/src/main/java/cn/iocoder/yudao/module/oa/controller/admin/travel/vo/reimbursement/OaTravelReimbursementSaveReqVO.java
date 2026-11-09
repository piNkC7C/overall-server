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

@Schema(description = "管理后台 - 出差报销新增/修改 Request VO")
@Data
public class OaTravelReimbursementSaveReqVO {

    @Schema(description = "编号，新建时不传", example = "1024")
    private Long id;

    @Schema(description = "出差事由", requiredMode = Schema.RequiredMode.REQUIRED, example = "Travel to Beijing for customer acceptance")
    @NotBlank(message = "Travel Reason is required.")
    private String reason;

    @Schema(description = "开始日期", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Start Date is required.")
    private LocalDateTime startTime;

    @Schema(description = "结束日期", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "End Date is required.")
    private LocalDateTime endTime;

    @Schema(description = "关联出差申请编号", example = "1024")
    private Long travelApplyId;

    @Schema(description = "备注", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "费用明细", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Add at least one valid line.")
    private List<@NotNull(message = "Detail is required.") @Valid Item> items;

    @Schema(description = "附件地址列表", requiredMode = Schema.RequiredMode.REQUIRED, example = "[\"https://example.com/file.pdf\"]")
    @NotEmpty(message = "Upload a reimbursement attachment.")
    private List<@NotBlank(message = "AttachmentAddress is required.") String> fileUrls;

    @AssertTrue(message = "End Date cannot earlier than start Date.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null
                || !endTime.isBefore(startTime);
    }

    @Schema(description = "管理后台 - 出差报销明细 Request VO")
    @Data
    public static class Item {

        @Schema(description = "费用类型", example = "1")
        @InDict(type = DictTypeConstants.EXPENSE_TYPE, message = "Expense Type must be {value}.")
        private Integer expenseType;

        @Schema(description = "发生日期", type = "integer", format = "int64", example = "1789347600000")
        private LocalDateTime expenseTime;

        @Schema(description = "出发地", example = "Shanghai")
        private String departureCity;

        @Schema(description = "到达地", example = "Beijing")
        private String arrivalCity;

        @Schema(description = "金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Expense line amount cannot be empty.")
        @DecimalMin(value = "0", message = "Amount cannot be less than 0.")
        private BigDecimal price;

        @Schema(description = "费用说明", example = "Customer acceptance travel expense")
        private String description;

    }

}
