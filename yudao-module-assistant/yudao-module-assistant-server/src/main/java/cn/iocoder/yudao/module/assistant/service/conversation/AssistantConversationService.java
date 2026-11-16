package cn.iocoder.yudao.module.assistant.service.conversation;

import cn.iocoder.yudao.module.assistant.dal.dataobject.conversation.AssistantConversationDO;

import java.util.List;

public interface AssistantConversationService {

    List<AssistantConversationDO> getMyList(Long userId);

    void deleteMy(Long id, Long userId);

    AssistantConversationDO validateMy(Long id, Long userId);

}
