package cn.iocoder.yudao.module.im.controller.admin.message.vo.privates;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Direct message history list request VO.")
@Data
public class ImPrivateMessageListReqVO {

    @Schema(description = "Recipient code ( the other party ).", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Recipient code is required.")
    private Long receiverId;

    @Schema(description = "Start message ID. Fetch older messages before this ID (exclusive). Empty means start from the latest.", example = "1024")
    private Long maxId;

    @Schema(description = "Fetch count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @NotNull(message = "Fetch count cannot be empty.")
    @Min(value = 1, message = "Fetch count minimum is 1.")
    @Max(value = 200, message = "Fetch count maximum is 200.")
    private Integer limit;

}
