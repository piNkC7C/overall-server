package cn.iocoder.yudao.module.system.controller.admin.notify.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Schema(description = "Admin - inbox message response.")
@Data
public class NotifyMessageRespVO {

    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25025")
    private Long userId;

    @Schema(description = "User type. See UserTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Byte userType;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13013")
    private Long templateId;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test_01")
    private String templateCode;

    @Schema(description = "Template send person name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String templateNickname;

    @Schema(description = "Template content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test content")
    private String templateContent;

    @Schema(description = "Template type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer templateType;

    @Schema(description = "Template parameter.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, Object> templateParams;

    @Schema(description = "Is not Read.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean readStatus;

    @Schema(description = "Read time")
    private LocalDateTime readTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
