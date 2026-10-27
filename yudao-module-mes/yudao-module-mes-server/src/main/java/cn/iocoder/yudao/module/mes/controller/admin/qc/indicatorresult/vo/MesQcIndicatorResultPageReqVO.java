package cn.iocoder.yudao.module.mes.controller.admin.qc.indicatorresult.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.mes.enums.qc.MesQcTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES inspection result page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesQcIndicatorResultPageReqVO extends PageParam {

    @Schema(description = "Relation quality inspection order ID.", example = "1")
    private Long qcId;

    @Schema(description = "Quality inspection type.", example = "1")
    @InEnum(MesQcTypeEnum.class)
    private Integer qcType;

    @Schema(description = "Sample ID.", example = "SPL-001")
    private String code;

    @Schema(description = "Product material ID.", example = "1")
    private Long itemId;

}
