package cn.iocoder.yudao.module.crm.controller.admin.product.vo.product;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - CRM product page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmProductPageReqVO extends PageParam {

    @Schema(description = "Product name.", example = "Jane.")
    private String name;

    @Schema(description = "Status.", example = "1")
    private Integer status;

}
