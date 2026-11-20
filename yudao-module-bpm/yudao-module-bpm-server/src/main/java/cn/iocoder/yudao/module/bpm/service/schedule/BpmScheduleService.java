package cn.iocoder.yudao.module.bpm.service.schedule;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmScheduleListReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmSchedulePageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmScheduleSaveReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.schedule.BpmScheduleDO;

import java.util.List;

/**
 * BPM 我的日程 Service
 */
public interface BpmScheduleService {

    Long createSchedule(BpmScheduleSaveReqVO createReqVO, Long userId);

    void updateSchedule(BpmScheduleSaveReqVO updateReqVO, Long userId);

    void deleteSchedule(Long id, Long userId);

    BpmScheduleDO getSchedule(Long id, Long userId);

    PageResult<BpmScheduleDO> getMySchedulePage(BpmSchedulePageReqVO pageReqVO, Long userId);

    PageResult<BpmScheduleDO> getSchedulePage(BpmSchedulePageReqVO pageReqVO, Long userId);

    List<BpmScheduleDO> getScheduleList(BpmScheduleListReqVO listReqVO, Long userId);

    List<String> getBusyDates(BpmScheduleListReqVO listReqVO, Long userId);

    int sendScheduleReminders();

}
