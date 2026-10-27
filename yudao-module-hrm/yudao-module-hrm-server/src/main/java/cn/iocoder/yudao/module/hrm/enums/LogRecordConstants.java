package cn.iocoder.yudao.module.hrm.enums;

/**
 * HRM 操作日志常量
 *
 * @author 芋道源码
 */
public interface LogRecordConstants {

    // ======================= HRM_EMPLOYEE employee profile =======================

    String HRM_EMPLOYEE_TYPE = "HRM employee profile";
    String HRM_EMPLOYEE_CREATE_SUB_TYPE = "Create employee profile";
    String HRM_EMPLOYEE_CREATE_SUCCESS = "Created employee profile[{{#employee.name}}]";
    String HRM_EMPLOYEE_CREATE_FROM_USER_LIST_SUB_TYPE = "Create employee profile from admin user";
    String HRM_EMPLOYEE_ARCHIVE_FILL_MESSAGE_SUB_TYPE = "Send employee-profile reminder";
    String HRM_EMPLOYEE_UPDATE_SUB_TYPE = "Update employee profile";
    String HRM_EMPLOYEE_UPDATE_SUCCESS = "Updated employee profile[{{#updateReqVO.name}}]: {_DIFF{#updateReqVO}}";
    String HRM_EMPLOYEE_PROFILE_UPDATE_SUB_TYPE = "Employee updated personal profile";
    String HRM_EMPLOYEE_PROFILE_UPDATE_SUCCESS =
            "Employee updated personal profile [{{#updateReqVO.name}}]: {_DIFF{#updateReqVO}}";
    String HRM_EMPLOYEE_DELETE_SUB_TYPE = "Delete employee profile";
    String HRM_EMPLOYEE_DELETE_SUCCESS = "Deleted employee profile[{{#employee.name}}]";
    String HRM_EMPLOYEE_FILE_UPDATE_SUB_TYPE = "Update employee document attachments";
    String HRM_EMPLOYEE_FILE_UPDATE_SUCCESS = "Updated employee profile[{{#employee.name}}] document attachments";
    String HRM_EMPLOYEE_CONFIRM_ENTRY_SUB_TYPE = "Confirm employee hire";
    String HRM_EMPLOYEE_CONFIRM_ENTRY_SUCCESS = "Confirmed employee [{{#employee.name}}] hire";
    String HRM_EMPLOYEE_REHIRE_SUB_TYPE = "Process employee rehire";
    String HRM_EMPLOYEE_REHIRE_SUCCESS = "Processed employee [{{#employee.name}}] rehire";
    String HRM_EMPLOYEE_REGULAR_SUB_TYPE = "Process employee confirmation";
    String HRM_EMPLOYEE_REGULAR_SUCCESS = "Processed employee [{{#employee.name}}] confirmation, effective date"
            + "【{{#reqVO.effectTime}}】";
    String HRM_EMPLOYEE_TRANSFER_SUB_TYPE = "Process employee transfer";
    String HRM_EMPLOYEE_TRANSFER_SUCCESS = "Processed employee [{{#employee.name}}] transfer, effective date"
            + "【{{#reqVO.effectTime}}】";
    String HRM_EMPLOYEE_PROMOTE_SUB_TYPE = "Process employee promotion";
    String HRM_EMPLOYEE_PROMOTE_SUCCESS = "Processed employee [{{#employee.name}}] promotion, effective date"
            + "【{{#reqVO.effectTime}}】";
    String HRM_EMPLOYEE_DEMOTE_SUB_TYPE = "Process employee demotion";
    String HRM_EMPLOYEE_DEMOTE_SUCCESS = "Processed employee [{{#employee.name}}] demotion, effective date"
            + "【{{#reqVO.effectTime}}】";
    String HRM_EMPLOYEE_FULL_TIME_SUB_TYPE = "Process conversion to full-time";
    String HRM_EMPLOYEE_FULL_TIME_SUCCESS = "Processed employee [{{#employee.name}}] conversion to full-time, effective date"
            + "【{{#reqVO.effectTime}}】";
    String HRM_EMPLOYEE_QUIT_SUB_TYPE = "Set employee termination";
    String HRM_EMPLOYEE_QUIT_SUCCESS = "Set employee [{{#employee.name}}] termination, planned termination date"
            + "【{{#reqVO.planQuitTime}}】";
    String HRM_EMPLOYEE_CANCEL_QUIT_SUB_TYPE = "Cancel employee termination";
    String HRM_EMPLOYEE_CANCEL_QUIT_SUCCESS = "Canceled employee [{{#employee.name}}] termination plan, reason"
            + "【{{#reqVO.reason}}】";
    String HRM_EMPLOYEE_SALARY_CARD_SAVE_SUB_TYPE = "Save employee payroll card";
    String HRM_EMPLOYEE_SALARY_CARD_SAVE_SUCCESS =
            "Saved payroll card for employee [{{#employee.name}}]: {_DIFF{#reqVO}}";
    String HRM_EMPLOYEE_SALARY_CARD_DELETE_SUB_TYPE = "Delete employee payroll card";
    String HRM_EMPLOYEE_SALARY_CARD_DELETE_SUCCESS = "Deleted payroll card for employee [{{#employee.name}}]";
    String HRM_EMPLOYEE_EDUCATION_EXPERIENCE_CREATE_SUB_TYPE = "Add employee education";
    String HRM_EMPLOYEE_EDUCATION_EXPERIENCE_CREATE_SUCCESS =
            "Added employee education [{{#educationExperience.id}}]";
    String HRM_EMPLOYEE_EDUCATION_EXPERIENCE_UPDATE_SUB_TYPE = "Update employee education";
    String HRM_EMPLOYEE_EDUCATION_EXPERIENCE_UPDATE_SUCCESS =
            "Updated employee education [{{#reqVO.id}}]: {_DIFF{#reqVO}}";
    String HRM_EMPLOYEE_EDUCATION_EXPERIENCE_DELETE_SUB_TYPE = "Delete employee education";
    String HRM_EMPLOYEE_EDUCATION_EXPERIENCE_DELETE_SUCCESS =
            "Deleted employee education [{{#educationExperience.id}}]";
    String HRM_EMPLOYEE_WORK_EXPERIENCE_CREATE_SUB_TYPE = "Add employee work history";
    String HRM_EMPLOYEE_WORK_EXPERIENCE_CREATE_SUCCESS =
            "Added employee work history [{{#workExperience.id}}]";
    String HRM_EMPLOYEE_WORK_EXPERIENCE_UPDATE_SUB_TYPE = "Update employee work history";
    String HRM_EMPLOYEE_WORK_EXPERIENCE_UPDATE_SUCCESS =
            "Updated employee work history [{{#reqVO.id}}]: {_DIFF{#reqVO}}";
    String HRM_EMPLOYEE_WORK_EXPERIENCE_DELETE_SUB_TYPE = "Delete employee work history";
    String HRM_EMPLOYEE_WORK_EXPERIENCE_DELETE_SUCCESS =
            "Deleted employee work history [{{#workExperience.id}}]";
    String HRM_EMPLOYEE_TRAINING_EXPERIENCE_CREATE_SUB_TYPE = "Add employee training";
    String HRM_EMPLOYEE_TRAINING_EXPERIENCE_CREATE_SUCCESS =
            "Added employee training [{{#trainingExperience.id}}]";
    String HRM_EMPLOYEE_TRAINING_EXPERIENCE_UPDATE_SUB_TYPE = "Update employee training";
    String HRM_EMPLOYEE_TRAINING_EXPERIENCE_UPDATE_SUCCESS =
            "Updated employee training [{{#reqVO.id}}]: {_DIFF{#reqVO}}";
    String HRM_EMPLOYEE_TRAINING_EXPERIENCE_DELETE_SUB_TYPE = "Delete employee training";
    String HRM_EMPLOYEE_TRAINING_EXPERIENCE_DELETE_SUCCESS =
            "Deleted employee training [{{#trainingExperience.id}}]";
    String HRM_EMPLOYEE_CERTIFICATE_CREATE_SUB_TYPE = "Add employee certificate";
    String HRM_EMPLOYEE_CERTIFICATE_CREATE_SUCCESS = "Added employee certificate [{{#certificate.id}}]";
    String HRM_EMPLOYEE_CERTIFICATE_UPDATE_SUB_TYPE = "Update employee certificate";
    String HRM_EMPLOYEE_CERTIFICATE_UPDATE_SUCCESS =
            "Updated employee certificate [{{#reqVO.id}}]: {_DIFF{#reqVO}}";
    String HRM_EMPLOYEE_CERTIFICATE_DELETE_SUB_TYPE = "Delete employee certificate";
    String HRM_EMPLOYEE_CERTIFICATE_DELETE_SUCCESS = "Deleted employee certificate [{{#certificate.id}}]";
    String HRM_EMPLOYEE_CONTACT_CREATE_SUB_TYPE = "Add employee contact";
    String HRM_EMPLOYEE_CONTACT_CREATE_SUCCESS = "Added employee contact [{{#contact.id}}]";
    String HRM_EMPLOYEE_CONTACT_UPDATE_SUB_TYPE = "Update employee contact";
    String HRM_EMPLOYEE_CONTACT_UPDATE_SUCCESS =
            "Updated employee contact [{{#reqVO.id}}]: {_DIFF{#reqVO}}";
    String HRM_EMPLOYEE_CONTACT_DELETE_SUB_TYPE = "Delete employee contact";
    String HRM_EMPLOYEE_CONTACT_DELETE_SUCCESS = "Deleted employee contact [{{#contact.id}}]";
    String HRM_EMPLOYEE_CONTRACT_CREATE_SUB_TYPE = "Add employee contract";
    String HRM_EMPLOYEE_CONTRACT_CREATE_SUCCESS = "Added employee contract [{{#contract.id}}]";
    String HRM_EMPLOYEE_CONTRACT_UPDATE_SUB_TYPE = "Update employee contract";
    String HRM_EMPLOYEE_CONTRACT_UPDATE_SUCCESS =
            "Updated employee contract [{{#reqVO.id}}]: {_DIFF{#reqVO}}";
    String HRM_EMPLOYEE_CONTRACT_DELETE_SUB_TYPE = "Delete employee contract";
    String HRM_EMPLOYEE_CONTRACT_DELETE_SUCCESS = "Deleted employee contract [{{#contract.id}}]";

