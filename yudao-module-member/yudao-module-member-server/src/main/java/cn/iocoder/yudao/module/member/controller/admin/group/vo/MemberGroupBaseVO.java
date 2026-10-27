package cn.iocoder.yudao.module.member.controller.admin.group.vo;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
 * 用户分组 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MemberGroupBaseVO {

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Shopper")
    @NotNull(message = "Name is required.")
    private String name;

    @Schema(description = "Notes.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Example.")
    private String remark;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

}
