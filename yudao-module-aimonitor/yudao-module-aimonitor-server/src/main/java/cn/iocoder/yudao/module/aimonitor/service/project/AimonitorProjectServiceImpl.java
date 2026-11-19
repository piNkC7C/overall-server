package cn.iocoder.yudao.module.aimonitor.service.project;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectCreateReqVO;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectPageReqVO;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorProjectUpdateReqVO;
import cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo.AimonitorPreflightReqVO;
import cn.iocoder.yudao.module.aimonitor.dal.dataobject.project.AimonitorProjectDO;
import cn.iocoder.yudao.module.aimonitor.dal.mysql.project.AimonitorProjectMapper;
import cn.iocoder.yudao.module.aimonitor.framework.algorithm.MonitorAlgorithmClient;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import tools.jackson.databind.JsonNode;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;
import static cn.iocoder.yudao.module.aimonitor.enums.ErrorCodeConstants.ALGORITHM_PROJECT_ID_MISSING;
import static cn.iocoder.yudao.module.aimonitor.enums.ErrorCodeConstants.PROJECT_ALREADY_EXISTS;
import static cn.iocoder.yudao.module.aimonitor.enums.ErrorCodeConstants.PROJECT_NOT_EXISTS;

@Service
@Validated
public class AimonitorProjectServiceImpl implements AimonitorProjectService {

    @Resource
    private AimonitorProjectMapper projectMapper;
    @Resource
    private MonitorAlgorithmClient algorithmClient;

    @Override
    public Long createProject(AimonitorProjectCreateReqVO createReqVO) {
        // 与算法一致：品牌 + 官网 + 地区唯一（预检已拦，创建再兜底）
        assertProjectKeyAvailable(createReqVO.getBrandName(), createReqVO.getWebsite(), createReqVO.getCountry());

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("brand_name", createReqVO.getBrandName());
        putIfNotBlank(body, "website", createReqVO.getWebsite());
        if (CollUtil.isNotEmpty(createReqVO.getKeywords())) {
            body.put("keywords", createReqVO.getKeywords());
        }
        putIfNotBlank(body, "prompt_source", createReqVO.getPromptSource());
        putIfNotBlank(body, "country", createReqVO.getCountry());
        if (CollUtil.isNotEmpty(createReqVO.getPlatforms())) {
            body.put("platforms", createReqVO.getPlatforms());
        }
        putIfNotBlank(body, "category", createReqVO.getCategory());
        putIfNotBlank(body, "business_type", createReqVO.getBusinessType());
        putIfNotBlank(body, "service_area", createReqVO.getServiceArea());
        if (createReqVO.getMerchantProfile() != null) {
            body.put("merchant_profile", createReqVO.getMerchantProfile());
        }
        if (CollUtil.isNotEmpty(createReqVO.getSeedCompetitors())) {
            body.put("seed_competitors", createReqVO.getSeedCompetitors());
        }
        if (CollUtil.isNotEmpty(createReqVO.getDetectedKeywords())) {
            body.put("detected_keywords", createReqVO.getDetectedKeywords());
        }
        if (createReqVO.getPromptsPerDirection() != null) {
            body.put("prompts_per_direction", createReqVO.getPromptsPerDirection());
        }
        body.put("start_scan", createReqVO.getStartScan() == null || createReqVO.getStartScan());

        JsonNode resp = algorithmClient.createProject(body);
        JsonNode projectNode = resp.get("project") != null && !resp.get("project").isNull()
                ? resp.get("project") : resp;
        String algorithmProjectId = JsonUtils.getText(projectNode, "id");
        if (StrUtil.isBlank(algorithmProjectId)) {
            throw exception(ALGORITHM_PROJECT_ID_MISSING);
        }

        AimonitorProjectDO row = new AimonitorProjectDO();
        row.setAlgorithmProjectId(algorithmProjectId);
        row.setName(firstNonBlank(JsonUtils.getText(projectNode, "name"), createReqVO.getBrandName()));
        row.setBrandName(firstNonBlank(JsonUtils.getText(projectNode, "brand_name"), createReqVO.getBrandName()));
        row.setWebsite(firstNonBlank(JsonUtils.getText(projectNode, "website"), createReqVO.getWebsite()));
        row.setCountry(firstNonBlank(JsonUtils.getText(projectNode, "country"), createReqVO.getCountry()));
        row.setStatus(firstNonBlank(JsonUtils.getText(projectNode, "status"), "active"));
        row.setCategory(firstNonBlank(JsonUtils.getText(projectNode, "category"), createReqVO.getCategory()));
        row.setBusinessType(firstNonBlank(JsonUtils.getText(projectNode, "business_type"), createReqVO.getBusinessType()));
        row.setPlatforms(joinPlatforms(projectNode.get("platforms"), createReqVO.getPlatforms()));
        row.setScanCount(intOrZero(projectNode.get("scan_count")));
        row.setLastScanAt(parseTime(JsonUtils.getText(projectNode, "last_scan_at")));
        row.setRemark(createReqVO.getRemark());
        projectMapper.insert(row);
        return row.getId();
    }

