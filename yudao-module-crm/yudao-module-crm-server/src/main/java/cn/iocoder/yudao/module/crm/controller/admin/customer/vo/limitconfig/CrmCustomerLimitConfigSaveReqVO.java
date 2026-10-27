package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.limitconfig;

import cn.iocoder.yudao.module.crm.framework.operatelog.core.SysAdminUserParseFunction;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.SysDeptParseFunction;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Create or update customer-limit setting request VO.")
@Data
public class CrmCustomerLimitConfigSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "27930")
    private Long id;

    @Schema(description = "Rule type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Rule type is required.")
    @DiffLogField(name = "Rule type.")
    private Integer type;

    @Schema(description = "Rule audience.")
    @DiffLogField(name = "Applies to Users", function = SysAdminUserParseFunction.NAME)
    private List<Long> userIds;

    @Schema(description = "Rule departments.")
    @DiffLogField(name = "Applies to Departments", function = SysDeptParseFunction.NAME)
    private List<Long> deptIds;

    @Schema(description = "Quantity limit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28384")
    @NotNull(message = "Quantity limit is required.")
    @DiffLogField(name = "Quantity limit.")
    private Integer maxCount;

    @Schema(description = "Won customers as a share of owned customers (when type = 1).")
    @DiffLogField(name = "Count Closed-Won Customers Toward Limit")
    private Boolean dealCountEnabled;

}
