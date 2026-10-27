package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.customer;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CRM follow-up count analysis (by type) VO.")
@Data
public class CrmStatisticsFollowUpSummaryByTypeRespVO {

    @Schema(description = "Follow-up type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer followUpType;

    @Schema(description = "Follow-up Count", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer followUpRecordCount;

}
