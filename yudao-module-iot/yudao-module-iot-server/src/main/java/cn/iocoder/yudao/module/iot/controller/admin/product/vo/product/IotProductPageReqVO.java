package cn.iocoder.yudao.module.iot.controller.admin.product.vo.product;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - IoT product page request.")
@Data
public class IotProductPageReqVO extends PageParam {

    @Schema(description = "Product name.", example = "Jane.")
    private String name;

    @Schema(description = "Product key.")
    private String productKey;

}