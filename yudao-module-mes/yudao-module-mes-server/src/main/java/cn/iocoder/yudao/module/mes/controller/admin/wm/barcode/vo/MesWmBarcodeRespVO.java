package cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 条码清单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmBarcodeRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "条码配置编号", example = "1")
    private Long configId;

    @Schema(description = "条码格式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Barcode Format")
    private Integer format;

    @Schema(description = "业务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "102")
    @ExcelProperty("Business Type")
    private Integer bizType;

    @Schema(description = "条码内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH-WH001")
    @ExcelProperty("Barcode Content")
    private String content;

    @Schema(description = "业务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long bizId;

    @Schema(description = "业务编码", example = "WH001")
    @ExcelProperty("Business Code")
    private String bizCode;

    @Schema(description = "业务名称", example = "Raw Materials.")
    @ExcelProperty("Business Name")
    private String bizName;

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
