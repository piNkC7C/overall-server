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

@Schema(description = "Admin - CRM contact response.")
@Data
@ToString(callSuper = true)
@ExcelIgnoreUnannotated
public class CrmContactRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3167")
    private Long id;

    @Schema(description = "ContactName.", example = "Overall.")
    @ExcelProperty(value = "ContactFull Name", order = 1)
    private String name;

    @Schema(description = "Customer code.", example = "10795")
    private Long customerId;
    @ExcelProperty(value = "Customer Name", order = 2)
    @Schema(description = "Customer name.", example = "test")
    private String customerName;

    @Schema(description = "Last Follow-up")
    @ExcelProperty(value = "Last Follow-up Time", order = 6)
    private LocalDateTime contactLastTime;

    @Schema(description = "Last follow-up note.")
    @ExcelProperty(value = "Last Follow-up Notes", order = 6)
    private String contactLastContent;

    @Schema(description = "Next Contact Time")
    @ExcelProperty(value = "Next Contact Time", order = 6)
    private LocalDateTime contactNextTime;

    @Schema(description = "Owner person code.")
    private Long ownerUserId;
    @Schema(description = "Owner person name.", example = "25682")
    @ExcelProperty("Owner Name")
    private String ownerUserName;
    @Schema(description = "Owner person department.")
    @ExcelProperty("Owner Department")
    private String ownerUserDeptName;

    @Schema(description = "Phone number.", example = "1387171766")
    @ExcelProperty(value = "Phone Number", order = 4)
    private String mobile;

    @Schema(description = "Phone", example = "021-0029922")
    @ExcelProperty(value = "Phone", order = 4)
    private String telephone;

    @Schema(description = "Email", example = "1111@22.com")
    @ExcelProperty(value = "Email", order = 4)
    private String email;

    @Schema(description = "QQ", example = "197272662")
    @ExcelProperty(value = "QQ", order = 4)
    private Long qq;

    @Schema(description = "WeChat", example = "zzz3883")
    @ExcelProperty(value = "WeChat", order = 4)
    private String wechat;

    @Schema(description = "Region ID", example = "20158")
    private Integer areaId;
    @Schema(description = "Region name.", example = "Seattle WA Downtown")
    @ExcelProperty(value = "Region", order = 5)
    private String areaName;

    @Schema(description = "Address")
    @ExcelProperty(value = "Address", order = 5)
    private String detailAddress;

    @Schema(description = "Gender")
    @ExcelProperty(value = "Gender", converter = DictConvert.class, order = 3)
    @DictFormat(cn.iocoder.yudao.module.system.enums.DictTypeConstants.USER_SEX)
    private Integer sex;

    @Schema(description = "Decision Maker?")
    @ExcelProperty(value = "Key Decision Maker", converter = DictConvert.class, order = 3)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    private Boolean master;

    @Schema(description = "Job Title")
    @ExcelProperty(value = "Title", order = 3)
    private String post;

    @Schema(description = "Direct Manager", example = "23457")
    private Long parentId;
    @Schema(description = "Manager name.", example = "Taro")
    @ExcelProperty(value = "Direct Manager", order = 4)
    private String parentName;

    @Schema(description = "Notes.", example = "Looks good.")
    @ExcelProperty(value = "Notes", order = 6)
    private String remark;

    @Schema(description = "Creator.", example = "25682")
    private String creator;
    @Schema(description = "Creator name.", example = "test")
    @ExcelProperty(value = "Creator", order = 8)
    private String creatorName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

}
