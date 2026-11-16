package cn.iocoder.yudao.module.assistant.dal.mysql.message;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.assistant.dal.dataobject.message.AssistantMessageDO;
import cn.iocoder.yudao.module.assistant.enums.AssistantMessageStatusEnum;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssistantMessageMapper extends BaseMapperX<AssistantMessageDO> {

    default List<AssistantMessageDO> selectListByConversationId(Long conversationId) {
        return selectList(new LambdaQueryWrapperX<AssistantMessageDO>()
                .eq(AssistantMessageDO::getConversationId, conversationId)
                .orderByAsc(AssistantMessageDO::getId));
    }

    default void deleteByConversationId(Long conversationId) {
        delete(new LambdaQueryWrapperX<AssistantMessageDO>()
                .eq(AssistantMessageDO::getConversationId, conversationId));
    }

    default void stopGenerating(Long conversationId) {
        update(null, new LambdaUpdateWrapper<AssistantMessageDO>()
                .eq(AssistantMessageDO::getConversationId, conversationId)
                .eq(AssistantMessageDO::getStatus, AssistantMessageStatusEnum.GENERATING)
                .set(AssistantMessageDO::getStatus, AssistantMessageStatusEnum.STOPPED));
    }

}
