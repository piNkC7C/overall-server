package cn.iocoder.yudao.module.mes.controller.admin.qc.iqc.vo;

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

@Schema(description = "管理后台 - MES 来料检验单新增/修改 Request VO")
@Data
public class MesQcIqcSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "检验单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "IQC20250101001")
    @NotEmpty(message = "Inspection code is required.")
    private String code;

    @Schema(description = "检验单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material A incoming inspection")
    @NotEmpty(message = "Inspection name is required.")
    private String name;

    // ========== source document ==========

    @Schema(description = "来源单据类型", example = "100")
    private Integer sourceDocType;

    @Schema(description = "来源单据 ID", example = "200")
    private Long sourceDocId;

    @Schema(description = "来源单据行 ID", example = "300")
    private Long sourceLineId;

    // ========== supplier ==========

    @Schema(description = "供应商 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Supplier is required.")
    private Long vendorId;

    @Schema(description = "供应商批次号", example = "VB20250101")
    private String vendorBatch;

    // ========== material ==========

    @Schema(description = "产品物料 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @NotNull(message = "Product material is required.")
    private Long itemId;

    // ========== quantity ==========

    @Schema(description = "本次接收数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "This TimesReceive quantity is required.")
    private BigDecimal receivedQuantity;

    @Schema(description = "合格品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "9")
    @NotNull(message = "Passed quantity quantity is required.")
    @DecimalMin(value = "0", message = "Passed quantity cannot be less than 0.")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "不合格品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Failed quantity quantity is required.")
    @DecimalMin(value = "0", message = "Failed quantity cannot be less than 0.")
    private BigDecimal unqualifiedQuantity;

    // ========== inspection ==========

    @Schema(description = "检测人员用户 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspector is required.")
    private Long inspectorUserId;

    @Schema(description = "检测日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inspection Date is required.")
    private LocalDateTime inspectDate;

    @Schema(description = "检测结果", example = "1")
    private Integer checkResult;

    @Schema(description = "来料日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Incoming Date is required.")
    private LocalDateTime receiveDate;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    @AssertTrue(message = "Passed quantity plus failed quantity must equal received quantity.")
    @JsonIgnore
    public boolean isQuantityValid() {
        if (ObjUtil.hasNull(qualifiedQuantity, unqualifiedQuantity, receivedQuantity)) {
            return true; // @NotNull will process null
        }
        return qualifiedQuantity.add(unqualifiedQuantity).compareTo(receivedQuantity) == 0;
    }

}
