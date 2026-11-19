package cn.iocoder.yudao.module.aimonitor.controller.admin.project;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectCreateReqVO;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectPageReqVO;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectRespVO;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectUpdateReqVO;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorPreflightReqVO;
import cn.iocoder.yudao.module.aimonitor.dal.dataobject.project.AimonitorProjectDO;
import cn.iocoder.yudao.module.aimonitor.service.project.AimonitorProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import tools.jackson.databind.JsonNode;

import java.util.LinkedHashMap;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - AI 监测项目")
@RestController
@RequestMapping("/aimonitor/project")
@Validated
public class AimonitorProjectController {

    @Resource
    private AimonitorProjectService projectService;

    @PostMapping("/create")
    @Operation(summary = "创建监测项目（同步创建算法项目）")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:create')")
    public CommonResult<Long> createProject(@Valid @RequestBody AimonitorProjectCreateReqVO createReqVO) {
        return success(projectService.createProject(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新监测项目")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Boolean> updateProject(@Valid @RequestBody AimonitorProjectUpdateReqVO updateReqVO) {
        projectService.updateProject(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除监测项目")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('aimonitor:project:delete')")
    public CommonResult<Boolean> deleteProject(@RequestParam("id") Long id) {
        projectService.deleteProject(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得监测项目")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<AimonitorProjectRespVO> getProject(@RequestParam("id") Long id) {
        AimonitorProjectDO project = projectService.getProject(id);
        return success(BeanUtils.toBean(project, AimonitorProjectRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得监测项目分页")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<PageResult<AimonitorProjectRespVO>> getProjectPage(@Valid AimonitorProjectPageReqVO pageReqVO) {
        PageResult<AimonitorProjectDO> pageResult = projectService.getProjectPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AimonitorProjectRespVO.class));
    }

    @PostMapping("/preflight")
    @Operation(summary = "品牌预检")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:create')")
    public CommonResult<Object> preflight(@Valid @RequestBody AimonitorPreflightReqVO reqVO) {
        return success(toJson(projectService.preflight(reqVO)));
    }

    @GetMapping("/{id}/workspace")
    @Operation(summary = "工作台聚合数据")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> getWorkspace(@PathVariable("id") Long id,
                                             @RequestParam(value = "days", required = false) Integer days,
                                             @RequestParam(value = "scanLimit", required = false) Integer scanLimit) {
        return success(toJson(projectService.getWorkspace(id, days, scanLimit)));
    }

    @GetMapping("/{id}/scans")
    @Operation(summary = "扫描历史")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> listScans(@PathVariable("id") Long id,
                                          @RequestParam(value = "limit", required = false) Integer limit) {
        return success(toJson(projectService.listScans(id, limit)));
    }

    @PostMapping("/{id}/scans")
    @Operation(summary = "发起扫描")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> createScan(@PathVariable("id") Long id) {
        return success(toJson(projectService.createScan(id)));
    }

    @GetMapping("/{id}/evidence")
    @Operation(summary = "证据列表")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> listEvidence(@PathVariable("id") Long id,
                                             @RequestParam(value = "scanId", required = false) String scanId,
                                             @RequestParam(value = "promptId", required = false) String promptId,
                                             @RequestParam(value = "platform", required = false) String platform,
                                             @RequestParam(value = "mentioned", required = false) String mentioned,
                                             @RequestParam(value = "limit", required = false) Integer limit,
                                             @RequestParam(value = "offset", required = false) Integer offset) {
        Map<String, String> query = new LinkedHashMap<>();
        if (scanId != null) {
            query.put("scan_id", scanId);
        }
        if (promptId != null) {
            query.put("prompt_id", promptId);
        }
        if (platform != null) {
            query.put("platform", platform);
        }
        if (mentioned != null) {
            query.put("mentioned", mentioned);
        }
        if (limit != null) {
            query.put("limit", String.valueOf(limit));
        }
        if (offset != null) {
            query.put("offset", String.valueOf(offset));
        }
        return success(toJson(projectService.listEvidence(id, query)));
    }

    @GetMapping("/{id}/schedule")
    @Operation(summary = "获得定时监测配置")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> getSchedule(@PathVariable("id") Long id) {
        return success(toJson(projectService.getSchedule(id)));
    }

    @PutMapping("/{id}/schedule")
    @Operation(summary = "更新定时监测配置")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> putSchedule(@PathVariable("id") Long id,
                                            @RequestBody Map<String, Object> body) {
        return success(toJson(projectService.putSchedule(id, body)));
    }

    @GetMapping("/{id}/prompt-panel")
    @Operation(summary = "获得问题集")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> getPromptPanel(@PathVariable("id") Long id) {
        return success(toJson(projectService.getPromptPanel(id)));
    }

    @PostMapping("/{id}/prompt-panel/custom")
    @Operation(summary = "创建自定义问题集")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> createCustomPromptPanel(@PathVariable("id") Long id,
                                                        @RequestBody Map<String, Object> body) {
        return success(toJson(projectService.createCustomPromptPanel(id, body)));
    }

    @PostMapping("/{id}/prompt-panel/activate")
    @Operation(summary = "启用问题集版本")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> activatePromptPanel(@PathVariable("id") Long id,
                                                    @RequestBody Map<String, Object> body) {
        return success(toJson(projectService.activatePromptPanel(id, body)));
    }

    @DeleteMapping("/{id}/prompt-panel/versions/{versionId}")
    @Operation(summary = "删除问题集版本")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> deletePromptPanelVersion(@PathVariable("id") Long id,
                                                         @PathVariable("versionId") String versionId,
                                                         @RequestParam(value = "force", required = false) Boolean force) {
        return success(toJson(projectService.deletePromptPanelVersion(id, versionId, force)));
    }

    @GetMapping("/{id}/trends")
    @Operation(summary = "趋势")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> getTrends(@PathVariable("id") Long id,
                                          @RequestParam(value = "days", required = false) Integer days,
                                          @RequestParam(value = "platform", required = false) String platform) {
        return success(toJson(projectService.getTrends(id, days, platform)));
    }

    @GetMapping("/{id}/changes")
    @Operation(summary = "变化事件")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> getChanges(@PathVariable("id") Long id,
                                           @RequestParam(value = "days", required = false) Integer days,
                                           @RequestParam(value = "limit", required = false) Integer limit,
                                           @RequestParam(value = "includeInfo", required = false) Boolean includeInfo) {
        return success(toJson(projectService.getChanges(id, days, limit, includeInfo)));
    }

    @GetMapping("/{id}/content/opportunities")
    @Operation(summary = "内容机会列表")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> listContentOpportunities(@PathVariable("id") Long id,
                                                         @RequestParam(value = "language", required = false) String language) {
        return success(toJson(projectService.listContentOpportunities(id, language)));
    }

    @GetMapping("/{id}/content/briefs")
    @Operation(summary = "内容包列表")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> listContentBriefs(@PathVariable("id") Long id) {
        return success(toJson(projectService.listContentBriefs(id)));
    }

    @PostMapping("/{id}/content/briefs")
    @Operation(summary = "从内容机会创建内容包")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> createContentBrief(@PathVariable("id") Long id,
                                                   @RequestBody Map<String, Object> body) {
        return success(toJson(projectService.createContentBrief(id, body)));
    }

    @GetMapping("/{id}/content/briefs/{briefId}")
    @Operation(summary = "内容包详情")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> getContentBrief(@PathVariable("id") Long id,
                                                @PathVariable("briefId") String briefId) {
        return success(toJson(projectService.getContentBrief(id, briefId)));
    }

    @PostMapping("/{id}/content/briefs/{briefId}/generate")
    @Operation(summary = "生成内容草稿")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> generateContentBrief(@PathVariable("id") Long id,
                                                     @PathVariable("briefId") String briefId,
                                                     @RequestBody(required = false) Map<String, Object> body) {
        return success(toJson(projectService.generateContentBrief(id, briefId,
                body != null ? body : Map.of())));
    }

    @GetMapping("/{id}/content/drafts")
    @Operation(summary = "内容草稿列表")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> listContentDrafts(@PathVariable("id") Long id,
                                                  @RequestParam(value = "briefId", required = false) String briefId) {
        return success(toJson(projectService.listContentDrafts(id, briefId)));
    }

    @PutMapping("/{id}/content/drafts/{draftId}")
    @Operation(summary = "更新内容草稿")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> patchContentDraft(@PathVariable("id") Long id,
                                                  @PathVariable("draftId") String draftId,
                                                  @RequestBody Map<String, Object> body) {
        return success(toJson(projectService.patchContentDraft(id, draftId, body)));
    }

    @PostMapping("/{id}/content/drafts/{draftId}/publish")
    @Operation(summary = "标记内容草稿已发布")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> publishContentDraft(@PathVariable("id") Long id,
                                                    @PathVariable("draftId") String draftId,
                                                    @RequestBody(required = false) Map<String, Object> body) {
        return success(toJson(projectService.publishContentDraft(id, draftId,
                body != null ? body : Map.of())));
    }

    @GetMapping("/{id}/content/assets")
    @Operation(summary = "素材库列表")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:query')")
    public CommonResult<Object> listContentAssets(@PathVariable("id") Long id) {
        return success(toJson(projectService.listContentAssets(id)));
    }

    @PostMapping("/{id}/content/assets")
    @Operation(summary = "添加素材")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> createContentAsset(@PathVariable("id") Long id,
                                                   @RequestBody Map<String, Object> body) {
        return success(toJson(projectService.createContentAsset(id, body)));
    }

    @DeleteMapping("/{id}/content/assets/{assetId}")
    @Operation(summary = "删除素材")
    @PreAuthorize("@ss.hasPermission('aimonitor:project:update')")
    public CommonResult<Object> deleteContentAsset(@PathVariable("id") Long id,
                                                   @PathVariable("assetId") String assetId) {
        return success(toJson(projectService.deleteContentAsset(id, assetId)));
    }

    /** JsonNode → Map/List，便于统一 CommonResult 序列化 */
    private static Object toJson(JsonNode node) {
        if (node == null || node.isNull()) {
            return null;
        }
        return JsonUtils.parseObject(node.toString(), Object.class);
    }

}
