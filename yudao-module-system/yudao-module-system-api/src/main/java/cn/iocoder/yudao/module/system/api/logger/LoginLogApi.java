package cn.iocoder.yudao.module.system.api.logger;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.logger.dto.LoginLogCreateReqDTO;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC - sign-in log.")
public interface LoginLogApi {

    String PREFIX = ApiConstants.PREFIX + "/login-log";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "Create sign-in log.")
    CommonResult<Boolean> createLoginLog(@Valid @RequestBody LoginLogCreateReqDTO reqDTO);

}
