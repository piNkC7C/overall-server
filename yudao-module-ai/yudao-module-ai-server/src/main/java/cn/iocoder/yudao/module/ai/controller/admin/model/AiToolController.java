package cn.iocoder.yudao.module.ai.controller.admin.model;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.tool.AiToolPageReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.tool.AiToolRespVO;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.tool.AiToolSaveReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.model.AiToolDO;
import cn.iocoder.yudao.module.ai.service.model.AiToolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - AI tool.")
@RestController
@RequestMapping("/ai/tool")
@Validated
public class AiToolController {

    @Resource
    private AiToolService toolService;

    @PostMapping("/create")
    @Operation(summary = "Createtool.")
    @PreAuthorize("@ss.hasPermission('ai:tool:create')")
    public CommonResult<Long> createTool(@Valid @RequestBody AiToolSaveReqVO createReqVO) {
        return success(toolService.createTool(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatetool.")
    @PreAuthorize("@ss.hasPermission('ai:tool:update')")
    public CommonResult<Boolean> updateTool(@Valid @RequestBody AiToolSaveReqVO updateReqVO) {
        toolService.updateTool(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletetool.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('ai:tool:delete')")
    public CommonResult<Boolean> deleteTool(@RequestParam("id") Long id) {
        toolService.deleteTool(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get tool.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:tool:query')")
    public CommonResult<AiToolRespVO> getTool(@RequestParam("id") Long id) {
        AiToolDO tool = toolService.getTool(id);
        return success(BeanUtils.toBean(tool, AiToolRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get tool page.")
    @PreAuthorize("@ss.hasPermission('ai:tool:query')")
    public CommonResult<PageResult<AiToolRespVO>> getToolPage(@Valid AiToolPageReqVO pageReqVO) {
        PageResult<AiToolDO> pageResult = toolService.getToolPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AiToolRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get tool list.")
    public CommonResult<List<AiToolRespVO>> getToolSimpleList() {
        List<AiToolDO> list = toolService.getToolListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, tool -> new AiToolRespVO()
                .setId(tool.getId()).setName(tool.getName())));
    }

}