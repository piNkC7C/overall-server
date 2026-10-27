package cn.iocoder.yudao.module.erp.controller.admin.sale.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - ERP customer create / edit request.")
@Data
public class ErpCustomerSaveReqVO {

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "27520")
    private Long id;

    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotEmpty(message = "Customer name is required.")
    private String name;

    @Schema(description = "Contact.", example = "Alex")
    private String contact;

    @Schema(description = "Mobile Number", example = "15601691300")
    private String mobile;

    @Schema(description = "Phone", example = "15601691300")
    private String telephone;

    @Schema(description = "Email", example = "7685323@qq.com")
    private String email;

    @Schema(description = "Fax.", example = "20 7123 4567")
    private String fax;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Enable status is required.")
    private Integer status;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Tax ID.", example = "91130803MA098BY05W")
    private String taxNo;

    @Schema(description = "Tax rate.", example = "10")
    private BigDecimal taxPercent;

    @Schema(description = "Bank", example = "Overall.")
    private String bankName;

    @Schema(description = "Bank Account.", example = "622908212277228617")
    private String bankAccount;

    @Schema(description = "Bank Address.", example = "CIB Pudong Branch")
    private String bankAddress;

}