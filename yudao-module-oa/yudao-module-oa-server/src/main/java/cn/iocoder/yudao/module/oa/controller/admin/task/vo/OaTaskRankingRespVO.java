package cn.iocoder.yudao.module.oa.controller.admin.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "OA task completion ranking response VO.")
@Data
public class OaTaskRankingRespVO {

    @Schema(description = "User ID.", example = "1")
    private Long userId;

    @Schema(description = "Nickname", example = "Overall.")
    private String userName;

    @Schema(description = "Completetask quantity.", example = "10")
    private Long completedCount;

}
