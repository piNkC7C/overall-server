package cn.iocoder.yudao.module.crm.service.dictconfig;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.iocoder.yudao.framework.common.biz.system.dict.dto.DictDataRespDTO;
import cn.iocoder.yudao.framework.common.biz.system.dict.dto.DictDataSaveReqDTO;
import cn.iocoder.yudao.framework.common.biz.system.permission.PermissionCommonApi;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.crm.controller.admin.dictconfig.vo.CrmDictConfigRespVO;
import cn.iocoder.yudao.module.crm.controller.admin.dictconfig.vo.CrmDictConfigSaveReqVO;
import cn.iocoder.yudao.module.crm.dal.mysql.clue.CrmClueMapper;
import cn.iocoder.yudao.module.crm.dal.mysql.customer.CrmCustomerMapper;
import cn.iocoder.yudao.module.crm.dal.mysql.followup.CrmFollowUpRecordMapper;
import cn.iocoder.yudao.module.crm.enums.DictTypeConstants;
import cn.iocoder.yudao.module.crm.enums.clue.CrmClueCollectSourceEnum;
import cn.iocoder.yudao.module.system.api.dict.DictDataApi;
import cn.iocoder.yudao.module.system.enums.permission.RoleCodeEnum;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;
import static cn.iocoder.yudao.module.crm.enums.ErrorCodeConstants.*;

/**
 * CRM 字典枚举配置 Service 实现类（通过 DictDataApi 读写系统字典）
 */
@Service
@Validated
public class CrmDictConfigServiceImpl implements CrmDictConfigService {

    @Resource
    private DictDataApi dictDataApi;
    @Resource
    private CrmFollowUpRecordMapper followUpRecordMapper;
    @Resource
    private CrmClueMapper clueMapper;
    @Resource
    private CrmCustomerMapper customerMapper;

    @Override
    public List<CrmDictConfigRespVO> getFollowUpTypeList() {
        return buildRespList(DictTypeConstants.CRM_FOLLOW_UP_TYPE, true, false);
    }

    @Override
    public List<CrmDictConfigRespVO> getClueSourceList() {
        return buildRespList(DictTypeConstants.CRM_CUSTOMER_SOURCE, false, true);
    }

    @Override
    public Long createFollowUpType(CrmDictConfigSaveReqVO createReqVO) {
        return createDictData(DictTypeConstants.CRM_FOLLOW_UP_TYPE, createReqVO);
    }

    @Override
    public void updateFollowUpType(CrmDictConfigSaveReqVO updateReqVO) {
        updateDictData(DictTypeConstants.CRM_FOLLOW_UP_TYPE, updateReqVO, false);
    }

    @Override
    public void deleteFollowUpType(Long id) {
        deleteDictData(DictTypeConstants.CRM_FOLLOW_UP_TYPE, id, true, false);
    }

    @Override
    public Long createClueSource(CrmDictConfigSaveReqVO createReqVO) {
        return createDictData(DictTypeConstants.CRM_CUSTOMER_SOURCE, createReqVO);
    }

    @Override
    public void updateClueSource(CrmDictConfigSaveReqVO updateReqVO) {
        updateDictData(DictTypeConstants.CRM_CUSTOMER_SOURCE, updateReqVO, true);
    }

    @Override
    public void deleteClueSource(Long id) {
        deleteDictData(DictTypeConstants.CRM_CUSTOMER_SOURCE, id, false, true);
    }

    private List<CrmDictConfigRespVO> buildRespList(String dictType, boolean followUpType, boolean clueSource) {
        List<DictDataRespDTO> list = dictDataApi.getDictDataList(dictType).getCheckedData();
        return list.stream()
                .sorted(Comparator.comparing(DictDataRespDTO::getSort, Comparator.nullsLast(Integer::compareTo))
                        .thenComparing(DictDataRespDTO::getId, Comparator.nullsLast(Long::compareTo)))
                .map(item -> {
                    CrmDictConfigRespVO respVO = BeanUtils.toBean(item, CrmDictConfigRespVO.class);
                    respVO.setInUse(isInUse(item.getValue(), followUpType));
                    respVO.setSystemBuiltin(clueSource && CrmClueCollectSourceEnum.isSystemBuiltinDictValue(item.getValue()));
                    return respVO;
                })
                .collect(Collectors.toList());
    }

