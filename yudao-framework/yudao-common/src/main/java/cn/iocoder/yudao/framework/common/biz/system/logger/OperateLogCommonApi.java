package cn.iocoder.yudao.framework.common.biz.system.logger;

import cn.iocoder.yudao.framework.common.biz.system.logger.dto.OperateLogCreateReqDTO;
import cn.iocoder.yudao.framework.common.enums.RpcConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = RpcConstants.SYSTEM_NAME, primary = false) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - Activity Log.")
public interface OperateLogCommonApi {

    String PREFIX = RpcConstants.SYSTEM_PREFIX + "/operate-log";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "CreateActivity Log.")
    CommonResult<Boolean> createOperateLog(@Valid @RequestBody OperateLogCreateReqDTO createReqDTO);

    /**
     * 【异步】创建操作日志
     *
     * @param createReqDTO 请求
     */
    @Async
    default void createOperateLogAsync(OperateLogCreateReqDTO createReqDTO) {
        createOperateLog(createReqDTO).checkError();
    }

}
