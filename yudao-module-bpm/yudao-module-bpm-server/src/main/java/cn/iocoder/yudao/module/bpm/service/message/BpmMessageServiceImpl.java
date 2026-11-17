package cn.iocoder.yudao.module.bpm.service.message;

import cn.iocoder.yudao.framework.web.config.WebProperties;
import cn.iocoder.yudao.module.bpm.convert.message.BpmMessageConvert;
import cn.iocoder.yudao.module.bpm.enums.message.BpmMessageEnum;
import cn.iocoder.yudao.module.bpm.service.message.dto.BpmMessageSendWhenProcessInstanceApproveReqDTO;
import cn.iocoder.yudao.module.bpm.service.message.dto.BpmMessageSendWhenProcessInstanceRejectReqDTO;
import cn.iocoder.yudao.module.bpm.service.message.dto.BpmMessageSendWhenTaskCreatedReqDTO;
import cn.iocoder.yudao.module.bpm.service.message.dto.BpmMessageSendWhenTaskTimeoutReqDTO;
import cn.iocoder.yudao.module.system.api.notify.NotifyMessageSendApi;
import cn.iocoder.yudao.module.system.api.notify.dto.NotifySendSingleToUserReqDTO;
import cn.iocoder.yudao.module.system.api.sms.SmsSendApi;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * BPM 消息 Service 实现类：短信 + 站内信
 *
 * @author 芋道源码
 */
@Service
@Validated
@Slf4j
public class BpmMessageServiceImpl implements BpmMessageService {

    /** 与 CRM 合同/回款审批流程 Key 对齐 */
    public static final String PROCESS_KEY_CRM_CONTRACT = "crm-contract-audit";
    public static final String PROCESS_KEY_CRM_RECEIVABLE = "crm-receivable-audit";

    public static final String NOTIFY_AUDIT_REMIND = "crm_audit_remind";
    public static final String NOTIFY_CONTRACT_PASS = "crm_contract_pass";
    public static final String NOTIFY_CONTRACT_REJECT = "crm_contract_reject";
    public static final String NOTIFY_RECEIVABLE_PASS = "crm_receivable_pass";
    public static final String NOTIFY_RECEIVABLE_REJECT = "crm_receivable_reject";

    @Resource
    private SmsSendApi smsSendApi;
    @Resource
    private NotifyMessageSendApi notifyMessageSendApi;

    @Resource
    private WebProperties webProperties;

    @Override
    public void sendMessageWhenProcessInstanceApprove(BpmMessageSendWhenProcessInstanceApproveReqDTO reqDTO) {
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("processInstanceName", reqDTO.getProcessInstanceName());
        templateParams.put("detailUrl", getProcessInstanceDetailUrl(reqDTO.getProcessInstanceId()));
        smsSendApi.sendSingleSmsToAdmin(BpmMessageConvert.INSTANCE.convert(reqDTO.getStartUserId(),
                BpmMessageEnum.PROCESS_INSTANCE_APPROVE.getSmsTemplateCode(), templateParams)).checkError();

        String notifyCode = resolvePassTemplate(reqDTO.getProcessDefinitionKey());
        if (notifyCode != null) {
            Map<String, Object> notifyParams = new HashMap<>();
            notifyParams.put("processInstanceName", reqDTO.getProcessInstanceName());
            notifyParams.put("processInstanceId", reqDTO.getProcessInstanceId());
            sendNotifyQuietly(reqDTO.getStartUserId(), notifyCode, notifyParams);
        }
    }

