package cn.iocoder.yudao.module.assistant.service.message;

import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantDecisionReqVO;
import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantMessageRespVO;
import cn.iocoder.yudao.module.assistant.controller.admin.message.vo.AssistantMessageSendReqVO;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

public interface AssistantMessageService {

    List<AssistantMessageRespVO> getMyList(Long conversationId, Long userId);

    SseEmitter sendStream(AssistantMessageSendReqVO reqVO, Long userId, String accessToken, String language);

    SseEmitter decisionStream(AssistantDecisionReqVO reqVO, Long userId, String accessToken, String language);

    void stopMy(Long conversationId, Long userId);

}
