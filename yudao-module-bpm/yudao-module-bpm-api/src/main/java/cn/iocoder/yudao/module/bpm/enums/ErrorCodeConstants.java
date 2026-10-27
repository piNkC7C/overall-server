package cn.iocoder.yudao.module.bpm.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Bpm 错误码枚举类
 * <p>
 * bpm 系统，使用 1-009-000-000 段
 */
public interface ErrorCodeConstants {

    // ==========  通用流程处理 模块 1-009-000-000 ==========

    // ========== OA workflow module 1-009-001-000 ==========
    ErrorCode OA_LEAVE_NOT_EXISTS = new ErrorCode(1_009_001_001, "Leave request was not found.");

    // ========== workflow model 1-009-002-000 ==========
    ErrorCode MODEL_KEY_EXISTS = new ErrorCode(1_009_002_000, "Already existsworkflow key is [{}] workflow.");
    ErrorCode MODEL_NOT_EXISTS = new ErrorCode(1_009_002_001, "Workflow model was not found.");
    ErrorCode MODEL_KEY_VALID = new ErrorCode(1_009_002_002, "Workflow key format is invalid, must start with a letter or underscore, followed by letters, numbers, hyphens, underscores, or periods!");
    ErrorCode MODEL_DEPLOY_FAIL_FORM_NOT_CONFIG = new ErrorCode(1_009_002_003, "Could not deploy the workflow, : workflow form is not configured, click [Edit Workflow] to setting.");
    ErrorCode MODEL_DEPLOY_FAIL_TASK_CANDIDATE_NOT_CONFIG = new ErrorCode(1_009_002_004, "Could not deploy the workflow. "
            + "Reason: user task ({}) has no approver. Click [Workflow Design] and configure [Task (Approver)].");
    ErrorCode MODEL_DEPLOY_FAIL_BPMN_START_EVENT_NOT_EXISTS = new ErrorCode(1_009_002_005, "Could not deploy the workflow, : BPMN workflow diagram, has no start event.");
    ErrorCode MODEL_DEPLOY_FAIL_BPMN_USER_TASK_NAME_NOT_EXISTS = new ErrorCode(1_009_002_006, "Could not deploy the workflow, : BPMN workflow diagram, user task({}) name was not found.");
    ErrorCode MODEL_UPDATE_FAIL_NOT_MANAGER = new ErrorCode(1_009_002_007, "Could not update the workflow, : you are not the workflow({}) admin.");
    ErrorCode MODEL_DEPLOY_FAIL_FIRST_USER_TASK_CANDIDATE_STRATEGY_ERROR = new ErrorCode(1_009_002_008, "Could not deploy the workflow, : first task({}) approver cannot be [assignee selected by starter].");
    ErrorCode MODEL_IMPORT_FAIL_INVALID = new ErrorCode(1_009_002_009, "Could not import the workflow, workflow model file is empty or JSON is invalid.");

    // ========== workflow definition 1-009-003-000 ==========
    ErrorCode PROCESS_DEFINITION_KEY_NOT_MATCH = new ErrorCode(1_009_003_000, "Workflow definition key should be ({}), but it is ({}), change BPMN workflow diagram.");
    ErrorCode PROCESS_DEFINITION_NAME_NOT_MATCH = new ErrorCode(1_009_003_001, "Workflow definition name should be ({}), but it is ({}), change BPMN workflow diagram.");
    ErrorCode PROCESS_DEFINITION_NOT_EXISTS = new ErrorCode(1_009_003_002, "Workflow definition was not found.");
    ErrorCode PROCESS_DEFINITION_IS_SUSPENDED = new ErrorCode(1_009_003_003, "Workflow definition is suspended.");

