package cn.iocoder.yudao.module.infra.api.websocket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Schema(description = "RPC service - WebSocket message send Request DTO.")
@Data
public class WebSocketSendReqDTO {

    @Schema(description = "Session code.", example = "abc")
    private String sessionId;
    @Schema(description = "User ID.", example = "1024")
    private Long userId;
    @Schema(description = "User type.", example = "1")
    private Integer userType;

    @Schema(description = "Message type.", example = "demo-message")
    @NotEmpty(message = "Message type is required.")
    private String messageType;
    @Schema(description = "Message content.", example = "{\"name\":\"Jane\"}}")
    @NotEmpty(message = "Message content is required.")
    private String messageContent;

}
