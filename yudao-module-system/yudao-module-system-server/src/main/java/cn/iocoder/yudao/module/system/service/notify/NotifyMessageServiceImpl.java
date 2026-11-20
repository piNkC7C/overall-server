package cn.iocoder.yudao.module.system.service.notify;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.notify.vo.message.NotifyMessageMyListReqVO;
import cn.iocoder.yudao.module.system.controller.admin.notify.vo.message.NotifyMessageMyPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.notify.vo.message.NotifyMessagePageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.notify.NotifyMessageDO;
import cn.iocoder.yudao.module.system.dal.dataobject.notify.NotifyTemplateDO;
import cn.iocoder.yudao.module.system.dal.mysql.notify.NotifyMessageMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.NOTIFY_MESSAGE_CREATE_TIME_RANGE_INVALID;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.NOTIFY_MESSAGE_CREATE_TIME_REQUIRED;

/**
 * 站内信 Service 实现类
 *
 * @author xrcoder
 */
@Service
@Validated
public class NotifyMessageServiceImpl implements NotifyMessageService {

    @Resource
    private NotifyMessageMapper notifyMessageMapper;

    @Override
    public Long createNotifyMessage(Long userId, Integer userType,
                                    NotifyTemplateDO template, String templateContent, Map<String, Object> templateParams) {
        NotifyMessageDO message = new NotifyMessageDO().setUserId(userId).setUserType(userType)
                .setTemplateId(template.getId()).setTemplateCode(template.getCode())
                .setTemplateType(template.getType()).setTemplateNickname(template.getNickname())
                .setTemplateContent(templateContent).setTemplateParams(templateParams)
                .setReadStatus(false).setProcessStatus(false);
        notifyMessageMapper.insert(message);
        return message.getId();
    }

    @Override
    public PageResult<NotifyMessageDO> getNotifyMessagePage(NotifyMessagePageReqVO pageReqVO) {
        return notifyMessageMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<NotifyMessageDO> getMyMyNotifyMessagePage(NotifyMessageMyPageReqVO pageReqVO, Long userId, Integer userType) {
        return notifyMessageMapper.selectPage(pageReqVO, userId, userType);
    }

    @Override
    public List<NotifyMessageDO> getMyNotifyMessageList(NotifyMessageMyListReqVO listReqVO, Long userId, Integer userType) {
        validateCreateTimeRange(listReqVO.getCreateTime());
        return notifyMessageMapper.selectList(listReqVO, userId, userType);
    }

    /**
     * 列表查询强制时间窗：必填且跨度最长 7 个自然日（含首尾）。
     * 未读数量接口不加此限制。
     */
    private void validateCreateTimeRange(LocalDateTime[] createTime) {
        if (createTime == null || createTime.length != 2 || createTime[0] == null || createTime[1] == null) {
            throw exception(NOTIFY_MESSAGE_CREATE_TIME_REQUIRED);
        }
        if (createTime[1].isBefore(createTime[0])) {
            throw exception(NOTIFY_MESSAGE_CREATE_TIME_RANGE_INVALID);
        }
        long days = ChronoUnit.DAYS.between(createTime[0].toLocalDate(), createTime[1].toLocalDate());
        if (days > 6) {
            throw exception(NOTIFY_MESSAGE_CREATE_TIME_RANGE_INVALID);
        }
    }

    @Override
    public NotifyMessageDO getNotifyMessage(Long id) {
        return notifyMessageMapper.selectById(id);
    }

    @Override
    public List<NotifyMessageDO> getUnreadNotifyMessageList(Long userId, Integer userType, Integer size) {
        return notifyMessageMapper.selectUnreadListByUserIdAndUserType(userId, userType, size);
    }

    @Override
    public Long getUnreadNotifyMessageCount(Long userId, Integer userType) {
        return notifyMessageMapper.selectUnreadCountByUserIdAndUserType(userId, userType);
    }

    @Override
    public int updateNotifyMessageRead(Collection<Long> ids, Long userId, Integer userType) {
        return notifyMessageMapper.updateListRead(ids, userId, userType);
    }

    @Override
    public int updateAllNotifyMessageRead(Long userId, Integer userType) {
        return notifyMessageMapper.updateListRead(userId, userType);
    }

    @Override
    public NotifyMessageDO getMyNotifyMessage(Long id, Long userId, Integer userType) {
        return notifyMessageMapper.selectByIdAndUser(id, userId, userType);
    }

    @Override
    public int updateNotifyMessageProcess(Collection<Long> ids, Long userId, Integer userType, boolean processStatus) {
        return notifyMessageMapper.updateListProcess(ids, userId, userType, processStatus);
    }

}
