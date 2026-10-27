package cn.iocoder.yudao.module.promotion.controller.admin.point.vo.activity;

import cn.iocoder.yudao.module.promotion.controller.admin.point.vo.product.PointProductRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - points shop campaign response.")
@Data
@ExcelIgnoreUnannotated
public class PointActivityRespVO {

    @Schema(description = "Points shop campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11373")
    @ExcelProperty("Points Mall Campaign ID")
    private Long id;

    @Schema(description = "Points shop campaignproduct.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19509")
    @ExcelProperty("Points Mall Product")
    private Long spuId;

    @Schema(description = "Campaign status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Campaign Status")
    private Integer status;

    @Schema(description = "Points shop campaigninventory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Points Mall Stock")
    private Integer stock; // 剩余库存积分兑换时扣减

    @Schema(description = "Points-mall campaign stock.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Points Mall Total Stock")
    private Integer totalStock;

    @Schema(description = "Notes.", example = "Looks good.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Sort")
    private Integer sort;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Points shop product.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PointProductRespVO> products;

    // ========== productfield ==========

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 name 读取
            example = "Summer Sale")
    private String spuName;
    @Schema(description = "Product main image.", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 picUrl 读取
            example = "https://www.iocoder.cn/xx.png")
    private String picUrl;
    @Schema(description = "Market price, in cents", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 marketPrice 读取
            example = "50")
    private Integer marketPrice;

    //======================= 显示所需兑换积分最少的 sku 信息 =======================

    @Schema(description = "Redeem points.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer point;

    @Schema(description = "Redeem amount, in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15860")
    private Integer price;

}