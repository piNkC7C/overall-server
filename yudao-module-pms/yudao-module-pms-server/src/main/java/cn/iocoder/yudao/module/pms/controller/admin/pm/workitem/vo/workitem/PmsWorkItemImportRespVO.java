package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Schema(description = "Admin - PMS work item import response.")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmsWorkItemImportRespVO {

    @Schema(description = "Import succeeded quantity.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer successCount;

    @Schema(description = "Failed import rows and reasons.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<Integer, String> failureReasons;

}
