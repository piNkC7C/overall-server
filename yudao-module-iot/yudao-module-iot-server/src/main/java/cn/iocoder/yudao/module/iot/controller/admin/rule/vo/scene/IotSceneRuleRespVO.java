package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.scene;

import cn.iocoder.yudao.module.iot.dal.dataobject.rule.IotSceneRuleDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - IoT scene automation response.")
@Data
public class IotSceneRuleRespVO {

    @Schema(description = "SceneID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15865")
    private Long id;

    @Schema(description = "Scene name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    private String name;

    @Schema(description = "SceneDescription.", example = "Example.")
    private String description;

    @Schema(description = "Scene status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Triggers.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<IotSceneRuleDO.Trigger> triggers;

    @Schema(description = "Executors.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<IotSceneRuleDO.Action> actions;

    @Schema(description = "Last trigger time.")
    private LocalDateTime lastTriggerTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}