    // ======================= HRM_EMPLOYEE_CONFIG employeefieldsetting =======================

    String HRM_EMPLOYEE_CONFIG_TYPE = "HRM employee field setting";
    String HRM_EMPLOYEE_CREATE_FIELD_CONFIG_UPDATE_SUB_TYPE = "Update new-employee field setting";
    String HRM_EMPLOYEE_CREATE_FIELD_CONFIG_UPDATE_SUCCESS =
            "Updated [{{#configGroupName}}]: {_DIFF{#reqVO}}";
    String HRM_EMPLOYEE_ARCHIVE_FIELD_CONFIG_UPDATE_SUB_TYPE = "Update employee profilefield setting";
    String HRM_EMPLOYEE_ARCHIVE_FIELD_CONFIG_UPDATE_SUCCESS =
            "Updated employee profilefield setting: {_DIFF{#reqVO}}";
    // ======================= HRM_INSURANCE_EMPLOYEE_INFO 员工参保信息 =======================

    String HRM_INSURANCE_EMPLOYEE_INFO_TYPE = "HRM employee benefits info";
    String HRM_INSURANCE_EMPLOYEE_INFO_SAVE_SUB_TYPE = "Save employee benefits info";
    String HRM_INSURANCE_EMPLOYEE_INFO_SAVE_SUCCESS =
            "Saved benefits info for employee [{{#employee.name}}]: {_DIFF{#reqVO}}";
    String HRM_INSURANCE_EMPLOYEE_INFO_UPDATE_SCHEME_SUB_TYPE = "Set employee benefits plan";
    String HRM_INSURANCE_EMPLOYEE_INFO_UPDATE_SCHEME_SUCCESS = "Changed benefits plan for employee [{{#employee.name}}] from "
            + "[{{#oldSchemeName}}] to [{{#newSchemeName}}]";

