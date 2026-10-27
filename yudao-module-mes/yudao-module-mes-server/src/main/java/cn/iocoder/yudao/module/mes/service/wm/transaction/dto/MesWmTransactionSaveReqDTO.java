package cn.iocoder.yudao.module.mes.service.wm.transaction.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * MES 库存事务 创建 Request DTO
 */
@Data
@Accessors(chain = true)
public class MesWmTransactionSaveReqDTO {

    // ===== 事务核心 =====

    /**
     * 事务类型
     *
     * 枚举 {@link cn.iocoder.yudao.module.mes.enums.wm.MesWmTransactionTypeEnum}
     */
    @NotNull(message = "Transaction type cannot be empty.")
    private Integer type;

    // ===== business source =====

    /**
     * 业务类型
     *
     * 对应 {@link cn.iocoder.yudao.module.mes.enums.MesBizTypeConstants}
     */
    @NotNull(message = "Business type is required.")
    private Integer bizType;
    /**
     * 业务主单 ID
     */
    @NotNull(message = "Business document ID cannot be empty.")
    private Long bizId;
    /**
     * 业务单号
     */
    @NotNull(message = "Business order no. is required.")
    private String bizCode;
    /**
     * 业务行 ID
     */
    @NotNull(message = "Business line ID is required.")
    private Long bizLineId;

    // ===== material Dimension =====

    /**
     * 物料 ID
     */
    @NotNull(message = "Material ID is required.")
    private Long itemId;
    /**
     * 变动数量（入库为正数，出库为负数）
     */
    @NotNull(message = "Quantity change cannot be empty.")
    private BigDecimal quantity;
    /**
     * 批次 ID
     */
    private Long batchId;
    /**
     * 批次号
     */
    private String batchCode;

    // ===== inventoryLocation =====

    /**
     * 仓库 ID
     */
    @NotNull(message = "Warehouse ID is required.")
    private Long warehouseId;
    /**
     * 库区 ID
     */
    @NotNull(message = "Zone ID is required.")
    private Long locationId;
    /**
     * 库位 ID
     */
    @NotNull(message = "Bin ID is required.")
    private Long areaId;

    // ===== 台账补充字段（入库时用于初始化 MesWmMaterialStockDO） =====

    /**
     * 供应商 ID（采购入库场景）
     */
    private Long vendorId;
    /**
     * 入库时间（为空默认当前时间）
     */
    private LocalDateTime receiptTime;

    // ===== relation =====

    /**
     * 关联事务 ID（成对事务中，入库事务关联出库事务）
     */
    private Long relatedTransactionId;

    // ===== 可选控制（非存储字段） =====

    /**
     * 是否校验库存充足（默认 true；线边库消耗等场景设 false 允许负库存）
     */
    private Boolean checkFlag;

}
