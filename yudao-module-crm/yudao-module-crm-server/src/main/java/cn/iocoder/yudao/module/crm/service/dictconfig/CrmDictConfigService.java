package cn.iocoder.yudao.module.crm.service.dictconfig;

import cn.iocoder.yudao.module.crm.controller.admin.dictconfig.vo.CrmDictConfigRespVO;
import cn.iocoder.yudao.module.crm.controller.admin.dictconfig.vo.CrmDictConfigSaveReqVO;

import java.util.List;

/**
 * CRM 字典枚举配置 Service
 */
public interface CrmDictConfigService {

    List<CrmDictConfigRespVO> getFollowUpTypeList();

    List<CrmDictConfigRespVO> getClueSourceList();

    Long createFollowUpType(CrmDictConfigSaveReqVO createReqVO);

    void updateFollowUpType(CrmDictConfigSaveReqVO updateReqVO);

    void deleteFollowUpType(Long id);

    Long createClueSource(CrmDictConfigSaveReqVO createReqVO);

    void updateClueSource(CrmDictConfigSaveReqVO updateReqVO);

    void deleteClueSource(Long id);

}
