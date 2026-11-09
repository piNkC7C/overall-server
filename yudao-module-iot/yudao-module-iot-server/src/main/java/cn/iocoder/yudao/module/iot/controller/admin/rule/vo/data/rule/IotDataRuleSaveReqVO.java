package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.rule;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.dal.dataobject.rule.IotDataRuleDO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - IoT 数据流转规则新增/修改 Request VO")
@Data
public class IotDataRuleSaveReqVO {

    @Schema(description = "数据流转规则编号", example = "8540")
    private Long id;

    @Schema(description = "数据流转规则名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Data flow rule name is required.")
    private String name;

    @Schema(description = "数据流转规则描述", example = "Example.")
    private String description;

    @Schema(description = "数据流转规则状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Data flow rule status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "数据源配置数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Data sourcesettingArray is required.")
    private List<IotDataRuleDO.SourceConfig> sourceConfigs;

    @Schema(description = "数据目的编号数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Data destination ID list is required.")
    private List<Long> sinkIds;

}