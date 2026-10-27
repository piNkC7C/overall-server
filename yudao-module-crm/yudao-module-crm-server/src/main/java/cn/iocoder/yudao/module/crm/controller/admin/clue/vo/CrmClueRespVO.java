package cn.iocoder.yudao.module.crm.controller.admin.clue.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.infra.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - lead response.")
@Data
@ToString(callSuper = true)
@ExcelIgnoreUnannotated
public class CrmClueRespVO {

    @Schema(description = "ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10969")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Lead name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Leadxxx.")
    @ExcelProperty("Lead Name")
    private String name;

    @Schema(description = "Follow-up status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty(value = "Follow-up Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean followUpStatus;

    @Schema(description = "Last Follow-up")
    @ExcelProperty("Last Follow-up Time")
    private LocalDateTime contactLastTime;

    @Schema(description = "Last follow-up note.", example = "Eat, sleep, play")
    @ExcelProperty("Last Follow-up Notes")
    private String contactLastContent;

    @Schema(description = "Next Contact Time", example = "2023-10-18 01:00:00")
    @ExcelProperty("Next Contact Time")
    private LocalDateTime contactNextTime;

    @Schema(description = "Owner person code.")
    private Long ownerUserId;
    @Schema(description = "Owner person name.", example = "25682")
    @ExcelProperty("Owner Name")
    private String ownerUserName;
    @Schema(description = "Owner person department.")
    @ExcelProperty("Owner Department")
    private String ownerUserDeptName;

    @Schema(description = "Conversion status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty(value = "Conversion Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean transformStatus;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "520")
    private Long customerId;
    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer name.")
    @ExcelProperty("Customer Name")
    private String customerName;

    @Schema(description = "Phone number.", example = "18000000000")
    @ExcelProperty("Phone Number")
    private String mobile;

    @Schema(description = "Phone", example = "18000000000")
    @ExcelProperty("Phone")
    private String telephone;

    @Schema(description = "QQ", example = "25682")
    @ExcelProperty("QQ")
    private String qq;

    @Schema(description = "wechat", example = "25682")
    @ExcelProperty("wechat")
    private String wechat;

    @Schema(description = "email", example = "25682")
    @ExcelProperty("email")
    private String email;

    @Schema(description = "Region ID", example = "1024")
    @ExcelProperty("Region ID")
    private Integer areaId;
    @Schema(description = "Region name.", example = "Seattle")
    @ExcelProperty("Region Name")
    private String areaName;
    @Schema(description = "Full Address", example = "Chenghua Ave, Seattle")
    @ExcelProperty("Full Address")
    private String detailAddress;

    @Schema(description = "Industry", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty(value = "Industry", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.crm.enums.DictTypeConstants.CRM_CUSTOMER_INDUSTRY)
    private Integer industryId;

    @Schema(description = "Customer level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty(value = "Customer Level", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.crm.enums.DictTypeConstants.CRM_CUSTOMER_LEVEL)
    private Integer level;

    @Schema(description = "Customer source.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty(value = "Customer Source", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.crm.enums.DictTypeConstants.CRM_CUSTOMER_SOURCE)
    private Integer source;

    @Schema(description = "Notes.", example = "Sample.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Creator.", example = "1024")
    @ExcelProperty("Creator")
    private String creator;
    @Schema(description = "Creator name.", example = "Overall.")
    @ExcelProperty("Creator Name")
    private String creatorName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

}
