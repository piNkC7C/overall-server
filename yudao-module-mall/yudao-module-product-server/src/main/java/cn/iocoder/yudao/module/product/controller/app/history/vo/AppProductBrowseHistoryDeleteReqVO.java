package cn.iocoder.yudao.module.product.controller.app.history.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Schema(description = "用户 APP - 删除商品浏览记录的 Request VO")
@Data
public class AppProductBrowseHistoryDeleteReqVO {

    @Schema(description = "商品 SPU 编号数组", requiredMode = Schema.RequiredMode.REQUIRED, example = "29502")
    @NotEmpty(message = "Product SPU ID list is required.")
    private List<Long> spuIds;

}
