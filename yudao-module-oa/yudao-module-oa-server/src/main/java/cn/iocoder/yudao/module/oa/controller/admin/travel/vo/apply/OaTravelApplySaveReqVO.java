package cn.iocoder.yudao.module.oa.controller.admin.travel.vo.apply;

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

@Schema(description = "管理后台 - 出差申请新增/修改 Request VO")
@Data
public class OaTravelApplySaveReqVO {

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

    @Schema(description = "同行人", example = "John、Jane.")
    private String companion;

    @Schema(description = "预计费用", example = "100.00")
    @DecimalMin(value = "0", message = "Amount cannot be less than 0.")
    private BigDecimal estimatedPrice;

    @Schema(description = "备注", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "行程明细", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Add at least one valid line.")
    private List<@NotNull(message = "Detail is required.") @Valid Item> items;

    @Schema(description = "附件地址列表", example = "[\"https://example.com/file.pdf\"]")
    private List<@NotBlank(message = "AttachmentAddress is required.") String> fileUrls;

    @AssertTrue(message = "End Date cannot earlier than start Date.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null
                || !endTime.isBefore(startTime);
    }

    @Schema(description = "管理后台 - 出差申请明细 Request VO")
    @Data
    public static class Item {

        @Schema(description = "出发地区编号", example = "110101")
        private Integer departureAreaId;

        @Schema(description = "到达地区编号", example = "110101")
        private Integer arrivalAreaId;

        @Schema(description = "开始日期", type = "integer", format = "int64", example = "1789347600000")
        private LocalDateTime startTime;

        @Schema(description = "结束日期", type = "integer", format = "int64", example = "1789380000000")
        private LocalDateTime endTime;

        @Schema(description = "交通方式", example = "2")
        @InDict(type = DictTypeConstants.TRANSPORT_TYPE, message = "Transport must be {value}.")
        private Integer transportType;

        @Schema(description = "备注", example = "Contact Admin in advance to confirm.")
        private String remark;

        @AssertTrue(message = "Trip end date cannot be earlier than the start date.")
        @JsonIgnore
        public boolean isTimeRangeValid() {
            return startTime == null || endTime == null
                    || !endTime.toLocalDate().isBefore(startTime.toLocalDate());
        }

    }

}
