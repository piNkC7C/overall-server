package cn.iocoder.yudao.module.fms.controller.admin.config.vo.auxiliaryitem;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

/**
 * FMS 辅助核算项目 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS auxiliary accounting item response.")
@Data
@ExcelIgnoreUnannotated
public class FmsAuxiliaryItemRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long accountSetId;

    @Schema(description = "Auxiliary category ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long auxiliaryTypeId;

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "KH001")
    @ExcelProperty("Code")
    private String code;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Seattle Sample Digital LLC")
    @ExcelProperty("Name")
    private String name;

    @Schema(description = "Notes.", example = "Key customer")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "SKU.", example = "Standard edition")
    @ExcelProperty("SKU")
    private String specification;

    @Schema(description = "Order characters.", example = "Unit")
    @ExcelProperty("Unit")
    private String unit;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