    @Override
    public void sendMessageWhenProcessInstanceReject(BpmMessageSendWhenProcessInstanceRejectReqDTO reqDTO) {
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("processInstanceName", reqDTO.getProcessInstanceName());
        templateParams.put("reason", reqDTO.getReason());
        templateParams.put("detailUrl", getProcessInstanceDetailUrl(reqDTO.getProcessInstanceId()));
        smsSendApi.sendSingleSmsToAdmin(BpmMessageConvert.INSTANCE.convert(reqDTO.getStartUserId(),
                BpmMessageEnum.PROCESS_INSTANCE_REJECT.getSmsTemplateCode(), templateParams)).checkError();

        String notifyCode = resolveRejectTemplate(reqDTO.getProcessDefinitionKey());
        if (notifyCode != null) {
            Map<String, Object> notifyParams = new HashMap<>();
            notifyParams.put("processInstanceName", reqDTO.getProcessInstanceName());
            notifyParams.put("reason", reqDTO.getReason());
            notifyParams.put("processInstanceId", reqDTO.getProcessInstanceId());
            sendNotifyQuietly(reqDTO.getStartUserId(), notifyCode, notifyParams);
        }
    }

    @Override
    public void sendMessageWhenTaskAssigned(BpmMessageSendWhenTaskCreatedReqDTO reqDTO) {
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("processInstanceName", reqDTO.getProcessInstanceName());
        templateParams.put("taskName", reqDTO.getTaskName());
        templateParams.put("startUserNickname", reqDTO.getStartUserNickname());
        templateParams.put("detailUrl", getProcessInstanceDetailUrl(reqDTO.getProcessInstanceId()));
        smsSendApi.sendSingleSmsToAdmin(BpmMessageConvert.INSTANCE.convert(reqDTO.getAssigneeUserId(),
                BpmMessageEnum.TASK_ASSIGNED.getSmsTemplateCode(), templateParams)).checkError();

        Map<String, Object> notifyParams = new HashMap<>();
        notifyParams.put("processInstanceName", reqDTO.getProcessInstanceName());
        notifyParams.put("taskName", reqDTO.getTaskName());
        notifyParams.put("startUserNickname", reqDTO.getStartUserNickname());
        notifyParams.put("processInstanceId", reqDTO.getProcessInstanceId());
        sendNotifyQuietly(reqDTO.getAssigneeUserId(), NOTIFY_AUDIT_REMIND, notifyParams);
    }

    @Override
    public void sendMessageWhenTaskTimeout(BpmMessageSendWhenTaskTimeoutReqDTO reqDTO) {
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("processInstanceName", reqDTO.getProcessInstanceName());
        templateParams.put("taskName", reqDTO.getTaskName());
        templateParams.put("detailUrl", getProcessInstanceDetailUrl(reqDTO.getProcessInstanceId()));
        smsSendApi.sendSingleSmsToAdmin(BpmMessageConvert.INSTANCE.convert(reqDTO.getAssigneeUserId(),
                BpmMessageEnum.TASK_TIMEOUT.getSmsTemplateCode(), templateParams)).checkError();
    }

    private void sendNotifyQuietly(Long userId, String templateCode, Map<String, Object> params) {
        try {
            notifyMessageSendApi.sendSingleMessageToAdmin(new NotifySendSingleToUserReqDTO()
                    .setUserId(userId)
                    .setTemplateCode(templateCode)
                    .setTemplateParams(params)).checkError();
        } catch (Exception ex) {
            log.warn("[sendNotifyQuietly][userId({}) template({}) 站内信发送失败]", userId, templateCode, ex);
        }
    }

    static String resolvePassTemplate(String processDefinitionKey) {
        if (Objects.equals(processDefinitionKey, PROCESS_KEY_CRM_CONTRACT)) {
            return NOTIFY_CONTRACT_PASS;
        }
        if (Objects.equals(processDefinitionKey, PROCESS_KEY_CRM_RECEIVABLE)) {
            return NOTIFY_RECEIVABLE_PASS;
        }
        return null;
    }

    static String resolveRejectTemplate(String processDefinitionKey) {
        if (Objects.equals(processDefinitionKey, PROCESS_KEY_CRM_CONTRACT)) {
            return NOTIFY_CONTRACT_REJECT;
        }
        if (Objects.equals(processDefinitionKey, PROCESS_KEY_CRM_RECEIVABLE)) {
            return NOTIFY_RECEIVABLE_REJECT;
        }
        return null;
    }

    private String getProcessInstanceDetailUrl(String taskId) {
        return webProperties.getAdminUi().getUrl() + "/bpm/process-instance/detail?id=" + taskId;
    }

}
