package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.item;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - Office supplypage request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaSupplyItemPageReqVO extends PageParam {

    @Schema(description = "Item Name", example = "A4 paper")
    private String name;

    @Schema(description = "Item Code", example = "BGYP0001")
    private String no;

    @Schema(description = "Category.", example = "1")
    private Integer category;

    @Schema(description = "Admin type.", example = "1")
    private Integer manageType;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
