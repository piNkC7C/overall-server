package cn.iocoder.yudao.module.assistant.dal.mysql.conversation;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.assistant.dal.dataobject.conversation.AssistantConversationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssistantConversationMapper extends BaseMapperX<AssistantConversationDO> {

    default List<AssistantConversationDO> selectMyList(Long userId) {
        return selectList(new LambdaQueryWrapperX<AssistantConversationDO>()
                .eq(AssistantConversationDO::getUserId, userId)
                .orderByDesc(AssistantConversationDO::getUpdateTime)
                .orderByDesc(AssistantConversationDO::getId)
                .last("LIMIT 100"));
    }

}
