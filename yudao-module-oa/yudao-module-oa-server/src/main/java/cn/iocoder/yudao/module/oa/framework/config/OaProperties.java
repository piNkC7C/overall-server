package cn.iocoder.yudao.module.oa.framework.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.time.LocalTime;

/**
 * OA 模块配置
 *
 * @author 芋道源码
 */
@Component
@ConfigurationProperties(prefix = "yudao.oa")
@Validated
@Data
public class OaProperties {

    /**
     * 考勤配置
     */
    @Valid
    private Attendance attendance = new Attendance();

    /**
     * 日程配置
     */
    @Valid
    private Schedule schedule = new Schedule();

    /**
     * 云盘配置
     */
    @Valid
    @NotNull(message = "Cloud-drive setting cannot be empty.")
    private File file = new File();

    /**
     * 云盘配置
     */
    @Data
    public static class File {

        /**
         * 默认个人云盘容量，单位字节（5 GB）
         */
        @NotNull(message = "Cloud drive quota cannot be empty.")
        @Min(value = 1, message = "Cloud drive quota must be greater than 0.")
        private Long storageSize = 5L * 1024 * 1024 * 1024;

        /**
         * 下载地址有效期，单位秒
         */
        @NotNull(message = "Download URL TTL cannot be empty.")
        @Min(value = 1, message = "Download URL TTL must be greater than 0.")
        private Integer downloadUrlExpireSeconds = 300;

    }

    /**
     * 日程配置
     */
    @Data
    public static class Schedule {

        /**
         * 提前提醒小时数
         */
        @Min(value = 1, message = "Calendar reminder hours must be greater than 0.")
        private Integer remindBeforeHours = 24;

    }

    /**
     * 考勤配置
     */
    @Data
    public static class Attendance {

        /**
         * 月报应出勤天数
         */
        @NotNull(message = "Monthly required attendance days cannot be empty.")
        @Min(value = 1, message = "Monthly required attendance days must be greater than 0.")
        private Integer monthlyWorkDays = 22;

        /**
         * 每日最早打卡时间（不包含）
         */
        @NotNull(message = "Earliest daily clock-in time cannot be empty.")
        private LocalTime clockBeginTime = LocalTime.of(5, 0);
        /**
         * 标准上班时间
         */
        @NotNull(message = "Standard work time is required.")
        private LocalTime workBeginTime = LocalTime.of(8, 0);
        /**
         * 标准下班时间，同时作为每日打卡截止时间（不包含）
         */
        @NotNull(message = "Standard clock-out time cannot be empty.")
        private LocalTime workEndTime = LocalTime.of(17, 0);

    }

}
