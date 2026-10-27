package cn.iocoder.yudao.module.im.controller.admin.manager.channel.vo.channel;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - IM Channel page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class ImChannelPageReqVO extends PageParam {

    @Schema(description = "Channel business code.", example = "system_notice")
    private String code;

    @Schema(description = "Channel name.", example = "System")
    private String name;

    @Schema(description = "Status.", example = "0")
    private Integer status; // See CommonStatusEnum enum class

}
