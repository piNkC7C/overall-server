package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.brand;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - WMS product brand create / edit request.")
@Data
public class WmsItemBrandSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Brand code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "B00000001")
    @NotEmpty(message = "Brand code is required.")
    @Size(max = 20, message = "Brand code length cannot exceed 20 characters.")
    private String code;

    @Schema(description = "Brand name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Huawei")
    @NotEmpty(message = "Brand name is required.")
    @Size(max = 30, message = "Brand name length cannot exceed 30 characters.")
    private String name;

}
