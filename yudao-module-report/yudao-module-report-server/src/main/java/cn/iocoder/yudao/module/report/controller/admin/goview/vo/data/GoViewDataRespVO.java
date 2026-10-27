package cn.iocoder.yudao.module.report.controller.admin.goview.vo.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - GoView data response.")
@Data
public class GoViewDataRespVO {

    @Schema(description = "Data Dimension.", requiredMode = Schema.RequiredMode.REQUIRED, example = "['product', 'data1', 'data2']")
    private List<String> dimensions;

    @Schema(description = "Data detail list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Map<String, Object>> source;

}
