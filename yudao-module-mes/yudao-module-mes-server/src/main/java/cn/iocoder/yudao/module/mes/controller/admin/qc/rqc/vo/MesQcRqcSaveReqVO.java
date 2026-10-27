package cn.iocoder.yudao.module.mes.controller.admin.qc.rqc.vo;

import cn.hutool.core.util.ObjUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES return inspection create / edit request.")
@Data
public class MesQcRqcSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inspection code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RQC20250101001")
    @NotEmpty(message = "Inspection code is required.")
    private String code;

    @Schema(description = "Inspection name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material A return inspection.")
    @NotEmpty(message = "Inspection name is required.")
    private String name;

    @Schema(description = "Inspection template ID.", example = "100")
    private Long templateId;

    // ========== source document ==========

    @Schema(description = "Source document type.", example = "116")
    private Integer sourceDocType;

    @Schema(description = "Source document ID.", example = "200")
    private Long sourceDocId;

    @Schema(description = "Source document line ID.", example = "300")
    private Long sourceLineId;

    // ========== inspection type ==========

    @Schema(description = "Inspection type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspection type is required.")
    private Integer type;

    // ========== material ==========

    @Schema(description = "Product material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @NotNull(message = "Product material is required.")
    private Long itemId;

    @Schema(description = "Lot no.", example = "BATCH001")
    private String batchCode;

    // ========== quantity ==========

    @Schema(description = "Inspected quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Inspected quantity is required.")
    @DecimalMin(value = "0", message = "Inspected quantity cannot be less than 0.")
    private BigDecimal checkQuantity;

    @Schema(description = "Passed quantity quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "90")
    @NotNull(message = "Passed quantity quantity is required.")
    @DecimalMin(value = "0", message = "Passed quantity cannot be less than 0.")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "Failed quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Failed quantity cannot be empty.")
    @DecimalMin(value = "0", message = "Failed quantity cannot be less than 0.")
    private BigDecimal unqualifiedQuantity;

    // ========== inspection ==========

    @Schema(description = "Inspection result.", example = "1")
    private Integer checkResult;

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
