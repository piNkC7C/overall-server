package cn.iocoder.yudao.framework.common.biz.infra.logger;

import cn.iocoder.yudao.framework.common.biz.infra.logger.dto.ApiAccessLogCreateReqDTO;
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
@Tag(name = "RPC - API access log.")
public interface ApiAccessLogCommonApi {

    String PREFIX = RpcConstants.INFRA_PREFIX + "/api-access-log";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "Create API access log.")
    CommonResult<Boolean> createApiAccessLog(@Valid @RequestBody ApiAccessLogCreateReqDTO createDTO);

    /**
     * 【异步】创建 API 访问日志
     *
     * @param createDTO 访问日志 DTO
     */
    @Async
    default void createApiAccessLogAsync(ApiAccessLogCreateReqDTO createDTO) {
        createApiAccessLog(createDTO).checkError();
    }

}
