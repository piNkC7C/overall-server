package cn.iocoder.yudao.module.crm.controller.admin.business.vo.status;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - opportunity status response.")
@Data
public class CrmBusinessStatusRespVO {

    @Schema(description = "Status group code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2934")
    private Long id;

    @Schema(description = "Status group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    private String name;

    @Schema(description = "Used department code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Long> deptIds;
    @Schema(description = "Used department name.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> deptNames;

    @Schema(description = "Creator.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String creator;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Status set.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Status> statuses;

    @Data
    public static class Status {

        @Schema(description = "Status code.", example = "23899")
        private Long id;

        @Schema(description = "Status name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
        private String name;

        @Schema(description = "Win rate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
        private BigDecimal percent;

        @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer sort;

    }

}
