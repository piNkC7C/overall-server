package cn.iocoder.yudao.module.mes.controller.admin.pro.andon.vo.config;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "MES andon call setting page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesProAndonConfigPageReqVO extends PageParam {

    @Schema(description = "Call Reason", example = "Equipment fault")
    private String reason;

    @Schema(description = "Level.", example = "1")
    private Integer level;

}
