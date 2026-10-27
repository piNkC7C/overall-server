package cn.iocoder.yudao.module.hrm.controller.admin.portal.salary.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "HRM employee unread payslips overview response VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HrmPortalSalarySlipUnreadSummaryRespVO {

    @Schema(description = "UnreadpayslipQuantity.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long unreadCount;

    @Schema(description = "Latest unread payslip reminder.")
    private String reminder;

}
