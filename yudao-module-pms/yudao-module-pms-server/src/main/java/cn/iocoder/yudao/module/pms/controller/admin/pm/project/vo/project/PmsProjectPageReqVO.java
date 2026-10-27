package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.project;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.project.PmsProjectSceneTypeEnum;
import cn.iocoder.yudao.module.pms.enums.pm.project.PmsProjectSortTypeEnum;
import cn.iocoder.yudao.module.pms.enums.pm.project.PmsProjectStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - PMS item page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PmsProjectPageReqVO extends PageParam {

    @Schema(description = "Item name.", example = "Website")
    private String name;

    @Schema(description = "ListScene.", example = "1")
    @InEnum(PmsProjectSceneTypeEnum.class)
    private Integer sceneType = PmsProjectSceneTypeEnum.ALL.getType();

    @Schema(description = "Person item group code.", example = "1024")
    private Long groupId;

    @Schema(description = "Item status.", example = "1")
    @InEnum(PmsProjectStatusEnum.class)
    private Integer status = PmsProjectStatusEnum.ACTIVE.getStatus();

    @Schema(description = "Sort type.", example = "1")
    @InEnum(PmsProjectSortTypeEnum.class)
    private Integer sortType = PmsProjectSortTypeEnum.ACCESS_TIME.getType();

}
