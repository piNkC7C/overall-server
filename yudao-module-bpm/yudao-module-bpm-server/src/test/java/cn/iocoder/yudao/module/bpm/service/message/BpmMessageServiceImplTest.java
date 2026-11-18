package cn.iocoder.yudao.module.bpm.service.message;

import cn.iocoder.yudao.framework.test.core.ut.BaseMockitoUnitTest;
import cn.iocoder.yudao.framework.web.config.WebProperties;
import cn.iocoder.yudao.module.bpm.enums.message.BpmMessageEnum;
import cn.iocoder.yudao.module.bpm.service.message.dto.BpmMessageSendWhenProcessInstanceApproveReqDTO;
import cn.iocoder.yudao.module.bpm.service.message.dto.BpmMessageSendWhenProcessInstanceRejectReqDTO;
import cn.iocoder.yudao.module.bpm.service.message.dto.BpmMessageSendWhenTaskCreatedReqDTO;
import cn.iocoder.yudao.module.system.api.notify.NotifyMessageSendApi;
import cn.iocoder.yudao.module.system.api.notify.dto.NotifySendSingleToUserReqDTO;
import cn.iocoder.yudao.module.system.api.sms.SmsSendApi;
import cn.iocoder.yudao.module.system.api.sms.dto.send.SmsSendSingleToUserReqDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.module.bpm.service.message.BpmMessageServiceImpl.NOTIFY_AUDIT_REMIND;
import static cn.iocoder.yudao.module.bpm.service.message.BpmMessageServiceImpl.NOTIFY_CONTRACT_PASS;
import static cn.iocoder.yudao.module.bpm.service.message.BpmMessageServiceImpl.NOTIFY_CONTRACT_REJECT;
import static cn.iocoder.yudao.module.bpm.service.message.BpmMessageServiceImpl.NOTIFY_RECEIVABLE_PASS;
import static cn.iocoder.yudao.module.bpm.service.message.BpmMessageServiceImpl.PROCESS_KEY_CRM_CONTRACT;
import static cn.iocoder.yudao.module.bpm.service.message.BpmMessageServiceImpl.PROCESS_KEY_CRM_RECEIVABLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * {@link BpmMessageServiceImpl} 的单元测试
 */
public class BpmMessageServiceImplTest extends BaseMockitoUnitTest {

    @InjectMocks
    private BpmMessageServiceImpl messageService;

    @Mock
    private SmsSendApi smsSendApi;
    @Mock
    private NotifyMessageSendApi notifyMessageSendApi;
    @Mock
    private WebProperties webProperties;
    @Mock
    private WebProperties.Ui adminUi;

    @BeforeEach
    public void setUp() {
        lenient().when(webProperties.getAdminUi()).thenReturn(adminUi);
        lenient().when(adminUi.getUrl()).thenReturn("http://localhost:48080");
        lenient().when(smsSendApi.sendSingleSmsToAdmin(any())).thenReturn(success(1L));
        lenient().when(notifyMessageSendApi.sendSingleMessageToAdmin(any())).thenReturn(success(1L));
    }

    @Test
    public void testSendMessageWhenProcessInstanceApprove_contract_sendsNotify() {
        BpmMessageSendWhenProcessInstanceApproveReqDTO reqDTO = new BpmMessageSendWhenProcessInstanceApproveReqDTO()
                .setProcessInstanceId("process-instance-1").setProcessInstanceName("合同审批")
                .setStartUserId(1L).setProcessDefinitionKey(PROCESS_KEY_CRM_CONTRACT);

        messageService.sendMessageWhenProcessInstanceApprove(reqDTO);

        SmsSendSingleToUserReqDTO smsReqDTO = captureSmsRequest();
        assertEquals(BpmMessageEnum.PROCESS_INSTANCE_APPROVE.getSmsTemplateCode(), smsReqDTO.getTemplateCode());
        NotifySendSingleToUserReqDTO notifyReq = captureNotifyRequest();
        assertEquals(NOTIFY_CONTRACT_PASS, notifyReq.getTemplateCode());
        assertEquals("Contract approval", notifyReq.getTemplateParams().get("processInstanceName"));
    }

    @Test
    public void testSendMessageWhenProcessInstanceApprove_other_skipNotify() {
        BpmMessageSendWhenProcessInstanceApproveReqDTO reqDTO = new BpmMessageSendWhenProcessInstanceApproveReqDTO()
                .setProcessInstanceId("process-instance-1").setProcessInstanceName("请假申请")
                .setStartUserId(1L).setProcessDefinitionKey("oa-leave");

        messageService.sendMessageWhenProcessInstanceApprove(reqDTO);

        verify(smsSendApi).sendSingleSmsToAdmin(any());
        verify(notifyMessageSendApi, never()).sendSingleMessageToAdmin(any());
    }

