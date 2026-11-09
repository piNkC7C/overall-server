package cn.iocoder.yudao.module.promotion.controller.admin.point.vo.activity;

import cn.iocoder.yudao.module.promotion.controller.admin.point.vo.product.PointProductRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 积分商城活动 Response VO")
@Data
@ExcelIgnoreUnannotated
public class PointActivityRespVO {

    @Schema(description = "积分商城活动编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11373")
    @ExcelProperty("Points Mall Campaign ID")
    private Long id;

    @Schema(description = "积分商城活动商品", requiredMode = Schema.RequiredMode.REQUIRED, example = "19509")
    @ExcelProperty("Points Mall Product")
    private Long spuId;

    @Schema(description = "活动状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Campaign Status")
    private Integer status;

    @Schema(description = "积分商城活动库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Points Mall Stock")
    private Integer stock; // 剩余库存积分兑换时扣减

    @Schema(description = "积分商城活动总库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Points Mall Total Stock")
    private Integer totalStock;

    @Schema(description = "备注", example = "Looks good.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Sort")
    private Integer sort;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "积分商城商品", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PointProductRespVO> products;

    // ========== productfield ==========

    @Schema(description = "商品名称", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 name 读取
            example = "Summer Sale")
    private String spuName;
    @Schema(description = "商品主图", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 picUrl 读取
            example = "https://www.iocoder.cn/xx.png")
    private String picUrl;
    @Schema(description = "商品市场价，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, // 从 SPU 的 marketPrice 读取
            example = "50")
    private Integer marketPrice;

    //======================= 显示所需兑换积分最少的 sku 信息 =======================

    @Schema(description = "兑换积分", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer point;

    @Schema(description = "兑换金额，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "15860")
    private Integer price;

}