    // ======================= HRM_INSURANCE_SCHEME social security plan =======================

    String HRM_INSURANCE_SCHEME_TYPE = "HRM benefits plan";
    String HRM_INSURANCE_SCHEME_CREATE_SUB_TYPE = "Create benefits plan";
    String HRM_INSURANCE_SCHEME_CREATE_SUCCESS = "Created benefits plan[{{#insuranceScheme.name}}]";
    String HRM_INSURANCE_SCHEME_UPDATE_SUB_TYPE = "Update benefits plan";
    String HRM_INSURANCE_SCHEME_UPDATE_SUCCESS = "Updated benefits plan[{{#insuranceScheme.name}}]";
    String HRM_INSURANCE_SCHEME_DELETE_SUB_TYPE = "Delete benefits plan";
    String HRM_INSURANCE_SCHEME_DELETE_SUCCESS = "Deleted benefits plan[{{#insuranceScheme.name}}]";

    // ======================= HRM_INSURANCE_MONTH 月度社保表 =======================

    String HRM_INSURANCE_MONTH_TYPE = "HRM monthly benefits sheet";
    String HRM_INSURANCE_MONTH_CREATE_SUB_TYPE = "Create monthly benefits sheet";
    String HRM_INSURANCE_MONTH_CREATE_SUCCESS = "Created monthly benefits sheet[{{#monthRecord.title}}]";
    String HRM_INSURANCE_MONTH_DELETE_SUB_TYPE = "Delete monthly benefits sheet";
    String HRM_INSURANCE_MONTH_DELETE_SUCCESS = "Deleted monthly benefits sheet[{{#monthRecord.title}}]";
    String HRM_INSURANCE_MONTH_EMPLOYEE_CREATE_SUB_TYPE = "Add monthly benefits employees";
    String HRM_INSURANCE_MONTH_EMPLOYEE_CREATE_SUCCESS = "To monthly benefits sheet [{{#monthRecord.title}}] added"
            + "[{{#reqVO.employeeIds.size()}}] employees";
    String HRM_INSURANCE_MONTH_EMPLOYEE_UPDATE_SUB_TYPE = "Adjust employee monthly benefits plan";
    String HRM_INSURANCE_MONTH_EMPLOYEE_UPDATE_SUCCESS = "Set employee monthly benefits record [{{#employeeRecord.id}}] to"
            + "benefits plan[{{#scheme.name}}]";
    String HRM_INSURANCE_MONTH_EMPLOYEE_STOP_SUB_TYPE = "Stop employee benefits in bulk";
    String HRM_INSURANCE_MONTH_EMPLOYEE_STOP_SUCCESS = "Stopped monthly benefits sheet[{{#monthRecord.title}}]"
            + "[{{#ids.size()}}] employees' benefits";

