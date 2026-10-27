package cn.iocoder.yudao.module.oa.controller.admin.contact.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "OA contact share process request VO.")
@Data
public class OaContactHandleReqVO {

    @Schema(description = "Contact code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Contact code is required.")
    private Long contactId;

    @Schema(description = "Recipientcategory code.", example = "1024")
    private Long categoryId;

}
