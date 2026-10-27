package cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - MES supplierreturn order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class MesWmReturnVendorPageReqVO extends PageParam {

    @Schema(description = "Return order code.", example = "RV20250226001")
    private String code;

    @Schema(description = "Return order name.", example = "Supplier return.")
    private String name;

    @Schema(description = "Purchase order code.")
    private String purchaseOrderCode;

    @Schema(description = "Supplier ID.", example = "1")
    private Long vendorId;

}
