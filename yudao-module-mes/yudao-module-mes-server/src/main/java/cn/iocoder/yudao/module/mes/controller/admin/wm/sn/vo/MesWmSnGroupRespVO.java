package cn.iocoder.yudao.module.mes.controller.admin.wm.sn.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "MES Serial number group response VO.")
@Data
@Accessors(chain = true)
public class MesWmSnGroupRespVO {

    @Schema(description = "Lot UUID.", example = "550e8400-e29b-41d4-a716-446655440000")
    private String uuid;

    @Schema(description = "SN. quantity.", example = "100")
    @ExcelProperty("Serial Number Count")
    private Integer count;

    @Schema(description = "Material code.", example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "ITEM001")
    @ExcelProperty("Material Code")
    private String itemCode;

    @Schema(description = "Material name.", example = "Material A.")
    @ExcelProperty("Material Name")
    private String itemName;

    @Schema(description = "Spec / Model", example = "100*200")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "Order characters.", example = "")
    @ExcelProperty("Unit")
    private String unitName;

    @Schema(description = "Lot no.", example = "BATCH001")
    @ExcelProperty("Lot No")
    private String batchCode;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Create time.")
    @ExcelProperty("Generated Time")
    private LocalDateTime createTime;

}
