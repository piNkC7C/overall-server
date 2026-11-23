package cn.iocoder.yudao.module.bpm.service.schedule;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.number.NumberUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmScheduleListReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmSchedulePageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmScheduleSaveReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.schedule.BpmScheduleDO;
import cn.iocoder.yudao.module.bpm.dal.mysql.schedule.BpmScheduleMapper;
import cn.iocoder.yudao.module.bpm.enums.schedule.BpmScheduleStatusEnum;
import cn.iocoder.yudao.module.system.api.notify.NotifyMessageSendApi;
import cn.iocoder.yudao.module.system.api.notify.dto.NotifySendSingleToUserReqDTO;
import com.google.common.collect.Maps;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bpm.enums.ErrorCodeConstants.SCHEDULE_ACCESS_DENIED;
import static cn.iocoder.yudao.module.bpm.enums.ErrorCodeConstants.SCHEDULE_NOT_EXISTS;
import static cn.iocoder.yudao.module.bpm.enums.MessageTemplateConstants.SCHEDULE_REMINDER;

/**
 * BPM 我的日程 Service 实现类（仅创建人）
 */
@Service
@Validated
@Slf4j
public class BpmScheduleServiceImpl implements BpmScheduleService {

    @Resource
    private BpmScheduleMapper scheduleMapper;
    @Resource
    private NotifyMessageSendApi notifyMessageSendApi;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createSchedule(BpmScheduleSaveReqVO createReqVO, Long userId) {
        BpmScheduleDO schedule = BeanUtils.toBean(createReqVO, BpmScheduleDO.class)
                .setReminded(false);
        if (schedule.getStatus() == null) {
            schedule.setStatus(BpmScheduleStatusEnum.NOT_STARTED.getStatus());
        }
        if (schedule.getRemindMinutes() == null) {
            schedule.setRemindMinutes(0);
        }
        if (schedule.getRemind() == null) {
            schedule.setRemind(true);
        }
        scheduleMapper.insert(schedule);
        trySendReminderIfDue(schedule.getId());
        return schedule.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSchedule(BpmScheduleSaveReqVO updateReqVO, Long userId) {
        BpmScheduleDO existing = validateScheduleOwner(updateReqVO.getId(), userId);

        BpmScheduleDO updateObj = BeanUtils.toBean(updateReqVO, BpmScheduleDO.class);
        if (updateReqVO.getStatus() != null
                && ObjectUtil.notEqual(updateReqVO.getStatus(), existing.getStatus())) {
            updateObj.setProcessTime(LocalDateTime.now());
        }
        boolean remindCycleChanged = ObjectUtil.notEqual(existing.getStartTime(), updateReqVO.getStartTime())
                || ObjectUtil.notEqual(existing.getEndTime(), updateReqVO.getEndTime())
                || ObjectUtil.notEqual(existing.getRemind(), updateReqVO.getRemind())
                || ObjectUtil.notEqual(
                existing.getRemindMinutes() == null ? 0 : existing.getRemindMinutes(),
                updateReqVO.getRemindMinutes() == null ? 0 : updateReqVO.getRemindMinutes());
        if (remindCycleChanged) {
            updateObj.setReminded(false);
        } else {
            updateObj.setReminded(null);
        }
        scheduleMapper.updateById(updateObj);
        trySendReminderIfDue(updateReqVO.getId());
    }

    private void trySendReminderIfDue(Long scheduleId) {
        Runnable send = () -> {
            try {
                getSelf().sendScheduleReminder(scheduleId, LocalDateTime.now());
            } catch (Exception ex) {
                log.warn("[trySendReminderIfDue][日程 ({}) 立即提醒失败]", scheduleId, ex);
            }
        };
        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            send.run();
            return;
        }
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                send.run();
            }
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSchedule(Long id, Long userId) {
        validateScheduleOwner(id, userId);
        scheduleMapper.deleteById(id);
    }

    @Override
    public BpmScheduleDO getSchedule(Long id, Long userId) {
        return validateScheduleOwner(id, userId);
    }

    @Override
    public PageResult<BpmScheduleDO> getMySchedulePage(BpmSchedulePageReqVO pageReqVO, Long userId) {
        return scheduleMapper.selectMyPage(pageReqVO, userId);
    }

    @Override
    public PageResult<BpmScheduleDO> getSchedulePage(BpmSchedulePageReqVO pageReqVO, Long userId) {
        return getMySchedulePage(pageReqVO, userId);
    }

    @Override
    public List<BpmScheduleDO> getScheduleList(BpmScheduleListReqVO listReqVO, Long userId) {
        BpmSchedulePageReqVO pageReqVO = BeanUtils.toBean(listReqVO, BpmSchedulePageReqVO.class);
        pageReqVO.setPageNo(1);
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        return getSchedulePage(pageReqVO, userId).getList();
    }

