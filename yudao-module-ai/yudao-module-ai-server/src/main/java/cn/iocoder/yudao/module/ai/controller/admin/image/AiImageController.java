package cn.iocoder.yudao.module.ai.controller.admin.image;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.module.ai.framework.ai.core.model.midjourney.api.MidjourneyApi;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import cn.iocoder.yudao.module.ai.controller.admin.image.vo.*;
import cn.iocoder.yudao.module.ai.controller.admin.image.vo.midjourney.AiMidjourneyActionReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.image.vo.midjourney.AiMidjourneyImagineReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.image.AiImageDO;
import cn.iocoder.yudao.module.ai.service.image.AiImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - AI image generation.")
@RestController
@RequestMapping("/ai/image")
@Slf4j
public class AiImageController {

    @Resource
    private AiImageService imageService;

    @GetMapping("/my-page")
    @Operation(summary = "Get [ my ] image generation page.")
    public CommonResult<PageResult<AiImageRespVO>> getImagePageMy(@Validated AiImagePageReqVO pageReqVO) {
        PageResult<AiImageDO> pageResult = imageService.getImagePageMy(getLoginUserId(), pageReqVO);
        return success(BeanUtils.toBean(pageResult, AiImageRespVO.class));
    }

    @GetMapping("/public-page")
    @Operation(summary = "Get public images page.")
    public CommonResult<PageResult<AiImageRespVO>> getImagePagePublic(AiImagePublicPageReqVO pageReqVO) {
        PageResult<AiImageDO> pageResult = imageService.getImagePagePublic(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AiImageRespVO.class));
    }

    @GetMapping("/get-my")
    @Operation(summary = "Get [ my ] image record.")
    @Parameter(name = "id", required = true, description = "Image generationID.", example = "1024")
    public CommonResult<AiImageRespVO> getImageMy(@RequestParam("id") Long id) {
        AiImageDO image = imageService.getImage(id);
        if (image == null || ObjUtil.notEqual(getLoginUserId(), image.getUserId())) {
            return success(null);
        }
        return success(BeanUtils.toBean(image, AiImageRespVO.class));
    }

    @GetMapping("/my-list-by-ids")
    @Operation(summary = "Get [ my ] image record list.")
    @Parameter(name = "ids", required = true, description = "Image generationIDArray.", example = "1024,2048")
    public CommonResult<List<AiImageRespVO>> getImageListMyByIds(@RequestParam("ids") List<Long> ids) {
        List<AiImageDO> imageList = imageService.getImageList(ids);
        imageList.removeIf(item -> !ObjUtil.equal(getLoginUserId(), item.getUserId()));
        return success(BeanUtils.toBean(imageList, AiImageRespVO.class));
    }

    @Operation(summary = "CreateImage.")
    @PostMapping("/draw")
    public CommonResult<Long> drawImage(@Valid @RequestBody AiImageDrawReqVO drawReqVO) {
        return success(imageService.drawImage(getLoginUserId(), drawReqVO));
    }

    @Operation(summary = "Delete [ my ] image record.")
    @DeleteMapping("/delete-my")
    @Parameter(name = "id", required = true, description = "Image generationID.", example = "1024")
    public CommonResult<Boolean> deleteImageMy(@RequestParam("id") Long id) {
        imageService.deleteImageMy(id, getLoginUserId());
        return success(true);
    }

    // ================ midjourney 专属 ================

    @Operation(summary = "[Midjourney]createImage.")
    @PostMapping("/midjourney/imagine")
    public CommonResult<Long> midjourneyImagine(@Valid @RequestBody AiMidjourneyImagineReqVO reqVO) {
        Long imageId = imageService.midjourneyImagine(getLoginUserId(), reqVO);
        return success(imageId);
    }

    @Operation(summary = "Midjourney image-progress notification.", description = "Callback from Midjourney Proxy.")
    @PostMapping("/midjourney/notify") // 必须是 POST 方法，否则会报错
    @PermitAll
    @TenantIgnore
    public CommonResult<Boolean> midjourneyNotify(@Valid @RequestBody MidjourneyApi.Notify notify) {
        imageService.midjourneyNotify(notify);
        return success(true);
    }

    @Operation(summary = "Midjourney action (regenerate image).", description = "For example: upscale, variation, U1, U2.")
    @PostMapping("/midjourney/action")
    public CommonResult<Long> midjourneyAction(@Valid @RequestBody AiMidjourneyActionReqVO reqVO) {
        Long imageId = imageService.midjourneyAction(getLoginUserId(), reqVO);
        return success(imageId);
    }

    // ================ 绘图管理 ================

    @GetMapping("/page")
    @Operation(summary = "Getimage generationpage.")
    @PreAuthorize("@ss.hasPermission('ai:image:query')")
    public CommonResult<PageResult<AiImageRespVO>> getImagePage(@Valid AiImagePageReqVO pageReqVO) {
        PageResult<AiImageDO> pageResult = imageService.getImagePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AiImageRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "Getimage generation.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:image:query')")
    public CommonResult<AiImageRespVO> getImage(@RequestParam("id") Long id) {
        AiImageDO image = imageService.getImage(id);
        return success(BeanUtils.toBean(image, AiImageRespVO.class));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateimage generation.")
    @PreAuthorize("@ss.hasPermission('ai:image:update')")
    public CommonResult<Boolean> updateImage(@Valid @RequestBody AiImageUpdateReqVO updateReqVO) {
        imageService.updateImage(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteimage generation.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('ai:image:delete')")
    public CommonResult<Boolean> deleteImage(@RequestParam("id") Long id) {
        imageService.deleteImage(id);
        return success(true);
    }

}
