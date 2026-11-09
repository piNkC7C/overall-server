package cn.iocoder.yudao.module.wms.controller.admin.md.merchant.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.wms.enums.md.WmsMerchantTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - WMS 往来企业创建/更新 Request VO")
@Data
public class WmsMerchantSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "往来企业编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "MER001")
    @NotBlank(message = "Business partner code is required.")
    @Size(max = 20, message = "Business partner code length cannot exceed 20 characters.")
    private String code;

    @Schema(description = "往来企业名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei")
    @NotBlank(message = "Business partner name is required.")
    @Size(max = 60, message = "Business partner name length cannot exceed 60 characters.")
    private String name;

    @Schema(description = "往来企业类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Business partner type is required.")
    @InEnum(value = WmsMerchantTypeEnum.class, message = "Business partner type must be {value}.")
    private Integer type;

    @Schema(description = "级别", example = "A")
    @Size(max = 10, message = "Level length cannot exceed 10 characters.")
    private String level;

    @Schema(description = "开户行", example = "China Merchants Bank")
    @Size(max = 255, message = "Bank length cannot exceed 255 characters.")
    private String bankName;

    @Schema(description = "银行账户", example = "6225888888888888")
    @Size(max = 40, message = "Bank account cannot exceed 40 characters.")
    private String bankAccount;

    @Schema(description = "地址", example = "Nanshan, Shenzhen")
    @Size(max = 200, message = "Address length cannot exceed 200 characters.")
    private String address;

    @Schema(description = "手机号", example = "15601691300")
    @Size(max = 13, message = "Phone number length cannot exceed 13 characters.")
    private String mobile;

    @Schema(description = "座机号", example = "0755-88888888")
    @Size(max = 13, message = "Landline cannot exceed 13 characters.")
    private String telephone;

    @Schema(description = "联系人", example = "Alex.")
    @Size(max = 30, message = "Contact length cannot exceed 30 characters.")
    private String contact;

    @Schema(description = "Email", example = "wms@example.com")
    @Size(max = 50, message = "Email length cannot exceed 50 characters.")
    private String email;

    @Schema(description = "备注", example = "Notes.")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    private String remark;

}
