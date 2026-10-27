package cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.recrod;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 拼团记录 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @author HUIHUI
 */
@Data
public class CombinationRecordBaseVO {

    @Schema(description = "Group buy record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Group buy campaign code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long activityId;

    @Schema(description = "Group-leader ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long headId;

    // ========== 用户相关 ==========

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "9430")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "Nickname", example = "John")
    private String nickname;

    @Schema(description = "UserAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xxx.jpg")
    private String avatar;

    // ========== 商品相关 ==========

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23622")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29950")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "I am Big Soybean")
    private String spuName;

    @Schema(description = "Product Image", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.png")
    private String picUrl;

    @Schema(description = "Expires at", requiredMode = Schema.RequiredMode.REQUIRED)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime expireTime;

    @Schema(description = "Group-buy capacity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer userSize;

    @Schema(description = "Joined group-buy count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer userCount;

    @Schema(description = "Group buy status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "WhetherVirtual group buy.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean virtualGroup;

    @Schema(description = "Start time (order payment after start time).", requiredMode = Schema.RequiredMode.REQUIRED)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "End time (group-formed time / failed time).", requiredMode = Schema.RequiredMode.REQUIRED)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

}