    @Override
    public void updateProject(AimonitorProjectUpdateReqVO updateReqVO) {
        AimonitorProjectDO exists = validateExists(updateReqVO.getId());
        Map<String, Object> body = new LinkedHashMap<>();
        putIfNotBlank(body, "name", updateReqVO.getName());
        putIfNotBlank(body, "brand_name", updateReqVO.getBrandName());
        putIfNotBlank(body, "website", updateReqVO.getWebsite());
        putIfNotBlank(body, "keyword", updateReqVO.getKeyword());
        if (CollUtil.isNotEmpty(updateReqVO.getKeywords())) {
            body.put("keywords", updateReqVO.getKeywords());
        }
        putIfNotBlank(body, "prompt_source", updateReqVO.getPromptSource());
        putIfNotBlank(body, "country", updateReqVO.getCountry());
        if (CollUtil.isNotEmpty(updateReqVO.getPlatforms())) {
            body.put("platforms", updateReqVO.getPlatforms());
        }
        putIfNotBlank(body, "status", updateReqVO.getStatus());
        if (!body.isEmpty()) {
            JsonNode projectNode = algorithmClient.patchProject(exists.getAlgorithmProjectId(), body);
            applyProjectNode(exists, projectNode);
        }
        if (updateReqVO.getRemark() != null) {
            exists.setRemark(updateReqVO.getRemark());
        }
        projectMapper.updateById(exists);
    }

    @Override
    public void deleteProject(Long id) {
        AimonitorProjectDO exists = validateExists(id);
        // 必须先归档算法侧：失败则整单失败，避免本地已删、算法仍占用品牌唯一键
        algorithmClient.patchProject(exists.getAlgorithmProjectId(), Map.of("status", "archived"));
        projectMapper.deleteById(id);
    }

    @Override
    public AimonitorProjectDO getProject(Long id) {
        return validateExists(id);
    }

    @Override
    public PageResult<AimonitorProjectDO> getProjectPage(AimonitorProjectPageReqVO pageReqVO) {
        return projectMapper.selectPage(pageReqVO, getLoginUserId());
    }

    @Override
    public JsonNode preflight(AimonitorPreflightReqVO reqVO) {
        // 预检阶段先拦重复，避免算法抓站成功后再在 create 报 409
        assertProjectKeyAvailable(reqVO.getBrandName(), reqVO.getUrl(), reqVO.getCountry());

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("url", reqVO.getUrl());
        putIfNotBlank(body, "brand_name", reqVO.getBrandName());
        putIfNotBlank(body, "country", reqVO.getCountry());
        return algorithmClient.preflight(body);
    }

    @Override
    public JsonNode getWorkspace(Long id, Integer days, Integer scanLimit) {
        AimonitorProjectDO project = validateExists(id);
        JsonNode workspace = algorithmClient.getWorkspace(project.getAlgorithmProjectId(), days, scanLimit);
        syncFromWorkspace(project, workspace);
        return workspace;
    }

    @Override
    public JsonNode listScans(Long id, Integer limit) {
        return algorithmClient.listScans(validateExists(id).getAlgorithmProjectId(), limit);
    }

    @Override
    public JsonNode createScan(Long id) {
        return algorithmClient.createScan(validateExists(id).getAlgorithmProjectId());
    }

    @Override
    public JsonNode listEvidence(Long id, Map<String, String> query) {
        return algorithmClient.listEvidence(validateExists(id).getAlgorithmProjectId(), query);
    }

    @Override
    public JsonNode getSchedule(Long id) {
        return algorithmClient.getSchedule(validateExists(id).getAlgorithmProjectId());
    }

    @Override
    public JsonNode putSchedule(Long id, Map<String, Object> body) {
        return algorithmClient.putSchedule(validateExists(id).getAlgorithmProjectId(), body);
    }

    @Override
    public JsonNode getPromptPanel(Long id) {
        return algorithmClient.getPromptPanel(validateExists(id).getAlgorithmProjectId());
    }

    @Override
    public JsonNode createCustomPromptPanel(Long id, Map<String, Object> body) {
        return algorithmClient.createCustomPromptPanel(validateExists(id).getAlgorithmProjectId(), body);
    }

