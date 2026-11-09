package cn.iocoder.yudao.module.crm.controller.admin.contact.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.infra.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - CRM 联系人 Response VO")
@Data
@ToString(callSuper = true)
@ExcelIgnoreUnannotated
public class CrmContactRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "3167")
    private Long id;

    @Schema(description = "联系人姓名", example = "Overall.")
    @ExcelProperty(value = "ContactFull Name", order = 1)
    private String name;

    @Schema(description = "客户编号", example = "10795")
    private Long customerId;
    @ExcelProperty(value = "Customer Name", order = 2)
    @Schema(description = "客户名字", example = "test")
    private String customerName;

    @Schema(description = "最后跟进时间")
    @ExcelProperty(value = "Last Follow-up Time", order = 6)
    private LocalDateTime contactLastTime;

    @Schema(description = "最后跟进内容")
    @ExcelProperty(value = "Last Follow-up Notes", order = 6)
    private String contactLastContent;

    @Schema(description = "下次联系时间")
    @ExcelProperty(value = "Next Contact Time", order = 6)
    private LocalDateTime contactNextTime;

    @Schema(description = "负责人编号")
    private Long ownerUserId;
    @Schema(description = "负责人名字", example = "25682")
    @ExcelProperty("Owner Name")
    private String ownerUserName;
    @Schema(description = "负责人部门")
    @ExcelProperty("Owner Department")
    private String ownerUserDeptName;

    @Schema(description = "手机号", example = "1387171766")
    @ExcelProperty(value = "Phone Number", order = 4)
    private String mobile;

    @Schema(description = "电话", example = "021-0029922")
    @ExcelProperty(value = "Phone", order = 4)
    private String telephone;

    @Schema(description = "电子邮箱", example = "1111@22.com")
    @ExcelProperty(value = "Email", order = 4)
    private String email;

    @Schema(description = "QQ", example = "197272662")
    @ExcelProperty(value = "QQ", order = 4)
    private Long qq;

    @Schema(description = "微信", example = "zzz3883")
    @ExcelProperty(value = "WeChat", order = 4)
    private String wechat;

    @Schema(description = "地区编号", example = "20158")
    private Integer areaId;
    @Schema(description = "地区名", example = "Seattle WA Downtown")
    @ExcelProperty(value = "Region", order = 5)
    private String areaName;

    @Schema(description = "地址")
    @ExcelProperty(value = "Address", order = 5)
    private String detailAddress;

    @Schema(description = "性别")
    @ExcelProperty(value = "Gender", converter = DictConvert.class, order = 3)
    @DictFormat(cn.iocoder.yudao.module.system.enums.DictTypeConstants.USER_SEX)
    private Integer sex;

    @Schema(description = "是否关键决策人")
    @ExcelProperty(value = "Key Decision Maker", converter = DictConvert.class, order = 3)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean master;

    @Schema(description = "职位")
    @ExcelProperty(value = "Title", order = 3)
    private String post;

    @Schema(description = "直属上级", example = "23457")
    private Long parentId;
    @Schema(description = "直属上级名", example = "Taro")
    @ExcelProperty(value = "Direct Manager", order = 4)
    private String parentName;

    @Schema(description = "备注", example = "Looks good.")
    @ExcelProperty(value = "Notes", order = 6)
    private String remark;

    @Schema(description = "创建人", example = "25682")
    private String creator;
    @Schema(description = "创建人名字", example = "test")
    @ExcelProperty(value = "Creator", order = 8)
    private String creatorName;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

}
