package cn.iocoder.yudao.module.statistics.controller.admin.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - memberGenderStats response.")
@Data
public class MemberSexStatisticsRespVO {

    @Schema(description = "Gender", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sex;

    // TODO @疯狂：要不还是其它字段，我们也补全，这样方便使用的用户，做定制化；就保持和 MemberAreaStatisticsRespVO 一致；
    @Schema(description = "Member quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer userCount;

}
