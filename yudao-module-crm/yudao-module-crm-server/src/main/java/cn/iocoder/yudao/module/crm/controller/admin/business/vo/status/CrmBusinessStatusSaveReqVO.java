package cn.iocoder.yudao.module.crm.controller.admin.business.vo.status;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Admin - opportunity status group create / edit request.")
@Data
public class CrmBusinessStatusSaveReqVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2934")
    private Long id;

    @Schema(description = "Status-type name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotEmpty(message = "Status-type name cannot be empty.")
    private String name;

    @Schema(description = "Used department code.")
    private List<Long> deptIds;

    @Schema(description = "Opportunity statuses.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Opportunity statuses cannot be empty.")
    @Valid
    private List<Status> statuses;

    @Data
    public static class Status {

        @Schema(description = "Status code.", example = "23899")
        private Long id;

        @Schema(description = "Status name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
        @NotEmpty(message = "Status name cannot be empty.")
        private String name;

        @Schema(description = "Win rate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
        @NotNull(message = "Win rate cannot be empty.")
        private BigDecimal percent;

        @Schema(description = "Sort.", hidden = true, example = "1")
        private Integer sort;

    }

}
