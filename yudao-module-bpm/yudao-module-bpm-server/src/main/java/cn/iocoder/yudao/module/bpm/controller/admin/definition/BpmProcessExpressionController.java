package cn.iocoder.yudao.module.bpm.controller.admin.definition;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.expression.BpmProcessExpressionPageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.expression.BpmProcessExpressionRespVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.expression.BpmProcessExpressionSaveReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.definition.BpmProcessExpressionDO;
import cn.iocoder.yudao.module.bpm.service.definition.BpmProcessExpressionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - BPM workflow expression.")
@RestController
@RequestMapping("/bpm/process-expression")
@Validated
public class BpmProcessExpressionController {

    @Resource
    private BpmProcessExpressionService processExpressionService;

    @PostMapping("/create")
    @Operation(summary = "Createworkflow expression.")
    @PreAuthorize("@ss.hasPermission('bpm:process-expression:create')")
    public CommonResult<Long> createProcessExpression(@Valid @RequestBody BpmProcessExpressionSaveReqVO createReqVO) {
        return success(processExpressionService.createProcessExpression(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateworkflow expression.")
    @PreAuthorize("@ss.hasPermission('bpm:process-expression:update')")
    public CommonResult<Boolean> updateProcessExpression(@Valid @RequestBody BpmProcessExpressionSaveReqVO updateReqVO) {
        processExpressionService.updateProcessExpression(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteworkflow expression.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('bpm:process-expression:delete')")
    public CommonResult<Boolean> deleteProcessExpression(@RequestParam("id") Long id) {
        processExpressionService.deleteProcessExpression(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get workflow expression.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bpm:process-expression:query')")
    public CommonResult<BpmProcessExpressionRespVO> getProcessExpression(@RequestParam("id") Long id) {
        BpmProcessExpressionDO processExpression = processExpressionService.getProcessExpression(id);
        return success(BeanUtils.toBean(processExpression, BpmProcessExpressionRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get workflow expression page.")
    @PreAuthorize("@ss.hasPermission('bpm:process-expression:query')")
    public CommonResult<PageResult<BpmProcessExpressionRespVO>> getProcessExpressionPage(
            @Valid BpmProcessExpressionPageReqVO pageReqVO) {
        PageResult<BpmProcessExpressionDO> pageResult = processExpressionService.getProcessExpressionPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BpmProcessExpressionRespVO.class));
    }

}