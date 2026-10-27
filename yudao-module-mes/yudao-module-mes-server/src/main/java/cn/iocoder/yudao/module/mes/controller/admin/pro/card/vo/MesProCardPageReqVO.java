package cn.iocoder.yudao.module.mes.controller.admin.pro.card.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES production routing card page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesProCardPageReqVO extends PageParam {

    @Schema(description = "Routing card code.", example = "CARD-001")
    private String code;

    @Schema(description = "Production work order code.", example = "100")
    private Long workOrderId;

    @Schema(description = "Product material code.", example = "200")
    private Long itemId;

    @Schema(description = "Lot no.", example = "BATCH-001")
    private String batchCode;


}
