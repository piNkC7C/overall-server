package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.category;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - WMS product category list request.")
@Data
public class WmsItemCategoryListReqVO {

    @Schema(description = "Parent code.", example = "1")
    private Long parentId;

    @Schema(description = "Category code.", example = "C00000001")
    private String code;

    @Schema(description = "Category name.", example = "Raw material")
    private String name;

    @Schema(description = "Status.", example = "0")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

}
