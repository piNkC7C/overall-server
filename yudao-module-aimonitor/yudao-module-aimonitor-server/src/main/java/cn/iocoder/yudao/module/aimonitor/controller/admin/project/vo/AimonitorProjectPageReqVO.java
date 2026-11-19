package cn.iocoder.yudao.module.aimonitor.controller.admin.project.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - AI 监测项目分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AimonitorProjectPageReqVO extends PageParam {

    @Schema(description = "品牌名称", example = "Apple")
    private String brandName;

    @Schema(description = "项目名称", example = "Apple CN")
    private String name;

    @Schema(description = "状态", example = "active")
    private String status;

    @Schema(description = "国家代码", example = "US")
    private String country;

}
