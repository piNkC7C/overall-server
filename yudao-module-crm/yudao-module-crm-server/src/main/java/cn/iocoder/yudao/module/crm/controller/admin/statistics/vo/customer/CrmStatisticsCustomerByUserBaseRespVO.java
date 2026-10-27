package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户客户统计响应 Base Response VO
 *
 * 目的：可以统一拼接子 VO 的 ownerUserId、ownerUserName 属性
 */
@Data
public class CrmStatisticsCustomerByUserBaseRespVO {

    @Schema(description = "Owner person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long ownerUserId;

    @Schema(description = "Owner person.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String ownerUserName;

}
