package cn.iocoder.yudao.module.member.controller.admin.tag;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.member.controller.admin.tag.vo.MemberTagCreateReqVO;
import cn.iocoder.yudao.module.member.controller.admin.tag.vo.MemberTagPageReqVO;
import cn.iocoder.yudao.module.member.controller.admin.tag.vo.MemberTagRespVO;
import cn.iocoder.yudao.module.member.controller.admin.tag.vo.MemberTagUpdateReqVO;
import cn.iocoder.yudao.module.member.convert.tag.MemberTagConvert;
import cn.iocoder.yudao.module.member.dal.dataobject.tag.MemberTagDO;
import cn.iocoder.yudao.module.member.service.tag.MemberTagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - membertag.")
@RestController
@RequestMapping("/member/tag")
@Validated
public class MemberTagController {

    @Resource
    private MemberTagService tagService;

    @PostMapping("/create")
    @Operation(summary = "Createmembertag.")
    @PreAuthorize("@ss.hasPermission('member:tag:create')")
    public CommonResult<Long> createTag(@Valid @RequestBody MemberTagCreateReqVO createReqVO) {
        return success(tagService.createTag(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatemembertag.")
    @PreAuthorize("@ss.hasPermission('member:tag:update')")
    public CommonResult<Boolean> updateTag(@Valid @RequestBody MemberTagUpdateReqVO updateReqVO) {
        tagService.updateTag(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletemembertag.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('member:tag:delete')")
    public CommonResult<Boolean> deleteTag(@RequestParam("id") Long id) {
        tagService.deleteTag(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get membertag.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('member:tag:query')")
    public CommonResult<MemberTagRespVO> getMemberTag(@RequestParam("id") Long id) {
        MemberTagDO tag = tagService.getTag(id);
        return success(MemberTagConvert.INSTANCE.convert(tag));
    }

    @GetMapping("/list-all-simple")
    @Operation(summary = "Get membertag simple info list.", description = "Only enabled member tag. Used for dropdowns.")
    public CommonResult<List<MemberTagRespVO>> getSimpleTagList() {
        // 获用户列表，只要开启状态的
        List<MemberTagDO> list = tagService.getTagList();
        // 排序后，返回给前端
        return success(MemberTagConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/list")
    @Operation(summary = "Get membertag list.")
    @Parameter(name = "ids", description = "Code list.", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('member:tag:query')")
    public CommonResult<List<MemberTagRespVO>> getMemberTagList(@RequestParam("ids") Collection<Long> ids) {
        List<MemberTagDO> list = tagService.getTagList(ids);
        return success(MemberTagConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "Get membertag page.")
    @PreAuthorize("@ss.hasPermission('member:tag:query')")
    public CommonResult<PageResult<MemberTagRespVO>> getTagPage(@Valid MemberTagPageReqVO pageVO) {
        PageResult<MemberTagDO> pageResult = tagService.getTagPage(pageVO);
        return success(MemberTagConvert.INSTANCE.convertPage(pageResult));
    }

}
