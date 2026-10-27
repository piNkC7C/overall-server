package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.scene;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.dal.dataobject.rule.IotSceneRuleDO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - IoT scene automation create / edit request.")
@Data
public class IotSceneRuleSaveReqVO {

    @Schema(description = "SceneID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15865")
    private Long id;

    @Schema(description = "Scene name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    @NotEmpty(message = "Scene name cannot be empty.")
    private String name;

    @Schema(description = "SceneDescription.", example = "Example.")
    private String description;

    @Schema(description = "Scene status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Scene status cannot be empty.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Triggers.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Triggers cannot be empty.")
    private List<IotSceneRuleDO.Trigger> triggers;

    @Schema(description = "Executors.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Executors cannot be empty.")
    private List<IotSceneRuleDO.Action> actions;

}