    // ======================= HRM_ATTENDANCE_GROUP attendance group =======================

    String HRM_ATTENDANCE_GROUP_TYPE = "HRM attendance group";
    String HRM_ATTENDANCE_GROUP_CREATE_SUB_TYPE = "Create attendance group";
    String HRM_ATTENDANCE_GROUP_CREATE_SUCCESS = "Created attendance group[{{#attendanceGroup.name}}]";
    String HRM_ATTENDANCE_GROUP_UPDATE_SUB_TYPE = "Update attendance group";
    String HRM_ATTENDANCE_GROUP_UPDATE_SUCCESS =
            "Updated attendance group[{{#updateReqVO.name}}]: {_DIFF{#updateReqVO}}";
    String HRM_ATTENDANCE_GROUP_DELETE_SUB_TYPE = "Delete attendance group";
    String HRM_ATTENDANCE_GROUP_DELETE_SUCCESS = "Deleted attendance group[{{#attendanceGroup.name}}]";

    // ======================= HRM_RECRUIT_POST job posting =======================

    String HRM_RECRUIT_POST_TYPE = "HRM job posting";
    String HRM_RECRUIT_POST_CREATE_SUB_TYPE = "Create job posting";
    String HRM_RECRUIT_POST_CREATE_SUCCESS = "Created job posting[{{#createReqVO.postName}}]";
    String HRM_RECRUIT_POST_UPDATE_SUB_TYPE = "Update job posting";
    String HRM_RECRUIT_POST_UPDATE_SUCCESS = "Updated job posting[{{#updateReqVO.postName}}]: {_DIFF{#updateReqVO}}";
    String HRM_RECRUIT_POST_UPDATE_STATUS_SUB_TYPE = "Update job postingstatus";
    String HRM_RECRUIT_POST_UPDATE_STATUS_SUCCESS = "job posting[{{#recruitPost.postName}}] status from"
            + "[{getRecruitPostStatusName{#recruitPost.status}}] to"
            + "【{getRecruitPostStatusName{#reqVO.status}}】";

    // ======================= HRM_RECRUIT_CHANNEL Recruiting Channel =======================

    String HRM_RECRUIT_CHANNEL_TYPE = "HRM recruiting channel";
    String HRM_RECRUIT_CHANNEL_CREATE_SUB_TYPE = "Create recruiting channel";
    String HRM_RECRUIT_CHANNEL_CREATE_SUCCESS = "Created recruiting channel[{{#createReqVO.name}}]";
    String HRM_RECRUIT_CHANNEL_UPDATE_SUB_TYPE = "Update recruiting channel";
    String HRM_RECRUIT_CHANNEL_UPDATE_SUCCESS = "Updated recruiting channel[{{#updateReqVO.name}}]: {_DIFF{#updateReqVO}}";
    String HRM_RECRUIT_CHANNEL_UPDATE_STATUS_SUB_TYPE = "Update recruiting channelstatus";
    String HRM_RECRUIT_CHANNEL_UPDATE_STATUS_SUCCESS = "recruiting channel[{{#recruitChannel.name}}] status from"
            + "[{getHrmCommonStatusName{#recruitChannel.status}}] to"
            + "【{getHrmCommonStatusName{#statusReqVO.status}}】";
    String HRM_RECRUIT_CHANNEL_DELETE_SUB_TYPE = "Delete recruiting channel";
    String HRM_RECRUIT_CHANNEL_DELETE_SUCCESS = "Deleted recruiting channel[{{#recruitChannel.name}}], and moved related employees and candidates"
            + "transferred to [{{#transferRecruitChannel.name}}]";

