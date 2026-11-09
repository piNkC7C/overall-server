package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.item;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.supply.*;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 办公用品新增/修改 Request VO")
@Data
public class OaSupplyItemSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "所属部门编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Department is required.")
    private Long deptId;

    @Schema(description = "物品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "A4 paper")
    @NotBlank(message = "Item Name is required.")
    @Size(max = 128, message = "Item Name length cannot exceed {max} characters.")
    private String name;

    @Schema(description = "物品编码", example = "BGYP0001")
    @Size(max = 64, message = "Item Code length cannot exceed {max} characters.")
    private String no;

    @Schema(description = "类别", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Category cannot be empty.")
    @InEnum(value = OaSupplyCategoryEnum.class, message = "Category must be {value}.")
    private Integer category;

    @Schema(description = "管理类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Admin type is required.")
    @InEnum(value = OaSupplyManageTypeEnum.class, message = "Admin type must be {value}.")
    private Integer manageType;

    @Schema(description = "规格型号", example = "A4 80g")
    @Size(max = 128, message = "Spec / Model length cannot exceed {max} characters.")
    private String model;

    @Schema(description = "计量单位", example = "Bag")
    @Size(max = 32, message = "Unit of measure length cannot exceed {max} characters.")
    private String unit;

    @Schema(description = "参考单价", example = "100.00")
    @DecimalMin(value = "0", message = "Reference unit price cannot be less than {value}.")
    @Digits(integer = 16, fraction = 2, message = "Reference unit price can have at most {integer} integer digits and {fraction} decimal places.")
    private BigDecimal referencePrice;

    @Schema(description = "库存数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inventory quantity is required.")
    @Min(value = 0, message = "Stock quantity cannot be less than {value}.")
    private Integer stockQuantity;

    @Schema(description = "最低库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Minimum stock cannot be empty.")
    @Min(value = 0, message = "Minimum stock cannot be less than {value}.")
    private Integer minStockQuantity;

    @Schema(description = "物品图片", example = "https://example.com/image.png")
    @Size(max = 2048, message = "Item image cannot exceed {max} characters.")
    private String picUrl;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "备注", example = "Contact Admin in advance to confirm.")
    @Size(max = 500, message = "Notes length cannot exceed {max} characters.")
    private String remark;

}
