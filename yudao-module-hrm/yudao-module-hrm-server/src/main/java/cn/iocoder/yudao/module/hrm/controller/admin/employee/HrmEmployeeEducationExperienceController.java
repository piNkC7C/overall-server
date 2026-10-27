package cn.iocoder.yudao.module.hrm.controller.admin.employee;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.educationexperience.HrmEmployeeEducationExperienceRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.educationexperience.HrmEmployeeEducationExperienceSaveReqVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.employee.experience.HrmEmployeeEducationExperienceDO;
import cn.iocoder.yudao.module.hrm.service.employee.experience.HrmEmployeeEducationExperienceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - HRM employee education.")
@RestController
@RequestMapping("/hrm/employee/education-experience")
@Validated
public class HrmEmployeeEducationExperienceController {

    @Resource
    private HrmEmployeeEducationExperienceService educationExperienceService;

    @GetMapping("/list")
    @Operation(summary = "Getemployeeeducationlist.")
    @Parameter(name = "employeeId", description = "Employee code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:employee:query')")
    public CommonResult<List<HrmEmployeeEducationExperienceRespVO>> getEducationExperienceList(
            @RequestParam("employeeId") Long employeeId) {
        List<HrmEmployeeEducationExperienceDO> educationExperiences =
                educationExperienceService.getEducationExperienceListByEmployeeId(employeeId);
        return success(BeanUtils.toBean(educationExperiences, HrmEmployeeEducationExperienceRespVO.class));
    }

    @PostMapping("/create")
    @Operation(summary = "Createemployeeeducation.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Long> createEducationExperience(
            @Valid @RequestBody HrmEmployeeEducationExperienceSaveReqVO reqVO) {
        return success(educationExperienceService.createEducationExperience(reqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateemployeeeducation.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> updateEducationExperience(
            @Valid @RequestBody HrmEmployeeEducationExperienceSaveReqVO reqVO) {
        educationExperienceService.updateEducationExperience(reqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteemployeeeducation.")
    @Parameter(name = "id", description = "Education ID.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:employee:delete')")
    public CommonResult<Boolean> deleteEducationExperience(@RequestParam("id") Long id) {
        educationExperienceService.deleteEducationExperience(id);
        return success(true);
    }

}
