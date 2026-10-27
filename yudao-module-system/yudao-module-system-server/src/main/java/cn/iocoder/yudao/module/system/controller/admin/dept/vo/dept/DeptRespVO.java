package cn.iocoder.yudao.module.system.controller.admin.dept.vo.dept;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - department info response.")
@Data
public class DeptRespVO {

    @Schema(description = "Department code.", example = "1024")
    private Long id;

    @Schema(description = "Department name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Parent department ID.", example = "1024")
    private Long parentId;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer sort;

    @Schema(description = "Owner person user ID.", example = "2048")
    private Long leaderUserId;

    @Schema(description = "Phone", example = "15601691000")
    private String phone;

    @Schema(description = "Email", example = "yudao@iocoder.cn")
    private String email;

    @Schema(description = "Status. See CommonStatusEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    private LocalDateTime createTime;

}
