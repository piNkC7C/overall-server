package cn.iocoder.yudao.module.oa.controller.admin.contact.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "OA external contact page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaContactPageReqVO extends PageParam {

    @Schema(description = "Name, pinyin, phone, or company keyword.", example = "John.")
    private String keyword;

    @Schema(description = "Category code.", example = "1024")
    private Long categoryId;

    @Schema(description = "Is not already process.", example = "false")
    private Boolean handleStatus;

    @Schema(description = "Name pinyin initial. Empty means all.", example = "A")
    @Pattern(regexp = "^[A-Z]?$", message = "Name initial must be A-Z.")
    private String alphabet;


}
