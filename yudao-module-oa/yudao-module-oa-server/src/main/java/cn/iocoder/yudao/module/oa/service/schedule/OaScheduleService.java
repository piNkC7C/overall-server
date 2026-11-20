package cn.iocoder.yudao.module.oa.service.schedule;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.oa.controller.admin.schedule.vo.OaScheduleListReqVO;
import cn.iocoder.yudao.module.oa.controller.admin.schedule.vo.OaSchedulePageReqVO;
import cn.iocoder.yudao.module.oa.controller.admin.schedule.vo.OaScheduleSaveReqVO;
import cn.iocoder.yudao.module.oa.dal.dataobject.schedule.OaScheduleDO;
import cn.iocoder.yudao.module.oa.dal.dataobject.schedule.OaScheduleParticipantDO;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMultiMap;

/**
 * OA 日程 Service 接口
 *
 * @author 芋道源码
 */
public interface OaScheduleService {

    /**
     * 创建日程
     *
     * @param createReqVO 创建信息
     * @param userId 用户编号
     * @return 日程编号
     */
    Long createSchedule(OaScheduleSaveReqVO createReqVO, Long userId);

    /**
     * 更新日程
     *
     * @param updateReqVO 更新信息
     * @param userId 用户编号
     */
    void updateSchedule(OaScheduleSaveReqVO updateReqVO, Long userId);

    /**
     * 删除日程
     *
     * @param id 日程编号
     * @param userId 用户编号
     */
    void deleteSchedule(Long id, Long userId);

    /**
     * 获得日程
     *
     * @param id 日程编号
     * @param userId 用户编号
     * @return 日程
     */
    OaScheduleDO getSchedule(Long id, Long userId);

    /**
     * 标记已读（兼容旧接口；日程已无参与人，仅校验归属）
     *
     * @param id 日程编号
     * @param userId 当前用户编号
     */
    void updateScheduleReadStatus(Long id, Long userId);

    /**
     * 获得日程参与人列表
     *
     * @param id 日程编号
     * @return 参与人列表
     */
    List<OaScheduleParticipantDO> getScheduleParticipantList(Long id);

    /**
     * 获得我的日程分页
     *
     * @param pageReqVO 分页查询
     * @param userId 当前用户编号
     * @return 日程分页
     */
    PageResult<OaScheduleDO> getMySchedulePage(OaSchedulePageReqVO pageReqVO, Long userId);

    /**
     * 获得所选范围内的日程分页
     *
     * @param pageReqVO 分页查询
     * @param userId 当前用户编号
     * @return 日程分页
     */
    PageResult<OaScheduleDO> getSchedulePage(OaSchedulePageReqVO pageReqVO, Long userId);

    /**
     * 按时间窗获得日程列表（不分页；日历日/周/月视图）
     *
     * @param listReqVO 列表查询（须带 overlapTime）
     * @param userId 当前用户编号
     * @return 日程列表
     */
    List<OaScheduleDO> getScheduleList(OaScheduleListReqVO listReqVO, Long userId);

    /**
     * 按时间窗获得有日程的日期列表（仅日期，不含日程详情；左侧月历标记用）
     *
     * @param listReqVO 列表查询（须带 overlapTime）
     * @param userId 当前用户编号
     * @return 有日程的日期，格式 yyyy-MM-dd
     */
    List<String> getBusyDates(OaScheduleListReqVO listReqVO, Long userId);

    /**
     * 获得共享给我的日程分页
     *
     * @param pageReqVO 分页查询
     * @param userId 当前用户编号
     * @return 日程分页
     */
    PageResult<OaScheduleDO> getReceivedSchedulePage(OaSchedulePageReqVO pageReqVO, Long userId);

    /**
     * 批量发送待提醒日程
     *
     * @return 成功提醒的日程数量
     */
    int sendScheduleReminders();

    /**
     * 获得日程参与人列表
     *
     * @param scheduleIds 日程编号集合
     * @return 日程参与人列表
     */
    List<OaScheduleParticipantDO> getScheduleParticipantList(Collection<Long> scheduleIds);

    /**
     * 获得日程参与人用户编号 Map
     *
     * @param scheduleIds 日程编号集合
     * @return 日程编号与参与人用户编号列表的 Map
     */
    default Map<Long, List<Long>> getScheduleParticipantUserIdListMap(Collection<Long> scheduleIds) {
        List<OaScheduleParticipantDO> participants = getScheduleParticipantList(scheduleIds);
        return convertMultiMap(participants, OaScheduleParticipantDO::getScheduleId, OaScheduleParticipantDO::getUserId);
    }

}