    // ======================= HRM_RECRUIT_CONFIG Recruitingset =======================

    String HRM_RECRUIT_CONFIG_TYPE = "HRM recruiting setting";
    String HRM_RECRUIT_ELIMINATE_REASON_UPDATE_SUB_TYPE = "Update rejection reason";
    String HRM_RECRUIT_ELIMINATE_REASON_UPDATE_SUCCESS =
            "Updated rejection reason: {_DIFF{#saveReqVO}}";

    // ======================= HRM_RECRUIT_CANDIDATE recruiting candidate =======================

    String HRM_RECRUIT_CANDIDATE_TYPE = "HRM candidate";
    String HRM_RECRUIT_CANDIDATE_CREATE_SUB_TYPE = "Create candidate";
    String HRM_RECRUIT_CANDIDATE_CREATE_SUCCESS = "Created candidate[{{#createReqVO.name}}]";
    String HRM_RECRUIT_CANDIDATE_UPDATE_SUB_TYPE = "Update candidate";
    String HRM_RECRUIT_CANDIDATE_UPDATE_SUCCESS = "Updated candidate[{{#updateReqVO.name}}]: {_DIFF{#updateReqVO}}";
    String HRM_RECRUIT_CANDIDATE_DELETE_SUB_TYPE = "Delete candidate";
    String HRM_RECRUIT_CANDIDATE_DELETE_SUCCESS = "Deleted candidate[{{#recruitCandidate.name}}]";
    String HRM_RECRUIT_CANDIDATE_UPDATE_STATUS_SUB_TYPE = "Update candidatestatus";
    String HRM_RECRUIT_CANDIDATE_UPDATE_STATUS_SUCCESS = "candidate[{{#recruitCandidate.name}}] status from"
            + "[{getRecruitCandidateStatusName{#recruitCandidate.status}}] to"
            + "【{getRecruitCandidateStatusName{#reqVO.status}}】";
    String HRM_RECRUIT_CANDIDATE_ARRANGE_INTERVIEW_SUB_TYPE = "Schedule interview";
    String HRM_RECRUIT_CANDIDATE_ARRANGE_INTERVIEW_SUCCESS = "For candidate [{{#recruitCandidate.name}}] scheduled round"
            + "[{{#recruitInterview.stageNumber}}] interview round";
    String HRM_RECRUIT_CANDIDATE_UPDATE_INTERVIEW_SUB_TYPE = "Change interview schedule";
    String HRM_RECRUIT_CANDIDATE_UPDATE_INTERVIEW_SUCCESS = "Changed candidate"
            + "[{{#recruitCandidate.name}}] #[{{#recruitInterview.stageNumber}}] interview schedule: {_DIFF{#updateReqVO}}";
    String HRM_RECRUIT_CANDIDATE_INTERVIEW_RESULT_SUB_TYPE =
            "{{#reqVO.result == 2? 'Interview passed': (#reqVO.result == 3? 'Interview failed'"
                    + "(#reqVO.result == 4? 'Interview canceled': 'Record interview result'))}}";
    String HRM_RECRUIT_CANDIDATE_INTERVIEW_RESULT_SUCCESS = "candidate[{{#recruitCandidate.name}}] #"
            + "[{{#recruitInterview.stageNumber}}] interview result set to"
            + "【{getRecruitInterviewResultName{#reqVO.result}}】"
            + "{{#reqVO.result == 4? 'cancel reason: [' + #reqVO.cancelReason + ']'"
            + "(#reqVO.evaluate!= null &&!#reqVO.evaluate.isEmpty()? 'interview notes: [' + #reqVO.evaluate + ']': '')}}";
    String HRM_RECRUIT_CANDIDATE_UPDATE_POST_SUB_TYPE = "Update candidate job";
    String HRM_RECRUIT_CANDIDATE_UPDATE_POST_SUCCESS = "candidate[{{#recruitCandidate.name}}] applied job to"
            + "【{{#recruitPost.postName}}】";
    String HRM_RECRUIT_CANDIDATE_UPDATE_CHANNEL_SUB_TYPE = "Update candidaterecruiting channel";
    String HRM_RECRUIT_CANDIDATE_UPDATE_CHANNEL_SUCCESS = "candidate[{{#recruitCandidate.name}}] recruiting channel to"
            + "【{{#recruitChannel.name}}】";
    String HRM_RECRUIT_CANDIDATE_ELIMINATE_SUB_TYPE = "Reject candidate";
    String HRM_RECRUIT_CANDIDATE_ELIMINATE_SUCCESS = "Rejected candidate [{{#recruitCandidate.name}}], reason"
            + "【{{#reqVO.eliminate}}】";
    String HRM_RECRUIT_CANDIDATE_CONVERT_EMPLOYEE_SUB_TYPE = "Convert candidate to employee";
    String HRM_RECRUIT_CANDIDATE_CONVERT_EMPLOYEE_SUCCESS = "candidate[{{#recruitCandidate.name}}] converted to employee"
            + "employee ID [{{#employeeId}}]";

