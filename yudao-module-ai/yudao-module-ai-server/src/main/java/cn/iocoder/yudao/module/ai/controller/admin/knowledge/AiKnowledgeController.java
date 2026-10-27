package cn.iocoder.yudao.module.ai.controller.admin.knowledge;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.knowledge.AiKnowledgePageReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.knowledge.AiKnowledgeRespVO;
import cn.iocoder.yudao.module.ai.controller.admin.knowledge.vo.knowledge.AiKnowledgeSaveReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.knowledge.AiKnowledgeDO;
import cn.iocoder.yudao.module.ai.service.knowledge.AiKnowledgeService;
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

@Tag(name = "Admin - AI knowledge base.")
@RestController
@RequestMapping("/ai/knowledge")
@Validated
public class AiKnowledgeController {

    @Resource
    private AiKnowledgeService knowledgeService;

    @GetMapping("/page")
    @Operation(summary = "Get knowledge base page.")
    @PreAuthorize("@ss.hasPermission('ai:knowledge:query')")
    public CommonResult<PageResult<AiKnowledgeRespVO>> getKnowledgePage(@Valid AiKnowledgePageReqVO pageReqVO) {
        PageResult<AiKnowledgeDO> pageResult = knowledgeService.getKnowledgePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AiKnowledgeRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "Get knowledge base.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:knowledge:query')")
    public CommonResult<AiKnowledgeRespVO> getKnowledge(@RequestParam("id") Long id) {
        AiKnowledgeDO knowledge = knowledgeService.getKnowledge(id);
        return success(BeanUtils.toBean(knowledge, AiKnowledgeRespVO.class));
    }

    @PostMapping("/create")
    @Operation(summary = "Create knowledge base.")
    @PreAuthorize("@ss.hasPermission('ai:knowledge:create')")
    public CommonResult<Long> createKnowledge(@RequestBody @Valid AiKnowledgeSaveReqVO createReqVO) {
        return success(knowledgeService.createKnowledge(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update knowledge base.")
    @PreAuthorize("@ss.hasPermission('ai:knowledge:update')")
    public CommonResult<Boolean> updateKnowledge(@RequestBody @Valid AiKnowledgeSaveReqVO updateReqVO) {
        knowledgeService.updateKnowledge(updateReqVO);
        return success(true);
    }
    
    @DeleteMapping("/delete")
    @Operation(summary = "Delete knowledge base.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:knowledge:delete')")
    public CommonResult<Boolean> deleteKnowledge(@RequestParam("id") Long id) {
        knowledgeService.deleteKnowledge(id);
        return success(true);
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get knowledge base simple list.")
    public CommonResult<List<AiKnowledgeRespVO>> getKnowledgeSimpleList() {
        List<AiKnowledgeDO> list = knowledgeService.getKnowledgeSimpleListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, knowledge -> new AiKnowledgeRespVO()
                .setId(knowledge.getId()).setName(knowledge.getName())));
    }

}
