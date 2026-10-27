package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.workshop;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES workshop page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesMdWorkshopPageReqVO extends PageParam {

    @Schema(description = "Workshop code.", example = "WS001")
    private String code;

    @Schema(description = "Workshop name.", example = "Workshop 1")
    private String name;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