    @Test
    public void testSendMessageWhenProcessInstanceReject_contract_sendsNotify() {
        BpmMessageSendWhenProcessInstanceRejectReqDTO reqDTO = new BpmMessageSendWhenProcessInstanceRejectReqDTO()
                .setProcessInstanceId("process-instance-1").setProcessInstanceName("合同审批")
                .setStartUserId(1L).setReason("金额不符").setProcessDefinitionKey(PROCESS_KEY_CRM_CONTRACT);

        messageService.sendMessageWhenProcessInstanceReject(reqDTO);

        NotifySendSingleToUserReqDTO notifyReq = captureNotifyRequest();
        assertEquals(NOTIFY_CONTRACT_REJECT, notifyReq.getTemplateCode());
        assertEquals("金额不符", notifyReq.getTemplateParams().get("reason"));
    }

    @Test
    public void testSendMessageWhenTaskAssigned_sendsAuditRemind() {
        BpmMessageSendWhenTaskCreatedReqDTO reqDTO = new BpmMessageSendWhenTaskCreatedReqDTO()
                .setProcessInstanceId("pi-1").setProcessInstanceName("回款审批")
                .setStartUserId(2L).setStartUserNickname("张三")
                .setTaskId("task-1").setTaskName("财务审批").setAssigneeUserId(9L);

        messageService.sendMessageWhenTaskAssigned(reqDTO);

        NotifySendSingleToUserReqDTO notifyReq = captureNotifyRequest();
        assertEquals(NOTIFY_AUDIT_REMIND, notifyReq.getTemplateCode());
        assertEquals(9L, notifyReq.getUserId());
        // 旧中文流程名规范化；非标准节点名保持原样
        assertEquals("Payment approval", notifyReq.getTemplateParams().get("processInstanceName"));
        assertEquals("财务审批", notifyReq.getTemplateParams().get("taskName"));
        assertEquals("张三", notifyReq.getTemplateParams().get("startUserNickname"));
    }

    @Test
    public void testSendMessageWhenTaskAssigned_smsFailureStillSendsNotify() {
        when(smsSendApi.sendSingleSmsToAdmin(any())).thenThrow(new RuntimeException("sms template missing"));
        BpmMessageSendWhenTaskCreatedReqDTO reqDTO = new BpmMessageSendWhenTaskCreatedReqDTO()
                .setProcessInstanceId("pi-2").setProcessInstanceName("合同审批")
                .setProcessDefinitionKey(PROCESS_KEY_CRM_CONTRACT)
                .setStartUserId(1L).setStartUserNickname("yshop")
                .setTaskId("task-2").setTaskName("审批人").setAssigneeUserId(249L);

        messageService.sendMessageWhenTaskAssigned(reqDTO);

        NotifySendSingleToUserReqDTO notifyReq = captureNotifyRequest();
        assertEquals(NOTIFY_AUDIT_REMIND, notifyReq.getTemplateCode());
        assertEquals(249L, notifyReq.getUserId());
        assertEquals("Contract approval", notifyReq.getTemplateParams().get("processInstanceName"));
        assertEquals("Approver", notifyReq.getTemplateParams().get("taskName"));
        assertEquals("yshop", notifyReq.getTemplateParams().get("startUserNickname"));
    }

    @Test
    public void testResolveTemplates() {
        assertEquals(NOTIFY_CONTRACT_PASS, BpmMessageServiceImpl.resolvePassTemplate(PROCESS_KEY_CRM_CONTRACT));
        assertEquals(NOTIFY_RECEIVABLE_PASS, BpmMessageServiceImpl.resolvePassTemplate(PROCESS_KEY_CRM_RECEIVABLE));
        assertNull(BpmMessageServiceImpl.resolvePassTemplate("other"));
        assertEquals(NOTIFY_CONTRACT_REJECT, BpmMessageServiceImpl.resolveRejectTemplate(PROCESS_KEY_CRM_CONTRACT));
        assertEquals("Contract approval",
                BpmMessageServiceImpl.resolveProcessInstanceLabel(PROCESS_KEY_CRM_CONTRACT, "合同审批"));
        assertEquals("Payment approval",
                BpmMessageServiceImpl.resolveProcessInstanceLabel(null, "回款审批"));
        assertEquals("Approver", BpmMessageServiceImpl.resolveTaskLabel("审批"));
        assertEquals("Approver", BpmMessageServiceImpl.resolveTaskLabel("审批人"));
    }

    private SmsSendSingleToUserReqDTO captureSmsRequest() {
        ArgumentCaptor<SmsSendSingleToUserReqDTO> captor = ArgumentCaptor.forClass(SmsSendSingleToUserReqDTO.class);
        verify(smsSendApi).sendSingleSmsToAdmin(captor.capture());
        return captor.getValue();
    }

    private NotifySendSingleToUserReqDTO captureNotifyRequest() {
        ArgumentCaptor<NotifySendSingleToUserReqDTO> captor = ArgumentCaptor.forClass(NotifySendSingleToUserReqDTO.class);
        verify(notifyMessageSendApi).sendSingleMessageToAdmin(captor.capture());
        return captor.getValue();
    }

}
