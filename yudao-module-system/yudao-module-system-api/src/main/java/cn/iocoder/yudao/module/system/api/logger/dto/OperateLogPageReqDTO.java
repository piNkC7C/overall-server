package cn.iocoder.yudao.module.system.api.logger.dto;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "RPC service - Activity Log page Request DTO.")
@Data
public class OperateLogPageReqDTO extends PageParam {

    @Schema(description = "Module type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Order.")
    private String type;

    @Schema(description = "Module data code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "188")
    private Long bizId;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "666")
    private Long userId;

}
