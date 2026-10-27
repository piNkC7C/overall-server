package cn.iocoder.yudao.module.ai.enums.model;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * AI 模型平台
 *
 * @author fansili
 */
@Getter
@AllArgsConstructor
public enum AiPlatformEnum implements ArrayValuable<String> {

    // ========== 国内平台 ==========

    TONG_YI("TongYi", "Qwen"), // 阿里
    YI_YAN("YiYan", "Ernie"), // 百度
    DEEP_SEEK("DeepSeek", "DeepSeek"), // DeepSeek
    ZHI_PU("ZhiPu", "Zhipu"), // 智谱 AI
    XING_HUO("XingHuo", "Spark"), // 讯飞
    DOU_BAO("DouBao", "Doubao"), // 字节
    HUN_YUAN("HunYuan", "Hunyuan"), // 腾讯
    SILICON_FLOW("SiliconFlow", "SiliconFlow"), // 硅基流动
    MINI_MAX("MiniMax", "MiniMax"), // 稀宇科技
    MOONSHOT("Moonshot", "Moonshot"), // KIMI
    BAI_CHUAN("BaiChuan", "Baichuan"), // 百川智能
    STEP_FUN("StepFun", "StepFun"), // 阶跃星辰

    // ========== 国外平台 ==========

    OPENAI("OpenAI", "OpenAI"), // OpenAI 官方
    AZURE_OPENAI("AzureOpenAI", "AzureOpenAI"), // OpenAI 微软
    ANTHROPIC("Anthropic", "Anthropic"), // Anthropic Claude
    GEMINI("Gemini", "Gemini"), // 谷歌 Gemini
    OLLAMA("Ollama", "Ollama"),

    STABLE_DIFFUSION("StableDiffusion", "StableDiffusion"), // Stability AI
    MIDJOURNEY("Midjourney", "Midjourney"), // Midjourney
    SUNO("Suno", "Suno"), // Suno AI
    GROK("Grok", "Grok"), // Grok

    ;

    /**
     * 平台
     */
    private final String platform;
    /**
     * 平台名
     */
    private final String name;

    public static final String[] ARRAYS = Arrays.stream(values()).map(AiPlatformEnum::getPlatform).toArray(String[]::new);

    public static AiPlatformEnum validatePlatform(String platform) {
        for (AiPlatformEnum platformEnum : AiPlatformEnum.values()) {
            if (platformEnum.getPlatform().equals(platform)) {
                return platformEnum;
            }
        }
        throw new IllegalArgumentException("Invalid platform: " + platform);
    }

    @Override
    public String[] array() {
        return ARRAYS;
    }

}
