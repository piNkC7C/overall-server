package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.rule;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.dal.dataobject.rule.IotDataRuleDO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - IoT data flow rule create / edit request.")
@Data
public class IotDataRuleSaveReqVO {

    @Schema(description = "Data flow rule code.", example = "8540")
    private Long id;

    @Schema(description = "Data flow rule name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Data flow rule name is required.")
    private String name;

    @Schema(description = "Data flow rule Description.", example = "Example.")
    private String description;

    @Schema(description = "Data flow rule status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Data flow rule status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Data sourcesettingArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Data sourcesettingArray is required.")
    private List<IotDataRuleDO.SourceConfig> sourceConfigs;

    @Schema(description = "Data destination ID list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Data destination ID list is required.")
    private List<Long> sinkIds;

}