    // ======================= HRM_SALARY_MONTH 月度工资表 =======================

    String HRM_SALARY_MONTH_TYPE = "HRM monthly payroll";
    String HRM_SALARY_MONTH_CREATE_SUB_TYPE = "Create monthly payroll";
    String HRM_SALARY_MONTH_CREATE_SUCCESS = "Created monthly payroll[{{#salaryMonthRecord.title}}]";
    String HRM_SALARY_MONTH_COMPUTE_SUB_TYPE = "Calculate monthly payroll";
    String HRM_SALARY_MONTH_COMPUTE_SUCCESS = "Calculated monthly payroll[{{#salaryMonthRecord.title}}]";
    String HRM_SALARY_MONTH_DELETE_SUB_TYPE = "Delete monthly payroll";
    String HRM_SALARY_MONTH_DELETE_SUCCESS = "Deleted monthly payroll[{{#salaryMonthRecord.title}}]";
    String HRM_SALARY_MONTH_EMPLOYEE_UPDATE_SUB_TYPE = "Edit employee monthly pay";
    String HRM_SALARY_MONTH_EMPLOYEE_UPDATE_SUCCESS =
            "Edited monthly payroll [{{#salaryMonthRecord.title}}], affecting [{{#employeeCount}}] employees"
                    + ", employee IDs [{{#employeeScope}}], changed pay items [{{#changedOptionSummary}}]";

    // ======================= HRM_SALARY_CONFIG 计薪配置 =======================

    String HRM_SALARY_CONFIG_TYPE = "HRM payroll setting";
    String HRM_SALARY_CONFIG_UPDATE_SUB_TYPE = "Update payroll setting";
    String HRM_SALARY_CONFIG_UPDATE_SUCCESS = "Updated payroll setting: {_DIFF{#updateReqVO}}";

    // ======================= HRM_SALARY_GROUP payroll group =======================

    String HRM_SALARY_GROUP_TYPE = "HRM pay group";
    String HRM_SALARY_GROUP_CREATE_SUB_TYPE = "Create pay group";
    String HRM_SALARY_GROUP_CREATE_SUCCESS = "Created pay group[{{#salaryGroup.name}}]";
    String HRM_SALARY_GROUP_UPDATE_SUB_TYPE = "Update pay group";
    String HRM_SALARY_GROUP_UPDATE_SUCCESS = "Updated pay group[{{#updateReqVO.name}}]: {_DIFF{#updateReqVO}}";
    String HRM_SALARY_GROUP_DELETE_SUB_TYPE = "Delete pay group";
    String HRM_SALARY_GROUP_DELETE_SUCCESS = "Deleted pay group[{{#salaryGroup.name}}]";

    // ======================= HRM_SALARY_OPTION payroll item =======================

    String HRM_SALARY_OPTION_TYPE = "HRM pay item";
    String HRM_SALARY_OPTION_CREATE_SUB_TYPE = "Create pay item";
    String HRM_SALARY_OPTION_CREATE_SUCCESS = "Created pay item[{{#salaryOption.name}}]";
    String HRM_SALARY_OPTION_UPDATE_ENABLED_SUB_TYPE = "Update pay itemenabledstatus";
    String HRM_SALARY_OPTION_UPDATE_ENABLED_SUCCESS =
            "Set pay item [{{#salaryOption.name}}] to [{{#enabled ? 'Enabled' : 'Disabled'}}]";
    String HRM_SALARY_OPTION_UPDATE_VISIBLE_SUB_TYPE = "Update pay itemvisiblestatus";
    String HRM_SALARY_OPTION_UPDATE_VISIBLE_SUCCESS =
            "Set pay item [{{#salaryOption.name}}] to [{{#visible ? 'Visible' : 'Hidden'}}]";
    String HRM_SALARY_OPTION_DELETE_SUB_TYPE = "Delete pay item";
    String HRM_SALARY_OPTION_DELETE_SUCCESS = "Deleted pay item[{{#salaryOption.name}}]";

