package cn.iocoder.yudao.module.oa.service.schedule;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.lenient;
import org.junit.jupiter.api.BeforeEach;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.security.core.LoginUser;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import cn.iocoder.yudao.module.oa.controller.admin.schedule.vo.OaSchedulePageReqVO;
import cn.iocoder.yudao.module.oa.controller.admin.schedule.vo.OaScheduleSaveReqVO;
import cn.iocoder.yudao.module.oa.dal.dataobject.schedule.OaScheduleDO;
import cn.iocoder.yudao.module.oa.dal.dataobject.schedule.OaScheduleParticipantDO;
import cn.iocoder.yudao.module.oa.dal.mysql.schedule.OaScheduleMapper;
import cn.iocoder.yudao.module.oa.dal.mysql.schedule.OaScheduleParticipantMapper;
import cn.iocoder.yudao.module.oa.enums.schedule.OaPriorityEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaScheduleTypeEnum;
import cn.iocoder.yudao.module.oa.framework.config.OaProperties;
import cn.iocoder.yudao.module.system.api.notify.NotifyMessageSendApi;
import cn.iocoder.yudao.module.system.api.notify.dto.NotifySendSingleToUserReqDTO;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.context.annotation.Import;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.module.oa.enums.ErrorCodeConstants.SCHEDULE_ACCESS_DENIED;
import static cn.iocoder.yudao.module.oa.enums.ErrorCodeConstants.SCHEDULE_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