    private Long createDictData(String dictType, CrmDictConfigSaveReqVO createReqVO) {
        DictDataSaveReqDTO dictData = BeanUtils.toBean(createReqVO, DictDataSaveReqDTO.class);
        dictData.setDictType(dictType);
        dictData.setValue(generateNextValue(dictType));
        return dictDataApi.createDictData(dictData).getCheckedData();
    }

    private void updateDictData(String dictType, CrmDictConfigSaveReqVO updateReqVO, boolean clueSource) {
        DictDataRespDTO dictData = validateDictDataBelongs(dictType, updateReqVO.getId());
        validateSystemBuiltinForUpdate(clueSource, dictData.getValue());
        DictDataSaveReqDTO saveReqDTO = BeanUtils.toBean(updateReqVO, DictDataSaveReqDTO.class);
        saveReqDTO.setDictType(dictType);
        saveReqDTO.setValue(dictData.getValue());
        dictDataApi.updateDictData(saveReqDTO).checkError();
    }

    private void deleteDictData(String dictType, Long id, boolean followUpType, boolean clueSource) {
        DictDataRespDTO dictData = validateDictDataBelongs(dictType, id);
        validateSystemBuiltinForDelete(clueSource, dictData.getValue());
        validateNotInUse(dictData.getValue(), followUpType);
        dictDataApi.deleteDictData(id).checkError();
    }

    private DictDataRespDTO validateDictDataBelongs(String dictType, Long id) {
        DictDataRespDTO dictData = dictDataApi.getDictData(id).getCheckedData();
        if (dictData == null || !StrUtil.equals(dictType, dictData.getDictType())) {
            throw exception(CRM_DICT_CONFIG_NOT_EXISTS);
        }
        return dictData;
    }

    private void validateSystemBuiltinForUpdate(boolean clueSource, String value) {
        if (!clueSource || !CrmClueCollectSourceEnum.isSystemBuiltinDictValue(value)) {
            return;
        }
        if (!isSuperAdmin()) {
            throw exception(CRM_DICT_CONFIG_SYSTEM_BUILTIN);
        }
    }

    private void validateSystemBuiltinForDelete(boolean clueSource, String value) {
        if (clueSource && CrmClueCollectSourceEnum.isSystemBuiltinDictValue(value)) {
            throw exception(CRM_DICT_CONFIG_SYSTEM_BUILTIN);
        }
    }

    private void validateNotInUse(String value, boolean followUpType) {
        if (isInUse(value, followUpType)) {
            throw exception(CRM_DICT_CONFIG_IN_USE);
        }
    }

    private boolean isInUse(String value, boolean followUpType) {
        if (!NumberUtil.isInteger(value)) {
            return false;
        }
        Integer intValue = Integer.valueOf(value);
        if (followUpType) {
            return followUpRecordMapper.selectCountByType(intValue) > 0;
        }
        return clueMapper.selectCountBySource(intValue) > 0
                || customerMapper.selectCountBySource(intValue) > 0;
    }

    private boolean isSuperAdmin() {
        Long userId = getLoginUserId();
        if (userId == null) {
            return false;
        }
        PermissionCommonApi permissionApi = SpringUtil.getBean(PermissionCommonApi.class);
        return Boolean.TRUE.equals(permissionApi.hasAnyRoles(userId, RoleCodeEnum.SUPER_ADMIN.getCode()).getCheckedData());
    }

    private String generateNextValue(String dictType) {
        List<DictDataRespDTO> list = dictDataApi.getDictDataList(dictType).getCheckedData();
        int maxValue = list.stream()
                .map(DictDataRespDTO::getValue)
                .filter(NumberUtil::isInteger)
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0);
        return String.valueOf(maxValue + 1);
    }

}