    // ======================= HRM_SALARY_TAX_RULE 薪资计税规则 =======================

    String HRM_SALARY_TAX_RULE_TYPE = "HRM payroll tax rule";
    String HRM_SALARY_TAX_RULE_CREATE_SUB_TYPE = "Create payroll tax rule";
    String HRM_SALARY_TAX_RULE_CREATE_SUCCESS = "Created payroll tax rule[{{#salaryTaxRule.name}}]";
    String HRM_SALARY_TAX_RULE_UPDATE_SUB_TYPE = "Update payroll tax rule";
    String HRM_SALARY_TAX_RULE_UPDATE_SUCCESS =
            "Updated payroll tax rule[{{#salaryTaxRule.name}}]: {_DIFF{#updateReqVO}}";
    String HRM_SALARY_TAX_RULE_DELETE_SUB_TYPE = "Delete payroll tax rule";
    String HRM_SALARY_TAX_RULE_DELETE_SUCCESS = "Deleted payroll tax rule[{{#salaryTaxRule.name}}]";

    // ======================= HRM_SALARY_EMPLOYEE employeepayroll =======================

    String HRM_SALARY_EMPLOYEE_TYPE = "HRM employee pay";
    String HRM_SALARY_EMPLOYEE_SET_SUB_TYPE = "Set or adjust employee pay";
    String HRM_SALARY_EMPLOYEE_SET_SUCCESS = "Saved pay set/adjustment record for employee [{{#employee.name}}]";
    String HRM_SALARY_EMPLOYEE_BATCH_SET_SUB_TYPE = "Bulk pay adjustment";
    String HRM_SALARY_EMPLOYEE_BATCH_SET_SUCCESS =
            "Bulk pay adjustment finished, succeeded[{{#batchResult.successEmployeeIds.size()}}] people"
                    + "failed[{{#batchResult.failureEmployeeReasons.size()}}] people";

    // ======================= HRM_SALARY_SLIP 工资条 =======================

    String HRM_SALARY_SLIP_TYPE = "HRM payslip";
    String HRM_SALARY_SLIP_SEND_SUB_TYPE = "Send payslip";
    String HRM_SALARY_SLIP_SEND_SUCCESS = "Sent [{{#salarySlipSendRecord.year}}] year"
            + "[{{#salarySlipSendRecord.month}}] month payslip, total [{{#salarySlipSendRecord.sendEmployeeCount}}] people";
    String HRM_SALARY_SLIP_DELETE_SUB_TYPE = "Delete payslip send record";
    String HRM_SALARY_SLIP_DELETE_SUCCESS = "Deleted [{{#salarySlipSendRecord.year}}] year"
            + "[{{#salarySlipSendRecord.month}}] month payslip send record";

    // ======================= HRM_PERFORMANCE_PLAN performance plan =======================

    String HRM_PERFORMANCE_PLAN_TYPE = "HRM performance plan";
    String HRM_PERFORMANCE_PLAN_CREATE_SUB_TYPE = "Create performance plan";
    String HRM_PERFORMANCE_PLAN_CREATE_SUCCESS = "Created performance plan[{{#performancePlan.name}}]";
    String HRM_PERFORMANCE_PLAN_UPDATE_SUB_TYPE = "Update performance plan";
    String HRM_PERFORMANCE_PLAN_UPDATE_SUCCESS = "Updated performance plan[{{#performancePlan.name}}]";
    String HRM_PERFORMANCE_PLAN_DELETE_SUB_TYPE = "Delete performance plan";
    String HRM_PERFORMANCE_PLAN_DELETE_SUCCESS = "Deleted performance plan[{{#performancePlan.name}}]";
    String HRM_PERFORMANCE_PLAN_START_SUB_TYPE = "Start performance plan";
    String HRM_PERFORMANCE_PLAN_START_SUCCESS = "Started performance plan[{{#performancePlan.name}}]";
    String HRM_PERFORMANCE_PLAN_OPEN_SCORING_SUB_TYPE = "Open performance score";
    String HRM_PERFORMANCE_PLAN_OPEN_SCORING_SUCCESS = "Opened performance plan[{{#performancePlan.name}}] scoring";
    String HRM_PERFORMANCE_PLAN_INTERVIEW_SUB_TYPE = "Start performance meeting";
    String HRM_PERFORMANCE_PLAN_INTERVIEW_SUCCESS = "Started performance plan[{{#performancePlan.name}}] performance meeting";
    String HRM_PERFORMANCE_PLAN_ARCHIVE_SUB_TYPE = "Archive performance plan";
    String HRM_PERFORMANCE_PLAN_ARCHIVE_SUCCESS = "Archived performance plan[{{#performancePlan.name}}]";
    String HRM_PERFORMANCE_PLAN_TERMINATE_SUB_TYPE = "Terminate performance plan";
    String HRM_PERFORMANCE_PLAN_TERMINATE_SUCCESS = "Terminated performance plan[{{#performancePlan.name}}]";

