package cn.iocoder.yudao.module.pms.controller.admin.kb.library.vo.library;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - PMS knowledge base page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PmsKnowledgeLibraryPageReqVO extends PageParam {

    @Schema(description = "Knowledge base name.", example = "Product.")
    private String name;

    @Schema(description = "Person knowledge base group code.", example = "1024")
    private Long groupId;

}
