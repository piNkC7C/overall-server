package cn.iocoder.yudao.module.iot.controller.admin.device.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - IoT 设备分组新增/修改 Request VO")
@Data
public class IotDeviceGroupSaveReqVO {

    @Schema(description = "分组 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "3583")
    private Long id;

    @Schema(description = "分组名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotEmpty(message = "Group name is required.")
    private String name;

    @Schema(description = "分组状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Group status is required.")
    private Integer status;

    @Schema(description = "分组描述", example = "Looks good.")
    private String description;

}