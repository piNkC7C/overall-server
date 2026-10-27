package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.limitconfig;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Customer-limit setting page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CrmCustomerLimitConfigPageReqVO extends PageParam {

    @Schema(description = "Rule type.", example = "1")
    private Integer type;

}
