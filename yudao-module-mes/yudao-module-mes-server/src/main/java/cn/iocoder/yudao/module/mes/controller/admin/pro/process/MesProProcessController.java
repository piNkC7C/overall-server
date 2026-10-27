package cn.iocoder.yudao.module.mes.controller.admin.pro.process;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.pro.process.vo.MesProProcessPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.pro.process.vo.MesProProcessRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.pro.process.vo.MesProProcessSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.process.MesProProcessDO;
import cn.iocoder.yudao.module.mes.service.pro.process.MesProProcessService;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - MES production operation.")
@RestController
@RequestMapping("/mes/pro/process")
@Validated
public class MesProProcessController {

    @Resource
    private MesProProcessService processService;

    @PostMapping("/create")
    @Operation(summary = "Create production operation.")
    @PreAuthorize("@ss.hasPermission('mes:pro-process:create')")
    public CommonResult<Long> createProcess(@Valid @RequestBody MesProProcessSaveReqVO createReqVO) {
        return success(processService.createProcess(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update production operation.")
    @PreAuthorize("@ss.hasPermission('mes:pro-process:update')")
    public CommonResult<Boolean> updateProcess(@Valid @RequestBody MesProProcessSaveReqVO updateReqVO) {
        processService.updateProcess(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete production operation.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:pro-process:delete')")
    public CommonResult<Boolean> deleteProcess(@RequestParam("id") Long id) {
        processService.deleteProcess(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get production operation.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:pro-process:query')")
    public CommonResult<MesProProcessRespVO> getProcess(@RequestParam("id") Long id) {
        MesProProcessDO process = processService.getProcess(id);
        return success(BeanUtils.toBean(process, MesProProcessRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get production operation page.")
    @PreAuthorize("@ss.hasPermission('mes:pro-process:query')")
    public CommonResult<PageResult<MesProProcessRespVO>> getProcessPage(@Valid MesProProcessPageReqVO pageReqVO) {
        PageResult<MesProProcessDO> pageResult = processService.getProcessPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MesProProcessRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get production operation simple list.", description = "Only enabled operation. Used for dropdowns.")
    public CommonResult<List<MesProProcessRespVO>> getProcessSimpleList() {
        List<MesProProcessDO> list = processService.getProcessListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, process -> new MesProProcessRespVO()
                .setId(process.getId()).setName(process.getName()).setCode(process.getCode())
                .setAttention(process.getAttention()).setRemark(process.getRemark())));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export production operation Excel.")
    @PreAuthorize("@ss.hasPermission('mes:pro-process:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportProcessExcel(@Valid MesProProcessPageReqVO pageReqVO,
                                   HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesProProcessDO> list = processService.getProcessPage(pageReqVO).getList();
        List<MesProProcessRespVO> data = BeanUtils.toBean(list, MesProProcessRespVO.class);
        ExcelUtils.write(response, "Production Processes.xls", "Data", MesProProcessRespVO.class, data);
    }

}
