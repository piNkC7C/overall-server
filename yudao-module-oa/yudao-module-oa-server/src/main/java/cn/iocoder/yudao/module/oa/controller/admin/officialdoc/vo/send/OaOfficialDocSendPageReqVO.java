package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.send;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Outgoing official document page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaOfficialDocSendPageReqVO extends PageParam {

    @Schema(description = "Document Title", example = "Notice: Office supply inventory")
    private String title;

    @Schema(description = "Document Issue No.", example = "OA-2026-1")
    private String documentNo;

    @Schema(description = "Workflow status.", example = "-1")
    private Integer status;

}
