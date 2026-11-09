package cn.iocoder.yudao.module.product.controller.admin.property.vo.value;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 商品属性值 Response VO")
@Data
public class ProductPropertyValueRespVO {

    @Schema(description = "主键", example = "1024")
    private Long id;

    @Schema(description = "属性项的编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Attribute item code is required.")
    private Long propertyId;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Red")
    @NotEmpty(message = "Name name is required.")
    private String name;

    @Schema(description = "备注", example = "Color.")
    private String remark;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
