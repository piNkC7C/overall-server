package cn.iocoder.yudao.module.im.controller.admin.message.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - group chat history message list request.")
@Data
public class ImGroupMessageListReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Group ID is required")
    private Long groupId;

    @Schema(description = "Start message ID. Fetch older messages before this ID (exclusive). Empty means start from the latest.", example = "1024")
    private Long maxId;

    @Schema(description = "Fetch count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @NotNull(message = "Fetch count cannot be empty.")
    @Min(value = 1, message = "Fetch count minimum is 1.")
    @Max(value = 200, message = "Fetch count maximum is 200.")
    private Integer limit;

}
