package cn.iocoder.yudao.module.system.controller.admin.tenant.vo.packages;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Set;

@Schema(description = "Admin - tenant plan create or update request.")
@Data
public class TenantPackageSaveReqVO {

    @Schema(description = "Plan ID", example = "1024")
    private Long id;

    @Schema(description = "Plan name", requiredMode = Schema.RequiredMode.REQUIRED, example = "VIP")
    @NotEmpty(message = "Plan name is required.")
    private String name;

    @Schema(description = "Status, see CommonStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "Notes.", example = "OK")
    private String remark;

    @Schema(description = "Relation menu code.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Relation menu code is required.")
    private Set<Long> menuIds;

}
