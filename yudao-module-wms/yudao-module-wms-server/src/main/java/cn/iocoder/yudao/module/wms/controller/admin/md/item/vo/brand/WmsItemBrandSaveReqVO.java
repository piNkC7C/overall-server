package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.brand;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - WMS 商品品牌新增/修改 Request VO")
@Data
public class WmsItemBrandSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "品牌编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "B00000001")
    @NotEmpty(message = "Brand code is required.")
    @Size(max = 20, message = "Brand code length cannot exceed 20 characters.")
    private String code;

    @Schema(description = "品牌名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei")
    @NotEmpty(message = "Brand name is required.")
    @Size(max = 30, message = "Brand name length cannot exceed 30 characters.")
    private String name;

}
