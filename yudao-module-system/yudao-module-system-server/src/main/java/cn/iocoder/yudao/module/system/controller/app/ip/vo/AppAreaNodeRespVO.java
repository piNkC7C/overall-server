package cn.iocoder.yudao.module.system.controller.app.ip.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Region node response VO.")
@Data
public class AppAreaNodeRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "110000")
    private Integer id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Beijing")
    private String name;

    /**
     * 子节点
     */
    private List<AppAreaNodeRespVO> children;

}
