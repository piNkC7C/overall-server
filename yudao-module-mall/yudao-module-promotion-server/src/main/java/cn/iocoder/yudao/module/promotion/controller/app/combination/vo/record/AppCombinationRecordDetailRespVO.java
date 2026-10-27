package cn.iocoder.yudao.module.promotion.controller.app.combination.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Group-buy record detail response VO.")
@Data
public class AppCombinationRecordDetailRespVO {

    @Schema(description = "Leader group-buy record.", requiredMode = Schema.RequiredMode.REQUIRED)
    private AppCombinationRecordRespVO headRecord;

    @Schema(description = "Member group buy record.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<AppCombinationRecordRespVO> memberRecords;

    @Schema(description = "Current user join-group record related order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long orderId;

}
