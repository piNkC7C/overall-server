package cn.iocoder.yudao.module.assistant.service.conversation;

import cn.iocoder.yudao.module.assistant.dal.dataobject.conversation.AssistantConversationDO;
import cn.iocoder.yudao.module.assistant.dal.mysql.conversation.AssistantConversationMapper;
import cn.iocoder.yudao.module.assistant.dal.mysql.message.AssistantMessageMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.assistant.enums.ErrorCodeConstants.CONVERSATION_NOT_FOUND;

@Service
@Validated
public class AssistantConversationServiceImpl implements AssistantConversationService {

    @Resource
    private AssistantConversationMapper conversationMapper;
    @Resource
    private AssistantMessageMapper messageMapper;

    @Override
    public List<AssistantConversationDO> getMyList(Long userId) {
        return conversationMapper.selectMyList(userId);
    }

    @Override
    public void deleteMy(Long id, Long userId) {
        validateMy(id, userId);
        messageMapper.deleteByConversationId(id);
        conversationMapper.deleteById(id);
    }

    @Override
    public AssistantConversationDO validateMy(Long id, Long userId) {
        AssistantConversationDO conversation = conversationMapper.selectById(id);
        if (conversation == null || !userId.equals(conversation.getUserId())) {
            throw exception(CONVERSATION_NOT_FOUND);
        }
        return conversation;
    }

}
