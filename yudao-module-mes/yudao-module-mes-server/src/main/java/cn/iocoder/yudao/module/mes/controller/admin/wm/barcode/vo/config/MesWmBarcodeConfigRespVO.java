package cn.iocoder.yudao.module.mes.controller.admin.wm.barcode.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 条码配置 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmBarcodeConfigRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "条码格式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Barcode Format")
    private Integer format;

    @Schema(description = "业务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "102")
    @ExcelProperty("Business Type")
    private Integer bizType;

    @Schema(description = "内容格式模板", requiredMode = Schema.RequiredMode.REQUIRED, example = "WH-{BUSINESSCODE}")
    @ExcelProperty("Content Format Template")
    private String contentFormat;

    @Schema(description = "内容样例", example = "WH-WH001")
    @ExcelProperty("Sample Content")
    private String contentExample;

    @Schema(description = "是否自动生成", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Auto Generate")
    private Boolean autoGenerateFlag;

    @Schema(description = "默认打印模板", example = "template1")
    @ExcelProperty("Default Print Template")
    private String defaultTemplate;

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
