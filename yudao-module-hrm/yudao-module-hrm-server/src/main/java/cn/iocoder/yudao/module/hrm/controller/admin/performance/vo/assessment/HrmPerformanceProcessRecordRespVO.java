package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM employeeperformance reviewReviewworkflowrecord response.")
@Data
public class HrmPerformanceProcessRecordRespVO {

    @Schema(description = "Title.")
    private String title;

    @Schema(description = "Content.")
    private String content;

    @Schema(description = "Source.")
    private String source;

    @Schema(description = "Performance reviewworkflowrecord status.")
    private Integer status;

    @Schema(description = "Action person Name.")
    private String operatorName;

    @Schema(description = "Action time.")
    private LocalDateTime operateTime;

    @Schema(description = "AttachmentAddress list.")
    private List<String> fileUrls;

}