    @Override
    public JsonNode activatePromptPanel(Long id, Map<String, Object> body) {
        return algorithmClient.activatePromptPanel(validateExists(id).getAlgorithmProjectId(), body);
    }

    @Override
    public JsonNode deletePromptPanelVersion(Long id, String versionId, Boolean force) {
        return algorithmClient.deletePromptPanelVersion(validateExists(id).getAlgorithmProjectId(), versionId, force);
    }

    @Override
    public JsonNode getTrends(Long id, Integer days, String platform) {
        return algorithmClient.getTrends(validateExists(id).getAlgorithmProjectId(), days, platform);
    }

    @Override
    public JsonNode getChanges(Long id, Integer days, Integer limit, Boolean includeInfo) {
        return algorithmClient.getChanges(validateExists(id).getAlgorithmProjectId(), days, limit, includeInfo);
    }

    @Override
    public JsonNode listContentOpportunities(Long id) {
        return algorithmClient.listContentOpportunities(validateExists(id).getAlgorithmProjectId());
    }

    @Override
    public JsonNode listContentBriefs(Long id) {
        return algorithmClient.listContentBriefs(validateExists(id).getAlgorithmProjectId());
    }

    @Override
    public JsonNode createContentBrief(Long id, Map<String, Object> body) {
        return algorithmClient.createContentBrief(validateExists(id).getAlgorithmProjectId(), body);
    }

    @Override
    public JsonNode getContentBrief(Long id, String briefId) {
        return algorithmClient.getContentBrief(validateExists(id).getAlgorithmProjectId(), briefId);
    }

    @Override
    public JsonNode generateContentBrief(Long id, String briefId, Map<String, Object> body) {
        return algorithmClient.generateContentBrief(validateExists(id).getAlgorithmProjectId(), briefId, body);
    }

    @Override
    public JsonNode listContentDrafts(Long id, String briefId) {
        return algorithmClient.listContentDrafts(validateExists(id).getAlgorithmProjectId(), briefId);
    }

    @Override
    public JsonNode patchContentDraft(Long id, String draftId, Map<String, Object> body) {
        return algorithmClient.patchContentDraft(validateExists(id).getAlgorithmProjectId(), draftId, body);
    }

    @Override
    public JsonNode publishContentDraft(Long id, String draftId, Map<String, Object> body) {
        return algorithmClient.publishContentDraft(validateExists(id).getAlgorithmProjectId(), draftId, body);
    }

    @Override
    public JsonNode listContentAssets(Long id) {
        return algorithmClient.listContentAssets(validateExists(id).getAlgorithmProjectId());
    }

    @Override
    public JsonNode createContentAsset(Long id, Map<String, Object> body) {
        return algorithmClient.createContentAsset(validateExists(id).getAlgorithmProjectId(), body);
    }

    @Override
    public JsonNode deleteContentAsset(Long id, String assetId) {
        return algorithmClient.deleteContentAsset(validateExists(id).getAlgorithmProjectId(), assetId);
    }

    private AimonitorProjectDO validateExists(Long id) {
        AimonitorProjectDO project = projectMapper.selectById(id);
        if (project == null) {
            throw exception(PROJECT_NOT_EXISTS);
        }
        // 仅创建人可访问；不暴露他人项目是否存在
        Long userId = getLoginUserId();
        if (userId == null || !Objects.equals(String.valueOf(userId), project.getCreator())) {
            throw exception(PROJECT_NOT_EXISTS);
        }
        return project;
    }

    /**
     * 对齐算法 project_key：品牌 + 监测目标（官网）+ 国家。
     * 国家缺省按算法默认 US；官网做协议/www/尾斜杠归一后再比。
     */
    private void assertProjectKeyAvailable(String brandName, String website, String country) {
        if (StrUtil.isBlank(brandName) || StrUtil.isBlank(website)) {
            return;
        }
        String brand = brandName.trim();
        String websiteKey = normalizeWebsiteKey(website);
        if (StrUtil.isBlank(websiteKey)) {
            return;
        }
        String countryKey = normalizeCountry(country);
        List<AimonitorProjectDO> candidates = projectMapper.selectListByBrandName(brand);
        for (AimonitorProjectDO row : candidates) {
            if (!countryKey.equalsIgnoreCase(normalizeCountry(row.getCountry()))) {
                continue;
            }
            if (websiteKey.equals(normalizeWebsiteKey(row.getWebsite()))) {
                throw exception(PROJECT_ALREADY_EXISTS);
            }
        }
    }

    private static String normalizeCountry(String country) {
        return StrUtil.blankToDefault(StrUtil.trim(country), "US");
    }

