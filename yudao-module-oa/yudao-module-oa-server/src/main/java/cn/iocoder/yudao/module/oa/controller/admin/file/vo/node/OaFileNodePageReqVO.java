package cn.iocoder.yudao.module.oa.controller.admin.file.vo.node;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.file.OaFileCategoryEnum;
import cn.iocoder.yudao.module.oa.enums.file.OaFileScopeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Cloud-drive file page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaFileNodePageReqVO extends PageParam {

    @Schema(description = "List Range：my、shared、favorite、recycle.", requiredMode = Schema.RequiredMode.REQUIRED, example = "my")
    @NotBlank(message = "List Range is required.")
    @InEnum(value = OaFileScopeEnum.class, message = "List Range must be {value}.")
    private String scope;

    @Schema(description = "Parent folder ID. Omit to list all files in scope.", example = "1024")
    private Long parentId;

    @Schema(description = "Name.", example = "office-supply-count.pdf")
    @Size(max = 255, message = "Name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Filecategory.", example = "1")
    @InEnum(value = OaFileCategoryEnum.class, message = "Filecategory must be {value}.")
    private Integer category;

    @Schema(description = "Create time range.", example = "[\"2026-09-14 00:00:00\", \"2026-09-14 23:59:59\"]")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
