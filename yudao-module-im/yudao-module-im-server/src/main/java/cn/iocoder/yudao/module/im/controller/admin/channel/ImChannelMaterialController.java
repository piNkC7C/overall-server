package cn.iocoder.yudao.module.im.controller.admin.channel;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.im.controller.admin.manager.channel.vo.material.ImChannelMaterialRespVO;
import cn.iocoder.yudao.module.im.dal.dataobject.channel.ImChannelMaterialDO;
import cn.iocoder.yudao.module.im.service.channel.ImChannelMaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "User APP - IM Channelmedia.")
@RestController
@RequestMapping("/im/channel/material")
@Validated
public class ImChannelMaterialController {

    @Resource
    private ImChannelMaterialService channelMaterialService;

    @GetMapping("/get")
    @Operation(summary = "Get media detail. Used when the client opens an article card.")
    @Parameter(name = "id", description = "Media code.", required = true, example = "1024")
    public CommonResult<ImChannelMaterialRespVO> getMaterial(@RequestParam("id") Long id) {
        ImChannelMaterialDO material = channelMaterialService.validateMaterialExists(id);
        return success(BeanUtils.toBean(material, ImChannelMaterialRespVO.class));
    }

}
