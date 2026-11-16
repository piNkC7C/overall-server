package cn.iocoder.yudao.module.assistant.enums;

/**
 * 助手消息状态
 */
public interface AssistantMessageStatusEnum {

    /** 生成中 */
    int GENERATING = 0;
    /** 完成 */
    int DONE = 1;
    /** 失败 */
    int ERROR = 2;
    /** 已停止 */
    int STOPPED = 3;
    /** 等待用户确认写操作 */
    int AWAITING = 4;

}