    /** host + path，去协议、www、尾斜杠，小写 */
    private static String normalizeWebsiteKey(String website) {
        if (StrUtil.isBlank(website)) {
            return "";
        }
        String raw = website.trim();
        try {
            java.net.URI uri = java.net.URI.create(raw.contains("://") ? raw : "https://" + raw);
            String host = StrUtil.blankToDefault(uri.getHost(), "");
            if (host.regionMatches(true, 0, "www.", 0, 4)) {
                host = host.substring(4);
            }
            String path = StrUtil.blankToDefault(uri.getPath(), "");
            while (path.endsWith("/") && path.length() > 1) {
                path = path.substring(0, path.length() - 1);
            }
            if ("/".equals(path)) {
                path = "";
            }
            return (host + path).toLowerCase();
        } catch (Exception ignored) {
            String fallback = raw.toLowerCase();
            if (fallback.startsWith("https://")) {
                fallback = fallback.substring(8);
            } else if (fallback.startsWith("http://")) {
                fallback = fallback.substring(7);
            }
            if (fallback.startsWith("www.")) {
                fallback = fallback.substring(4);
            }
            while (fallback.endsWith("/") && fallback.length() > 1) {
                fallback = fallback.substring(0, fallback.length() - 1);
            }
            return fallback;
        }
    }

    private void syncFromWorkspace(AimonitorProjectDO local, JsonNode workspace) {
        JsonNode projectNode = workspace.get("project");
        if (projectNode == null || projectNode.isNull()) {
            return;
        }
        applyProjectNode(local, projectNode);
        projectMapper.updateById(local);
    }

    private void applyProjectNode(AimonitorProjectDO local, JsonNode projectNode) {
        if (projectNode == null || projectNode.isNull()) {
            return;
        }
        String name = JsonUtils.getText(projectNode, "name");
        if (StrUtil.isNotBlank(name)) {
            local.setName(name);
        }
        String brand = JsonUtils.getText(projectNode, "brand_name");
        if (StrUtil.isNotBlank(brand)) {
            local.setBrandName(brand);
        }
        String website = JsonUtils.getText(projectNode, "website");
        if (website != null) {
            local.setWebsite(website);
        }
        String country = JsonUtils.getText(projectNode, "country");
        if (StrUtil.isNotBlank(country)) {
            local.setCountry(country);
        }
        String status = JsonUtils.getText(projectNode, "status");
        if (StrUtil.isNotBlank(status)) {
            local.setStatus(status);
        }
        String category = JsonUtils.getText(projectNode, "category");
        if (category != null) {
            local.setCategory(category);
        }
        String businessType = JsonUtils.getText(projectNode, "business_type");
        if (businessType != null) {
            local.setBusinessType(businessType);
        }
        String platforms = joinPlatforms(projectNode.get("platforms"), null);
        if (platforms != null) {
            local.setPlatforms(platforms);
        }
        if (projectNode.get("scan_count") != null && !projectNode.get("scan_count").isNull()) {
            local.setScanCount(intOrZero(projectNode.get("scan_count")));
        }
        LocalDateTime lastScanAt = parseTime(JsonUtils.getText(projectNode, "last_scan_at"));
        if (lastScanAt != null) {
            local.setLastScanAt(lastScanAt);
        }
    }

    private static void putIfNotBlank(Map<String, Object> body, String key, String value) {
        if (StrUtil.isNotBlank(value)) {
            body.put(key, value);
        }
    }

    private static String joinPlatforms(JsonNode node, List<String> fallback) {
        if (node != null && node.isArray()) {
            StringBuilder sb = new StringBuilder();
            node.forEach(item -> {
                String text = item == null || item.isNull() ? null : item.asText();
                if (StrUtil.isBlank(text)) {
                    return;
                }
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(text);
            });
            return sb.toString();
        }
        if (CollUtil.isNotEmpty(fallback)) {
            return String.join(",", fallback);
        }
        return null;
    }

    private static int intOrZero(JsonNode node) {
        if (node == null || node.isNull()) {
            return 0;
        }
        return node.asInt();
    }

    private static LocalDateTime parseTime(String raw) {
        if (StrUtil.isBlank(raw)) {
            return null;
        }
        try {
            return OffsetDateTime.parse(raw).toLocalDateTime();
        } catch (Exception ignored) {
            try {
                return LocalDateTime.parse(raw);
            } catch (Exception ignored2) {
                return null;
            }
        }
    }

    private static String firstNonBlank(String... values) {
        if (values == null) {
            return "";
        }
        for (String value : values) {
            if (StrUtil.isNotBlank(value)) {
                return value;
            }
        }
        return "";
    }

}
