package cn.iocoder.yudao.module.bpm.api.task;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import cn.iocoder.yudao.module.bpm.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import java.util.List;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC 服务 - 流程实例")
public interface BpmProcessInstanceApi {

    String PREFIX = ApiConstants.PREFIX + "/process-instance";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "创建流程实例（提供给内部），返回实例编号")
    @Parameter(name = "userId", description = "用户编号", required = true, example = "1")
    CommonResult<String> createProcessInstance(@RequestParam("userId") Long userId,
                                               @Valid @RequestBody BpmProcessInstanceCreateReqDTO reqDTO);

    @PostMapping(PREFIX + "/cancel-by-start-user")
    @Operation(summary = "取消流程实例（提供给内部）")
    CommonResult<Boolean> cancelProcessInstanceByStartUser(
            @RequestParam("userId") Long userId,
            @RequestParam("processInstanceId") String processInstanceId,
            @RequestParam("reason") String reason);

    @GetMapping(PREFIX + "/assignee-process-instance-ids")
    @Operation(summary = "获得用户作为审批人的流程实例编号列表（CRM 待办等）")
    @Parameters({
            @Parameter(name = "userId", description = "用户编号", required = true, example = "1"),
            @Parameter(name = "processDefinitionKey", description = "流程定义 Key", required = true,
                    example = "crm-contract-audit"),
            @Parameter(name = "activeOnly", description = "仅运行中待办；false=已办历史", example = "true")
    })
    CommonResult<List<String>> getAssigneeProcessInstanceIds(
            @RequestParam("userId") Long userId,
            @RequestParam("processDefinitionKey") String processDefinitionKey,
            @RequestParam(value = "activeOnly", defaultValue = "true") Boolean activeOnly);

}
