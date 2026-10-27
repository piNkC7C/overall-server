package cn.iocoder.yudao.module.mes.controller.admin.qc.oqc.vo;

import cn.hutool.core.util.ObjUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "MES outgoing inspection create / update request VO.")
@Data
public class MesQcOqcSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inspection code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "OQC20250101001")
    @NotEmpty(message = "Inspection code is required.")
    private String code;

    @Schema(description = "Inspection name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material A outgoing inspection")
    @NotEmpty(message = "Inspection name is required.")
    private String name;

    // ========== source document ==========

    @Schema(description = "Source document type.", example = "118")
    private Integer sourceDocType;

    @Schema(description = "Source document ID.", example = "200")
    private Long sourceDocId;

    @Schema(description = "Source document line ID.", example = "300")
    private Long sourceLineId;

    // ========== customer ==========

    @Schema(description = "Customer ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Customer is required.")
    private Long clientId;

    // ========== material ==========

    @Schema(description = "Lot no.", example = "BC20250101")
    private String batchCode;

    @Schema(description = "Product material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @NotNull(message = "Product material is required.")
    private Long itemId;

    // ========== quantity ==========

    @Schema(description = "This shipment quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "This shipment quantity cannot be empty.")
    @DecimalMin(value = "0", message = "This shipment quantity cannot be less than 0.")
    private BigDecimal outQuantity;

    @Schema(description = "This Timesinspected quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "This Timesinspected quantity is required.")
    @DecimalMin(value = "0", message = "This inspection quantity cannot be less than 0.")
    private BigDecimal checkQuantity;

    @Schema(description = "Passed quantity quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9")
    @NotNull(message = "Passed quantity quantity is required.")
    @DecimalMin(value = "0", message = "Passed quantity cannot be less than 0.")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "Failed quantity quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Failed quantity quantity is required.")
    @DecimalMin(value = "0", message = "Failed quantity cannot be less than 0.")
    private BigDecimal unqualifiedQuantity;

    // ========== inspection ==========

    @Schema(description = "Inspection result.", example = "1")
    private Integer checkResult;

    @Schema(description = "Ship date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Ship date cannot be empty.")
    private LocalDateTime outDate;

    @Schema(description = "Inspection Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inspection Date is required.")
    private LocalDateTime inspectDate;

    @Schema(description = "Inspectoruser ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspector is required.")
    private Long inspectorUserId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @AssertTrue(message = "Inspected quantity must equal passed quantity plus failed quantity.")
    @JsonIgnore
    public boolean isQuantityValid() {
        if (ObjUtil.hasNull(checkQuantity, qualifiedQuantity, unqualifiedQuantity)) {
            return true; // @NotNull will process null
        }
        return checkQuantity.compareTo(qualifiedQuantity.add(unqualifiedQuantity)) == 0;
    }

}
