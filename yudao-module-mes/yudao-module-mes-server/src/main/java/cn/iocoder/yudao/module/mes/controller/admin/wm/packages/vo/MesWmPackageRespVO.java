package cn.iocoder.yudao.module.mes.controller.admin.wm.packages.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * MES 装箱单 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "管理后台 - MES 装箱单 Response VO")
@Data
@Accessors(chain = true)
@ExcelIgnoreUnannotated
public class MesWmPackageRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "装箱单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "PKG20260307001")
    @ExcelProperty("Packing List No")
    private String code;

    @Schema(description = "父箱 ID", example = "0")
    private Long parentId;

    @Schema(description = "装箱日期")
    @ExcelProperty("Packing Date")
    private LocalDateTime packageDate;

    @Schema(description = "销售订单编号", example = "SO20260301")
    @ExcelProperty("Sales Order No")
    private String salesOrderCode;

    @Schema(description = "发票编号", example = "INV20260301")
    @ExcelProperty("Invoice No")
    private String invoiceCode;

    @Schema(description = "客户 ID", example = "1")
    private Long clientId;

    @Schema(description = "客户编码", example = "C001")
    @ExcelProperty("Customer Code")
    private String clientCode;

    @Schema(description = "客户名称", example = "A customer.")
    @ExcelProperty("Customer Name")
    private String clientName;

    @Schema(description = "客户简称", example = "A customer short name.")
    private String clientNickname;

    @Schema(description = "箱长度", example = "60.00")
    @ExcelProperty("Box Length")
    private BigDecimal length;

    @Schema(description = "箱宽度", example = "40.00")
    @ExcelProperty("Box Width")
    private BigDecimal width;

    @Schema(description = "箱高度", example = "30.00")
    @ExcelProperty("Box Height")
    private BigDecimal height;

    @Schema(description = "尺寸单位 ID", example = "1")
    private Long sizeUnitId;

    @Schema(description = "尺寸单位名称", example = "cm")
    @ExcelProperty("Size Unit")
    private String sizeUnitName;

    @Schema(description = "净重", example = "10.00")
    @ExcelProperty("Net Weight")
    private BigDecimal netWeight;

    @Schema(description = "毛重", example = "12.00")
    @ExcelProperty("Gross Weight")
    private BigDecimal grossWeight;

    @Schema(description = "重量单位 ID", example = "2")
    private Long weightUnitId;

    @Schema(description = "重量单位名称", example = "Kg.")
    @ExcelProperty("Weight Unit")
    private String weightUnitName;

    @Schema(description = "检查员用户 ID", example = "1")
    private Long inspectorUserId;

    @Schema(description = "检查员姓名", example = "John.")
    @ExcelProperty("Inspector")
    private String inspectorName;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
