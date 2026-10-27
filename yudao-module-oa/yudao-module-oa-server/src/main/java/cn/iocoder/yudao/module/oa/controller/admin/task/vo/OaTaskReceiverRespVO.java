package cn.iocoder.yudao.module.oa.controller.admin.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - OA taskRecipient response.")
@Data
public class OaTaskReceiverRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Recipient user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "RecipientNickname.", example = "Overall.")
    private String userName;

    @Schema(description = "Recipientdepartment name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Receive status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime updateTime;

}
