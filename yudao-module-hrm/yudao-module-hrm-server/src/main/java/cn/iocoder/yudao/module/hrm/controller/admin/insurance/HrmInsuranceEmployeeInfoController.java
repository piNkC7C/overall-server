package cn.iocoder.yudao.module.hrm.controller.admin.insurance;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.employeeinfo.HrmInsuranceEmployeeInfoRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.employeeinfo.HrmInsuranceEmployeeInfoSaveReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.employeeinfo.HrmInsuranceEmployeeInfoUpdateSchemeReqVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.insurance.employee.HrmInsuranceEmployeeInfoDO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.insurance.config.HrmInsuranceSchemeDO;
import cn.iocoder.yudao.module.hrm.service.insurance.employee.HrmInsuranceEmployeeInfoService;
import cn.iocoder.yudao.module.hrm.service.insurance.config.HrmInsuranceSchemeService;
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

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - HRM employee benefits info.")
@RestController
@RequestMapping("/hrm/insurance/employee-info")
@Validated
public class HrmInsuranceEmployeeInfoController {

    @Resource
    private HrmInsuranceEmployeeInfoService insuranceEmployeeInfoService;
    @Resource
    private HrmInsuranceSchemeService insuranceSchemeService;

    @GetMapping("/get")
    @Operation(summary = "Get employee benefits info.")
    @Parameter(name = "employeeId", description = "Employee code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:insurance:employee-info:query')")
    public CommonResult<HrmInsuranceEmployeeInfoRespVO> getInsuranceEmployeeInfo(
            @RequestParam("employeeId") Long employeeId) {
        HrmInsuranceEmployeeInfoDO employeeInfo = insuranceEmployeeInfoService
                .getInsuranceEmployeeInfoByEmployeeId(employeeId);
        HrmInsuranceEmployeeInfoRespVO respVO = BeanUtils.toBean(
                employeeInfo, HrmInsuranceEmployeeInfoRespVO.class);
        if (respVO != null && respVO.getSchemeId() != null) {
            HrmInsuranceSchemeDO scheme = insuranceSchemeService.getScheme(respVO.getSchemeId());
            respVO.setSchemeName(scheme == null ? null : scheme.getName());
        }
        return success(respVO);
    }

    @PutMapping("/save")
    @Operation(summary = "Save employee benefits info.")
    @PreAuthorize("@ss.hasPermission('hrm:insurance:employee-info:update')")
    public CommonResult<Long> saveInsuranceEmployeeInfo(
            @Valid @RequestBody HrmInsuranceEmployeeInfoSaveReqVO reqVO) {
        return success(insuranceEmployeeInfoService.saveInsuranceEmployeeInfo(reqVO));
    }

    @PutMapping("/update-scheme")
    @Operation(summary = "Updateemployee insurance plan.")
    @PreAuthorize("@ss.hasPermission('hrm:insurance:employee-info:update')")
    public CommonResult<Boolean> updateEmployeeScheme(
            @Valid @RequestBody HrmInsuranceEmployeeInfoUpdateSchemeReqVO reqVO) {
        insuranceEmployeeInfoService.updateEmployeeScheme(reqVO.getEmployeeId(), reqVO.getSchemeId());
        return success(true);
    }

}
