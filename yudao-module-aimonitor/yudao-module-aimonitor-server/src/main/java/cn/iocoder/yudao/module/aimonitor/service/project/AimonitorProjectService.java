package cn.iocoder.yudao.module.aimonitor.service.project;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectCreateReqVO;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectPageReqVO;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectUpdateReqVO;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorPreflightReqVO;
import cn.iocoder.yudao.module.aimonitor.dal.dataobject.project.AimonitorProjectDO;
import tools.jackson.databind.JsonNode;

import java.util.Map;

public interface AimonitorProjectService {

    Long createProject(AimonitorProjectCreateReqVO createReqVO);

    void updateProject(AimonitorProjectUpdateReqVO updateReqVO);

    void deleteProject(Long id);

    AimonitorProjectDO getProject(Long id);

    PageResult<AimonitorProjectDO> getProjectPage(AimonitorProjectPageReqVO pageReqVO);

    JsonNode preflight(AimonitorPreflightReqVO reqVO);

    JsonNode getWorkspace(Long id, Integer days, Integer scanLimit);

    JsonNode listScans(Long id, Integer limit);

    JsonNode createScan(Long id);

    JsonNode listEvidence(Long id, Map<String, String> query);

    JsonNode getSchedule(Long id);

    JsonNode putSchedule(Long id, Map<String, Object> body);

    JsonNode getPromptPanel(Long id);

    JsonNode createCustomPromptPanel(Long id, Map<String, Object> body);

    JsonNode activatePromptPanel(Long id, Map<String, Object> body);

    JsonNode deletePromptPanelVersion(Long id, String versionId, Boolean force);

    JsonNode getTrends(Long id, Integer days, String platform);

    JsonNode getChanges(Long id, Integer days, Integer limit, Boolean includeInfo);

    JsonNode listContentOpportunities(Long id);

    JsonNode listContentBriefs(Long id);

    JsonNode createContentBrief(Long id, Map<String, Object> body);

    JsonNode getContentBrief(Long id, String briefId);

    JsonNode generateContentBrief(Long id, String briefId, Map<String, Object> body);

    JsonNode listContentDrafts(Long id, String briefId);

    JsonNode patchContentDraft(Long id, String draftId, Map<String, Object> body);

    JsonNode publishContentDraft(Long id, String draftId, Map<String, Object> body);

    JsonNode listContentAssets(Long id);

    JsonNode createContentAsset(Long id, Map<String, Object> body);

    JsonNode deleteContentAsset(Long id, String assetId);

}
