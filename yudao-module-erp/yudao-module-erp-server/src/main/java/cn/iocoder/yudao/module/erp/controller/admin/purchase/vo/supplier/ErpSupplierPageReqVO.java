package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.supplier;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - ERP supplier page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpSupplierPageReqVO extends PageParam {

    @Schema(description = "Supplier name.", example = "Overall.")
    private String name;

    @Schema(description = "Mobile Number", example = "15601691300")
    private String mobile;

    @Schema(description = "Phone", example = "18818288888")
    private String telephone;

}