    // ========== workflow instance 1-009-004-000 ==========
    ErrorCode PROCESS_INSTANCE_NOT_EXISTS = new ErrorCode(1_009_004_000, "Workflow instance was not found.");
    ErrorCode PROCESS_INSTANCE_CANCEL_FAIL_NOT_EXISTS = new ErrorCode(1_009_004_001, "Could not cancel the workflow, workflow is not running.");
    ErrorCode PROCESS_INSTANCE_CANCEL_FAIL_NOT_SELF = new ErrorCode(1_009_004_002, "Could not cancel the workflow, this workflow was not started by you.");
    ErrorCode PROCESS_INSTANCE_START_USER_SELECT_ASSIGNEES_NOT_CONFIG = new ErrorCode(1_009_004_003, "Task({}) candidate is not configured.");
    ErrorCode PROCESS_INSTANCE_START_USER_SELECT_ASSIGNEES_NOT_EXISTS = new ErrorCode(1_009_004_004, "Task({}) candidate({}) was not found.");
    ErrorCode PROCESS_INSTANCE_START_USER_CAN_START = new ErrorCode(1_009_004_005, "Could not start the workflow, you do not have permission to start this workflow.");
    ErrorCode PROCESS_INSTANCE_CANCEL_FAIL_NOT_ALLOW = new ErrorCode(1_009_004_005, "Could not cancel the workflow, this workflow cannot be canceled.");
    ErrorCode PROCESS_INSTANCE_HTTP_CALL_ERROR = new ErrorCode(1_009_004_006, "Workflow HTTP call failed.");
    ErrorCode PROCESS_INSTANCE_APPROVE_USER_SELECT_ASSIGNEES_NOT_CONFIG = new ErrorCode(1_009_004_007, "Next task({}) approver is not configured.");
    ErrorCode PROCESS_INSTANCE_CANCEL_CHILD_FAIL_NOT_ALLOW = new ErrorCode(1_009_004_008, "Could not cancel the child workflow, child workflow cannot be canceled.");
    ErrorCode PROCESS_INSTANCE_START_FORM_FIELD_REQUIRED = new ErrorCode(1_009_004_009, "Could not start the workflow, form field ({}) is required, is required.");

    // ========== workflow task 1-009-005-000 ==========
    ErrorCode TASK_OPERATE_FAIL_ASSIGN_NOT_SELF = new ErrorCode(1_009_005_001, "The action failed, : this task approver is not you.");
    ErrorCode TASK_NOT_EXISTS = new ErrorCode(1_009_005_002, "Workflow task was not found.");
    ErrorCode TASK_IS_PENDING = new ErrorCode(1_009_005_003, "The current task is suspended, cannot be changed.");
    ErrorCode TASK_TARGET_NODE_NOT_EXISTS = new ErrorCode(1_009_005_004, "Target node was not found.");
    ErrorCode TASK_RETURN_FAIL_SOURCE_TARGET_ERROR = new ErrorCode(1_009_005_006, "Could not return the task, target node is in parallel gateway or not the same path, so it cannot jump there.");
    ErrorCode TASK_DELEGATE_FAIL_USER_REPEAT = new ErrorCode(1_009_005_007, "Could not delegate the task, delegate and current approver is the same person.");
    ErrorCode TASK_DELEGATE_FAIL_USER_NOT_EXISTS = new ErrorCode(1_009_005_008, "Could not delegate the task, delegatee was not found.");
    ErrorCode TASK_SIGN_CREATE_USER_NOT_EXIST = new ErrorCode(1_009_005_009, "Taskcountersign： select user was not found.");
    ErrorCode TASK_SIGN_CREATE_TYPE_ERROR = new ErrorCode(1_009_005_010, "Taskcountersign：The current task already {}, cannot {}.");
    ErrorCode TASK_SIGN_CREATE_USER_REPEAT = new ErrorCode(1_009_005_011, "Could not add a countersignature, countersign user and existing approver[{}] is duplicated.");
    ErrorCode TASK_SIGN_DELETE_NO_PARENT = new ErrorCode(1_009_005_012, "Could not remove a countersignature, by remove countersign task must be via countersign created by task.");
    ErrorCode TASK_TRANSFER_FAIL_USER_REPEAT = new ErrorCode(1_009_005_013, "Could not transfer the task, transfer target and current approver is the same person.");
    ErrorCode TASK_TRANSFER_FAIL_USER_NOT_EXISTS = new ErrorCode(1_009_005_014, "Could not transfer the task, transfer target was not found.");
    ErrorCode TASK_SIGNATURE_NOT_EXISTS = new ErrorCode(1_009_005_015, "Signature is required!");
    ErrorCode TASK_REASON_REQUIRE = new ErrorCode(1_009_005_016, "Approval comment is required!");
    ErrorCode TASK_WITHDRAW_FAIL_PROCESS_NOT_RUNNING = new ErrorCode(1_009_005_017, "Could not withdraw, workflow instance is not running!");
    ErrorCode TASK_WITHDRAW_FAIL_TASK_NOT_EXISTS = new ErrorCode(1_009_005_018, "Could not withdraw, could not find user completed task!");
    ErrorCode TASK_WITHDRAW_FAIL_NOT_ALLOW = new ErrorCode(1_009_005_019, "Could not withdraw, this workflow cannot be withdrawnaction!");
    ErrorCode TASK_WITHDRAW_FAIL_NEXT_TASK_NOT_ALLOW = new ErrorCode(1_009_005_020, "Could not withdraw, next node not meet withdraw condition!");
    ErrorCode TASK_SIGN_DELETE_FAIL_NOT_SELF = new ErrorCode(1_009_005_021, "Could not remove a countersignature, : you are not the task countersign user.");
    ErrorCode TASK_OPERATE_FAIL_APPROVING = new ErrorCode(1_009_005_022, "The action failed, : this task already approved, waiting for countersign task approval complete.");
    ErrorCode TASK_SIGN_CREATE_TYPE_NOT_EXISTS = new ErrorCode(1_009_005_023, "Could not add a countersignature, countersign type({}) was not found.");

