package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Commission record response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BrokerageRecordRespVO extends BrokerageRecordBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28896")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;


    // ========== user info ==========

    @Schema(description = "UserAvatar.", example = "https://www.iocoder.cn/xxx.png")
    private String userAvatar;
    @Schema(description = "Nickname", example = "Jane.")
    private String userNickname;


    // ========== source user info ==========

    @Schema(description = "Source userAvatar.", example = "https://www.iocoder.cn/xxx.png")
    private String sourceUserAvatar;
    @Schema(description = "Source nickname.", example = "Jane.")
    private String sourceUserNickname;
}
