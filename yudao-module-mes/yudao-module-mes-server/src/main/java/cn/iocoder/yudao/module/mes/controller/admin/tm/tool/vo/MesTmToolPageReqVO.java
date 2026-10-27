package cn.iocoder.yudao.module.mes.controller.admin.tm.tool.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "MES tool ledger page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesTmToolPageReqVO extends PageParam {

    @Schema(description = "Tool code.", example = "T-001")
    private String code;

    @Schema(description = "Tool name.", example = "Milling cutter")
    private String name;

    @Schema(description = "Tool type code.", example = "100")
    private Long toolTypeId;

    @Schema(description = "Brand.", example = "Mitsubishi")
    private String brand;

    @Schema(description = "Model / Spec", example = "M5-100")
    private String specification;

    @Schema(description = "Status.", example = "1")
    private Integer status;

}