    @Override
    public List<String> getBusyDates(BpmScheduleListReqVO listReqVO, Long userId) {
        List<BpmScheduleDO> list = getScheduleList(listReqVO, userId);
        if (CollUtil.isEmpty(list) || listReqVO.getOverlapTime() == null || listReqVO.getOverlapTime().length < 2) {
            return Collections.emptyList();
        }
        LocalDate rangeBegin = listReqVO.getOverlapTime()[0].toLocalDate();
        LocalDate rangeEnd = listReqVO.getOverlapTime()[1].toLocalDate();
        TreeSet<String> dates = new TreeSet<>();
        for (BpmScheduleDO schedule : list) {
            if (schedule.getStartTime() == null || schedule.getEndTime() == null) {
                continue;
            }
            LocalDate cur = schedule.getStartTime().toLocalDate();
            LocalDate end = schedule.getEndTime().toLocalDate();
            if (cur.isBefore(rangeBegin)) {
                cur = rangeBegin;
            }
            if (end.isAfter(rangeEnd)) {
                end = rangeEnd;
            }
            while (!cur.isAfter(end)) {
                dates.add(cur.format(DateTimeFormatter.ISO_LOCAL_DATE));
                cur = cur.plusDays(1);
            }
        }
        return new ArrayList<>(dates);
    }

    @Override
    public int sendScheduleReminders() {
        LocalDateTime remindTime = LocalDateTime.now();
        List<BpmScheduleDO> schedules = scheduleMapper.selectListByRemindAndRemindedAndStartTime(true, false,
                new LocalDateTime[]{remindTime.minusDays(1), remindTime.plusDays(7)});
        int count = 0;
        for (BpmScheduleDO schedule : schedules) {
            try {
                count += getSelf().sendScheduleReminder(schedule.getId(), remindTime) ? 1 : 0;
            } catch (Exception ex) {
                log.error("[sendScheduleReminders][日程 ({}) 提醒失败]", schedule.getId(), ex);
            }
        }
        return count;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean sendScheduleReminder(Long id, LocalDateTime remindTime) {
        // FOR UPDATE：本地 Scheduler 与生产 XXL 同库并发时只发一条
        BpmScheduleDO schedule = scheduleMapper.selectByIdForUpdate(id);
        if (schedule == null) {
            return false;
        }
        if (Boolean.FALSE.equals(schedule.getRemind()) || Boolean.TRUE.equals(schedule.getReminded())) {
            return false;
        }
        int minutes = schedule.getRemindMinutes() == null ? 0 : Math.max(schedule.getRemindMinutes(), 0);
        LocalDateTime fireAt = schedule.getStartTime().minusMinutes(minutes);
        LocalDateTime expireAt = minutes == 0
                ? (schedule.getEndTime() != null ? schedule.getEndTime() : schedule.getStartTime().plusMinutes(1))
                : schedule.getStartTime();
        if (remindTime.isBefore(fireAt) || !remindTime.isBefore(expireAt)) {
            return false;
        }

        Long ownerId = NumberUtils.parseLong(schedule.getCreator());
        if (ownerId == null) {
            return false;
        }
        Map<String, Object> templateParams = Maps.newHashMapWithExpectedSize(3);
        templateParams.put("scheduleId", schedule.getId());
        templateParams.put("name", schedule.getTitle());
        templateParams.put("route", "/bpm/my-schedule?scheduleId=" + schedule.getId());
        notifyMessageSendApi.sendSingleMessageToAdmin(new NotifySendSingleToUserReqDTO()
                .setUserId(ownerId).setTemplateCode(SCHEDULE_REMINDER).setTemplateParams(templateParams)).checkError();
        scheduleMapper.updateById(new BpmScheduleDO().setId(id).setReminded(true));
        return true;
    }

    private BpmScheduleServiceImpl getSelf() {
        return SpringUtil.getBean(getClass());
    }

    private BpmScheduleDO validateScheduleOwner(Long id, Long userId) {
        BpmScheduleDO schedule = validateScheduleExists(id);
        if (ObjectUtil.notEqual(NumberUtils.parseLong(schedule.getCreator()), userId)) {
            throw exception(SCHEDULE_ACCESS_DENIED);
        }
        return schedule;
    }

    private BpmScheduleDO validateScheduleExists(Long id) {
        BpmScheduleDO schedule = scheduleMapper.selectById(id);
        if (schedule == null) {
            throw exception(SCHEDULE_NOT_EXISTS);
        }
        return schedule;
    }

}
