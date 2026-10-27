package cn.iocoder.yudao.framework.common.biz.infra.logger;

import cn.iocoder.yudao.framework.common.biz.infra.logger.dto.ApiErrorLogCreateReqDTO;
import cn.iocoder.yudao.framework.common.enums.RpcConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = RpcConstants.INFRA_NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC - API exception log.")
public interface ApiErrorLogCommonApi {

    String PREFIX = RpcConstants.INFRA_PREFIX + "/api-error-log";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "Create API exception log.")
    CommonResult<Boolean> createApiErrorLog(@Valid @RequestBody ApiErrorLogCreateReqDTO createDTO);

    /**
     * 【异步】创建 API 异常日志
     *
     * @param createDTO 异常日志 DTO
     */
    @Async
    default void createApiErrorLogAsync(ApiErrorLogCreateReqDTO createDTO) {
        createApiErrorLog(createDTO).checkError();
    }

}
