package cn.iocoder.yudao.module.promotion.controller.admin.seckill.vo.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

/**
 * 秒杀时段 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 *
 * @author HUIHUI
 */
@Data
public class SeckillConfigBaseVO {

    @Schema(description = "Flash-sale slot name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Morning session")
    @NotNull(message = "Flash-sale slot name cannot be empty.")
    private String name;

    @Schema(description = "Start Time Point.", requiredMode = Schema.RequiredMode.REQUIRED, example = "09:00:00")
    @NotNull(message = "Start Time Point is required.")
    private String startTime;

    @Schema(description = "End Time Point.", requiredMode = Schema.RequiredMode.REQUIRED, example = "16:00:00")
    @NotNull(message = "End Time Point is required.")
    private String endTime;

    @Schema(description = "Flash-sale banners.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[https://www.iocoder.cn/xx.png]")
    @NotNull(message = "Flash-sale banners cannot be empty.")
    private List<String> sliderPicUrls;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @AssertTrue(message = "Flash-sale start time and end time cannot be the same.")
    @JsonIgnore
    public boolean isValidStartTimeValid() {
        return !LocalTime.parse(startTime).equals(LocalTime.parse(endTime));
    }

    @AssertTrue(message = "Flash-sale start time cannot be after the end time.")
    @JsonIgnore
    public boolean isValidEndTimeValid() {
        return !LocalTime.parse(startTime).isAfter(LocalTime.parse(endTime));
    }

}
