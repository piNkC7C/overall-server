package cn.iocoder.yudao.module.member.controller.admin.level.vo.level;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 会员等级 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MemberLevelBaseVO {

    @Schema(description = "Level name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotBlank(message = "Level name is required.")
    private String name;

    @Schema(description = "Upgrade experience.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Upgrade experience is required.")
    @Positive(message = "Upgrade XP must be greater than 0.")
    private Integer experience;

    @Schema(description = "Level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Level is required.")
    @Positive(message = "Level must be greater than 0.")
    private Integer level;

    @Schema(description = "Discount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "98")
    @NotNull(message = "Discount cannot be empty.")
    @Range(min = 0, max = 100, message = "Discount must be between 0 and 100.")
    private Integer discountPercent;

    @Schema(description = "Level Icon.", example = "https://www.iocoder.cn/yudao.jpg")
    @URL(message = "Level Icon must be URL format.")
    private String icon;

    @Schema(description = "Level background image.", example = "https://www.iocoder.cn/yudao.jpg")
    @URL(message = "Level background image must be a valid URL.")
    private String backgroundUrl;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
