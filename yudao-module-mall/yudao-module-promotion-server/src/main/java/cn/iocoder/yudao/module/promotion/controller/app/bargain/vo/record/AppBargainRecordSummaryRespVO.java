package cn.iocoder.yudao.module.promotion.controller.app.bargain.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Bargain record brief summary response VO.")
@Data
public class AppBargainRecordSummaryRespVO {

    @Schema(description = "Bargain user quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer successUserCount;

    @Schema(description = "Succeeded bargain record.", requiredMode = Schema.RequiredMode.REQUIRED) // 只返回最近的 7 个
    private List<Record> successList;

    @Schema(description = "Succeeded bargain record.")
    @Data
    public static class Record {

        @Schema(description = "Nickname", requiredMode = Schema.RequiredMode.REQUIRED, example = "Wang**")
        private String nickname;

        @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xxx.jpg")
        private String avatar;

        @Schema(description = "Campaign name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato")
        private String activityName;

    }

}
