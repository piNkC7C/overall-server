package cn.iocoder.yudao.module.fms.controller.admin.config.vo.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

/**
 * FMS 币别保存 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "FMS currency save request VO.")
@Data
public class FmsCurrencySaveReqVO {

    @Schema(description = "Currency ID.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Currency code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "USD")
    @NotBlank(message = "Currency code cannot be empty.")
    @Size(max = 64, message = "Currency code cannot exceed 64 characters.")
    @Pattern(regexp = "^[A-Za-z][A-Za-z0-9_]*$", message = "Currency code must start with a letter and contain only letters, digits, and underscores.")
    private String code;

    @Schema(description = "Currency name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "USD")
    @NotBlank(message = "Currency name cannot be empty.")
    @Size(max = 255, message = "Currency name cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Exchange rate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7.120000")
    @NotNull(message = "Exchange rate cannot be empty.")
    @DecimalMin(value = "0", inclusive = false, message = "Exchange rate must be greater than 0.")
    @Digits(integer = 12, fraction = 6, message = "Exchange rate can have at most 12 integer digits and 6 decimal places.")
    private BigDecimal exchangeRate;

}
