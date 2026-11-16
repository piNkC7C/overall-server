package cn.iocoder.yudao.module.assistant.dal.dataobject.message;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * AI 助手消息
 */
@TableName("assistant_message")
@KeySequence("assistant_message_seq")
@Data
@EqualsAndHashCode(callSuper = true)
public class AssistantMessageDO extends TenantBaseDO {

    @TableId
    private Long id;
    /**
     * 对话编号
     */
    private Long conversationId;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 角色，见 {@link cn.iocoder.yudao.module.assistant.enums.AssistantMessageRoleEnum}
     */
    private String role;
    /**
     * 正文
     */
    private String content;
    /**
     * 思考过程
     */
    private String reasoning;
    /**
     * 状态，见 {@link cn.iocoder.yudao.module.assistant.enums.AssistantMessageStatusEnum}
     */
    private Integer status;
    /**
     * 附件 JSON
     */
    private String files;
    /**
     * 流式扩展 JSON：segments / approval 等
     */
    private String payload;

}
