package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.supplier;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.framework.common.validation.Telephone;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - ERP supplier create / edit request.")
@Data
public class ErpSupplierSaveReqVO {

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17791")
    private Long id;

    @Schema(description = "Supplier name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Supplier name is required.")
    private String name;

    @Schema(description = "Contact.", example = "Overall.")
    private String contact;

    @Schema(description = "Mobile Number", example = "15601691300")
    @Mobile
    private String mobile;

    @Schema(description = "Phone", example = "18818288888")
    @Telephone
    private String telephone;

    @Schema(description = "Email", example = "76853@qq.com")
    @Email
    private String email;

    @Schema(description = "Fax.", example = "20 7123 4567")
    private String fax;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Enable status is required.")
    @InEnum(value = CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Tax ID.", example = "91130803MA098BY05W")
    private String taxNo;

    @Schema(description = "Tax rate.", example = "10")
    private BigDecimal taxPercent;

    @Schema(description = "Bank", example = "John.")
    private String bankName;

    @Schema(description = "Bank Account.", example = "622908212277228617")
    private String bankAccount;

    @Schema(description = "Bank Address.", example = "CIB Pudong Branch")
    private String bankAddress;

}