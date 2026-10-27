package cn.iocoder.yudao.module.system.controller.admin.dept.vo.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelProperty;

@Schema(description = "Admin - post info simple response.")
@Data
public class PostSimpleRespVO {

    @Schema(description = "Post No.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Job Title Sequence")
    private Long id;

    @Schema(description = "Post name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Potato")
    @ExcelProperty("Job Title")
    private String name;

}
