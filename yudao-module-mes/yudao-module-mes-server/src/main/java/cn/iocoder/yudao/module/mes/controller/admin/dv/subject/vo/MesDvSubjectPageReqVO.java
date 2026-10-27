package cn.iocoder.yudao.module.mes.controller.admin.dv.subject.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - MES inspection and maintenance item page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MesDvSubjectPageReqVO extends PageParam {

    @Schema(description = "Item code.", example = "CHK001")
    private String code;

    @Schema(description = "Item name.", example = "Injection-machine visual check")
    private String name;

    @Schema(description = "Item type.", example = "1")
    private Integer type;

    @Schema(description = "Status.", example = "0")
    private Integer status;

}