    // ========== dynamic form module 1-009-010-000 ==========
    ErrorCode FORM_NOT_EXISTS = new ErrorCode(1_009_010_000, "Dynamic form was not found.");
    ErrorCode FORM_FIELD_REPEAT = new ErrorCode(1_009_010_001, "Form item({}) and ({}) use the same field name({}).");

    // ========== user group module 1-009-011-000 ==========
    ErrorCode USER_GROUP_NOT_EXISTS = new ErrorCode(1_009_011_000, "User group was not found.");
    ErrorCode USER_GROUP_IS_DISABLE = new ErrorCode(1_009_011_001, "Name is [{}] user group is disabled.");

    // ========== user group module 1-009-012-000 ==========
    ErrorCode CATEGORY_NOT_EXISTS = new ErrorCode(1_009_012_000, "Workflowcategory was not found.");
    ErrorCode CATEGORY_NAME_DUPLICATE = new ErrorCode(1_009_012_001, "Workflowcategory name[{}] is duplicated.");
    ErrorCode CATEGORY_CODE_DUPLICATE = new ErrorCode(1_009_012_002, "Workflowcategory code[{}] is duplicated.");
    ErrorCode CATEGORY_DELETE_FAIL_MODEL_USED = new ErrorCode(1_009_012_003, "Could not delete, workflowcategory[{}] is already used by workflow model used, delete a matching workflow model.");

    // ========== BPM workflow listener 1-009-013-000 ==========
    ErrorCode PROCESS_LISTENER_NOT_EXISTS = new ErrorCode(1_009_013_000, "Workflow listener was not found.");
    ErrorCode PROCESS_LISTENER_CLASS_NOT_FOUND = new ErrorCode(1_009_013_001, "Workflow listener class ({}) was not found.");
    ErrorCode PROCESS_LISTENER_CLASS_IMPLEMENTS_ERROR = new ErrorCode(1_009_013_002, "Workflow listener class ({}) has no implement interface ({}).");
    ErrorCode PROCESS_LISTENER_EXPRESSION_INVALID = new ErrorCode(1_009_013_003, "Workflow listener expression ({}) is invalid.");

    // ========== BPM workflow expression 1-009-014-000 ==========
    ErrorCode PROCESS_EXPRESSION_NOT_EXISTS = new ErrorCode(1_009_014_000, "Workflow expression was not found.");

}
