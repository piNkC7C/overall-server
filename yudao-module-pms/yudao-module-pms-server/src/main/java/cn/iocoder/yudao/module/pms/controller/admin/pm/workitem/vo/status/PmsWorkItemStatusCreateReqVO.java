package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.status;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemStatusTypeEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - PMS create work item status request.")
@Data
public class PmsWorkItemStatusCreateReqVO {

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item is required.")
    private Long projectId;

    @Schema(description = "Work item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Work item type is required.")
    @InEnum(PmsWorkItemTypeEnum.class)
    private Integer workItemType;

    @Schema(description = "Status name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pending acceptance.")
    @NotBlank(message = "Status name is required.")
    @Size(max = 50, message = "Status name cannot exceed 50 characters.")
    private String name;

    @Schema(description = "Semantic status", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Semantic status is required.")
    @InEnum(PmsWorkItemStatusTypeEnum.class)
    private Integer statusType;

    @Schema(description = "StatusDescription.", example = "Stories split. Waiting for development")
    @Size(max = 255, message = "StatusDescription cannot exceed 255 characters.")
    private String description;

}
