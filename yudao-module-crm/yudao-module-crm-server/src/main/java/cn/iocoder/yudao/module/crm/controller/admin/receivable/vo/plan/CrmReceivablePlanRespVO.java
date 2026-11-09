package cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.plan;

import cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.receivable.CrmReceivableRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - CRM 回款计划 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CrmReceivablePlanRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "期数", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Period No")
    private Integer period;

    @Schema(description = "客户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Customer ID")
    private Long customerId;
    @Schema(description = "客户名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "test")
    @ExcelProperty("Customer Name")
    private String customerName;

    @Schema(description = "合同编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Contract No")
    private Long contractId;
    @Schema(description = "合同编号", example = "Q110")
    @ExcelProperty("Contract No")
    private String contractNo;

    @Schema(description = "负责人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Owner ID")
    private Long ownerUserId;
    @Schema(description = "负责人", example = "test")
    @ExcelProperty("Owner")
    private String ownerUserName;

    @Schema(description = "计划回款日期", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02")
    @ExcelProperty("Planned Collection Date")
    private LocalDateTime returnTime;

    @Schema(description = "计划回款方式", example = "1")
    @ExcelProperty("Planned Collection Method")
    private Integer returnType;

    @Schema(description = "计划回款金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "9000")
    @ExcelProperty("Planned Collection Amount")
    private BigDecimal price;

    @Schema(description = "回款编号", example = "19852")
    @ExcelProperty("Collection No")
    private Long receivableId;
    @Schema(description = "回款信息")
    private CrmReceivableRespVO receivable;

    @Schema(description = "提前几天提醒", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Remind Days Ahead")
    private Integer remindDays;

    @Schema(description = "提醒日期", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02")
    @ExcelProperty("Reminder Date")
    private LocalDateTime remindTime;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

    @Schema(description = "创建人", example = "1024")
    @ExcelProperty("Creator")
    private String creator;
    @Schema(description = "创建人名字", example = "Overall.")
    @ExcelProperty("Creator Name")
    private String creatorName;

}
