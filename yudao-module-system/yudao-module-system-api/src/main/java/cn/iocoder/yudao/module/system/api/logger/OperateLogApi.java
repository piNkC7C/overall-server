package cn.iocoder.yudao.module.system.api.logger;

import cn.iocoder.yudao.framework.common.biz.system.logger.OperateLogCommonApi;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.api.logger.dto.OperateLogPageReqDTO;
import cn.iocoder.yudao.module.system.api.logger.dto.OperateLogRespDTO;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - Activity Log.")
public interface OperateLogApi extends OperateLogCommonApi {

    String PREFIX = ApiConstants.PREFIX + "/operate-log";

    @GetMapping(PREFIX + "/page")
    @Operation(summary = "Get specified module specified data Activity Log page.")
    CommonResult<PageResult<OperateLogRespDTO>> getOperateLogPage(@SpringQueryMap OperateLogPageReqDTO pageReqDTO);

}
