package cn.iocoder.yudao.module.oa.controller.admin.contact.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "OA contact share request VO.")
@Data
public class OaContactShareReqVO {

    @Schema(description = "Contact code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Contact code is required.")
    private Long contactId;

    @Schema(description = "Share Recipients user ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    @NotEmpty(message = "Share Recipients is required.")
    private List<@NotNull(message = "Share Recipients code is required.") Long> userIds;

}
