package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.voucher.FmsVoucherTidyTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(description = "Tidy journals request VO.")
@Data
public class FmsVoucherTidyReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Organize month.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
    @NotBlank(message = "Organize month cannot be empty.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "Organize month must use yyyy-MM.")
    private String month;

    @Schema(description = "Voucher word ID. Empty tidies all voucher words.", example = "11")
    private Long voucherWordId;

    @Schema(description = "Start number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Start number cannot be empty.")
    @Min(value = 1, message = "Start number must be greater than 0.")
    private Integer startNumber;

    @Schema(description = "Organize mode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Organize mode cannot be empty.")
    @InEnum(FmsVoucherTidyTypeEnum.class)
    private Integer type;

}
