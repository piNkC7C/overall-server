package cn.iocoder.yudao.module.crm.framework.rpc.core;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.bpm.api.task.BpmProcessInstanceApi;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static cn.iocoder.yudao.framework.common.exception.enums.GlobalErrorCodeConstants.NOT_IMPLEMENTED;

/**
 * Used when the workflow module is not on the classpath.
 * Contract and payment records can still be saved; submitting them for approval returns this error.
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnMissingClass("cn.iocoder.yudao.module.bpm.api.task.BpmProcessInstanceApiImpl")
public class BpmProcessInstanceApiUnavailableConfiguration {

    @Bean
    @ConditionalOnMissingBean(BpmProcessInstanceApi.class)
    public BpmProcessInstanceApi bpmProcessInstanceApi() {
        return new BpmProcessInstanceApiUnavailable();
    }

    static class BpmProcessInstanceApiUnavailable implements BpmProcessInstanceApi {

        private static final String MESSAGE =
                "Workflow is disabled. Contract and payment approval is unavailable.";

        @Override
        public CommonResult<String> createProcessInstance(Long userId, BpmProcessInstanceCreateReqDTO reqDTO) {
            return CommonResult.error(NOT_IMPLEMENTED.getCode(), MESSAGE);
        }

        @Override
        public CommonResult<Boolean> cancelProcessInstanceByStartUser(Long userId, String processInstanceId,
                                                                        String reason) {
            return CommonResult.error(NOT_IMPLEMENTED.getCode(), MESSAGE);
        }

    }

}
