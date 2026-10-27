package cn.iocoder.yudao.module.mp.controller.admin.menu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "Admin - Official Accountmenu save request.")
@Data
public class MpMenuSaveReqVO {

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Official Account account code is required.")
    private Long accountId;

    @NotEmpty(message = "Menu is required.")
    @Valid
    private List<Menu> menus;

    @Schema(description = "Admin - Official Accountmenu save time each menu.")
    @Data
    public static class Menu extends MpMenuBaseVO {

        /**
         * 子菜单数组
         */
        private List<Menu> children;

    }

}
