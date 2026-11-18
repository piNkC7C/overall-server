package cn.iocoder.yudao.module.bpm.api.task;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import cn.iocoder.yudao.module.bpm.controller.admin.task.vo.instance.BpmProcessInstanceCancelReqVO;
import cn.iocoder.yudao.module.bpm.service.task.BpmProcessInstanceService;
import cn.iocoder.yudao.module.bpm.service.task.BpmTaskService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * Flowable 流程实例 Api 实现类
 *
 * @author 芋道源码
 * @author jason
 */
@RestController
@Validated
public class BpmProcessInstanceApiImpl implements BpmProcessInstanceApi {

    @Resource
    private BpmProcessInstanceService processInstanceService;
    @Resource
    private BpmTaskService bpmTaskService;

    @Override
    public CommonResult<String> createProcessInstance(Long userId, @Valid BpmProcessInstanceCreateReqDTO reqDTO) {
        return success(processInstanceService.createProcessInstance(userId, reqDTO));
    }

    @Override
    public CommonResult<Boolean> cancelProcessInstanceByStartUser(
            Long userId, String processInstanceId, String reason) {
        BpmProcessInstanceCancelReqVO cancelReqVO = new BpmProcessInstanceCancelReqVO();
        cancelReqVO.setId(processInstanceId);
        cancelReqVO.setReason(reason);
        processInstanceService.cancelProcessInstanceByStartUser(userId, cancelReqVO);
        return success(true);
    }

    @Override
    public CommonResult<List<String>> getAssigneeProcessInstanceIds(
            Long userId, String processDefinitionKey, Boolean activeOnly) {
        boolean onlyActive = activeOnly == null || activeOnly;
        return success(bpmTaskService.getProcessInstanceIdsByAssignee(userId, processDefinitionKey, onlyActive));
    }

}
