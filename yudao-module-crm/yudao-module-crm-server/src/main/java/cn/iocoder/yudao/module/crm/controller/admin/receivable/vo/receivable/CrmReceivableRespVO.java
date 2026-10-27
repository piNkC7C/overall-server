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

@Schema(description = "Admin - CRM collection response.")
@Data
@ExcelIgnoreUnannotated
public class CrmReceivableRespVO {

    @Schema(description = "Code.", example = "25787")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Collection code.", example = "31177")
    @ExcelProperty("Collection No")
    private String no;

    @Schema(description = "Collectionplan code.", example = "1024")
    @ExcelProperty("Collection Plan ID")
    private Long planId;

    @Schema(description = "Collection method.", example = "2")
    @ExcelProperty(value = "Collection Method", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CRM_RECEIVABLE_RETURN_TYPE)
    private Integer returnType;

    @Schema(description = "Collection amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9000")
    @ExcelProperty("Collection Amount")
    private BigDecimal price;

    @Schema(description = "PlancollectionDate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-02-02")
    @ExcelProperty("Planned Collection Date")
    private LocalDateTime returnTime;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long customerId;
    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test")
    @ExcelProperty("Customer Name")
    private String customerName;

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Contract No")
    private Long contractId;
    @Schema(description = "Contract info.")
    private CrmContractRespVO contract;

    @Schema(description = "Owner person user ID.", example = "25682")
    private Long ownerUserId;
    @Schema(description = "Owner person name.", example = "25682")
    @ExcelProperty("Owner Name")
    private String ownerUserName;
    @Schema(description = "Owner person department.")
    @ExcelProperty("Owner Department")
    private String ownerUserDeptName;

    @Schema(description = "Workflow ID.", example = "1043")
    @ExcelProperty("Workflow ID")
    private String processInstanceId;

    @Schema(description = "Approval status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Approval Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.CRM_AUDIT_STATUS)
    private Integer auditStatus;

    @Schema(description = "Workflow ID.", example = "Notes.")
    @ExcelProperty("Workflow ID")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

    @Schema(description = "Creator.", example = "25682")
    private String creator;
    @Schema(description = "Creator name.", example = "test")
    @ExcelProperty("Creator Name")
    private String creatorName;

}
