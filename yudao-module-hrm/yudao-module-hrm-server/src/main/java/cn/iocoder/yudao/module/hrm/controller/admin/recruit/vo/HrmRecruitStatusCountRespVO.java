package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Admin - HRM Recruiting status quantity response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HrmRecruitStatusCountRespVO {

    @Schema(description = "Status.", example = "1")
    private Integer status;

    @Schema(description = "Quantity.", example = "12")
    private Long count;

}
