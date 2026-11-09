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

@Schema(description = "管理后台 - MES 退货检验单新增/修改 Request VO")
@Data
public class MesQcRqcSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "检验单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "RQC20250101001")
    @NotEmpty(message = "Inspection code is required.")
    private String code;

    @Schema(description = "检验单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material A return inspection.")
    @NotEmpty(message = "Inspection name is required.")
    private String name;

    @Schema(description = "检验模板 ID", example = "100")
    private Long templateId;

    // ========== source document ==========

    @Schema(description = "来源单据类型", example = "116")
    private Integer sourceDocType;

    @Schema(description = "来源单据 ID", example = "200")
    private Long sourceDocId;

    @Schema(description = "来源单据行 ID", example = "300")
    private Long sourceLineId;

    // ========== inspection type ==========

    @Schema(description = "检验类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspection type is required.")
    private Integer type;

    // ========== material ==========

    @Schema(description = "产品物料 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @NotNull(message = "Product material is required.")
    private Long itemId;

    @Schema(description = "批次号", example = "BATCH001")
    private String batchCode;

    // ========== quantity ==========

    @Schema(description = "检测数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Inspected quantity is required.")
    @DecimalMin(value = "0", message = "Inspected quantity cannot be less than 0.")
    private BigDecimal checkQuantity;

    @Schema(description = "合格品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "90")
    @NotNull(message = "Passed quantity quantity is required.")
    @DecimalMin(value = "0", message = "Passed quantity cannot be less than 0.")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "不合格数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Failed quantity cannot be empty.")
    @DecimalMin(value = "0", message = "Failed quantity cannot be less than 0.")
    private BigDecimal unqualifiedQuantity;

    // ========== inspection ==========

    @Schema(description = "检测结果", example = "1")
    private Integer checkResult;

    @Schema(description = "检测日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inspection Date is required.")
    private LocalDateTime inspectDate;

    @Schema(description = "检测人员用户 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspector is required.")
    private Long inspectorUserId;

    @Schema(description = "备注", example = "Notes.")
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
