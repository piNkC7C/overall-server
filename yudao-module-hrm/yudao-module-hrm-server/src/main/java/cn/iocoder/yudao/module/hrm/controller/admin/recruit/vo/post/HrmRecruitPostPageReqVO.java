package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.post;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - HRM RecruitingJob Title page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmRecruitPostPageReqVO extends PageParam {

    @Schema(description = "Job Title name, fuzzy match.", example = "Java")
    private String postName;

    @Schema(description = "Work Type", example = "1")
    private Integer jobNature;

    @Schema(description = "Work CityRegion ID.", example = "310115")
    private Integer areaId;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Recruiteremployee code.", example = "200")
    private Long ownerEmployeeId;

    @Schema(description = "Job Title type code.", example = "100")
    private Long postTypeId;

    @Schema(description = "Job Title status.", example = "1")
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
