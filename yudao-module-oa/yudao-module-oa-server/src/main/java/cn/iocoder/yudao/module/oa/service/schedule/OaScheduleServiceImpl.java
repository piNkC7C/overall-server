package cn.iocoder.yudao.module.oa.service.schedule;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.iocoder.yudao.framework.common.util.number.NumberUtils;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.oa.controller.admin.schedule.vo.OaScheduleListReqVO;
import cn.iocoder.yudao.module.oa.controller.admin.schedule.vo.OaSchedulePageReqVO;
import cn.iocoder.yudao.module.oa.controller.admin.schedule.vo.OaScheduleSaveReqVO;
import cn.iocoder.yudao.module.oa.dal.dataobject.schedule.OaScheduleDO;
import cn.iocoder.yudao.module.oa.dal.dataobject.schedule.OaScheduleParticipantDO;
import cn.iocoder.yudao.module.oa.dal.mysql.schedule.OaScheduleMapper;
import cn.iocoder.yudao.module.oa.dal.mysql.schedule.OaScheduleParticipantMapper;
import cn.iocoder.yudao.module.oa.enums.schedule.OaScheduleStatusEnum;
import cn.iocoder.yudao.module.oa.framework.config.OaProperties;
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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.oa.enums.ErrorCodeConstants.SCHEDULE_ACCESS_DENIED;
import static cn.iocoder.yudao.module.oa.enums.ErrorCodeConstants.SCHEDULE_NOT_EXISTS;
import static cn.iocoder.yudao.module.oa.enums.MessageTemplateConstants.SCHEDULE_REMINDER;

