package cn.iocoder.yudao.module.member.controller.admin.signin.vo.config;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * 签到规则 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MemberSignInConfigBaseVO {

    @Schema(description = "Check-in day X.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7")
    @NotNull(message = "Check-in days is required.")
    private Integer day;

    @Schema(description = "Bonus points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Bonus points cannot be empty.")
    @PositiveOrZero(message = "Bonus points cannot be less than 0.")
    private Integer point;

    @Schema(description = "Bonus XP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Bonus XP cannot be empty.")
    @PositiveOrZero(message = "Bonus XP cannot be less than 0.")
    private Integer experience;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @AssertTrue(message = "Check-in points and XP cannot both be empty.")
    @JsonIgnore
    public boolean isConfigAward() {
        return ObjUtil.notEqual(point, 0) || ObjUtil.notEqual(experience, 0);
    }
}
