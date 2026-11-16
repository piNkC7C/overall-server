package cn.iocoder.yudao.module.assistant.dal.dataobject.conversation;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * AI 助手对话
 */
@TableName("assistant_conversation")
@KeySequence("assistant_conversation_seq")
@Data
@EqualsAndHashCode(callSuper = true)
public class AssistantConversationDO extends TenantBaseDO {

    @TableId
    private Long id;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 标题，取首条用户消息
     */
    private String title;
    /**
     * 导航预览，取首条用户消息
     */
    private String preview;
    /**
     * CRM 智能体会话 id（算法侧），仅后端使用
     */
    private String agentSessionId;

}
