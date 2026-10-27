package cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.plan;

import cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.receivable.CrmReceivableRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - CRM collectionplan response.")
@Data
@ExcelIgnoreUnannotated
public class CrmReceivablePlanRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Period No.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Period No")
    private Integer period;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Customer ID")
    private Long customerId;
    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test")
    @ExcelProperty("Customer Name")
    private String customerName;

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Contract No")
    private Long contractId;
    @Schema(description = "Contract code.", example = "Q110")
    @ExcelProperty("Contract No")
    private String contractNo;

    @Schema(description = "Owner person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Owner ID")
    private Long ownerUserId;
    @Schema(description = "Owner person.", example = "test")
    @ExcelProperty("Owner")
    private String ownerUserName;

    @Schema(description = "PlancollectionDate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02")
    @ExcelProperty("Planned Collection Date")
    private LocalDateTime returnTime;

    @Schema(description = "Plancollection method.", example = "1")
    @ExcelProperty("Planned Collection Method")
    private Integer returnType;

    @Schema(description = "Plancollection amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9000")
    @ExcelProperty("Planned Collection Amount")
    private BigDecimal price;

    @Schema(description = "Collection code.", example = "19852")
    @ExcelProperty("Collection No")
    private Long receivableId;
    @Schema(description = "Collection info.")
    private CrmReceivableRespVO receivable;

    @Schema(description = "Remind Days Ahead", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Remind Days Ahead")
    private Integer remindDays;

    @Schema(description = "Reminder Date", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02")
    @ExcelProperty("Reminder Date")
    private LocalDateTime remindTime;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

    @Schema(description = "Creator.", example = "1024")
    @ExcelProperty("Creator")
    private String creator;
    @Schema(description = "Creator name.", example = "Overall.")
    @ExcelProperty("Creator Name")
    private String creatorName;

}