/**
 * OA 日程 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
@Slf4j
public class OaScheduleServiceImpl implements OaScheduleService {

    @Resource
    private OaProperties properties;

    @Resource
    private OaScheduleMapper scheduleMapper;
    @Resource
    private OaScheduleParticipantMapper scheduleParticipantMapper;

    @Resource
    private NotifyMessageSendApi notifyMessageSendApi;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createSchedule(OaScheduleSaveReqVO createReqVO, Long userId) {
        // 日程仅服务创建人，不支持参与人/共享
        OaScheduleDO schedule = BeanUtils.toBean(createReqVO, OaScheduleDO.class)
                .setReminded(false);
        if (schedule.getStatus() == null) {
            schedule.setStatus(OaScheduleStatusEnum.NOT_STARTED.getStatus());
        }
        if (schedule.getRemindMinutes() == null) {
            schedule.setRemindMinutes(0);
        }
        if (schedule.getRemind() == null) {
            schedule.setRemind(true);
        }
        scheduleMapper.insert(schedule);

        // 提醒时刻已过、日程尚未结束：保存后立即补发，不等定时任务
        trySendReminderIfDue(schedule.getId());
        return schedule.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSchedule(OaScheduleSaveReqVO updateReqVO, Long userId) {
        OaScheduleDO existing = validateScheduleOwner(updateReqVO.getId(), userId);

        OaScheduleDO updateObj = BeanUtils.toBean(updateReqVO, OaScheduleDO.class);
        // 状态变更时记录处理时间
        if (updateReqVO.getStatus() != null
                && ObjectUtil.notEqual(updateReqVO.getStatus(), existing.getStatus())) {
            updateObj.setProcessTime(LocalDateTime.now());
        }
        // 仅时间/提醒变更才重置提醒周期；纯改状态不打断已发提醒
        boolean remindCycleChanged = ObjectUtil.notEqual(existing.getStartTime(), updateReqVO.getStartTime())
                || ObjectUtil.notEqual(existing.getEndTime(), updateReqVO.getEndTime())
                || ObjectUtil.notEqual(existing.getRemind(), updateReqVO.getRemind())
                || ObjectUtil.notEqual(
                existing.getRemindMinutes() == null ? 0 : existing.getRemindMinutes(),
                updateReqVO.getRemindMinutes() == null ? 0 : updateReqVO.getRemindMinutes());
        if (remindCycleChanged) {
            updateObj.setReminded(false);
        } else {
            updateObj.setReminded(null); // 不覆盖
        }
        scheduleMapper.updateById(updateObj);
        // 提醒时刻已过则立即补发
        trySendReminderIfDue(updateReqVO.getId());
    }

    /**
     * 保存提交后再判断：提醒时刻已过、日程仍在窗口内则立即补发。
     * 放在 afterCommit，避免嵌套事务失败把日程保存一起回滚。
     */
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
        // 1. 校验日程
        validateScheduleOwner(id, userId);

        // 2.1 清理历史参与人行（业务已不再写入）
        scheduleParticipantMapper.deleteByScheduleId(id);
        // 2.2 删除日程
        scheduleMapper.deleteById(id);
    }

    @Override
    public OaScheduleDO getSchedule(Long id, Long userId) {
        // 仅创建人可查看
        return validateScheduleOwner(id, userId);
    }

    @Override
    public PageResult<OaScheduleDO> getMySchedulePage(OaSchedulePageReqVO pageReqVO, Long userId) {
        return scheduleMapper.selectMyPage(pageReqVO, userId);
    }

    @Override
    public PageResult<OaScheduleDO> getSchedulePage(OaSchedulePageReqVO pageReqVO, Long userId) {
        // 日程仅本人可见，忽略 includeMine / includeReceived
        return getMySchedulePage(pageReqVO, userId);
    }

    @Override
    public List<OaScheduleDO> getScheduleList(OaScheduleListReqVO listReqVO, Long userId) {
        // 日历按 overlapTime 取全量：内部转分页 VO 并设 PAGE_SIZE_NONE（不经 HTTP 校验）
        OaSchedulePageReqVO pageReqVO = BeanUtils.toBean(listReqVO, OaSchedulePageReqVO.class);
        pageReqVO.setPageNo(1);
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        return getSchedulePage(pageReqVO, userId).getList();
    }

    @Override
    public List<String> getBusyDates(OaScheduleListReqVO listReqVO, Long userId) {
        List<OaScheduleDO> list = getScheduleList(listReqVO, userId);
        if (CollUtil.isEmpty(list) || listReqVO.getOverlapTime() == null || listReqVO.getOverlapTime().length < 2) {
            return Collections.emptyList();
        }
        LocalDate rangeBegin = listReqVO.getOverlapTime()[0].toLocalDate();
        LocalDate rangeEnd = listReqVO.getOverlapTime()[1].toLocalDate();
        TreeSet<String> dates = new TreeSet<>();
        for (OaScheduleDO schedule : list) {
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
    public void updateScheduleReadStatus(Long id, Long userId) {
        // 已无参与人阅读回执；保留接口兼容，仅校验归属
        validateScheduleOwner(id, userId);
    }

    @Override
    public List<OaScheduleParticipantDO> getScheduleParticipantList(Long id) {
        return scheduleParticipantMapper.selectListByScheduleId(id);
    }

    @Override
    public PageResult<OaScheduleDO> getReceivedSchedulePage(OaSchedulePageReqVO pageReqVO, Long userId) {
        // 已取消共享日程，保留接口返回空
        return PageResult.empty();
    }

    @Override
    public int sendScheduleReminders() {
        // 1. 查近 1 天～未来 7 天内未提醒日程（含「准时」已开始的窗口），再按 remindMinutes 精确过滤
        LocalDateTime remindTime = LocalDateTime.now();
        List<OaScheduleDO> schedules = scheduleMapper.selectListByRemindAndRemindedAndStartTime(true, false,
                new LocalDateTime[]{remindTime.minusDays(1), remindTime.plusDays(7)});

        // 2. 逐条发送，通过代理调用保证每条日程独立事务，失败不影响其他日程
        int count = 0;
        for (OaScheduleDO schedule : schedules) {
            try {
                count += getSelf().sendScheduleReminder(schedule.getId(), remindTime) ? 1 : 0;
            } catch (Exception ex) {
                log.error("[sendScheduleReminders][日程 ({}) 提醒失败]", schedule.getId(), ex);
            }
        }
        return count;
    }

    /**
     * 向创建人和参与人发送单条日程提醒
     *
     * 保留 public 供自身代理调用，使单条日程的事务生效，不对外暴露 Service 接口。
     *
     * @param id 日程编号
     * @param remindTime 提醒基准时间
     * @return 是否完成本日程的提醒，已提醒或不符合条件时返回 false
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean sendScheduleReminder(Long id, LocalDateTime remindTime) {
        // 1. 校验日程当前仍需提醒
        // 提前 N 分钟：窗口 [start-N, start)；准时(0)：窗口 [start, end)（无结束时间则 start 起 1 分钟内）
        OaScheduleDO schedule = validateScheduleExists(id);
        if (Boolean.FALSE.equals(schedule.getRemind()) || Boolean.TRUE.equals(schedule.getReminded())) {
            return false;
        }
        int minutes = schedule.getRemindMinutes() == null ? 0 : Math.max(schedule.getRemindMinutes(), 0);
        LocalDateTime fireAt = schedule.getStartTime().minusMinutes(minutes);
        LocalDateTime expireAt = minutes == 0
                ? (schedule.getEndTime() != null ? schedule.getEndTime() : schedule.getStartTime().plusMinutes(1))
                : schedule.getStartTime();
        // 未到提醒时刻，或已过提醒窗口，则不发
        if (remindTime.isBefore(fireAt) || !remindTime.isBefore(expireAt)) {
            return false;
        }

        // 2. 仅通知创建人
        Long ownerId = NumberUtils.parseLong(schedule.getCreator());
        if (ownerId == null) {
            return false;
        }
        Map<String, Object> templateParams = Maps.newHashMapWithExpectedSize(3);
        templateParams.put("scheduleId", schedule.getId());
        templateParams.put("name", schedule.getTitle());
        // 跳转只带 id，我的日程页再按 id 取详情做日期+标题筛选
        templateParams.put("route", "/bpm/my-schedule?scheduleId=" + schedule.getId());
        notifyMessageSendApi.sendSingleMessageToAdmin(new NotifySendSingleToUserReqDTO()
                .setUserId(ownerId).setTemplateCode(SCHEDULE_REMINDER).setTemplateParams(templateParams)).checkError();
        scheduleMapper.updateById(new OaScheduleDO().setId(id).setReminded(true));
        return true;
    }

    /**
     * 获得自身代理，保证内部调用的事务生效
     *
     * @return 当前 Service 的 Spring 代理
     */
    private OaScheduleServiceImpl getSelf() {
        return SpringUtil.getBean(getClass());
    }

    @Override
    public List<OaScheduleParticipantDO> getScheduleParticipantList(Collection<Long> scheduleIds) {
        if (CollUtil.isEmpty(scheduleIds)) {
            return Collections.emptyList();
        }
        return scheduleParticipantMapper.selectListByScheduleIds(scheduleIds);
    }

    /**
     * 校验日程存在且属于当前用户
     *
     * @param id 日程编号
     * @param userId 用户编号
     * @return 日程
     */
    private OaScheduleDO validateScheduleOwner(Long id, Long userId) {
        OaScheduleDO schedule = validateScheduleExists(id);
        if (ObjectUtil.notEqual(NumberUtils.parseLong(schedule.getCreator()), userId)) {
            throw exception(SCHEDULE_ACCESS_DENIED);
        }
        return schedule;
    }

    /**
     * 校验日程存在
     *
     * @param id 日程编号
     * @return 日程
     */
    private OaScheduleDO validateScheduleExists(Long id) {
        OaScheduleDO schedule = scheduleMapper.selectById(id);
        if (schedule == null) {
            throw exception(SCHEDULE_NOT_EXISTS);
        }
        return schedule;
    }

}
