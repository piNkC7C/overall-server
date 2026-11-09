package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 分销用户创建 Request VO")
@Data
public class BrokerageUserCreateReqVO {

    @Schema(description = "分销用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Distributor user ID cannot be empty.")
    private Long userId;

    @Schema(description = "推广员编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "4587")
    @NotNull(message = "Promoter code is required.")
    private Long bindUserId;

}
