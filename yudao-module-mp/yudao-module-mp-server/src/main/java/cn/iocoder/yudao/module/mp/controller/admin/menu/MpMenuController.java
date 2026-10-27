package cn.iocoder.yudao.module.mp.controller.admin.menu;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.mp.controller.admin.menu.vo.MpMenuRespVO;
import cn.iocoder.yudao.module.mp.controller.admin.menu.vo.MpMenuSaveReqVO;
import cn.iocoder.yudao.module.mp.convert.menu.MpMenuConvert;
import cn.iocoder.yudao.module.mp.dal.dataobject.menu.MpMenuDO;
import cn.iocoder.yudao.module.mp.service.menu.MpMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - Official Accountmenu.")
@RestController
@RequestMapping("/mp/menu")
@Validated
public class MpMenuController {

    @Resource
    private MpMenuService mpMenuService;

    @PostMapping("/save")
    @Operation(summary = "Save Official Accountmenu.")
    @PreAuthorize("@ss.hasPermission('mp:menu:save')")
    public CommonResult<Boolean> saveMenu(@Valid @RequestBody MpMenuSaveReqVO createReqVO) {
        mpMenuService.saveMenu(createReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "DeleteOfficial Accountmenu.")
    @Parameter(name = "accountId", description = "Official Account account code.", required = true, example = "10")
    @PreAuthorize("@ss.hasPermission('mp:menu:delete')")
    public CommonResult<Boolean> deleteMenu(@RequestParam("accountId") Long accountId) {
        mpMenuService.deleteMenuByAccountId(accountId);
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "Get Official Accountmenu list.")
    @Parameter(name = "accountId", description = "Official Account account code.", required = true, example = "10")
    @PreAuthorize("@ss.hasPermission('mp:menu:query')")
    public CommonResult<List<MpMenuRespVO>> getMenuList(@RequestParam("accountId") Long accountId) {
        List<MpMenuDO> list = mpMenuService.getMenuListByAccountId(accountId);
        return success(MpMenuConvert.INSTANCE.convertList(list));
    }

}
