package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.brand;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - WMS product brand response.")
@Data
@ExcelIgnoreUnannotated
public class WmsItemBrandRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Brand code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "B00000001")
    @ExcelProperty("Brand ID")
    private String code;

    @Schema(description = "Brand name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei")
    @ExcelProperty("Brand Name")
    private String name;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
