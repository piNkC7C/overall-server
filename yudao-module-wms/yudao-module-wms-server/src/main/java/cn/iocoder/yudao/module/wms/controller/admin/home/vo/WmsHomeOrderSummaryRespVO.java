package cn.iocoder.yudao.module.wms.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "WMS home document summary stats response VO.")
@Data
public class WmsHomeOrderSummaryRespVO {

    @Schema(description = "Document type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Document total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    private Long total;

    @Schema(description = "Status distribution.")
    private List<WmsHomeOrderStatusRespVO> statuses;

}
