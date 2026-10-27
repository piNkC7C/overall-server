package cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES barcode setting response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmBarcodeConfigRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Barcode format.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Barcode Format")
    private Integer format;

    @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "102")
    @ExcelProperty("Business Type")
    private Integer bizType;

    @Schema(description = "Content format template.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH-{BUSINESSCODE}")
    @ExcelProperty("Content Format Template")
    private String contentFormat;

    @Schema(description = "Sample content.", example = "WH-WH001")
    @ExcelProperty("Sample Content")
    private String contentExample;

    @Schema(description = "Is not Autocreate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Auto Generate")
    private Boolean autoGenerateFlag;

    @Schema(description = "Default print template.", example = "template1")
    @ExcelProperty("Default Print Template")
    private String defaultTemplate;

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
