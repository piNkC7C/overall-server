package cn.iocoder.yudao.module.pms.controller.admin.kb.interaction;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.pms.controller.admin.kb.interaction.vo.viewrecord.PmsKnowledgeRecentListRespVO;
import cn.iocoder.yudao.module.pms.service.kb.interaction.PmsKnowledgeViewRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - PMS knowledge Recently Viewed.")
@RestController
@RequestMapping("/pms/kb/view-record")
@Validated
public class PmsKnowledgeViewRecordController {

    @Resource
    private PmsKnowledgeViewRecordService viewRecordService;

    @GetMapping("/recent-list")
    @Operation(summary = "Get Recently Viewed list.")
    @Parameter(name = "libraryId", description = "Knowledge-base ID. Omit to query all readable knowledge bases.", example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:kb:library:query')")
    public CommonResult<PmsKnowledgeRecentListRespVO> getRecentViewRecordList(
            @RequestParam(value = "libraryId", required = false) Long libraryId) {
        return success(viewRecordService.getRecentViewRecordList(libraryId, getLoginUserId()));
    }

}
