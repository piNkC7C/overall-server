package cn.iocoder.yudao.module.bpm.dal.dataobject.schedule;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.module.bpm.enums.schedule.BpmSchedulePriorityEnum;
import cn.iocoder.yudao.module.bpm.enums.schedule.BpmScheduleStatusEnum;
import cn.iocoder.yudao.module.bpm.enums.schedule.BpmScheduleTypeEnum;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * BPM 我的日程 DO（仅创建人可见）
 */
@TableName("bpm_schedule")
@KeySequence("bpm_schedule_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmScheduleDO extends BaseDO {

    @TableId
    private Long id;
    /**
     * 日程类型
     *
     * 枚举 {@link BpmScheduleTypeEnum}
     */
    private Integer type;
    /**
     * 优先级
     *
     * 枚举 {@link BpmSchedulePriorityEnum}
     */
    private Integer priority;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean remind;
    /** 提醒提前分钟数（0=准时） */
    private Integer remindMinutes;
    private Boolean reminded;
    /**
     * 日程执行状态
     *
     * 枚举 {@link BpmScheduleStatusEnum}
     * 对应列 process_status
     */
    @TableField("process_status")
    private Integer status;
    private LocalDateTime processTime;

}
