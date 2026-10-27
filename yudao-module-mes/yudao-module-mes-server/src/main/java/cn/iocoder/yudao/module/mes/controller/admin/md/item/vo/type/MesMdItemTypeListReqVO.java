package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - MES material product category list request.")
@Data
public class MesMdItemTypeListReqVO {

    @Schema(description = "Category name.", example = "Raw material")
    private String name;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
