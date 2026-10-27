package cn.iocoder.yudao.module.hrm.controller.admin.salary;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionSaveReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionUpdateEnabledReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionUpdateVisibleReqVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.salary.config.HrmSalaryOptionDO;
import cn.iocoder.yudao.module.hrm.service.salary.config.HrmSalaryOptionService;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - HRM payroll item.")
@RestController
@RequestMapping("/hrm/salary/option")
@Validated
public class HrmSalaryOptionController {

    @Resource
    private HrmSalaryOptionService salaryOptionService;

    @PostMapping("/create")
    @Operation(summary = "Createpayroll item.")
    @PreAuthorize("@ss.hasPermission('hrm:salary:option:create')")
    public CommonResult<Long> createSalaryOption(@Valid @RequestBody HrmSalaryOptionSaveReqVO reqVO) {
        return success(salaryOptionService.createSalaryOption(reqVO));
    }

    @PutMapping("/update-enabled")
    @Operation(summary = "Updatepayroll item Enabled status.")
    @PreAuthorize("@ss.hasPermission('hrm:salary:option:update')")
    public CommonResult<Boolean> updateSalaryOptionEnabled(
            @Valid @RequestBody HrmSalaryOptionUpdateEnabledReqVO reqVO) {
        salaryOptionService.updateSalaryOptionEnabled(reqVO.getId(), reqVO.getEnabled());
        return success(true);
    }

    @PutMapping("/update-visible")
    @Operation(summary = "Updatepayroll item Show status.")
    @PreAuthorize("@ss.hasPermission('hrm:salary:option:update')")
    public CommonResult<Boolean> updateSalaryOptionVisible(
            @Valid @RequestBody HrmSalaryOptionUpdateVisibleReqVO reqVO) {
        salaryOptionService.updateSalaryOptionVisible(reqVO.getId(), reqVO.getVisible());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletepayroll item.")
    @Parameter(name = "id", description = "Payroll item code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:salary:option:delete')")
    public CommonResult<Boolean> deleteSalaryOption(@RequestParam("id") Long id) {
        salaryOptionService.deleteSalaryOption(id);
        return success(true);
    }

    @PutMapping("/sync")
    @Operation(summary = "Sync standard payroll item.")
    @PreAuthorize("@ss.hasPermission('hrm:salary:option:update')")
    public CommonResult<Boolean> syncSalaryOption() {
        salaryOptionService.syncSalaryOption();
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "Get payroll item list.")
    @PreAuthorize("@ss.hasPermission('hrm:salary:option:query')")
    public CommonResult<List<HrmSalaryOptionRespVO>> getSalaryOptionList() {
        List<HrmSalaryOptionDO> list = salaryOptionService.getSalaryOptionList();
        return success(BeanUtils.toBean(list, HrmSalaryOptionRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get payroll item simple list.", description = "Only enabled pay items.")
    @Parameter(name = "adjustable", description = "Is not can Salary Change.", example = "true")
    @PreAuthorize("@ss.hasPermission('hrm:salary:option:query')")
    public CommonResult<List<HrmSalaryOptionRespVO>> getSalaryOptionSimpleList(
            @RequestParam(value = "adjustable", required = false) Boolean adjustable) {
        List<HrmSalaryOptionDO> list = salaryOptionService.getSalaryOptionList(adjustable);
        return success(convertList(list, option -> new HrmSalaryOptionRespVO()
                .setCode(option.getCode()).setParentCode(option.getParentCode())
                .setName(option.getName()).setCalculateEnabled(option.getCalculateEnabled())));
    }

}
