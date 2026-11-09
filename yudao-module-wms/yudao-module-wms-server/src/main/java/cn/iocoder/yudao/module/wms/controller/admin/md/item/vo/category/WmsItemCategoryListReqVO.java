package cn.iocoder.yudao.module.wms.controller.admin.md.item.vo.category;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - WMS 商品分类列表 Request VO")
@Data
public class WmsItemCategoryListReqVO {

    @Schema(description = "父级编号", example = "1")
    private Long parentId;

    @Schema(description = "分类编号", example = "C00000001")
    private String code;

    @Schema(description = "分类名称", example = "Raw material")
    private String name;

    @Schema(description = "状态", example = "0")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

}
