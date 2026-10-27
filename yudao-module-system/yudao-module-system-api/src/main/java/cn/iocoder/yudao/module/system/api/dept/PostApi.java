package cn.iocoder.yudao.module.system.api.dept;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.module.system.api.dept.dto.PostRespDTO;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - post.")
public interface PostApi {

    String PREFIX = ApiConstants.PREFIX + "/post";

    @GetMapping(PREFIX + "/valid")
    @Operation(summary = "Validate job title valid.")
    @Parameter(name = "ids", description = "Post ID list.", example = "1,2", required = true)
    CommonResult<Boolean> validPostList(@RequestParam("ids") Collection<Long> ids);

    @GetMapping(PREFIX + "/list")
    @Operation(summary = "Get post list.")
    @Parameter(name = "ids", description = "Post ID list.", example = "1,2", required = true)
    CommonResult<List<PostRespDTO>> getPostList(@RequestParam("ids") Collection<Long> ids);

    default Map<Long, PostRespDTO> getPostMap(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return MapUtil.empty();
        }

        List<PostRespDTO> list = getPostList(ids).getData();
        return CollectionUtils.convertMap(list, PostRespDTO::getId);
    }

}
