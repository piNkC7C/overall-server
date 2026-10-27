package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.warehouse;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - ERP warehouse page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpWarehousePageReqVO extends PageParam {

    @Schema(description = "Warehouse name.", example = "Jane.")
    private String name;

    @Schema(description = "Enable status.", example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}