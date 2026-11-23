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

    /** 审批站内信：发送人 OA（入口 OA办公）；code 用 oa_* */
    public static final String NOTIFY_AUDIT_REMIND = "oa_audit_remind";
    public static final String NOTIFY_CONTRACT_PASS = "oa_contract_pass";
    public static final String NOTIFY_CONTRACT_REJECT = "oa_contract_reject";
    public static final String NOTIFY_RECEIVABLE_PASS = "oa_receivable_pass";
    public static final String NOTIFY_RECEIVABLE_REJECT = "oa_receivable_reject";

    /** 站内信 / glossary 用的英文流程名（与 CrmBpmModelInitializer 对齐） */
    public static final String LABEL_CONTRACT_APPROVAL = "Contract approval";
    public static final String LABEL_PAYMENT_APPROVAL = "Payment approval";
    public static final String LABEL_APPROVER = "Approver";

    @Resource
    private SmsSendApi smsSendApi;
    @Resource
    private NotifyMessageSendApi notifyMessageSendApi;

    @Resource
    private WebProperties webProperties;

    @Override
    public void sendMessageWhenProcessInstanceApprove(BpmMessageSendWhenProcessInstanceApproveReqDTO reqDTO) {
        String processLabel = resolveProcessInstanceLabel(reqDTO.getProcessDefinitionKey(),
                reqDTO.getProcessInstanceName());
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("processInstanceName", processLabel);
        templateParams.put("detailUrl", getProcessInstanceDetailUrl(reqDTO.getProcessInstanceId()));
        // 短信失败不阻断站内信（审批结果提醒给发起人）
        sendSmsQuietly(reqDTO.getStartUserId(), BpmMessageEnum.PROCESS_INSTANCE_APPROVE.getSmsTemplateCode(),
                templateParams);

        String notifyCode = resolvePassTemplate(reqDTO.getProcessDefinitionKey());
        if (notifyCode != null) {
            Map<String, Object> notifyParams = new HashMap<>();
            notifyParams.put("processInstanceName", processLabel);
            notifyParams.put("processInstanceId", reqDTO.getProcessInstanceId());
            notifyParams.put("processDefinitionKey", reqDTO.getProcessDefinitionKey());
            sendNotifyQuietly(reqDTO.getStartUserId(), notifyCode, notifyParams);
        }
    }

    @Override
    public void sendMessageWhenProcessInstanceReject(BpmMessageSendWhenProcessInstanceRejectReqDTO reqDTO) {
        String processLabel = resolveProcessInstanceLabel(reqDTO.getProcessDefinitionKey(),
                reqDTO.getProcessInstanceName());
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("processInstanceName", processLabel);
        templateParams.put("reason", reqDTO.getReason());
        templateParams.put("detailUrl", getProcessInstanceDetailUrl(reqDTO.getProcessInstanceId()));
        sendSmsQuietly(reqDTO.getStartUserId(), BpmMessageEnum.PROCESS_INSTANCE_REJECT.getSmsTemplateCode(),
                templateParams);

        String notifyCode = resolveRejectTemplate(reqDTO.getProcessDefinitionKey());
        if (notifyCode != null) {
            Map<String, Object> notifyParams = new HashMap<>();
            notifyParams.put("processInstanceName", processLabel);
            notifyParams.put("reason", reqDTO.getReason());
            notifyParams.put("processInstanceId", reqDTO.getProcessInstanceId());
            notifyParams.put("processDefinitionKey", reqDTO.getProcessDefinitionKey());
            sendNotifyQuietly(reqDTO.getStartUserId(), notifyCode, notifyParams);
        }
    }

    @Override
    public void sendMessageWhenTaskAssigned(BpmMessageSendWhenTaskCreatedReqDTO reqDTO) {
        String processLabel = resolveProcessInstanceLabel(reqDTO.getProcessDefinitionKey(),
                reqDTO.getProcessInstanceName());
        String taskLabel = resolveTaskLabel(reqDTO.getTaskName());
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("processInstanceName", processLabel);
        templateParams.put("taskName", taskLabel);
        templateParams.put("startUserNickname", reqDTO.getStartUserNickname());
        templateParams.put("detailUrl", getProcessInstanceDetailUrl(reqDTO.getProcessInstanceId()));
        // 短信失败不阻断站内信（待审批提醒给审批人，一任务一条）
        sendSmsQuietly(reqDTO.getAssigneeUserId(), BpmMessageEnum.TASK_ASSIGNED.getSmsTemplateCode(), templateParams);

        Map<String, Object> notifyParams = new HashMap<>();
        notifyParams.put("processInstanceName", processLabel);
        notifyParams.put("taskName", taskLabel);
        notifyParams.put("startUserNickname", reqDTO.getStartUserNickname());
        notifyParams.put("processInstanceId", reqDTO.getProcessInstanceId());
        notifyParams.put("processDefinitionKey", reqDTO.getProcessDefinitionKey());
        sendNotifyQuietly(reqDTO.getAssigneeUserId(), NOTIFY_AUDIT_REMIND, notifyParams);
    }

    @Override
    public void sendMessageWhenTaskTimeout(BpmMessageSendWhenTaskTimeoutReqDTO reqDTO) {
        String processLabel = resolveProcessInstanceLabel(null, reqDTO.getProcessInstanceName());
        String taskLabel = resolveTaskLabel(reqDTO.getTaskName());
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("processInstanceName", processLabel);
        templateParams.put("taskName", taskLabel);
        templateParams.put("detailUrl", getProcessInstanceDetailUrl(reqDTO.getProcessInstanceId()));
        sendSmsQuietly(reqDTO.getAssigneeUserId(), BpmMessageEnum.TASK_TIMEOUT.getSmsTemplateCode(), templateParams);
    }

    private void sendSmsQuietly(Long userId, String templateCode, Map<String, Object> params) {
        try {
            smsSendApi.sendSingleSmsToAdmin(BpmMessageConvert.INSTANCE.convert(userId, templateCode, params))
                    .checkError();
        } catch (Exception ex) {
            log.warn("[sendSmsQuietly][userId({}) template({}) 短信发送失败，已忽略]", userId, templateCode, ex);
        }
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

    /**
     * 流程名 → 英文占位符（前端 glossary 再出中文）。优先 processDefinitionKey，兼容旧中文名。
     */
    static String resolveProcessInstanceLabel(String processDefinitionKey, String processInstanceName) {
        if (Objects.equals(processDefinitionKey, PROCESS_KEY_CRM_CONTRACT)
                || Objects.equals(processInstanceName, "合同审批")
                || Objects.equals(processInstanceName, LABEL_CONTRACT_APPROVAL)) {
            return LABEL_CONTRACT_APPROVAL;
        }
        if (Objects.equals(processDefinitionKey, PROCESS_KEY_CRM_RECEIVABLE)
                || Objects.equals(processInstanceName, "回款审批")
                || Objects.equals(processInstanceName, LABEL_PAYMENT_APPROVAL)) {
            return LABEL_PAYMENT_APPROVAL;
        }
        return processInstanceName;
    }

    /**
     * 审批节点名 → 英文 Approver（兼容旧「审批」「审批人」）
     */
    static String resolveTaskLabel(String taskName) {
        if (Objects.equals(taskName, "审批")
                || Objects.equals(taskName, "审批人")
                || Objects.equals(taskName, LABEL_APPROVER)) {
            return LABEL_APPROVER;
        }
        return taskName;
    }

    private String getProcessInstanceDetailUrl(String taskId) {
        return webProperties.getAdminUi().getUrl() + "/bpm/process-instance/detail?id=" + taskId;
    }

}
