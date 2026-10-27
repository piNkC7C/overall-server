package cn.iocoder.yudao.module.hrm.controller.admin.salary;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.changetemplate.HrmSalaryChangeTemplateRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.changetemplate.HrmSalaryChangeTemplateSaveReqVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.salary.config.HrmSalaryChangeTemplateDO;
import cn.iocoder.yudao.module.hrm.service.salary.config.HrmSalaryChangeTemplateService;
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

@Tag(name = "Admin - HRM Salary Changetemplate.")
@RestController
@RequestMapping("/hrm/salary/change-template")
@Validated
public class HrmSalaryChangeTemplateController {

    @Resource
    private HrmSalaryChangeTemplateService salaryChangeTemplateService;

    @PostMapping("/create")
    @Operation(summary = "CreateSalary Changetemplate.")
    @PreAuthorize("@ss.hasPermission('hrm:salary:change-template:create')")
    public CommonResult<Long> createSalaryChangeTemplate(
            @Valid @RequestBody HrmSalaryChangeTemplateSaveReqVO createReqVO) {
        return success(salaryChangeTemplateService.createSalaryChangeTemplate(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "UpdateSalary Changetemplate.")
    @PreAuthorize("@ss.hasPermission('hrm:salary:change-template:update')")
    public CommonResult<Boolean> updateSalaryChangeTemplate(
            @Valid @RequestBody HrmSalaryChangeTemplateSaveReqVO updateReqVO) {
        salaryChangeTemplateService.updateSalaryChangeTemplate(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "DeleteSalary Changetemplate.")
    @Parameter(name = "id", description = "Salary Changetemplate code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:salary:change-template:delete')")
    public CommonResult<Boolean> deleteSalaryChangeTemplate(@RequestParam("id") Long id) {
        salaryChangeTemplateService.deleteSalaryChangeTemplate(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get Salary Changetemplate.")
    @Parameter(name = "id", description = "Salary Changetemplate code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:salary:change-template:query')")
    public CommonResult<HrmSalaryChangeTemplateRespVO> getSalaryChangeTemplate(@RequestParam("id") Long id) {
        HrmSalaryChangeTemplateDO template = salaryChangeTemplateService.getSalaryChangeTemplate(id);
        return success(BeanUtils.toBean(template, HrmSalaryChangeTemplateRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "Get Salary Changetemplate list.")
    @PreAuthorize("@ss.hasPermission('hrm:salary:change-template:query') "
            + "or @ss.hasPermission('hrm:salary:employee-info:query')")
    public CommonResult<List<HrmSalaryChangeTemplateRespVO>> getSalaryChangeTemplateList() {
        List<HrmSalaryChangeTemplateDO> list = salaryChangeTemplateService.getSalaryChangeTemplateList();
        return success(BeanUtils.toBean(list, HrmSalaryChangeTemplateRespVO.class));
    }

}
