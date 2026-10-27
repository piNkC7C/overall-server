package cn.iocoder.yudao.module.mes.controller.admin.wm.transfer.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES transfer order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesWmTransferPageReqVO extends PageParam {

    @Schema(description = "Transfer order code.", example = "TR2026020001")
    private String code;

    @Schema(description = "Transfer order name.", example = "Steel plate transfer order.")
    private String name;

    @Schema(description = "Transfer order type.", example = "1")
    private Integer type;

    @Schema(description = "Document status.", example = "0")
    private Integer status;

}
