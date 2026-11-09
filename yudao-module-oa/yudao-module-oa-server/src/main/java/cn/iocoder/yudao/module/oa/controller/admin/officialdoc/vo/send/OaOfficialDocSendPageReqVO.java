package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.send;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 公文发文分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaOfficialDocSendPageReqVO extends PageParam {

    @Schema(description = "公文标题", example = "Notice: Office supply inventory")
    private String title;

    @Schema(description = "发文字号", example = "OA-2026-1")
    private String documentNo;

    @Schema(description = "流程状态", example = "-1")
    private Integer status;

}
