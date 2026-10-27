package cn.iocoder.yudao.module.report.controller.admin.goview.vo.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Schema(description = "Admin - GoView used SQL search data request.")
@Data
public class GoViewDataGetBySqlReqVO {

    @Schema(description = "SQL statement.", requiredMode = Schema.RequiredMode.REQUIRED, example = "SELECT * FROM user")
    @NotEmpty(message = "SQL statement cannot be empty.")
    private String sql;

}
