package cn.iocoder.yudao.module.promotion.controller.admin.bargain.vo.recrod;

import cn.iocoder.yudao.module.promotion.controller.admin.bargain.vo.activity.BargainActivityRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - bargain record page item response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BargainRecordPageItemRespVO extends BargainRecordBaseVO {

    @Schema(description = "Record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "22901")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2022-07-01 23:59:59")
    private LocalDateTime createTime;

    @Schema(description = "Help-bargain count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer helpCount;

    // ========== 用户相关 ==========

    @Schema(description = "Nickname", example = "John")
    private String nickname;

    @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xxx.jpg")
    private String avatar;

    // ========== 活动相关 ==========

    private BargainActivityRespVO activity;

}
