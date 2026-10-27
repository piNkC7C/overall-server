package cn.iocoder.yudao.module.erp.controller.admin.finance.vo.account;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - ERP Settlement Account create / edit request.")
@Data
public class ErpAccountSaveReqVO {

    @Schema(description = "Settlement Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28684")
    private Long id;

    @Schema(description = "Account name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    @NotEmpty(message = "Account name cannot be empty.")
    private String name;

    @Schema(description = "Account code.", example = "A88")
    private String no;

    @Schema(description = "Notes.", example = "Sample.")
    private String remark;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Enable status is required.")
    @InEnum(value = CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

}