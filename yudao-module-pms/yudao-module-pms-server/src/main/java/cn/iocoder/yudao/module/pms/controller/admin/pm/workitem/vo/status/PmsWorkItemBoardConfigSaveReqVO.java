package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.status;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - PMS 工作项看板配置保存 Request VO")
@Data
public class PmsWorkItemBoardConfigSaveReqVO {

    @Schema(description = "项目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "工作项类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Work item type is required.")
    @InEnum(PmsWorkItemTypeEnum.class)
    private Integer workItemType;

    @Schema(description = "看板列列表", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "Board columns cannot be empty.")
    private List<Board> boards;

    @Schema(description = "管理后台 - PMS 工作项看板列")
    @Data
    public static class Board {

        @Schema(description = "看板列编号", example = "1024")
        private Long id;

        @Schema(description = "看板列名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "In progress.")
        @NotBlank(message = "Board column name cannot be empty.")
        @Size(max = 50, message = "Board column name cannot exceed 50 characters.")
        private String name;

        @Schema(description = "关联状态编号列表，可为空", example = "[1024, 2048]")
        @NotNull(message = "Relation status code list is required.")
        private List<Long> statusIds;

    }

}
