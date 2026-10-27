package cn.iocoder.yudao.module.crm.controller.admin.contact.vo;

import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.framework.common.validation.Telephone;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.*;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

@Schema(description = "Admin - CRM contact create or update request.")
@Data
public class CrmContactSaveReqVO {

    @Schema(description = "Primary key.", example = "3167")
    private Long id;

    @Schema(description = "Name", example = "Overall.")
    @NotNull(message = "Name is required.")
    @DiffLogField(name = "Name")
    private String name;

    @Schema(description = "Customer code.", example = "10795")
    @NotNull(message = "Customer code is required.")
    @DiffLogField(name = "Customer.", function = CrmCustomerParseFunction.NAME)
    private Long customerId;

    @Schema(description = "Next Contact Time")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    @DiffLogField(name = "Next Contact Time")
    private LocalDateTime contactNextTime;

    @Schema(description = "Owner person user ID.", example = "14334")
    @NotNull(message = "Owner person is required.")
    @DiffLogField(name = "Owner person.", function = SysAdminUserParseFunction.NAME)
    private Long ownerUserId;

    @Schema(description = "Phone number.", example = "1387171766")
    @Mobile
    @DiffLogField(name = "Phone number.")
    private String mobile;

    @Schema(description = "Phone", example = "021-0029922")
    @Telephone
    @DiffLogField(name = "Phone")
    private String telephone;

    @Schema(description = "QQ", example = "197272662")
    @DiffLogField(name = "QQ")
    private Long qq;

    @Schema(description = "WeChat", example = "zzz3883")
    @DiffLogField(name = "WeChat")
    private String wechat;

    @Schema(description = "Email", example = "1111@22.com")
    @DiffLogField(name = "Email")
    @Email
    private String email;

    @Schema(description = "Region ID", example = "20158")
    @DiffLogField(name = "Location", function = SysAreaParseFunction.NAME)
    private Integer areaId;

    @Schema(description = "Address")
    @DiffLogField(name = "Address")
    private String detailAddress;

    @Schema(description = "Gender")
    @DiffLogField(name = "Gender", function = SysSexParseFunction.NAME)
    private Integer sex;

    @Schema(description = "Decision Maker?")
    @DiffLogField(name = "Decision Maker", function = SysBooleanParseFunction.NAME)
    private Boolean master;

    @Schema(description = "Job Title")
    @DiffLogField(name = "Job Title")
    private String post;

    @Schema(description = "Direct Manager", example = "23457")
    @DiffLogField(name = "Direct Manager", function = CrmContactParseFunction.NAME)
    private Long parentId;

    @Schema(description = "Notes.", example = "Looks good.")
    @DiffLogField(name = "Notes.")
    private String remark;

    @Schema(description = "Relation opportunity ID.", example = "122233")
    private Long businessId; // 注意：该字段用于在【商机】详情界面「新建联系人」时，自动进行关联

}
