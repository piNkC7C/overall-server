package cn.iocoder.yudao.module.mes.controller.admin.dv.subject;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.dv.subject.vo.MesDvSubjectPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.subject.vo.MesDvSubjectRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.subject.vo.MesDvSubjectSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.subject.MesDvSubjectDO;
import cn.iocoder.yudao.module.mes.service.dv.subject.MesDvSubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - MES inspection and maintenance item.")
@RestController
@RequestMapping("/mes/dv/subject")
@Validated
public class MesDvSubjectController {

    @Resource
    private MesDvSubjectService subjectService;

    @PostMapping("/create")
    @Operation(summary = "Create inspection and maintenance item.")
    @PreAuthorize("@ss.hasPermission('mes:dv-subject:create')")
    public CommonResult<Long> createSubject(@Valid @RequestBody MesDvSubjectSaveReqVO createReqVO) {
        return success(subjectService.createSubject(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update inspection and maintenance item.")
    @PreAuthorize("@ss.hasPermission('mes:dv-subject:update')")
    public CommonResult<Boolean> updateSubject(@Valid @RequestBody MesDvSubjectSaveReqVO updateReqVO) {
        subjectService.updateSubject(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete inspection and maintenance item.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-subject:delete')")
    public CommonResult<Boolean> deleteSubject(@RequestParam("id") Long id) {
        subjectService.deleteSubject(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get inspection and maintenance item.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:dv-subject:query')")
    public CommonResult<MesDvSubjectRespVO> getSubject(@RequestParam("id") Long id) {
        MesDvSubjectDO subject = subjectService.getSubject(id);
        return success(BeanUtils.toBean(subject, MesDvSubjectRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get inspection and maintenance item page.")
    @PreAuthorize("@ss.hasPermission('mes:dv-subject:query')")
    public CommonResult<PageResult<MesDvSubjectRespVO>> getSubjectPage(@Valid MesDvSubjectPageReqVO pageReqVO) {
        PageResult<MesDvSubjectDO> pageResult = subjectService.getSubjectPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MesDvSubjectRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get inspection and maintenance item simple list.", description = "Used by frontend select options.")
    @PreAuthorize("@ss.hasPermission('mes:dv-subject:query')")
    public CommonResult<List<MesDvSubjectRespVO>> getSubjectSimpleList() {
        List<MesDvSubjectDO> list = subjectService.getSubjectList();
        return success(BeanUtils.toBean(list, MesDvSubjectRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export inspection and maintenance item Excel.")
    @PreAuthorize("@ss.hasPermission('mes:dv-subject:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSubjectExcel(@Valid MesDvSubjectPageReqVO pageReqVO,
                                    HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesDvSubjectDO> list = subjectService.getSubjectPage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Inspection and Maintenance Items.xls", "Data", MesDvSubjectRespVO.class,
                BeanUtils.toBean(list, MesDvSubjectRespVO.class));
    }

}
