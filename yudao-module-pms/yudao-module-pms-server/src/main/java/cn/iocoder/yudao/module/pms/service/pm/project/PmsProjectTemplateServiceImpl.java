package cn.iocoder.yudao.module.pms.service.pm.project;

import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.template.PmsProjectTemplatePageReqVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.template.PmsProjectTemplateSaveReqVO;
import cn.iocoder.yudao.module.pms.dal.dataobject.pm.project.PmsProjectTemplateDO;
import cn.iocoder.yudao.module.pms.dal.mysql.pm.project.PmsProjectTemplateMapper;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemTypeEnum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.module.pms.enums.ErrorCodeConstants.PROJECT_TEMPLATE_CONFIG_INVALID;
import static cn.iocoder.yudao.module.pms.enums.ErrorCodeConstants.PROJECT_TEMPLATE_NAME_DUPLICATE;
import static cn.iocoder.yudao.module.pms.enums.ErrorCodeConstants.PROJECT_TEMPLATE_NOT_EXISTS;

/**
 * PMS 项目模板 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PmsProjectTemplateServiceImpl implements PmsProjectTemplateService {

    @Resource
    private PmsProjectTemplateMapper projectTemplateMapper;

    @Override
    public Long createProjectTemplate(PmsProjectTemplateSaveReqVO createReqVO) {
        // 1. 校验模板名称和协作配置
        validateProjectTemplateNameDuplicate(createReqVO.getName(), createReqVO.getProjectType(), null);
        validateProjectTemplateConfig(createReqVO);

        // 2. create item template
        PmsProjectTemplateDO template = buildProjectTemplateDO(createReqVO);
        projectTemplateMapper.insert(template);
        return template.getId();
    }

    @Override
    public void updateProjectTemplate(PmsProjectTemplateSaveReqVO updateReqVO) {
        // 1. 校验模板存在、名称和协作配置
        validateProjectTemplateExists(updateReqVO.getId());
        validateProjectTemplateNameDuplicate(updateReqVO.getName(), updateReqVO.getProjectType(), updateReqVO.getId());
        validateProjectTemplateConfig(updateReqVO);

        // 2. update item template
        projectTemplateMapper.updateById(buildProjectTemplateDO(updateReqVO));
    }

    @Override
    public void deleteProjectTemplate(Long id) {
        // 1. 校验模板存在
        validateProjectTemplateExists(id);

        // 2. delete item template
        projectTemplateMapper.deleteById(id);
    }

    @Override
    public PmsProjectTemplateDO getProjectTemplate(Long id) {
        return validateProjectTemplateExists(id);
    }

    @Override
    public PageResult<PmsProjectTemplateDO> getProjectTemplatePage(PmsProjectTemplatePageReqVO pageReqVO) {
        return projectTemplateMapper.selectPage(pageReqVO);
    }

    /**
     * 构建项目模板 DO
     *
     * <p>顶层字段使用 BeanUtils 复制，嵌套状态和看板项分别转换为 DO 内部类型后持久化。</p>
     *
     * @param saveReqVO 保存信息
     * @return 项目模板 DO
     */
    private PmsProjectTemplateDO buildProjectTemplateDO(PmsProjectTemplateSaveReqVO saveReqVO) {
        return BeanUtils.toBean(saveReqVO, PmsProjectTemplateDO.class)
                .setStatuses(convertList(saveReqVO.getStatuses(), status ->
                        BeanUtils.toBean(status, PmsProjectTemplateDO.StatusTemplate.class)))
                .setBoards(convertList(saveReqVO.getBoards(), board ->
                        BeanUtils.toBean(board, PmsProjectTemplateDO.BoardTemplate.class)));
    }

    /**
     * 校验项目模板存在
     *
     * @param id 模板编号
     * @return 项目模板
     */
    private PmsProjectTemplateDO validateProjectTemplateExists(Long id) {
        PmsProjectTemplateDO template = projectTemplateMapper.selectById(id);
        if (template == null) {
            throw exception(PROJECT_TEMPLATE_NOT_EXISTS);
        }
        return template;
    }

    /**
     * 校验同一项目类型下的模板名称唯一
     *
     * @param name 模板名称
    * @param projectType 项目类型
    * @param id 排除的模板编号
    */
    private void validateProjectTemplateNameDuplicate(String name, Integer projectType, Long id) {
        PmsProjectTemplateDO template = projectTemplateMapper
                .selectByNameAndProjectType(name, projectType);
        if (template == null) {
            return;
        }
        if (id == null) {
            throw exception(PROJECT_TEMPLATE_NAME_DUPLICATE);
        }
        if (ObjectUtil.notEqual(template.getId(), id)) {
            throw exception(PROJECT_TEMPLATE_NAME_DUPLICATE);
        }
    }

    /**
     * 校验工作项类型、状态和看板列之间的模板关系
     *
     * @param saveReqVO 保存信息
     */
    private void validateProjectTemplateConfig(PmsProjectTemplateSaveReqVO saveReqVO) {
        Set<Integer> itemTypes = new HashSet<>(saveReqVO.getItemTypes());
        if (itemTypes.size() != saveReqVO.getItemTypes().size()
                || itemTypes.stream().anyMatch(type -> PmsWorkItemTypeEnum.valueOf(type) == null)) {
            throw exception(PROJECT_TEMPLATE_CONFIG_INVALID, "Work-item types are duplicated or invalid");
        }

        // 1. 校验状态编码唯一，并且每种工作项只有一个初始状态
        Set<String> statusCodes = new HashSet<>();
        Map<Integer, Integer> defaultStatusCountMap = new HashMap<>();
        for (PmsProjectTemplateSaveReqVO.StatusTemplate status : saveReqVO.getStatuses()) {
            if (!itemTypes.contains(status.getWorkItemType()) || !statusCodes.add(status.getCode())) {
                throw exception(PROJECT_TEMPLATE_CONFIG_INVALID, "Status type is not in the template, or the status code is duplicated");
            }
            if (Boolean.TRUE.equals(status.getDefaultStatus())) {
                defaultStatusCountMap.merge(status.getWorkItemType(), 1, Integer::sum);
            }
        }
        if (itemTypes.stream().anyMatch(type -> ObjectUtil.notEqual(defaultStatusCountMap.get(type), 1))) {
            throw exception(PROJECT_TEMPLATE_CONFIG_INVALID, "Each work-item type must have exactly one initial status");
        }

        // 2. 校验看板列编码唯一，且看板列只关联同类型的有效状态
        Set<String> boardCodes = new HashSet<>();
        Map<String, PmsProjectTemplateSaveReqVO.StatusTemplate> statusMap = new HashMap<>();
        Map<String, String> statusBoardCodeMap = new HashMap<>();
        saveReqVO.getStatuses().forEach(status -> statusMap.put(status.getCode(), status));
        for (PmsProjectTemplateSaveReqVO.BoardTemplate board : saveReqVO.getBoards()) {
            if (!itemTypes.contains(board.getWorkItemType()) || !boardCodes.add(board.getCode())
                    || new HashSet<>(board.getStatusCodes()).size() != board.getStatusCodes().size()) {
                throw exception(PROJECT_TEMPLATE_CONFIG_INVALID, "Board column type is invalid, or the code or linked status is duplicated");
            }
            for (String statusCode : board.getStatusCodes()) {
                PmsProjectTemplateSaveReqVO.StatusTemplate status = statusMap.get(statusCode);
                if (status == null || ObjectUtil.notEqual(status.getWorkItemType(), board.getWorkItemType())
                        || ObjectUtil.notEqual(status.getBoardCode(), board.getCode())
                        || statusBoardCodeMap.putIfAbsent(statusCode, board.getCode()) != null) {
                    throw exception(PROJECT_TEMPLATE_CONFIG_INVALID, "Board column and status type or code do not match");
                }
            }
        }

        // 3. 校验每个状态都归属且只归属一个已配置的看板列
        if (saveReqVO.getStatuses().stream().anyMatch(status -> !boardCodes.contains(status.getBoardCode())
                || ObjectUtil.notEqual(statusBoardCodeMap.get(status.getCode()), status.getBoardCode()))) {
            throw exception(PROJECT_TEMPLATE_CONFIG_INVALID, "A status must map to exactly one board column");
        }
    }

}
