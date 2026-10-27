package cn.iocoder.yudao.module.bpm.controller.admin.task;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.number.NumberUtils;
import cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task.*;
import cn.iocoder.yudao.module.bpm.convert.task.BpmTaskConvert;
import cn.iocoder.yudao.module.bpm.dal.dataobject.definition.BpmFormDO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.definition.BpmProcessDefinitionInfoDO;
import cn.iocoder.yudao.module.bpm.enums.task.BpmAttachmentTypeEnum;
import cn.iocoder.yudao.module.bpm.service.definition.BpmFormService;
import cn.iocoder.yudao.module.bpm.service.definition.BpmProcessDefinitionService;
import cn.iocoder.yudao.module.bpm.service.task.BpmProcessInstanceService;
import cn.iocoder.yudao.module.bpm.service.task.BpmTaskService;
import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import cn.iocoder.yudao.module.system.api.dept.dto.DeptRespDTO;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.flowable.bpmn.model.UserTask;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.task.Attachment;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.*;
import static cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - Workflow Task Instance.")
@RestController
@RequestMapping("/bpm/task")
@Validated
public class BpmTaskController {

    @Resource
    private BpmTaskService taskService;
    @Resource
    private BpmProcessInstanceService processInstanceService;
    @Resource
    private BpmFormService formService;
    @Resource
    private BpmProcessDefinitionService processDefinitionService;

    @Resource
    private AdminUserApi adminUserApi;
    @Resource
    private DeptApi deptApi;

