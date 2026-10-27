package cn.iocoder.yudao.module.fms.controller.admin.config.vo.auxiliaryitem;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * FMS 辅助核算项目导入结果 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - FMS auxiliary accounting item import result response.")
@Data
public class FmsAuxiliaryItemImportRespVO {

    @Schema(description = "Total quantity.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer totalCount;

    @Schema(description = "Succeeded codeArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> successItemCodes;

    @Schema(description = "Failedreason Map.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureReasons;

}
