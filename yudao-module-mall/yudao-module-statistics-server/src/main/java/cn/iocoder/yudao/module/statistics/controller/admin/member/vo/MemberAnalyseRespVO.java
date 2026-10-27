package cn.iocoder.yudao.module.statistics.controller.admin.member.vo;

import cn.iocoder.yudao.module.statistics.controller.admin.common.vo.DataComparisonRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Member analysis response VO.")
@Data
public class MemberAnalyseRespVO {

    @Schema(description = "Visitor count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer visitUserCount;

    @Schema(description = "Order user quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer orderUserCount;

    @Schema(description = "Wonuser quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer payUserCount;

    @Schema(description = "Average order value in cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer atv;

    @Schema(description = "Comparison data.", requiredMode = Schema.RequiredMode.REQUIRED)
    private DataComparisonRespVO<MemberAnalyseDataRespVO> comparison;

}
