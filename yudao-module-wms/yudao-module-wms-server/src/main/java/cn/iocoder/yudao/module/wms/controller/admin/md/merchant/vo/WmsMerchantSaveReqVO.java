package cn.iocoder.yudao.module.wms.controller.admin.md.merchant.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.wms.enums.md.WmsMerchantTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - WMS business partner create or update request.")
@Data
public class WmsMerchantSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Business partner code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "MER001")
    @NotBlank(message = "Business partner code is required.")
    @Size(max = 20, message = "Business partner code length cannot exceed 20 characters.")
    private String code;

    @Schema(description = "Business partner name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei")
    @NotBlank(message = "Business partner name is required.")
    @Size(max = 60, message = "Business partner name length cannot exceed 60 characters.")
    private String name;

    @Schema(description = "Business partner type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Business partner type is required.")
    @InEnum(value = WmsMerchantTypeEnum.class, message = "Business partner type must be {value}.")
    private Integer type;

    @Schema(description = "Level.", example = "A")
    @Size(max = 10, message = "Level length cannot exceed 10 characters.")
    private String level;

    @Schema(description = "Bank", example = "China Merchants Bank")
    @Size(max = 255, message = "Bank length cannot exceed 255 characters.")
    private String bankName;

    @Schema(description = "Bank account.", example = "6225888888888888")
    @Size(max = 40, message = "Bank account cannot exceed 40 characters.")
    private String bankAccount;

    @Schema(description = "Address", example = "Nanshan, Shenzhen")
    @Size(max = 200, message = "Address length cannot exceed 200 characters.")
    private String address;

    @Schema(description = "Phone number.", example = "15601691300")
    @Size(max = 13, message = "Phone number length cannot exceed 13 characters.")
    private String mobile;

    @Schema(description = "Landline.", example = "0755-88888888")
    @Size(max = 13, message = "Landline cannot exceed 13 characters.")
    private String telephone;

    @Schema(description = "Contact.", example = "Alex.")
    @Size(max = 30, message = "Contact length cannot exceed 30 characters.")
    private String contact;

    @Schema(description = "Email", example = "wms@example.com")
    @Size(max = 50, message = "Email length cannot exceed 50 characters.")
    private String email;

    @Schema(description = "Notes.", example = "Notes.")
    @Size(max = 255, message = "Notes length cannot exceed 255 characters.")
    private String remark;

}
