package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM RecruitingJob Title response.")
@Data
public class HrmRecruitPostRespVO {

    @Schema(description = "RecruitingJob Title code.", example = "1024")
    private Long id;

    @Schema(description = "Job Title name.", example = "Java engineer")
    private String postName;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Person department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Work Type", example = "1")
    private Integer jobNature;

    @Schema(description = "Work CityRegion ID.", example = "310115")
    private Integer areaId;

    @Schema(description = "Work Cityregion name.", example = "Seattle WA Downtown")
    private String areaName;

    @Schema(description = "Headcount", example = "3")
    private Integer recruitNum;

    @Schema(description = "Recruitingreason.", example = "Team expansion")
    private String reason;

    @Schema(description = "Experience", example = "3")
    private Integer workTime;

    @Schema(description = "Education require.", example = "4")
    private Integer educationRequire;

    @Schema(description = "Minimum salary.", example = "20000")
    private BigDecimal minSalary;

    @Schema(description = "Maximum salary.", example = "30000")
    private BigDecimal maxSalary;

    @Schema(description = "Payroll order characters.", example = "2")
    private Integer salaryUnit;

    @Schema(description = "MinimumAge.", example = "22")
    private Integer minAge;

    @Schema(description = "MaximumAge.", example = "35")
    private Integer maxAge;

    @Schema(description = "Latest Start Date")
    private LocalDateTime latestEntryTime;

    @Schema(description = "Recruiteremployee code.", example = "1")
    private Long ownerEmployeeId;

    @Schema(description = "RecruiterName.", example = "John.")
    private String ownerEmployeeName;

    @Schema(description = "Intervieweremployee ID list.", example = "[1, 2]")
    private List<Long> interviewEmployeeIds;

    @Schema(description = "InterviewerNameArray.", example = "[\"John\", \"Jane\"]")
    private List<String> interviewEmployeeNames;

    @Schema(description = "Job TitleDescription.")
    private String description;

    @Schema(description = "Urgency", example = "1")
    private Integer emergencyLevel;

    @Schema(description = "Job Title type code.", example = "100")
    private Long postTypeId;

    @Schema(description = "Job Title type name.", example = "R&D")
    private String postTypeName;

    @Schema(description = "Job Title status.", example = "1")
    private Integer status;

    @Schema(description = "Stop reason.", example = "Job on hold")
    private String stopReason;

    @Schema(description = "Hired count.", example = "2")
    private Long hasEntryNum;

    @Schema(description = "Recruiting progress percent.", example = "40.00")
    private BigDecimal recruitSchedule;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}
