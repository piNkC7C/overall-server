package cn.iocoder.yudao.module.mes.controller.admin.wm.arrivalnotice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 到货通知单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmArrivalNoticeRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "通知单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "AN2026020001")
    @ExcelProperty("Notice Code")
    private String code;

    @Schema(description = "通知单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "2 Monthsteel plate receiving.")
    @ExcelProperty("Notice Name")
    private String name;

    @Schema(description = "采购订单编号", example = "PO20260101")
    @ExcelProperty("Purchase Order No")
    private String purchaseOrderCode;

    @Schema(description = "供应商编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long vendorId;

    @Schema(description = "供应商编码", example = "V001")
    @ExcelProperty("Supplier Code")
    private String vendorCode;

    @Schema(description = "供应商名称", example = "A supplier.")
    @ExcelProperty("Supplier Name")
    private String vendorName;

    @Schema(description = "到货日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Arrival Date")
    private LocalDateTime arrivalDate;

    @Schema(description = "联系人", example = "John.")
    @ExcelProperty("Contact")
    private String contactName;

    @Schema(description = "联系电话", example = "13800138000")
    @ExcelProperty("Phone")
    private String contactTelephone;

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
