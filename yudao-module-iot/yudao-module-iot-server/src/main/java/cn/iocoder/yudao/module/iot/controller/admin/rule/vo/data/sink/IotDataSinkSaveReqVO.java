package cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.sink;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.iot.dal.dataobject.rule.config.IotAbstractDataSinkConfig;
import cn.iocoder.yudao.module.iot.enums.rule.IotDataSinkTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - IoT 数据流转目的新增/修改 Request VO")
@Data
public class IotDataSinkSaveReqVO {

    @Schema(description = "数据目的编号", example = "18564")
    private Long id;

    @Schema(description = "数据目的名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sam.")
    @NotEmpty(message = "Data destination name is required.")
    private String name;

    @Schema(description = "数据目的描述", example = "Sample.")
    private String description;

    @Schema(description = "数据目的状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Data destination status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "数据目的类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Data destination type is required.")
    @InEnum(IotDataSinkTypeEnum.class)
    private Integer type;

    @Schema(description = "数据目的配置")
    @NotNull(message = "Data destination setting is required.")
    private IotAbstractDataSinkConfig config;

}