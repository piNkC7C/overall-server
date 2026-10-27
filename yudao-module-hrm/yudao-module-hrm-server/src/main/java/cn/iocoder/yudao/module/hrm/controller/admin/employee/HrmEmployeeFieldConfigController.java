package cn.iocoder.yudao.module.hrm.controller.admin.employee;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.config.HrmEmployeeArchiveFieldConfigSaveReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.config.HrmEmployeeCreateFieldConfigSaveReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.config.HrmEmployeeFieldConfigRespVO;
import cn.iocoder.yudao.module.hrm.service.employee.config.HrmEmployeeFieldConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - HRM employeefieldsetting.")
@RestController
@RequestMapping("/hrm/employee/config")
@Validated
public class HrmEmployeeFieldConfigController {

    @Resource
    private HrmEmployeeFieldConfigService employeeFieldConfigService;

    @GetMapping("/create-field/list")
    @Operation(summary = "Get new-employee field setting.")
    @Parameter(name = "entryStatus", description = "Onboarding status：1 active, 2 pending hire.", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('hrm:employee:config:query') or @ss.hasPermission('hrm:employee:create')")
    public CommonResult<List<HrmEmployeeFieldConfigRespVO>> getEmployeeCreateFieldConfigList(
            @RequestParam("entryStatus") Integer entryStatus) {
        return success(employeeFieldConfigService.getEmployeeCreateFieldConfigList(entryStatus));
    }

    @PutMapping("/create-field/save")
    @Operation(summary = "Save new-employee field setting.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:config:update')")
    public CommonResult<Boolean> saveEmployeeCreateFieldConfig(
            @Valid @RequestBody HrmEmployeeCreateFieldConfigSaveReqVO reqVO) {
        employeeFieldConfigService.saveEmployeeCreateFieldConfig(reqVO);
        return success(true);
    }

    @GetMapping("/archive-field/list")
    @Operation(summary = "Get employee profile fieldsetting.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:config:query')")
    public CommonResult<List<HrmEmployeeFieldConfigRespVO>> getEmployeeArchiveFieldConfigList() {
        return success(employeeFieldConfigService.getEmployeeArchiveFieldConfigList());
    }

    @PutMapping("/archive-field/save")
    @Operation(summary = "Save employee profile fieldsetting.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:config:update')")
    public CommonResult<Boolean> saveEmployeeArchiveFieldConfig(
            @Valid @RequestBody HrmEmployeeArchiveFieldConfigSaveReqVO reqVO) {
        employeeFieldConfigService.saveEmployeeArchiveFieldConfig(reqVO);
        return success(true);
    }

}
