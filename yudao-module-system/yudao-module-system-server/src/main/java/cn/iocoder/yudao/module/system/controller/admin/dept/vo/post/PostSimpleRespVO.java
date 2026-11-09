package cn.iocoder.yudao.module.system.controller.admin.dept.vo.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelProperty;

@Schema(description = "管理后台 - 岗位信息的精简 Response VO")
@Data
public class PostSimpleRespVO {

    @Schema(description = "岗位序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Job Title Sequence")
    private Long id;

    @Schema(description = "岗位名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato")
    @ExcelProperty("Job Title")
    private String name;

}
