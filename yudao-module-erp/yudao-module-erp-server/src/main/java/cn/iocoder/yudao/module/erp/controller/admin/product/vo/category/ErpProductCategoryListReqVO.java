package cn.iocoder.yudao.module.erp.controller.admin.product.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - ERP product category list request.")
@Data
public class ErpProductCategoryListReqVO {

    @Schema(description = "Category name.", example = "Overall.")
    private String name;

    @Schema(description = "Enable status.", example = "1")
    private Integer status;

}