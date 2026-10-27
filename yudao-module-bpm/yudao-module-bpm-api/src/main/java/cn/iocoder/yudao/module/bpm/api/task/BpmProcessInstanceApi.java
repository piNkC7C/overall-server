package cn.iocoder.yudao.module.bpm.api.task;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import cn.iocoder.yudao.module.bpm.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - workflow instance.")
public interface BpmProcessInstanceApi {

    String PREFIX = ApiConstants.PREFIX + "/process-instance";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "Create a workflow instance (internal). Returns the instance ID.")
    @Parameter(name = "userId", description = "User ID.", required = true, example = "1")
    CommonResult<String> createProcessInstance(@RequestParam("userId") Long userId,
                                               @Valid @RequestBody BpmProcessInstanceCreateReqDTO reqDTO);

    @PostMapping(PREFIX + "/cancel-by-start-user")
    @Operation(summary = "Cancel workflow instance (for internal use).")
    CommonResult<Boolean> cancelProcessInstanceByStartUser(
            @RequestParam("userId") Long userId,
            @RequestParam("processInstanceId") String processInstanceId,
            @RequestParam("reason") String reason);

}