    // ======================= HRM_PERFORMANCE performance review =======================

    String HRM_PERFORMANCE_TYPE = "HRM performance review";
    String HRM_PERFORMANCE_FILL_QUOTA_SUB_TYPE = "Submit performance KPI";
    String HRM_PERFORMANCE_FILL_QUOTA_SUCCESS = "Submitted performance KPI";
    String HRM_PERFORMANCE_SCORE_SUB_TYPE = "Submit performance score";
    String HRM_PERFORMANCE_SCORE_SUCCESS = "Submitted performance score";
    String HRM_PERFORMANCE_REJECT_SCORE_SUB_TYPE = "Reject performance score";
    String HRM_PERFORMANCE_REJECT_SCORE_SUCCESS = "Rejected the previous scoring stage, reason: [{{#reqVO.reason}}]";
    String HRM_PERFORMANCE_CONFIRM_TARGET_SUB_TYPE =
            "{{#reqVO.pass == 1 ? 'Confirm performance goals' : 'Reject performance goals'}}";
    String HRM_PERFORMANCE_CONFIRM_TARGET_SUCCESS =
            "{{#reqVO.pass == 1 ? 'Confirmed performance goals' : 'Rejected performance goals'}}"
                    + "{{#reqVO.comment != null && !#reqVO.comment.isEmpty() ? ', comment: [' + #reqVO.comment + ']' : ''}}";
    String HRM_PERFORMANCE_CONFIRM_RESULT_SUB_TYPE = "Confirm performance result";
    String HRM_PERFORMANCE_CONFIRM_RESULT_SUCCESS = "Confirmed performance result";
    String HRM_PERFORMANCE_APPEAL_SUB_TYPE = "Submit performance appeal";
    String HRM_PERFORMANCE_APPEAL_SUCCESS = "Submitted performance appeal, reason: [{{#reqVO.appealReason}}]";
    String HRM_PERFORMANCE_RESULT_AUDIT_SUB_TYPE =
            "{{#reqVO.pass == 1 ? 'Approve performance result review' : 'Reject performance result review'}}";
    String HRM_PERFORMANCE_RESULT_AUDIT_SUCCESS =
            "{{#reqVO.pass == 1 ? 'Approved the performance result review' : 'Rejected the performance result review'}}"
                    + "{{#reqVO.comment != null && !#reqVO.comment.isEmpty() ? ', comment: [' + #reqVO.comment + ']' : ''}}";
    String HRM_PERFORMANCE_APPEAL_HANDLE_SUB_TYPE =
            "{{#reqVO.pass == 1 ? 'Approve performance appeal' : 'Reject performance appeal'}}";
    String HRM_PERFORMANCE_APPEAL_HANDLE_SUCCESS =
            "{{#reqVO.pass == 1 ? 'Approved the performance appeal' : 'Rejected the performance appeal'}}"
                    + "{{#reqVO.comment != null && !#reqVO.comment.isEmpty() ? ', comment: [' + #reqVO.comment + ']' : ''}}";
    String HRM_PERFORMANCE_APPEAL_TIMEOUT_HANDLE_SUB_TYPE =
            "{{#appealPass ? 'Auto-approve performance appeal' : 'Auto-reject performance appeal'}}";
    String HRM_PERFORMANCE_APPEAL_TIMEOUT_HANDLE_SUCCESS =
            "{{#appealPass ? 'Appeal confirmation timed out; the system auto-approved the performance appeal' : 'Appeal confirmation timed out; the system auto-rejected the performance appeal'}}";

}
