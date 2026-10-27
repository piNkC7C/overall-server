package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.rule;

import cn.iocoder.yudao.module.iot.dal.dataobject.rule.IotDataRuleDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - IoT data flow rule response.")
@Data
public class IotDataRuleRespVO {

    @Schema(description = "Data flow rule code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8540")
    private Long id;

    @Schema(description = "Data flow rule name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Data flow rule Description.", example = "Example.")
    private String description;

    @Schema(description = "Data flow rule status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Data sourcesettingArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<IotDataRuleDO.SourceConfig> sourceConfigs;

    @Schema(description = "Data destination ID list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Long> sinkIds;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}