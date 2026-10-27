package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.receive;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Incoming official document page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaOfficialDocReceivePageReqVO extends PageParam {

    @Schema(description = "Document Title", example = "Notice: Office supply inventory")
    private String title;

    @Schema(description = "Incoming Doc No.", example = "OA-2026-1")
    private String documentNo;

    @Schema(description = "Workflow status.", example = "-1")
    private Integer status;

}
