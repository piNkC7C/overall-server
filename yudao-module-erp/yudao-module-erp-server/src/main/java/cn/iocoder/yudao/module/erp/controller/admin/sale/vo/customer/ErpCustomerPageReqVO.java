package cn.iocoder.yudao.module.erp.controller.admin.sale.vo.customer;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - ERP customer page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpCustomerPageReqVO extends PageParam {

    @Schema(description = "Customer name.", example = "John.")
    private String name;

    @Schema(description = "Mobile Number", example = "15601691300")
    private String mobile;

    @Schema(description = "Phone", example = "15601691300")
    private String telephone;

}