    @GetMapping("todo-page")
    @Operation(summary = "Get Todo Todo task page.")
    @PreAuthorize("@ss.hasPermission('bpm:task:query')")
    public CommonResult<PageResult<BpmTaskRespVO>> getTaskTodoPage(@Valid BpmTaskPageReqVO pageVO) {
        PageResult<Task> pageResult = taskService.getTaskTodoPage(getLoginUserId(), pageVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }

        // 拼接数据
        Map<String, ProcessInstance> processInstanceMap = processInstanceService.getProcessInstanceMap(
                convertSet(pageResult.getList(), Task::getProcessInstanceId));
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(processInstanceMap.values(), instance -> Long.valueOf(instance.getStartUserId())));
        Map<String, BpmProcessDefinitionInfoDO> processDefinitionInfoMap = processDefinitionService.getProcessDefinitionInfoMap(
                convertSet(pageResult.getList(), Task::getProcessDefinitionId));
        return success(BpmTaskConvert.INSTANCE.buildTodoTaskPage(pageResult, processInstanceMap, userMap, processDefinitionInfoMap));
    }

    @GetMapping("done-page")
    @Operation(summary = "Get Done completed task page.")
    @PreAuthorize("@ss.hasPermission('bpm:task:query')")
    public CommonResult<PageResult<BpmTaskRespVO>> getTaskDonePage(@Valid BpmTaskPageReqVO pageVO) {
        PageResult<HistoricTaskInstance> pageResult = taskService.getTaskDonePage(getLoginUserId(), pageVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }

        // 拼接数据
        Map<String, HistoricProcessInstance> processInstanceMap = processInstanceService.getHistoricProcessInstanceMap(
                convertSet(pageResult.getList(), HistoricTaskInstance::getProcessInstanceId));
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(processInstanceMap.values(), instance -> Long.valueOf(instance.getStartUserId())));
        Map<String, BpmProcessDefinitionInfoDO> processDefinitionInfoMap = processDefinitionService.getProcessDefinitionInfoMap(
                convertSet(pageResult.getList(), HistoricTaskInstance::getProcessDefinitionId));
        Map<String, List<Attachment>> taskAttachmentMap = getTaskAttachmentMap(pageResult.getList());
        return success(BpmTaskConvert.INSTANCE.buildTaskPage(pageResult, processInstanceMap, userMap, null,
                processDefinitionInfoMap, taskAttachmentMap));
    }

    @GetMapping("manager-page")
    @Operation(summary = "Get Alltask page.", description = "At [workflow task]menu.")
    @PreAuthorize("@ss.hasPermission('bpm:task:manager-query')")
    public CommonResult<PageResult<BpmTaskRespVO>> getTaskManagerPage(@Valid BpmTaskPageReqVO pageVO) {
        PageResult<HistoricTaskInstance> pageResult = taskService.getTaskPage(getLoginUserId(), pageVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }

        // 拼接数据
        Map<String, HistoricProcessInstance> processInstanceMap = processInstanceService.getHistoricProcessInstanceMap(
                convertSet(pageResult.getList(), HistoricTaskInstance::getProcessInstanceId));
        // Get User and Dept Map
        Set<Long> userIds = convertSet(processInstanceMap.values(), instance -> Long.valueOf(instance.getStartUserId()));
        userIds.addAll(convertSet(pageResult.getList(), task -> NumberUtils.parseLong(task.getAssignee())));
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(userIds);
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(
                convertSet(userMap.values(), AdminUserRespDTO::getDeptId));
        Map<String, BpmProcessDefinitionInfoDO> processDefinitionInfoMap = processDefinitionService.getProcessDefinitionInfoMap(
                convertSet(pageResult.getList(), HistoricTaskInstance::getProcessDefinitionId));
        Map<String, List<Attachment>> taskAttachmentMap = getTaskAttachmentMap(pageResult.getList());
        return success(BpmTaskConvert.INSTANCE.buildTaskPage(pageResult, processInstanceMap, userMap, deptMap,
                processDefinitionInfoMap, taskAttachmentMap));
    }

    @GetMapping("/list-by-process-instance-id")
    @Operation(summary = "Get specified workflow instance task list.", description = "Includes completed and incomplete.")
    @Parameter(name = "processInstanceId", description = "Workflow instance code.", required = true)
    @PreAuthorize("@ss.hasPermission('bpm:task:query')")
    public CommonResult<List<BpmTaskRespVO>> getTaskListByProcessInstanceId(
            @RequestParam("processInstanceId") String processInstanceId) {
        List<HistoricTaskInstance> taskList = taskService.getTaskListByProcessInstanceId(processInstanceId, true);
        if (CollUtil.isEmpty(taskList)) {
            return success(Collections.emptyList());
        }

        // 拼接数据
        Set<Long> userIds = convertSetByFlatMap(taskList, task ->
                Stream.of(NumberUtils.parseLong(task.getAssignee()), NumberUtils.parseLong(task.getOwner())));
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(userIds);
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(
                convertSet(userMap.values(), AdminUserRespDTO::getDeptId));
        // Get Form Map
        Map<Long, BpmFormDO> formMap = formService.getFormMap(
                convertSet(taskList, task -> NumberUtils.parseLong(task.getFormKey())));
        Map<String, List<Attachment>> taskAttachmentMap = getTaskAttachmentMap(taskList);
        return success(BpmTaskConvert.INSTANCE.buildTaskListByProcessInstanceId(taskList,
                formMap, userMap, deptMap, taskAttachmentMap));
    }

    @PutMapping("/approve")
    @Operation(summary = "Via task.")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> approveTask(@Valid @RequestBody BpmTaskApproveReqVO reqVO) {
        taskService.approveTask(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/reject")
    @Operation(summary = "Not via task.")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> rejectTask(@Valid @RequestBody BpmTaskRejectReqVO reqVO) {
        taskService.rejectTask(getLoginUserId(), reqVO);
        return success(true);
    }

    @GetMapping("/list-by-return")
    @Operation(summary = "Get all nodes that can be returned to.", description = "At [workflow details ] [return].")
    @Parameter(name = "taskId", description = "The current taskID.", required = true)
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<List<BpmTaskRespVO>> getTaskListByReturn(@RequestParam("id") String id) {
        List<UserTask> userTaskList = taskService.getUserTaskListByReturn(id);
        return success(convertList(userTaskList, userTask -> // 只返回 id 和 name
                new BpmTaskRespVO().setName(userTask.getName()).setTaskDefinitionKey(userTask.getId())));
    }

    @PutMapping("/return")
    @Operation(summary = "Returntask.", description = "At [workflow details ] [return].")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> returnTask(@Valid @RequestBody BpmTaskReturnReqVO reqVO) {
        taskService.returnTask(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/delegate")
    @Operation(summary = "Delegatetask.", description = "At [workflow details ] [delegate].")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> delegateTask(@Valid @RequestBody BpmTaskDelegateReqVO reqVO) {
        taskService.delegateTask(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/transfer")
    @Operation(summary = "Reassign task.", description = "Used by Reassign on the workflow detail page.")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> transferTask(@Valid @RequestBody BpmTaskTransferReqVO reqVO) {
        taskService.transferTask(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/create-sign")
    @Operation(summary = "Countersign.", description = "Before before countersign, after after countersign.")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> createSignTask(@Valid @RequestBody BpmTaskSignCreateReqVO reqVO) {
        taskService.createSignTask(getLoginUserId(), reqVO);
        return success(true);
    }

    @DeleteMapping("/delete-sign")
    @Operation(summary = "Remove countersign.")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> deleteSignTask(@Valid @RequestBody BpmTaskSignDeleteReqVO reqVO) {
        taskService.deleteSignTask(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/copy")
    @Operation(summary = "CC task.")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> copyTask(@Valid @RequestBody BpmTaskCopyReqVO reqVO) {
        taskService.copyTask(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/withdraw")
    @Operation(summary = "Withdrawtask.")
    @PreAuthorize("@ss.hasPermission('bpm:task:update')")
    public CommonResult<Boolean> withdrawTask(@RequestParam("taskId") String taskId) {
        taskService.withdrawTask(getLoginUserId(), taskId);
        return success(true);
    }

    @GetMapping("/list-by-parent-task-id")
    @Operation(summary = "Get specified parent task Subtask list.") // 目前用于，减签的时候，获得子任务列表
    @Parameter(name = "parentTaskId", description = "Parent task code.", required = true)
    @PreAuthorize("@ss.hasPermission('bpm:task:query')")
    public CommonResult<List<BpmTaskRespVO>> getTaskListByParentTaskId(@RequestParam("parentTaskId") String parentTaskId) {
        List<Task> taskList = taskService.getTaskListByParentTaskId(parentTaskId);
        if (CollUtil.isEmpty(taskList)) {
            return success(Collections.emptyList());
        }
        // 拼接数据
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(convertSetByFlatMap(taskList,
                user -> Stream.of(NumberUtils.parseLong(user.getAssignee()), NumberUtils.parseLong(user.getOwner()))));
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(
                convertSet(userMap.values(), AdminUserRespDTO::getDeptId));
        return success(BpmTaskConvert.INSTANCE.buildTaskListByParentTaskId(taskList, userMap, deptMap));
    }

    /**
     * 获得任务附件 Map
     *
     * @param taskList 历史任务列表
     * @return 任务附件 Map，key 为任务编号
     */
    private Map<String, List<Attachment>> getTaskAttachmentMap(List<HistoricTaskInstance> taskList) {
        // 1.1 get workflow instance task Map
        Map<String, List<HistoricTaskInstance>> processTaskMap = convertMultiMap(taskList,
                HistoricTaskInstance::getProcessInstanceId);
        // 1.2 get taskAttachment list
        List<Attachment> attachments = new ArrayList<>();
        processTaskMap.forEach((processInstanceId, tasks) -> attachments.addAll(taskService.getAttachments(
                processInstanceId, convertSet(tasks, HistoricTaskInstance::getId), BpmAttachmentTypeEnum.TASK_ATTACHMENT)));
        // 2. 返回 Map
        return convertMultiMap(attachments, Attachment::getTaskId);
    }

}
