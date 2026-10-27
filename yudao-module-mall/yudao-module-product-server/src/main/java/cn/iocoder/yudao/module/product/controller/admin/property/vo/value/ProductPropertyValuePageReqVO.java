package cn.iocoder.yudao.module.product.controller.admin.property.vo.value;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - product attribute valuepage request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductPropertyValuePageReqVO extends PageParam {

    @Schema(description = "Attribute item code.", example = "1024")
    private Long propertyId;

    @Schema(description = "Name.", example = "Red")
    private String name;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

}
