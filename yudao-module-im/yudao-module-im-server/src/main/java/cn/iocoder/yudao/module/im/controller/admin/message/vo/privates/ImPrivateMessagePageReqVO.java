package cn.iocoder.yudao.module.im.controller.admin.message.vo.privates;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - direct messagepage request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ImPrivateMessagePageReqVO extends PageParam {

    @Schema(description = "Recipient code ( the other party ).", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Recipient code is required.")
    private Long receiverId;

}
