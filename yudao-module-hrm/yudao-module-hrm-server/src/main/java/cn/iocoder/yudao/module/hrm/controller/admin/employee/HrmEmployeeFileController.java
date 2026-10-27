package cn.iocoder.yudao.module.hrm.controller.admin.employee;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.file.HrmEmployeeFileRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.file.HrmEmployeeFileSaveReqVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.employee.info.HrmEmployeeFileDO;
import cn.iocoder.yudao.module.hrm.service.employee.info.HrmEmployeeFileService;
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

@Tag(name = "Admin - HRM employee document attachments.")
@RestController
@RequestMapping("/hrm/employee/file")
@Validated
public class HrmEmployeeFileController {

    @Resource
    private HrmEmployeeFileService employeeFileService;

    @GetMapping("/list")
    @Operation(summary = "Get employee document attachments list.")
    @Parameter(name = "employeeId", description = "Employee code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:employee:query')")
    public CommonResult<List<HrmEmployeeFileRespVO>> getEmployeeFileList(
            @RequestParam("employeeId") Long employeeId) {
        List<HrmEmployeeFileDO> employeeFiles = employeeFileService.getEmployeeFileList(employeeId);
        return success(BeanUtils.toBean(employeeFiles, HrmEmployeeFileRespVO.class));
    }

    @PutMapping("/save")
    @Operation(summary = "Save employee document attachments.")
    @PreAuthorize("@ss.hasPermission('hrm:employee:update')")
    public CommonResult<Boolean> saveEmployeeFiles(@Valid @RequestBody HrmEmployeeFileSaveReqVO reqVO) {
        employeeFileService.saveEmployeeFiles(reqVO);
        return success(true);
    }

}
