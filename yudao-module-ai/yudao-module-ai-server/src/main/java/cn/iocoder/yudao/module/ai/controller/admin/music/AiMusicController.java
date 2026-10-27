package cn.iocoder.yudao.module.ai.controller.admin.music;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.ai.controller.admin.music.vo.*;
import cn.iocoder.yudao.module.ai.dal.dataobject.music.AiMusicDO;
import cn.iocoder.yudao.module.ai.service.music.AiMusicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - AI music.")
@RestController
@RequestMapping("/ai/music")
public class AiMusicController {

    @Resource
    private AiMusicService musicService;

    @GetMapping("/my-page")
    @Operation(summary = "Get [ my ] music page.")
    public CommonResult<PageResult<AiMusicRespVO>> getMusicMyPage(@Valid AiMusicPageReqVO pageReqVO) {
        PageResult<AiMusicDO> pageResult = musicService.getMusicMyPage(pageReqVO, getLoginUserId());
        return success(BeanUtils.toBean(pageResult, AiMusicRespVO.class));
    }

    @PostMapping("/generate")
    @Operation(summary = "Musicgenerate.")
    public CommonResult<List<Long>> generateMusic(@RequestBody @Valid AiSunoGenerateReqVO reqVO) {
        return success(musicService.generateMusic(getLoginUserId(), reqVO));
    }

    @Operation(summary = "Delete [ my ] music record.")
    @DeleteMapping("/delete-my")
    @Parameter(name = "id", required = true, description = "MusicID.", example = "1024")
    public CommonResult<Boolean> deleteMusicMy(@RequestParam("id") Long id) {
        musicService.deleteMusicMy(id, getLoginUserId());
        return success(true);
    }

    @GetMapping("/get-my")
    @Operation(summary = "Get [ my ] music.")
    @Parameter(name = "id", required = true, description = "MusicID.", example = "1024")
    public CommonResult<AiMusicRespVO> getMusicMy(@RequestParam("id") Long id) {
        AiMusicDO music = musicService.getMusic(id);
        if (music == null || ObjUtil.notEqual(getLoginUserId(), music.getUserId())) {
            return success(null);
        }
        return success(BeanUtils.toBean(music, AiMusicRespVO.class));
    }

    @PostMapping("/update-my")
    @Operation(summary = "Update my music. Currently only the title can change.")
    @Parameter(name = "title", required = true, description = "Music name.", example = "Brightest star")
    public CommonResult<Boolean> updateMy(AiMusicUpdateMyReqVO updateReqVO) {
        musicService.updateMyMusic(updateReqVO, getLoginUserId());
        return success(true);
    }

    // ================ 音乐管理 ================

    @GetMapping("/page")
    @Operation(summary = "Getmusicpage.")
    @PreAuthorize("@ss.hasPermission('ai:music:query')")
    public CommonResult<PageResult<AiMusicRespVO>> getMusicPage(@Valid AiMusicPageReqVO pageReqVO) {
        PageResult<AiMusicDO> pageResult = musicService.getMusicPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AiMusicRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "Getmusic.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:music:query')")
    public CommonResult<AiMusicRespVO> getMusic(@RequestParam("id") Long id) {
        AiMusicDO music = musicService.getMusic(id);
        return success(BeanUtils.toBean(music, AiMusicRespVO.class));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletemusic.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('ai:music:delete')")
    public CommonResult<Boolean> deleteMusic(@RequestParam("id") Long id) {
        musicService.deleteMusic(id);
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "Updatemusic.")
    @PreAuthorize("@ss.hasPermission('ai:music:update')")
    public CommonResult<Boolean> updateMusic(@Valid @RequestBody AiMusicUpdateReqVO updateReqVO) {
        musicService.updateMusic(updateReqVO);
        return success(true);
    }

}
