package cn.iocoder.yudao.module.mp.controller.admin.tag;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.mp.controller.admin.tag.vo.*;
import cn.iocoder.yudao.module.mp.convert.tag.MpTagConvert;
import cn.iocoder.yudao.module.mp.dal.dataobject.tag.MpTagDO;
import cn.iocoder.yudao.module.mp.service.tag.MpTagService;
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

@Tag(name = "Admin - Official Accounttag.")
@RestController
@RequestMapping("/mp/tag")
@Validated
public class MpTagController {

    @Resource
    private MpTagService mpTagService;

    @PostMapping("/create")
    @Operation(summary = "CreateOfficial Accounttag.")
    @PreAuthorize("@ss.hasPermission('mp:tag:create')")
    public CommonResult<Long> createTag(@Valid @RequestBody MpTagCreateReqVO createReqVO) {
        return success(mpTagService.createTag(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "UpdateOfficial Accounttag.")
    @PreAuthorize("@ss.hasPermission('mp:tag:update')")
    public CommonResult<Boolean> updateTag(@Valid @RequestBody MpTagUpdateReqVO updateReqVO) {
        mpTagService.updateTag(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "DeleteOfficial Accounttag.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mp:tag:delete')")
    public CommonResult<Boolean> deleteTag(@RequestParam("id") Long id) {
        mpTagService.deleteTag(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get Official Accounttag details.")
    @PreAuthorize("@ss.hasPermission('mp:tag:query')")
    public CommonResult<MpTagRespVO> get(@RequestParam("id") Long id) {
        MpTagDO mpTagDO = mpTagService.get(id);
        return success(MpTagConvert.INSTANCE.convert(mpTagDO));
    }

    @GetMapping("/page")
    @Operation(summary = "Get Official Accounttag page.")
    @PreAuthorize("@ss.hasPermission('mp:tag:query')")
    public CommonResult<PageResult<MpTagRespVO>> getTagPage(MpTagPageReqVO pageReqVO) {
        PageResult<MpTagDO> pageResult = mpTagService.getTagPage(pageReqVO);
        return success(MpTagConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/list-all-simple")
    @Operation(summary = "Get Official Account account simple info list.")
    @PreAuthorize("@ss.hasPermission('mp:account:query')")
    public CommonResult<List<MpTagSimpleRespVO>> getSimpleTags() {
        List<MpTagDO> list = mpTagService.getTagList();
        return success(MpTagConvert.INSTANCE.convertList02(list));
    }

    @PostMapping("/sync")
    @Operation(summary = "Sync Official Accounttag.")
    @Parameter(name = "accountId", description = "Official Account account code.", required = true)
    @PreAuthorize("@ss.hasPermission('mp:tag:sync')")
    public CommonResult<Boolean> syncTag(@RequestParam("accountId") Long accountId) {
        mpTagService.syncTag(accountId);
        return success(true);
    }

}
