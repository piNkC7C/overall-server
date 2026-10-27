package cn.iocoder.yudao.module.oa.controller.admin.file;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.oa.controller.admin.file.vo.permission.OaFilePermissionRespVO;
import cn.iocoder.yudao.module.oa.controller.admin.file.vo.permission.OaFilePermissionSaveReqVO;
import cn.iocoder.yudao.module.oa.dal.dataobject.file.OaFilePermissionDO;
import cn.iocoder.yudao.module.oa.service.file.OaFilePermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - cloud-drive share permission.")
@RestController
@RequestMapping("/oa/file-permission")
@Validated
public class OaFilePermissionController {

    @Resource
    private OaFilePermissionService filePermissionService;

    @GetMapping("/list")
    @Operation(summary = "Get file share permission.")
    @Parameter(name = "nodeId", description = "Node code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('oa:file:share')")
    public CommonResult<List<OaFilePermissionRespVO>> getFilePermissionList(@RequestParam("nodeId") Long nodeId) {
        List<OaFilePermissionDO> permissions = filePermissionService.getFilePermissionList(nodeId, getLoginUserId());
        return success(BeanUtils.toBean(permissions, OaFilePermissionRespVO.class));
    }

    @PostMapping("/save")
    @Operation(summary = "Save file share permission.")
    @PreAuthorize("@ss.hasPermission('oa:file:share')")
    public CommonResult<Long> saveFilePermission(@Valid @RequestBody OaFilePermissionSaveReqVO reqVO) {
        return success(filePermissionService.saveFilePermission(reqVO, getLoginUserId()));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Cancel file share permission.")
    @Parameter(name = "id", description = "Permission code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('oa:file:share')")
    public CommonResult<Boolean> deleteFilePermission(@RequestParam("id") Long id) {
        filePermissionService.deleteFilePermission(id, getLoginUserId());
        return success(true);
    }

}
