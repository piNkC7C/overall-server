package cn.iocoder.yudao.module.system.api.dept.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 岗位 Response DTO
 *
 * @author 芋道源码
 */
@Schema(description = "RPC service - post Response DTO.")
@Data
public class PostRespDTO {

    @Schema(description = "Post code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Post name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato")
    private String name;

    @Schema(description = "Post code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    private String code;

    @Schema(description = "Post sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status; // See CommonStatusEnum enum

}
