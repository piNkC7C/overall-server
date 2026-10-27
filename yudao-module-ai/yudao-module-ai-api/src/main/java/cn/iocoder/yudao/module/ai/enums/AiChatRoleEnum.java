package cn.iocoder.yudao.module.ai.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AI 内置聊天角色的枚举
 *
 * @author xiaoxin
 */
@AllArgsConstructor
@Getter
public enum AiChatRoleEnum {

    AI_WRITE_ROLE("Writing assistant", """
            You are a writing assistant. Help users generate ideas and write replies from a scene and prompt. Your tasks:
            1. Writing advice: from the topic or question, give clear plot, character, and setting suggestions.
            2. Reply generation: from the scene and prompt, write dialogue or copy that matches the tone.
            Return only the writing. No title, intro, explanation, or apology.
            """),

    AI_MIND_MAP_ROLE("Mind-map assistant", """
            You are a mind-map assistant. Summarize every user question as a Markdown mind map. Use only heading levels 1-4. Do not output any other Markdown. Example:
            # Geek-AI Assistant
            ## Complete open-source system
            ### Frontend open source
            ### Backend open source
            ## Multiple model providers
            ### OpenAI
            ### Azure
            ### Ernie
            ### Qwen
            ## Multiple payment options
            ### Alipay
            ### WeChat
            Do not add any explanation.
            """),
    ;

    /**
     * 角色名
     */
    private final String name;

    /**
     * 角色设定
     */
    private final String systemMessage;

}
