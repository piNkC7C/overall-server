package cn.iocoder.yudao.module.system.sentineldemo.controller.admin;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.sentineldemo.DemoSentinelInfraApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - Sentinel 服务保障示例
 *
 * 三个接口分别演示网关限流、服务限流、Feign 熔断降级，对应的规则见 script/sentinel/nacos 目录：
 * 1. /gateway-flow：gateway-server 的 API 分组 system-sentinel-demo-api
 * 2. /flow：system-server 的 URL 资源 /admin-api/system/sentinel-demo/flow
 * 3. /feign：system-server 的 Feign 资源 GET:http://infra-server/rpc-api/infra/sentinel-demo/echo
 *
 * 放在 controller.admin 包下，才会和项目其它管理后台接口一样，添加 /admin-api 前缀
 *
 * @author 芋道源码
 */
@Tag(name = "Admin - Sentinel sample.")
@RestController
@RequestMapping("/system/sentinel-demo")
@RequiredArgsConstructor // 使用构造方法注入，避免 JDK 8 与 JDK 17+ 分支的 @Resource 包名不同
public class DemoSentinelController {

    private final DemoSentinelInfraApi demoSentinelInfraApi;

    @GetMapping("/gateway-flow")
    @Operation(summary = "Gateway rate-limit sample.", description = "Limited by the gateway-server API group system-sentinel-demo-api. At most 2 requests per second.")
    public CommonResult<String> gatewayFlow() {
        return success("gateway-flow");
    }

    @GetMapping("/flow")
    @Operation(summary = "Service rate-limit sample.", description = "Limited by the system-server URL /admin-api/system/sentinel-demo/flow. At most 2 requests per second.")
    public CommonResult<String> flow() {
        return success("flow");
    }

    @GetMapping("/feign")
    @Operation(summary = "Feign circuit-breaker sample.", description = "Calls infra-server over Feign. When the slow-call ratio exceeds the threshold, the circuit opens for 10 seconds and returns the fallbackFactory error code.")
    @Parameter(name = "mode", description = "How infra-server should behave: ok=success, slow=slow call, biz-error=business error.", example = "ok")
    public CommonResult<String> feign(@RequestParam(value = "mode", defaultValue = "ok") String mode) {
        // 必须调用 getCheckedData()：infra-server 的业务错误码、fallbackFactory 返回的错误码，都在这里抛出 ServiceException，
        // 由全局异常处理器返回给前端；不检查时，调用方会把失败当作成功，拿着为 null 的 data 继续执行
        return success(demoSentinelInfraApi.echo(mode).getCheckedData());
    }

}
