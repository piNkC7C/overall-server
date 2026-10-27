package cn.iocoder.yudao.module.oa.controller.admin.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "OA task feedback log response VO.")
@Data
public class OaTaskLogRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Feedback user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Feedback nickname.", example = "Overall.")
    private String userName;

    @Schema(description = "Status after change.", example = "3")
    private Integer status;

    @Schema(description = "Feedback.", example = "Completed stocktake, result already submit.")
    private String content;

    @Schema(description = "Feedback time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}
