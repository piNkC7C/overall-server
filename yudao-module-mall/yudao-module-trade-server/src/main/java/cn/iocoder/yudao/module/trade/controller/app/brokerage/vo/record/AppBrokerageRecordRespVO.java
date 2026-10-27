package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Reseller record response VO.")
@Data
public class AppBrokerageRecordRespVO {

    @Schema(description = "Record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long id;

    @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private String bizId;

    @Schema(description = "Reseller Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "User order.")
    private String title;

    @Schema(description = "Reseller Amount, unit: cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    private Integer price;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Status name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pending settlement")
    private String statusName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Complete time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime finishTime;

}
