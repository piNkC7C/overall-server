package cn.iocoder.yudao.module.ai.controller.admin.model;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.apikey.AiApiKeyPageReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.apikey.AiApiKeyRespVO;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.apikey.AiApiKeySaveReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.model.vo.model.AiModelRespVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.model.AiApiKeyDO;
import cn.iocoder.yudao.module.ai.service.model.AiApiKeyService;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - AI API secret.")
@RestController
@RequestMapping("/ai/api-key")
@Validated
public class AiApiKeyController {

    @Resource
    private AiApiKeyService apiKeyService;

    @PostMapping("/create")
    @Operation(summary = "Create API secret.")
    @PreAuthorize("@ss.hasPermission('ai:api-key:create')")
    public CommonResult<Long> createApiKey(@Valid @RequestBody AiApiKeySaveReqVO createReqVO) {
        return success(apiKeyService.createApiKey(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update API secret.")
    @PreAuthorize("@ss.hasPermission('ai:api-key:update')")
    public CommonResult<Boolean> updateApiKey(@Valid @RequestBody AiApiKeySaveReqVO updateReqVO) {
        apiKeyService.updateApiKey(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete API secret.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('ai:api-key:delete')")
    public CommonResult<Boolean> deleteApiKey(@RequestParam("id") Long id) {
        apiKeyService.deleteApiKey(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get API secret.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:api-key:query')")
    public CommonResult<AiApiKeyRespVO> getApiKey(@RequestParam("id") Long id) {
        AiApiKeyDO apiKey = apiKeyService.getApiKey(id);
        return success(BeanUtils.toBean(apiKey, AiApiKeyRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get API secret page.")
    @PreAuthorize("@ss.hasPermission('ai:api-key:query')")
    public CommonResult<PageResult<AiApiKeyRespVO>> getApiKeyPage(@Valid AiApiKeyPageReqVO pageReqVO) {
        PageResult<AiApiKeyDO> pageResult = apiKeyService.getApiKeyPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AiApiKeyRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get API secret page list.")
    public CommonResult<List<AiModelRespVO>> getApiKeySimpleList() {
        List<AiApiKeyDO> list = apiKeyService.getApiKeyList();
        return success(convertList(list, key -> new AiModelRespVO().setId(key.getId()).setName(key.getName())));
    }

}