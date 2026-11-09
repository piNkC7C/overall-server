package cn.iocoder.yudao.module.crm.controller.admin.receivable.vo.receivable;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.crm.controller.admin.contract.vo.contract.CrmContractRespVO;
import cn.iocoder.yudao.module.crm.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - CRM 回款 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CrmReceivableRespVO {

    @Schema(description = "编号", example = "25787")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "回款编号", example = "31177")
    @ExcelProperty("Collection No")
    private String no;

    @Schema(description = "回款计划编号", example = "1024")
    @ExcelProperty("Collection Plan ID")
    private Long planId;

    @Schema(description = "回款方式", example = "2")
    @ExcelProperty(value = "Collection Method", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CRM_RECEIVABLE_RETURN_TYPE)
    private Integer returnType;

    @Schema(description = "回款金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "9000")
    @ExcelProperty("Collection Amount")
    private BigDecimal price;

    @Schema(description = "计划回款日期", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02")
    @ExcelProperty("Planned Collection Date")
    private LocalDateTime returnTime;

    @Schema(description = "客户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long customerId;
    @Schema(description = "客户名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "test")
    @ExcelProperty("Customer Name")
    private String customerName;

    @Schema(description = "合同编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Contract No")
    private Long contractId;
    @Schema(description = "合同信息")
    private CrmContractRespVO contract;

    @Schema(description = "负责人的用户编号", example = "25682")
    private Long ownerUserId;
    @Schema(description = "负责人名字", example = "25682")
    @ExcelProperty("Owner Name")
    private String ownerUserName;
    @Schema(description = "负责人部门")
    @ExcelProperty("Owner Department")
    private String ownerUserDeptName;

    @Schema(description = "工作流编号", example = "1043")
    @ExcelProperty("Workflow ID")
    private String processInstanceId;

    @Schema(description = "审批状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Approval Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CRM_AUDIT_STATUS)
    private Integer auditStatus;

    @Schema(description = "工作流编号", example = "Notes.")
    @ExcelProperty("Workflow ID")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

    @Schema(description = "创建人", example = "25682")
    private String creator;
    @Schema(description = "创建人名字", example = "test")
    @ExcelProperty("Creator Name")
    private String creatorName;

}
