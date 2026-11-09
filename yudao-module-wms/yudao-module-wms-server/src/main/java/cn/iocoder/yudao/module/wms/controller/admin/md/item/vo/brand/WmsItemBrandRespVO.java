package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.brand;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - WMS 商品品牌 Response VO")
@Data
@ExcelIgnoreUnannotated
public class WmsItemBrandRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "品牌编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "B00000001")
    @ExcelProperty("Brand ID")
    private String code;

    @Schema(description = "品牌名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei")
    @ExcelProperty("Brand Name")
    private String name;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}
