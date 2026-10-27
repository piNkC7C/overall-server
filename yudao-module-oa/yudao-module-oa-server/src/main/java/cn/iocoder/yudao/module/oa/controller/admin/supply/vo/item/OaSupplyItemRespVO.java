package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.item;

import cn.iocoder.yudao.module.oa.enums.supply.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - Office supply response.")
@Data
public class OaSupplyItemRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Department code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long deptId;

    @Schema(description = "Item Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "A4 paper")
    private String name;

    @Schema(description = "Item Code", example = "BGYP0001")
    private String no;

    @Schema(description = "Category.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer category;

    @Schema(description = "Admin type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer manageType;

    @Schema(description = "Spec / Model", example = "A4 80g")
    private String model;

    @Schema(description = "Unit of measure.", example = "Bag")
    private String unit;

    @Schema(description = "Reference unit price.", example = "100.00")
    private BigDecimal referencePrice;

    @Schema(description = "Inventory quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer stockQuantity;

    @Schema(description = "Minimum stock.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer minStockQuantity;

    @Schema(description = "Item image.", example = "https://example.com/image.png")
    private String picUrl;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "Department.", example = "Administration.")
    private String deptName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}
