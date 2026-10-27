package cn.iocoder.yudao.module.product.api.comment;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.product.api.comment.dto.ProductCommentCreateReqDTO;
import cn.iocoder.yudao.module.product.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - product comment.")
public interface ProductCommentApi {

    String PREFIX = ApiConstants.PREFIX + "/comment";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "Create comment.")
    CommonResult<Long> createComment(@RequestBody @Valid ProductCommentCreateReqDTO createReqDTO);

}
