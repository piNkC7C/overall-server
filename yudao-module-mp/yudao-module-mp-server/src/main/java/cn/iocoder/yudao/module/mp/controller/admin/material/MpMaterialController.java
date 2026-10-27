package cn.iocoder.yudao.module.mp.controller.admin.material;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.mp.controller.admin.material.vo.*;
import cn.iocoder.yudao.module.mp.convert.material.MpMaterialConvert;
import cn.iocoder.yudao.module.mp.dal.dataobject.material.MpMaterialDO;
import cn.iocoder.yudao.module.mp.service.material.MpMaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.io.IOException;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - Official Accountmedia.")
@RestController
@RequestMapping("/mp/material")
@Validated
public class MpMaterialController {

    @Resource
    private MpMaterialService mpMaterialService;

    @Operation(summary = "Upload temporary media.")
    @PostMapping("/upload-temporary")
    @PreAuthorize("@ss.hasPermission('mp:material:upload-temporary')")
    public CommonResult<MpMaterialUploadRespVO> uploadTemporaryMaterial(
            @Valid MpMaterialUploadTemporaryReqVO reqVO) throws IOException {
        MpMaterialDO material = mpMaterialService.uploadTemporaryMaterial(reqVO);
        return success(MpMaterialConvert.INSTANCE.convert(material));
    }

    @Operation(summary = "Upload permanent media.")
    @PostMapping("/upload-permanent")
    @PreAuthorize("@ss.hasPermission('mp:material:upload-permanent')")
    public CommonResult<MpMaterialUploadRespVO> uploadPermanentMaterial(
            @Valid MpMaterialUploadPermanentReqVO reqVO) throws IOException {
        MpMaterialDO material = mpMaterialService.uploadPermanentMaterial(reqVO);
        return success(MpMaterialConvert.INSTANCE.convert(material));
    }

    @Operation(summary = "Deletemedia.")
    @DeleteMapping("/delete-permanent")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mp:material:delete')")
    public CommonResult<Boolean> deleteMaterial(@RequestParam("id") Long id) {
        mpMaterialService.deleteMaterial(id);
        return success(true);
    }

    @Operation(summary = "Upload article inline image.")
    @PostMapping("/upload-news-image")
    @PreAuthorize("@ss.hasPermission('mp:material:upload-news-image')")
    public CommonResult<String> uploadNewsImage(@Valid MpMaterialUploadNewsImageReqVO reqVO)
            throws IOException {
        return success(mpMaterialService.uploadNewsImage(reqVO));
    }

    @Operation(summary = "Get media page.")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('mp:material:query')")
    public CommonResult<PageResult<MpMaterialRespVO>> getMaterialPage(@Valid MpMaterialPageReqVO pageReqVO) {
        PageResult<MpMaterialDO> pageResult = mpMaterialService.getMaterialPage(pageReqVO);
        return success(MpMaterialConvert.INSTANCE.convertPage(pageResult));
    }

}
