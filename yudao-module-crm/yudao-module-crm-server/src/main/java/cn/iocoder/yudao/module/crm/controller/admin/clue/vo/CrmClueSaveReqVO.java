package cn.iocoder.yudao.module.crm.controller.admin.clue.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.framework.common.validation.Telephone;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.module.crm.enums.customer.CrmCustomerLevelEnum;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.CrmCustomerIndustryParseFunction;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.CrmCustomerLevelParseFunction;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.CrmCustomerSourceParseFunction;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.SysAreaParseFunction;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.module.crm.enums.DictTypeConstants.CRM_CUSTOMER_INDUSTRY;

@Schema(description = "Admin - CRM lead create or update request.")
@Data
public class CrmClueSaveReqVO {

    @Schema(description = "Code.", example = "10969")
    private Long id;

    @Schema(description = "Lead name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Leadxxx.")
    @DiffLogField(name = "Lead name.")
    @NotEmpty(message = "Lead name is required.")
    private String name;

    @Schema(description = "Last Follow-up")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @DiffLogField(name = "Last Follow-up")
    private LocalDateTime contactLastTime;

    @Schema(description = "Next Contact Time", example = "2023-10-18 01:00:00")
    @DiffLogField(name = "Next Contact Time")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime contactNextTime;

    @Schema(description = "Owner person code.", example = "2048")
    @NotNull(message = "Owner person code is required.")
    private Long ownerUserId;

    @Schema(description = "Phone number.", example = "18000000000")
    @DiffLogField(name = "Phone number.")
    @Mobile
    private String mobile;

    @Schema(description = "Phone", example = "18000000000")
    @DiffLogField(name = "Phone")
    @Telephone
    private String telephone;

    @Schema(description = "QQ", example = "123456789")
    @DiffLogField(name = "QQ")
    @Size(max = 20, message = "QQ length cannot exceed 20 characters.")
    private String qq;

    @Schema(description = "WeChat", example = "123456789")
    @DiffLogField(name = "WeChat")
    @Size(max = 255, message = "WeChat length cannot exceed 255 characters.")
    private String wechat;

    @Schema(description = "Email", example = "123456789@qq.com")
    @DiffLogField(name = "Email")
    @Email(message = "Email format is invalid.")
    @Size(max = 255, message = "Email length cannot exceed 255 characters.")
    private String email;

    @Schema(description = "Region ID", example = "20158")
    @DiffLogField(name = "Region ID", function = SysAreaParseFunction.NAME)
    private Integer areaId;

    @Schema(description = "Full Address", example = "Downtown Seattle")
    @DiffLogField(name = "Full Address")
    private String detailAddress;

    @Schema(description = "Industry", example = "1")
    @DiffLogField(name = "Industry", function = CrmCustomerIndustryParseFunction.NAME)
    @DictFormat(CRM_CUSTOMER_INDUSTRY)
    private Integer industryId;

    @Schema(description = "Customer level.", example = "2")
    @DiffLogField(name = "Customer level.", function = CrmCustomerLevelParseFunction.NAME)
    @InEnum(CrmCustomerLevelEnum.class)
    private Integer level;

    @Schema(description = "Customer source.", example = "3")
    @DiffLogField(name = "Customer source.", function = CrmCustomerSourceParseFunction.NAME)
    private Integer source;

    @Schema(description = "CustomerDescription.", example = "Any Text.")
    @DiffLogField(name = "CustomerDescription.")
    @Size(max = 4096, message = "CustomerDescription length cannot exceed 4096 characters.")
    private String description;

    @Schema(description = "Notes.", example = "Sample.")
    @DiffLogField(name = "Notes.")
    private String remark;

}
