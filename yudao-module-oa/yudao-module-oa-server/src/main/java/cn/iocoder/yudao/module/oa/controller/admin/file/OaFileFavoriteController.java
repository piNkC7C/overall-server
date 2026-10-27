package cn.iocoder.yudao.module.oa.controller.admin.file;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.oa.service.file.OaFileFavoriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - cloud-drive favorite.")
@RestController
@RequestMapping("/oa/file-favorite")
@Validated
public class OaFileFavoriteController {

    @Resource
    private OaFileFavoriteService fileFavoriteService;

    @PostMapping("/create")
    @Operation(summary = "Favorite file.")
    @Parameter(name = "nodeId", description = "Node code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('oa:file:query')")
    public CommonResult<Boolean> createFileFavorite(@RequestParam("nodeId") Long nodeId) {
        fileFavoriteService.createFileFavorite(nodeId, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "CancelFavorite file.")
    @Parameter(name = "nodeId", description = "Node code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('oa:file:query')")
    public CommonResult<Boolean> deleteFileFavorite(@RequestParam("nodeId") Long nodeId) {
        fileFavoriteService.deleteFileFavorite(nodeId, getLoginUserId());
        return success(true);
    }

}
