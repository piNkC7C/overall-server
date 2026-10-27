package cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "MES barcode list response VO.")
@Data
@ExcelIgnoreUnannotated
public class MesWmBarcodeRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Barcode setting code.", example = "1")
    private Long configId;

    @Schema(description = "Barcode format.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Barcode Format")
    private Integer format;

    @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "102")
    @ExcelProperty("Business Type")
    private Integer bizType;

    @Schema(description = "Barcode content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH-WH001")
    @ExcelProperty("Barcode Content")
    private String content;

    @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long bizId;

    @Schema(description = "Business code.", example = "WH001")
    @ExcelProperty("Business Code")
    private String bizCode;

    @Schema(description = "Business name.", example = "Raw Materials.")
    @ExcelProperty("Business Name")
    private String bizName;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
