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

@Schema(description = "管理后台 - 线索 Response VO")
@Data
@ToString(callSuper = true)
@ExcelIgnoreUnannotated
public class CrmClueRespVO {

    @Schema(description = "编号，主键自增", requiredMode = Schema.RequiredMode.REQUIRED, example = "10969")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "线索名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Leadxxx.")
    @ExcelProperty("Lead Name")
    private String name;

    @Schema(description = "跟进状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty(value = "Follow-up Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean followUpStatus;

    @Schema(description = "最后跟进时间")
    @ExcelProperty("Last Follow-up Time")
    private LocalDateTime contactLastTime;

    @Schema(description = "最后跟进内容", example = "Eat, sleep, play")
    @ExcelProperty("Last Follow-up Notes")
    private String contactLastContent;

    @Schema(description = "下次联系时间", example = "2023-10-18 01:00:00")
    @ExcelProperty("Next Contact Time")
    private LocalDateTime contactNextTime;

    @Schema(description = "负责人编号")
    private Long ownerUserId;
    @Schema(description = "负责人名字", example = "25682")
    @ExcelProperty("Owner Name")
    private String ownerUserName;
    @Schema(description = "负责人部门")
    @ExcelProperty("Owner Department")
    private String ownerUserDeptName;

    @Schema(description = "转化状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty(value = "Conversion Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean transformStatus;

    @Schema(description = "客户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "520")
    private Long customerId;
    @Schema(description = "客户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer name.")
    @ExcelProperty("Customer Name")
    private String customerName;

    @Schema(description = "手机号", example = "18000000000")
    @ExcelProperty("Phone Number")
    private String mobile;

    @Schema(description = "电话", example = "18000000000")
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

    @Schema(description = "地区编号", example = "1024")
    @ExcelProperty("Region ID")
    private Integer areaId;
    @Schema(description = "地区名称", example = "Seattle")
    @ExcelProperty("Region Name")
    private String areaName;
    @Schema(description = "详细地址", example = "Chenghua Ave, Seattle")
    @ExcelProperty("Full Address")
    private String detailAddress;

    @Schema(description = "所属行业", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty(value = "Industry", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.crm.enums.DictTypeConstants.CRM_CUSTOMER_INDUSTRY)
    private Integer industryId;

    @Schema(description = "客户等级", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty(value = "Customer Level", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.crm.enums.DictTypeConstants.CRM_CUSTOMER_LEVEL)
    private Integer level;

    @Schema(description = "客户来源", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty(value = "Customer Source", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.crm.enums.DictTypeConstants.CRM_CUSTOMER_SOURCE)
    private Integer source;

    @Schema(description = "备注", example = "Sample.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建人", example = "1024")
    @ExcelProperty("Creator")
    private String creator;
    @Schema(description = "创建人名字", example = "Overall.")
    @ExcelProperty("Creator Name")
    private String creatorName;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

}
