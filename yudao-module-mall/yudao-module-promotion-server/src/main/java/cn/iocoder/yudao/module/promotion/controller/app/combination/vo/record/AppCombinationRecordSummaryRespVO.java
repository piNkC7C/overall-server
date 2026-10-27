package cn.iocoder.yudao.module.promotion.controller.app.combination.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Group-buy record brief summary response VO.")
@Data
public class AppCombinationRecordSummaryRespVO {

    /**
     * 加载 {@link #avatars} 的数量
     */
    public static final Integer AVATAR_COUNT = 7;

    @Schema(description = "Group buy user quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userCount;

    @Schema(description = "Group buy userAvatar list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> avatars;

}
