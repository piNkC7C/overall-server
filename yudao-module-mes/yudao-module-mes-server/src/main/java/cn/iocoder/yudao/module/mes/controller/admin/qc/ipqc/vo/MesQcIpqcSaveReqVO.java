package cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc.vo;

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

@Schema(description = "管理后台 - MES 过程检验单新增/修改 Request VO")
@Data
public class MesQcIpqcSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "检验单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "IPQC20250101001")
    @NotEmpty(message = "Inspection code is required.")
    private String code;

    @Schema(description = "检验单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "XX work-order in-process inspection")
    @NotEmpty(message = "Inspection name is required.")
    private String name;

    @Schema(description = "IPQC 检验类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspection type is required.")
    private Integer type;

    // ========== source document ==========

    @Schema(description = "来源单据类型", example = "304")
    private Integer sourceDocType;

    @Schema(description = "来源单据 ID", example = "200")
    private Long sourceDocId;

    @Schema(description = "来源单据行 ID", example = "300")
    private Long sourceLineId;

    // ========== production relation ==========

    @Schema(description = "生产工单 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Production work order is required.")
    private Long workOrderId;

    @Schema(description = "生产任务 ID", example = "20")
    private Long taskId;

    @Schema(description = "工位 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
    @NotNull(message = "Workstation cannot be empty.")
    private Long workstationId;

    @Schema(description = "工序 ID", example = "40")
    private Long processId;

    // ========== material ==========

    @Schema(description = "产品物料 ID", example = "50")
    private Long itemId;

    // ========== quantity ==========

    @Schema(description = "检测数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Inspected quantity is required.")
    @DecimalMin(value = "0", message = "Inspected quantity cannot be less than 0.")
    private BigDecimal checkQuantity;

    @Schema(description = "合格品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "95")
    @NotNull(message = "Passed quantity quantity is required.")
    @DecimalMin(value = "0", message = "Passed quantity cannot be less than 0.")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "不合格品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Failed quantity quantity is required.")
    @DecimalMin(value = "0", message = "Failed quantity cannot be less than 0.")
    private BigDecimal unqualifiedQuantity;

    @Schema(description = "工废数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Process scrap quantity cannot be empty.")
    @DecimalMin(value = "0", message = "Process scrap quantity cannot be less than 0.")
    private BigDecimal laborScrapQuantity;

    @Schema(description = "料废数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Material scrap quantity cannot be empty.")
    @DecimalMin(value = "0", message = "Material scrap quantity cannot be less than 0.")
    private BigDecimal materialScrapQuantity;

    @Schema(description = "其他废品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Other scrap quantity cannot be empty.")
    @DecimalMin(value = "0", message = "Other scrap quantity cannot be less than 0.")
    private BigDecimal otherScrapQuantity;

    // ========== inspection ==========

    @Schema(description = "检测结果", example = "1")
    private Integer checkResult;

    @Schema(description = "检测日期")
    private LocalDateTime inspectDate;

    @Schema(description = "检测人员用户 ID", example = "1")
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

    @AssertTrue(message = "Process, material, and other scrap cannot exceed failed quantity.")
    @JsonIgnore
    public boolean isScrapQuantityValid() {
        if (ObjUtil.hasNull(unqualifiedQuantity, laborScrapQuantity, materialScrapQuantity, otherScrapQuantity)) {
            return true; // @NotNull will process null
        }
        BigDecimal scrapSum = laborScrapQuantity.add(materialScrapQuantity).add(otherScrapQuantity);
        return scrapSum.compareTo(unqualifiedQuantity) <= 0;
    }

}
