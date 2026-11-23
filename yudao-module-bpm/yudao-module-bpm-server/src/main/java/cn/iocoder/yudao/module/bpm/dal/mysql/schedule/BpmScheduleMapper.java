package cn.iocoder.yudao.module.bpm.dal.mysql.schedule;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmSchedulePageReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.schedule.BpmScheduleDO;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BpmScheduleMapper extends BaseMapperX<BpmScheduleDO> {

    default PageResult<BpmScheduleDO> selectMyPage(BpmSchedulePageReqVO pageReqVO, Long userId) {
        return selectPage(pageReqVO, buildPageQuery(pageReqVO)
                .eq(BpmScheduleDO::getCreator, userId.toString()));
    }

    default LambdaQueryWrapperX<BpmScheduleDO> buildPageQuery(BpmSchedulePageReqVO pageReqVO) {
        return new LambdaQueryWrapperX<BpmScheduleDO>()
                .likeIfPresent(BpmScheduleDO::getTitle, pageReqVO.getTitle())
                .eqIfPresent(BpmScheduleDO::getType, pageReqVO.getType())
                .eqIfPresent(BpmScheduleDO::getPriority, pageReqVO.getPriority())
                .betweenIfPresent(BpmScheduleDO::getStartTime, pageReqVO.getStartTime())
                .leIfPresent(BpmScheduleDO::getStartTime, ArrayUtil.get(pageReqVO.getOverlapTime(), 1))
                .geIfPresent(BpmScheduleDO::getEndTime, ArrayUtil.get(pageReqVO.getOverlapTime(), 0))
                .orderByDesc(BpmScheduleDO::getStartTime)
                .orderByDesc(BpmScheduleDO::getId);
    }

    default List<BpmScheduleDO> selectListByRemindAndRemindedAndStartTime(Boolean remind, Boolean reminded,
                                                                          LocalDateTime[] startTime) {
        return selectList(new LambdaQueryWrapperX<BpmScheduleDO>()
                .eq(BpmScheduleDO::getRemind, remind)
                .eq(BpmScheduleDO::getReminded, reminded)
                .gt(BpmScheduleDO::getStartTime, startTime[0])
                .lt(BpmScheduleDO::getStartTime, startTime[1])
                .orderByAsc(BpmScheduleDO::getStartTime)
                .orderByAsc(BpmScheduleDO::getId));
    }

    /** 发送提醒前行锁，避免本地 Scheduler 与生产 XXL 叠跑双发 */
    default BpmScheduleDO selectByIdForUpdate(Long id) {
        return selectOne(new LambdaQueryWrapperX<BpmScheduleDO>()
                .eq(BpmScheduleDO::getId, id)
                .last("FOR UPDATE"));
    }

}
