package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.resulttemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM performance review resulttemplate response.")
@Data
public class HrmPerformanceResultTemplateRespVO {

    @Schema(description = "Resulttemplate code.", example = "1024")
    private Long id;

    @Schema(description = "Resulttemplate name.", example = "Quarterly review result")
    private String name;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Result level list.")
    private List<Level> levels;

    @Schema(description = "Creator.")
    private String creator;

    @Schema(description = "Creator name.")
    private String creatorName;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

    @Schema(description = "Update time.")
    private LocalDateTime updateTime;

    @Schema(description = "Admin - HRM performance review resulttemplate level.")
    @Data
    public static class Level {

        @Schema(description = "Level name.", example = "A")
        private String name;

        @Schema(description = "Minimum score.", example = "90")
        private BigDecimal minScore;

        @Schema(description = "Maximum score.", example = "100")
        private BigDecimal maxScore;

        @Schema(description = "Performance Factor", example = "1.2")
        private BigDecimal coefficient;
    }

}
