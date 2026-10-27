package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.post.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM RecruitingJob Title type response.")
@Data
public class HrmRecruitPostTypeRespVO {

    @Schema(description = "Job Title type code.", example = "1024")
    private Long id;

    @Schema(description = "Type name.", example = "Backend development")
    private String name;

    @Schema(description = "Parent type code.", example = "0")
    private Long parentId;

    @Schema(description = "Sort.", example = "10")
    private Integer sort;

    @Schema(description = "Status, see common_status.", example = "0")
    private Integer status;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
