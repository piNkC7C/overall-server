package cn.iocoder.yudao.module.trade.controller.admin.aftersale.vo.log;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "After-sale log response VO.")
@Data
public class AfterSaleLogRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20669")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22634")
    private Long userId;

    @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer userType;

    @Schema(description = "After-sales code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3023")
    private Long afterSaleId;

    @Schema(description = "After-sales status ( before ).", example = "2")
    private Integer beforeStatus;

    @Schema(description = "After-sales status ( after ).", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer afterStatus;

    @Schema(description = "Actiondetail.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Dispute closed. Refund amount: $377.76")
    private String content;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
