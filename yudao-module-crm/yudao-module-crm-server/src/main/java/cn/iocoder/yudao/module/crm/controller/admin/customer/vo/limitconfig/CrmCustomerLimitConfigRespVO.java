package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.limitconfig;

import cn.iocoder.yudao.module.system.api.dept.dto.DeptRespDTO;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Customer-limit setting response VO.")
@Data
public class CrmCustomerLimitConfigRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "27930")
    private Long id;

    @Schema(description = "Rule type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer type;

    @Schema(description = "Rule audience.")
    private List<Long> userIds;

    @Schema(description = "Rule departments.")
    private List<Long> deptIds;

    @Schema(description = "Quantity limit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28384")
    private Integer maxCount;

    @Schema(description = "Won customers as a share of owned customers.")
    private Boolean dealCountEnabled;

    @Schema(description = "Rule audience. name.")
    private List<AdminUserRespDTO> users;

    @Schema(description = "Rule departments. name.")
    private List<DeptRespDTO> depts;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
