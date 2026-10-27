package cn.iocoder.yudao.module.erp.controller.admin.finance.vo.account;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - ERP Settlement Account page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpAccountPageReqVO extends PageParam {

    @Schema(description = "Account code.", example = "A88")
    private String no;

    @Schema(description = "Account name.", example = "John.")
    private String name;

    @Schema(description = "Notes.", example = "Sample.")
    private String remark;

}