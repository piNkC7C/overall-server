package cn.iocoder.yudao.module.hrm.controller.admin.portal.employee;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.workexperience.HrmEmployeeWorkExperienceRespVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.employee.experience.HrmEmployeeWorkExperienceDO;
import cn.iocoder.yudao.module.hrm.service.employee.info.HrmEmployeeService;
import cn.iocoder.yudao.module.hrm.service.employee.experience.HrmEmployeeWorkExperienceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - HRM employee work history.")
@RestController
@RequestMapping("/hrm/portal/employee/work-experience")
@Validated
public class HrmPortalEmployeeWorkExperienceController {

    @Resource
    private HrmEmployeeWorkExperienceService workExperienceService;
    @Resource
    private HrmEmployeeService employeeService;

    @GetMapping("/list")
    @Operation(summary = "Get my work history list.")
    @PreAuthorize("@ss.hasPermission('hrm:portal:query')")
    public CommonResult<List<HrmEmployeeWorkExperienceRespVO>> getWorkExperienceList() {
        Long employeeId = employeeService.validateEmployeeBySelf(getLoginUserId()).getId();
        List<HrmEmployeeWorkExperienceDO> workExperiences =
                workExperienceService.getWorkExperienceListByEmployeeId(employeeId);
        return success(BeanUtils.toBean(
                workExperiences, HrmEmployeeWorkExperienceRespVO.class));
    }

}
