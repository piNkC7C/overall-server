package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.infra.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - CRM 客户 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CrmCustomerRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "客户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty("Customer Name")
    private String name;

    @Schema(description = "跟进状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty(value = "Follow-up Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean followUpStatus;

    @Schema(description = "最后跟进时间")
    @ExcelProperty("Last Follow-up Time")
    private LocalDateTime contactLastTime;

    @Schema(description = "最后跟进内容", example = "Eat, sleep, play")
    @ExcelProperty("Last Follow-up Notes")
    private String contactLastContent;

    @Schema(description = "下次联系时间")
    @ExcelProperty("Next Contact Time")
    private LocalDateTime contactNextTime;

    @Schema(description = "负责人的用户编号", example = "25682")
    @ExcelProperty("Owner User ID")
    private Long ownerUserId;
    @Schema(description = "负责人名字", example = "25682")
    @ExcelProperty("Owner Name")
    private String ownerUserName;
    @Schema(description = "负责人部门")
    @ExcelProperty("Owner Department")
    private String ownerUserDeptName;

    @Schema(description = "锁定状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty(value = "Lock Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean lockStatus;

    @Schema(description = "成交状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "13563")
    @ExcelProperty(value = "Deal Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean dealStatus;

    @Schema(description = "手机", example = "25682")
    @ExcelProperty("Mobile")
    private String mobile;

    @Schema(description = "电话", example = "25682")
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

    @Schema(description = "负责人的用户编号", example = "25682")
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

    @Schema(description = "距离加入公海时间", example = "1")
    private Long poolDay;

}
