package cn.iocoder.yudao.module.im.controller.admin.group.vo.request;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.im.enums.group.ImGroupAddSourceEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "IM join-group request start request VO.")
@Data
public class ImGroupRequestApplyReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Group ID is required")
    private Long groupId;

    @Schema(description = "Apply please reason.", example = "I am Potato (a food)")
    @Size(max = 255, message = "Request reason cannot exceed 255 characters.")
    private String applyContent;

    @Schema(description = "Join source.", example = "1")
    @InEnum(ImGroupAddSourceEnum.class)
    private Integer addSource;

}
