package cn.iocoder.yudao.module.oa.controller.admin.seal.vo.apply;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.seal.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "Seal request create / update request VO.")
public class OaSealApplySaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Seal No.", example = "1024", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Seal is required.")
    private Long sealId;

    @Schema(description = "Seal Reason", example = "Contract seal", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Seal Reason is required.")
    @Size(max = 500, message = "Seal Reason length cannot exceed {max} characters.")
    private String reason;

    @Schema(description = "Seal-use type.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Seal-use type cannot be empty.")
    @InEnum(value = OaSealApplyTypeEnum.class, message = "Seal-use type must be {value}.")
    private Integer type;

    @Schema(description = "Seal-use method.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Seal-use method cannot be empty.")
    @InEnum(value = OaSealUseModeEnum.class, message = "Seal-use method must be {value}.")
    private Integer mode;

    @Schema(description = "File title.", example = "Purchase contract.")
    @Size(max = 255, message = "File title length cannot exceed {max} characters.")
    private String documentTitle;

    @Schema(description = "File type.", example = "Contract.")
    @Size(max = 64, message = "File type length cannot exceed {max} characters.")
    private String documentType;

    @Schema(description = "Copy count.", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Copy count cannot be empty.")
    @Min(value = 1, message = "Copy count cannot be less than {value}.")
    private Integer documentCount;

    @Schema(description = "Contract amount.", example = "10000.00")
    @DecimalMin(value = "0", message = "Contract amount cannot be less than {value}.")
    @Digits(integer = 16, fraction = 2, message = "Contract amount can have at most {integer} integer digits and {fraction} decimal places.")
    private BigDecimal contractPrice;

    @Schema(description = "Contract the other party.", example = "Sample Company.")
    @Size(max = 255, message = "Contract the other party length cannot exceed {max} characters.")
    private String contractParty;

    @Schema(description = "Planned Seal Time", example = "1789088400000", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64")
    @NotNull(message = "Planned Seal Time is required.")
    private LocalDateTime expectedUseTime;

    @Schema(description = "Planned Return Time", example = "1789120800000", type = "integer", format = "int64")
    private LocalDateTime expectedReturnTime;

    @Schema(description = "Actual Return Time.", example = "1789117200000", type = "integer", format = "int64")
    private LocalDateTime actualReturnTime;

    @Schema(description = "Is not Urgent.", example = "false", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Is not Urgent is required.")
    private Boolean urgent;

    @Schema(description = "Notes.", example = "Archive after the contract is signed")
    @Size(max = 500, message = "Notes length cannot exceed {max} characters.")
    private String remark;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/contract.pdf\"]")
    @Size(max = 5, message = "AttachmentAddress list quantity cannot exceed {max}.")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 2048, message = "AttachmentAddress length cannot exceed {max} characters.") String> fileUrls;
}
