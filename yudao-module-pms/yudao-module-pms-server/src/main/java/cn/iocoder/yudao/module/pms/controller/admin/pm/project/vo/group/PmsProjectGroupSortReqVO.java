package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS item group sort request.")
@Data
public class PmsProjectGroupSortReqVO {

    @Schema(description = "Item group sort item.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Item group sort item is required.")
    private List<Item> items;

    @Schema(description = "Admin - PMS item group sort item.")
    @Data
    public static class Item {

        @Schema(description = "Item group code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Item group code is required.")
        private Long id;

        @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Sort is required.")
        @Min(value = 0, message = "Sort order cannot be less than 0.")
        private Integer sort;

    }

}
