package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - CRM 待办事项汇总 Response VO")
@Data
public class CrmTodoSummaryRespVO {

    @Schema(description = "今日需联系线索数", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Long clueFollowCount;

    @Schema(description = "今日需联系客户数", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Long customerTodayContactCount;

    @Schema(description = "今日需联系商机数", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long businessTodayCount;

    @Schema(description = "今日需联系合同数", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long contractTodayCount;

    @Schema(description = "待进入公海客户数", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    private Long customerPutPoolRemindCount;

    @Schema(description = "待我审批合同数", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long contractAuditCount;

    @Schema(description = "待我审批回款数", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long receivableAuditCount;

    @Schema(description = "待回款提醒数", requiredMode = Schema.RequiredMode.REQUIRED, example = "6")
    private Long receivablePlanRemindCount;

    @Schema(description = "即将到期合同数", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long contractRemindCount;

}