/**
 * {@link OaScheduleServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import({OaScheduleServiceImpl.class, OaProperties.class})
public class OaScheduleServiceImplTest extends BaseDbUnitTest {

    @Resource
    private OaScheduleServiceImpl scheduleService;

    @Resource
    private OaScheduleMapper scheduleMapper;
    @Resource
    private OaScheduleParticipantMapper scheduleParticipantMapper;

    @MockitoBean
    private AdminUserApi adminUserApi;
    @MockitoBean
    private NotifyMessageSendApi notifyMessageSendApi;

    @AfterEach
    public void tearDown() {
        SecurityContextHolder.clearContext();
    }

    @BeforeEach
    public void setUpCloudApiMocks() {
        lenient().when(adminUserApi.validateUserList(anyCollection())).thenReturn(success(true));
        lenient().when(notifyMessageSendApi.sendSingleMessageToAdmin(any())).thenReturn(success(1L));
    }

    @Test
    public void testGetSchedulePage_overlapIncludesPreviousMonth() {
        // mock 数据
        Long userId = randomLongId();
        OaScheduleDO crossing = buildScheduleDO(userId).setStartTime(LocalDateTime.of(2026, 8, 30, 9, 0))
                .setEndTime(LocalDateTime.of(2026, 9, 2, 18, 0));
        scheduleMapper.insert(crossing);
        scheduleMapper.insert(buildScheduleDO(userId).setStartTime(LocalDateTime.of(2026, 8, 29, 9, 0))
                .setEndTime(LocalDateTime.of(2026, 8, 31, 23, 59)));
        // 准备参数
        OaSchedulePageReqVO reqVO = new OaSchedulePageReqVO();
        reqVO.setIncludeMine(true);
        reqVO.setIncludeReceived(false);
        reqVO.setOverlapTime(new LocalDateTime[]{LocalDateTime.of(2026, 9, 1, 0, 0), LocalDateTime.of(2026, 9, 30, 23, 59)});

        // 调用
        PageResult<OaScheduleDO> result = scheduleService.getSchedulePage(reqVO, userId);
        // 断言
        assertEquals(1L, result.getTotal());
        assertEquals(crossing.getId(), CollUtil.getFirst(result.getList()).getId());
    }

    @Test
    public void testSchedulePages_onlyMine() {
        // mock 数据：他人日程即使有历史参与关系也不返回
        Long userId = randomLongId();
        OaScheduleDO mine = buildScheduleDO(userId).setTitle("我的日程");
        scheduleMapper.insert(mine);
        OaScheduleDO received = buildScheduleDO(randomLongId()).setTitle("收到日程");
        scheduleMapper.insert(received);
        scheduleParticipantMapper.insert(new OaScheduleParticipantDO().setScheduleId(received.getId()).setUserId(userId));
        OaSchedulePageReqVO reqVO = new OaSchedulePageReqVO();

        assertEquals(mine.getId(), CollUtil.getFirst(scheduleService.getMySchedulePage(reqVO, userId).getList()).getId());
        assertEquals(1L, scheduleService.getMySchedulePage(reqVO, userId).getTotal());
        assertEquals(0L, scheduleService.getReceivedSchedulePage(reqVO, userId).getTotal());
        assertEquals(1L, scheduleService.getSchedulePage(reqVO, userId).getTotal());
    }

    @Test
    public void testGetSchedulePage_onlyOwnerRegardlessOfFlags() {
        Long userId = randomLongId();
        OaScheduleDO mine = buildScheduleDO(userId).setStartTime(LocalDateTime.of(2026, 9, 9, 9, 0));
        scheduleMapper.insert(mine);
        OaScheduleDO received = buildScheduleDO(randomLongId()).setStartTime(LocalDateTime.of(2026, 9, 10, 9, 0));
        scheduleMapper.insert(received);
        scheduleParticipantMapper.insert(new OaScheduleParticipantDO().setScheduleId(received.getId()).setUserId(userId));

        OaSchedulePageReqVO reqVO = new OaSchedulePageReqVO();
        reqVO.setIncludeMine(true);
        reqVO.setIncludeReceived(true);
        assertEquals(1L, scheduleService.getSchedulePage(reqVO, userId).getTotal());
        assertEquals(mine.getId(), CollUtil.getFirst(scheduleService.getSchedulePage(reqVO, userId).getList()).getId());

        // 忽略 include 开关，始终本人
        reqVO.setIncludeMine(false);
        reqVO.setIncludeReceived(false);
        assertEquals(1L, scheduleService.getSchedulePage(reqVO, userId).getTotal());
    }

    @Test
    public void testCreateSchedule_success() {
        Long userId = randomLongId();
        OaScheduleSaveReqVO reqVO = buildScheduleSaveReqVO();

        SecurityFrameworkUtils.setLoginUser(new LoginUser().setId(userId), new MockHttpServletRequest());
        Long scheduleId = scheduleService.createSchedule(reqVO, userId);

        OaScheduleDO schedule = scheduleMapper.selectById(scheduleId);
        assertNotNull(schedule);
        assertEquals(userId.toString(), schedule.getCreator());
        assertEquals(reqVO.getTitle(), schedule.getTitle());
        assertTrue(CollUtil.isEmpty(scheduleParticipantMapper.selectListByScheduleIds(Collections.singleton(scheduleId))));
    }

    @Test
    public void testGetSchedule_nonOwnerDenied() {
        Long ownerUserId = randomLongId();
        Long otherUserId = randomLongId();
        OaScheduleDO schedule = buildScheduleDO(ownerUserId);
        scheduleMapper.insert(schedule);
        scheduleParticipantMapper.insert(new OaScheduleParticipantDO().setScheduleId(schedule.getId())
                .setUserId(otherUserId));

        assertServiceException(() -> scheduleService.getSchedule(schedule.getId(), otherUserId), SCHEDULE_ACCESS_DENIED);
        assertEquals(schedule.getId(), scheduleService.getSchedule(schedule.getId(), ownerUserId).getId());
    }

    @Test
    public void testUpdateSchedule_notOwner() {
        OaScheduleDO schedule = buildScheduleDO(randomLongId());
        scheduleMapper.insert(schedule);
        OaScheduleSaveReqVO reqVO = buildScheduleSaveReqVO().setId(schedule.getId());

        assertServiceException(() -> scheduleService.updateSchedule(reqVO, randomLongId()), SCHEDULE_ACCESS_DENIED);
    }

    @Test
    public void testUpdateSchedule_resetReminder() {
        Long userId = randomLongId();
        OaScheduleDO schedule = buildScheduleDO(userId).setReminded(true);
        scheduleMapper.insert(schedule);
        OaScheduleSaveReqVO reqVO = buildScheduleSaveReqVO().setId(schedule.getId());

        scheduleService.updateSchedule(reqVO, userId);

        assertFalse(scheduleMapper.selectById(schedule.getId()).getReminded());
        assertEquals(userId.toString(), scheduleMapper.selectById(schedule.getId()).getCreator());
        assertTrue(CollUtil.isEmpty(scheduleParticipantMapper.selectListByScheduleId(schedule.getId())));
    }

    @Test
    public void testSendScheduleReminder_allUsersAndRepeat() {
        LocalDateTime remindTime = LocalDateTime.now();
        Long ownerId = 1L;
        OaScheduleDO schedule = buildScheduleDO(ownerId).setRemind(true).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime.plusHours(1));
        scheduleMapper.insert(schedule);
        when(notifyMessageSendApi.sendSingleMessageToAdmin(any())).thenReturn(success(10L));

        assertTrue(scheduleService.sendScheduleReminder(schedule.getId(), remindTime));
        assertTrue(scheduleMapper.selectById(schedule.getId()).getReminded());
        assertFalse(scheduleService.sendScheduleReminder(schedule.getId(), remindTime));
        verify(notifyMessageSendApi, times(1)).sendSingleMessageToAdmin(argThat(req -> ownerId.equals(req.getUserId())));
    }

    @Test
    public void testSendScheduleReminders_timeAndStatus() {
        // mock 数据：仅第一条在提前 60 分钟窗口内，且开启提醒、尚未提醒
        LocalDateTime remindTime = LocalDateTime.of(2026, 9, 9, 10, 0);
        OaScheduleDO due = buildScheduleDO(1L).setRemind(true).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime.plusHours(1));
        scheduleMapper.insert(due);
        scheduleMapper.insert(buildScheduleDO(1L).setRemind(true).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime));
        scheduleMapper.insert(buildScheduleDO(1L).setRemind(true).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime.plusHours(24)));
        scheduleMapper.insert(buildScheduleDO(1L).setRemind(true).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime.minusMinutes(1)));
        scheduleMapper.insert(buildScheduleDO(1L).setRemind(false).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime.plusHours(1)));
        scheduleMapper.insert(buildScheduleDO(1L).setRemind(true).setReminded(true)
                .setRemindMinutes(60).setStartTime(remindTime.plusHours(1)));

        // mock 方法
        when(notifyMessageSendApi.sendSingleMessageToAdmin(any())).thenReturn(success(10L));
        try (MockedStatic<LocalDateTime> timeMock = mockStatic(LocalDateTime.class, CALLS_REAL_METHODS)) {
            timeMock.when(LocalDateTime::now).thenReturn(remindTime);

            // 调用，并断言：通过批量入口验证查询范围，只有符合条件的日程实际发送
            assertEquals(1, scheduleService.sendScheduleReminders());
            assertTrue(scheduleMapper.selectById(due.getId()).getReminded());
            verify(notifyMessageSendApi, times(1)).sendSingleMessageToAdmin(any());
        }
    }

    @Test
    public void testSendScheduleReminder_failureDoesNotMarkAndCanRetry() {
        LocalDateTime remindTime = LocalDateTime.now();
        OaScheduleDO schedule = buildScheduleDO(1L).setRemind(true).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime.plusHours(1));
        scheduleMapper.insert(schedule);
        when(notifyMessageSendApi.sendSingleMessageToAdmin(any()))
                .thenThrow(new IllegalStateException("发送失败")).thenReturn(success(11L));

        assertThrows(IllegalStateException.class,
                () -> scheduleService.sendScheduleReminder(schedule.getId(), remindTime));
        assertFalse(scheduleMapper.selectById(schedule.getId()).getReminded());
        assertTrue(scheduleService.sendScheduleReminder(schedule.getId(), remindTime));
        assertTrue(scheduleMapper.selectById(schedule.getId()).getReminded());
        verify(notifyMessageSendApi, times(2)).sendSingleMessageToAdmin(any());
    }

    @Test
    public void testSendScheduleReminder_disabledDoesNotSend() {
        // mock 数据
        LocalDateTime remindTime = LocalDateTime.now();
        OaScheduleDO schedule = buildScheduleDO(1L).setRemind(false).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime.plusHours(1));
        scheduleMapper.insert(schedule);

        // 调用，并断言
        assertFalse(scheduleService.sendScheduleReminder(schedule.getId(), remindTime));
        verifyNoInteractions(notifyMessageSendApi);
    }

    @Test
    public void testSendScheduleReminder_doesNotCheckMessageId() {
        // mock 数据
        LocalDateTime remindTime = LocalDateTime.now();
        OaScheduleDO schedule = buildScheduleDO(1L).setRemind(true).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime.plusHours(1));
        scheduleMapper.insert(schedule);
        // mock 方法
        when(notifyMessageSendApi.sendSingleMessageToAdmin(any())).thenReturn(success(null));

        // 调用，并断言
        assertTrue(scheduleService.sendScheduleReminder(schedule.getId(), remindTime));
        assertTrue(scheduleMapper.selectById(schedule.getId()).getReminded());
    }

    @Test
    public void testSendScheduleReminder_creatorOnly() {
        // mock 数据
        LocalDateTime remindTime = LocalDateTime.now();
        OaScheduleDO schedule = buildScheduleDO(1L).setRemind(true).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime.plusHours(1));
        scheduleMapper.insert(schedule);
        // mock 方法
        when(notifyMessageSendApi.sendSingleMessageToAdmin(any())).thenReturn(success(10L));

        // 调用，并断言：没有参与人也提醒创建人
        assertTrue(scheduleService.sendScheduleReminder(schedule.getId(), remindTime));
        verify(notifyMessageSendApi).sendSingleMessageToAdmin(argThat(req -> Long.valueOf(1L).equals(req.getUserId())));
    }

    @Test
    public void testSendScheduleReminder_onTime() {
        // 准时提醒：开始后、结束前应发送；开始前不发
        LocalDateTime remindTime = LocalDateTime.of(2026, 9, 9, 10, 0);
        OaScheduleDO schedule = buildScheduleDO(1L).setRemind(true).setReminded(false)
                .setRemindMinutes(0)
                .setStartTime(remindTime)
                .setEndTime(remindTime.plusHours(1));
        scheduleMapper.insert(schedule);
        when(notifyMessageSendApi.sendSingleMessageToAdmin(any())).thenReturn(success(10L));

        assertFalse(scheduleService.sendScheduleReminder(schedule.getId(), remindTime.minusMinutes(1)));
        assertTrue(scheduleService.sendScheduleReminder(schedule.getId(), remindTime));
        assertTrue(scheduleMapper.selectById(schedule.getId()).getReminded());
    }

    @Test
    public void testSendScheduleReminders_failureDoesNotBlockOthers() {
        // mock 数据：较早日程失败，后续日程仍需发送
        LocalDateTime remindTime = LocalDateTime.now();
        OaScheduleDO failed = buildScheduleDO(1L).setRemind(true).setReminded(false)
                .setRemindMinutes(60).setStartTime(remindTime.plusHours(1));
        OaScheduleDO success = buildScheduleDO(2L).setRemind(true).setReminded(false)
                .setRemindMinutes(120).setStartTime(remindTime.plusHours(2));
        scheduleMapper.insert(failed);
        scheduleMapper.insert(success);
        // mock 方法：验证批量内部调用也在事务内
        when(notifyMessageSendApi.sendSingleMessageToAdmin(any())).thenAnswer(invocation -> {
            assertTrue(TransactionSynchronizationManager.isActualTransactionActive());
            NotifySendSingleToUserReqDTO req = invocation.getArgument(0);
            if (Long.valueOf(1L).equals(req.getUserId())) {
                throw new IllegalStateException("发送失败");
            }
            return success(10L);
        });

        // 调用
        int count = scheduleService.sendScheduleReminders();

        // 断言：统计和异常隔离均由 Service 负责
        assertEquals(1, count);
        assertFalse(scheduleMapper.selectById(failed.getId()).getReminded());
        assertTrue(scheduleMapper.selectById(success.getId()).getReminded());
        verify(notifyMessageSendApi, times(2)).sendSingleMessageToAdmin(any());
    }

    @Test
    public void testSendScheduleReminders_empty() {

        // 调用，并断言
        assertEquals(0, scheduleService.sendScheduleReminders());
        verifyNoInteractions(notifyMessageSendApi);
    }

    @Test
    public void testUpdateScheduleReadStatus_ownerOnly() {
        Long userId = randomLongId();
        OaScheduleDO schedule = buildScheduleDO(userId);
        scheduleMapper.insert(schedule);

        scheduleService.updateScheduleReadStatus(schedule.getId(), userId);
        assertTrue(CollUtil.isEmpty(scheduleParticipantMapper.selectListByScheduleId(schedule.getId())));
        assertServiceException(() -> scheduleService.updateScheduleReadStatus(schedule.getId(), randomLongId()),
                SCHEDULE_ACCESS_DENIED);
        assertServiceException(() -> scheduleService.getSchedule(schedule.getId(), randomLongId()),
                SCHEDULE_ACCESS_DENIED);
    }

    @Test
    public void testUpdateScheduleReadStatus_notExists() {
        Long id = randomLongId();
        assertServiceException(() -> scheduleService.updateScheduleReadStatus(id, 2L), SCHEDULE_NOT_EXISTS);
    }

    @Test
    public void testUpdateScheduleReadStatus_deletedSchedule() {
        Long userId = randomLongId();
        OaScheduleDO schedule = buildScheduleDO(userId);
        scheduleMapper.insert(schedule);
        scheduleMapper.deleteById(schedule.getId());

        assertServiceException(() -> scheduleService.updateScheduleReadStatus(schedule.getId(), userId), SCHEDULE_NOT_EXISTS);
    }

    @Test
    public void testGetScheduleParticipantUserIdListMap_success() {
        // mock 数据
        scheduleParticipantMapper.insert(new OaScheduleParticipantDO().setScheduleId(10L).setUserId(1L).setReadStatus(false));
        scheduleParticipantMapper.insert(new OaScheduleParticipantDO().setScheduleId(10L).setUserId(2L).setReadStatus(false));
        scheduleParticipantMapper.insert(new OaScheduleParticipantDO().setScheduleId(20L).setUserId(3L).setReadStatus(false));

        // 调用
        Map<Long, List<Long>> participants = scheduleService.getScheduleParticipantUserIdListMap(Collections.singletonList(10L));

        // 断言
        assertEquals(1, participants.size());
        assertEquals(2, participants.get(10L).size());
        assertTrue(participants.get(10L).containsAll(Arrays.asList(1L, 2L)));
    }

    @Test
    public void testGetScheduleParticipantUserIdListMap_empty() {

        // 调用，并断言
        assertTrue(scheduleService.getScheduleParticipantUserIdListMap(Collections.emptyList()).isEmpty());
    }

    // ========== 随机对象 ==========

    /**
     * 构造开始时间晚于当前时间且开启提醒的日程参数。
     *
     * @return 保存参数
     */
    private static OaScheduleSaveReqVO buildScheduleSaveReqVO() {
        LocalDateTime startTime = LocalDateTime.now().plusHours(1);
        return new OaScheduleSaveReqVO().setType(OaScheduleTypeEnum.REMINDER.getType())
                .setPriority(OaPriorityEnum.NORMAL.getPriority()).setTitle("产品周会").setDescription("同步项目进度")
                .setStartTime(startTime).setEndTime(startTime.plusHours(1)).setRemind(true);
    }

    /**
     * 构造开始时间晚于当前时间且关闭提醒的日程。
     *
     * @param ownerUserId 创建人编号
     * @return 未入库的测试对象
     */
    private static OaScheduleDO buildScheduleDO(Long ownerUserId) {
        LocalDateTime startTime = LocalDateTime.now().plusHours(1);
        OaScheduleDO schedule = new OaScheduleDO().setType(OaScheduleTypeEnum.REMINDER.getType())
                .setPriority(OaPriorityEnum.NORMAL.getPriority()).setTitle("共享日程")
                .setStartTime(startTime).setEndTime(startTime.plusHours(1)).setRemind(false);
        schedule.setCreator(ownerUserId.toString());
        return schedule;
    }

}
