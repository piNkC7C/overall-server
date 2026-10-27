package cn.iocoder.yudao.module.mes.controller.admin.qc.oqc.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "MES outgoing inspection page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcOqcPageReqVO extends PageParam {

    @Schema(description = "Inspection code.", example = "OQC2025")
    private String code;

    @Schema(description = "Customer ID.", example = "10")
    private Long clientId;

    @Schema(description = "Lot no.", example = "BC2025")
    private String batchCode;

    @Schema(description = "Product material ID.", example = "20")
    private Long itemId;

    @Schema(description = "Inspection result.", example = "1")
    private Integer checkResult;

}
