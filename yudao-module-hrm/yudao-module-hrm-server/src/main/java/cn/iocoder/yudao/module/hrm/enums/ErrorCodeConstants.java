package cn.iocoder.yudao.module.hrm.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * HRM 错误码枚举类
 *
 * HRM 系统，使用 1-050-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== employee profile 1-050-100-000 ==========
    ErrorCode EMPLOYEE_NOT_EXISTS = new ErrorCode(1_050_100_000, "Employee profile was not found.");
    ErrorCode EMPLOYEE_JOB_NUMBER_DUPLICATE = new ErrorCode(1_050_100_001, "Employee work no. already exists.");
    ErrorCode EMPLOYEE_USER_DUPLICATE = new ErrorCode(1_050_100_002, "This system user is already bound to an employee profile.");
    ErrorCode EMPLOYEE_MOBILE_DUPLICATE = new ErrorCode(1_050_100_003, "Phone number already bind employee profile.");
    ErrorCode EMPLOYEE_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_050_100_006, "Importemployee profile data is required.");
    ErrorCode EMPLOYEE_IMPORT_DUPLICATE_STRATEGY_INVALID =
            new ErrorCode(1_050_100_033, "Invalid strategy for duplicate employee import rows.");
    ErrorCode EMPLOYEE_LEADER_INVALID = new ErrorCode(1_050_100_014, "The direct manager cannot be the employee or a subordinate.");
    ErrorCode EMPLOYEE_ENTRY_STATUS_INVALID = new ErrorCode(1_050_100_037, "Employee [{}] is not active.");
    ErrorCode EMPLOYEE_IMPORT_REFERENCE_NOT_EXISTS =
            new ErrorCode(1_050_100_038, "Importfield[{}] value [{}] was not found.");
    // ========== employee lifecycle 1-050-100-004 ==========
    ErrorCode EMPLOYEE_CANDIDATE_CONVERTED = new ErrorCode(1_050_100_005, "The recruiting candidate is already an employee.");
    ErrorCode EMPLOYEE_REHIRE_STATUS_INVALID = new ErrorCode(1_050_100_007, "Only offboarded employees can be rehired.");
    ErrorCode EMPLOYEE_CONFIRM_ENTRY_STATUS_INVALID = new ErrorCode(1_050_100_009, "Only pending-hire employees can be confirmed.");
    ErrorCode EMPLOYEE_QUIT_STATUS_INVALID = new ErrorCode(1_050_100_010, "Only active or pending-offboard employees can be offboarded.");
    ErrorCode EMPLOYEE_QUIT_CANCEL_STATUS_INVALID = new ErrorCode(1_050_100_011, "Only pending offboarding employee can cancel offboarding.");
    ErrorCode EMPLOYEE_CHANGE_STATUS_INVALID = new ErrorCode(1_050_100_025, "The employee status does not allow [{}].");
    ErrorCode EMPLOYEE_CHANGE_TYPE_INVALID = new ErrorCode(1_050_100_026, "Employee change type [{}] is invalid.");
    ErrorCode EMPLOYEE_QUIT_TIME_INVALID = new ErrorCode(1_050_100_028, "Offboarding time range is invalid.");
    ErrorCode EMPLOYEE_RESOURCE_BELONG_INVALID = new ErrorCode(1_050_100_029, "Employee{} does not belong to specified employee.");
    ErrorCode EMPLOYEE_PERSONAL_NOTE_NOT_EXISTS = new ErrorCode(1_050_100_030, "Employee memo not found.");
    ErrorCode EMPLOYEE_CREATE_USER_LIST_DUPLICATE =
            new ErrorCode(1_050_100_031, "Admin users in a bulk profile create cannot be duplicated.");
    ErrorCode EMPLOYEE_CREATE_USER_NOT_EXISTS = new ErrorCode(1_050_100_032, "An admin user in the bulk profile create was not found.");

    // ========== 员工教育经历 1-050-100-016 ==========
    ErrorCode EMPLOYEE_EDUCATION_EXPERIENCE_NOT_EXISTS =
            new ErrorCode(1_050_100_016, "Education record not found.");

    // ========== 员工工作经历 1-050-100-017 ==========
    ErrorCode EMPLOYEE_WORK_EXPERIENCE_NOT_EXISTS = new ErrorCode(1_050_100_017, "Work-history record not found.");

    // ========== 员工培训经历 1-050-100-018 ==========
    ErrorCode EMPLOYEE_TRAINING_EXPERIENCE_NOT_EXISTS =
            new ErrorCode(1_050_100_018, "Training record not found.");

    // ========== employeeCertificate 1-050-100-019 ==========
    ErrorCode EMPLOYEE_CERTIFICATE_NOT_EXISTS = new ErrorCode(1_050_100_019, "Certificate record not found.");

    // ========== employeecontact 1-050-100-020 ==========
    ErrorCode EMPLOYEE_CONTACT_NOT_EXISTS = new ErrorCode(1_050_100_020, "Employeecontact was not found.");

    // ========== employeecontract 1-050-100-021 ==========
    ErrorCode EMPLOYEE_CONTRACT_NOT_EXISTS = new ErrorCode(1_050_100_021, "Employeecontract was not found.");

    // ========== employee offboarding info 1-050-100-023 ==========
    ErrorCode EMPLOYEE_QUIT_INFO_NOT_EXISTS = new ErrorCode(1_050_100_023, "Employee offboarding info was not found.");

    // ========== employeefieldsetting 1-050-100-024 ==========
    ErrorCode EMPLOYEE_FIELD_CONFIG_INVALID = new ErrorCode(1_050_100_024, "Employeefieldsetting[{}] is invalid.");
    ErrorCode EMPLOYEE_FIELD_NOT_VISIBLE = new ErrorCode(1_050_100_034, "Employee field [{}] is hidden and cannot be submitted.");
    ErrorCode EMPLOYEE_PROFILE_FIELD_REQUIRED = new ErrorCode(1_050_100_035, "Employee profile field[{}] is required.");

    // ========== job posting 1-050-200-000 ==========
    ErrorCode RECRUIT_POST_NOT_EXISTS = new ErrorCode(1_050_200_000, "Job posting not found.");

    // ========== recruiting candidate 1-050-200-001 ==========
    ErrorCode RECRUIT_CANDIDATE_NOT_EXISTS = new ErrorCode(1_050_200_001, "Recruiting candidate not found.");
    ErrorCode RECRUIT_CANDIDATE_STATUS_TRANSITION_INVALID =
            new ErrorCode(1_050_200_011, "The candidate status cannot change to [{}].");
    ErrorCode RECRUIT_CANDIDATE_HAS_EMPLOYEE =
            new ErrorCode(1_050_200_012, "Candidate already createemployee profile, cannot be deleted.");
    ErrorCode RECRUIT_CANDIDATE_DELETE_STATUS_INVALID =
            new ErrorCode(1_050_200_016, "Candidate current status is not alloweddelete.");
    ErrorCode RECRUIT_CANDIDATE_CONVERT_STATUS_INVALID =
            new ErrorCode(1_050_200_017, "The candidate status does not allow conversion to an employee.");
    ErrorCode RECRUIT_CANDIDATE_ELIMINATE_STATUS_INVALID =
            new ErrorCode(1_050_200_018, "The candidate status does not allow rejection.");

    // ========== Recruiting interview 1-050-200-002 ==========
    ErrorCode RECRUIT_INTERVIEW_NOT_EXISTS = new ErrorCode(1_050_200_002, "Interview not found.");
    ErrorCode RECRUIT_INTERVIEW_FINISHED = new ErrorCode(1_050_200_009, "A completed interview cannot have its schedule changed.");
    ErrorCode RECRUIT_INTERVIEW_CANCEL_REASON_REQUIRED =
            new ErrorCode(1_050_200_010, "Cancel interview time must enter cancelreason.");
    ErrorCode RECRUIT_INTERVIEW_STATE_INVALID =
            new ErrorCode(1_050_200_013, "The candidate status does not allow scheduling or changing interviews.");
    ErrorCode RECRUIT_INTERVIEW_NOT_CURRENT =
            new ErrorCode(1_050_200_014, "You can change only the candidate's current interview round.");
    ErrorCode RECRUIT_INTERVIEW_RESULT_INVALID =
            new ErrorCode(1_050_200_015, "Current interview status or interview result is not allowed submit.");

    // ========== Recruiting Channel 1-050-200-003 ==========
    ErrorCode RECRUIT_CHANNEL_NOT_EXISTS = new ErrorCode(1_050_200_003, "Recruiting channel not found.");
    ErrorCode RECRUIT_CHANNEL_SYSTEM_NAME_UPDATE_FORBIDDEN =
            new ErrorCode(1_050_200_005, "Built-in recruiting channel names cannot be changed.");
    ErrorCode RECRUIT_CHANNEL_SYSTEM_DELETE_FORBIDDEN =
            new ErrorCode(1_050_200_006, "Built-in recruiting channels cannot be deleted.");
    ErrorCode RECRUIT_CHANNEL_TRANSFER_SELF =
            new ErrorCode(1_050_200_007, "The replacement recruiting channel cannot be the one being deleted.");
    ErrorCode RECRUIT_CHANNEL_TRANSFER_DISABLED = new ErrorCode(1_050_200_008, "The replacement recruiting channel is disabled.");

    // ========== job posting type 1-050-200-004 ==========
    ErrorCode RECRUIT_POST_TYPE_NOT_EXISTS = new ErrorCode(1_050_200_004, "Job type not found.");

    // ========== attendance group 1-050-300-002 ==========
    ErrorCode ATTENDANCE_GROUP_NOT_EXISTS = new ErrorCode(1_050_300_002, "Attendance group was not found.");
    ErrorCode ATTENDANCE_NAME_DUPLICATE = new ErrorCode(1_050_300_007, "Attendance name already exists.");
    ErrorCode ATTENDANCE_DEFAULT_CANNOT_DELETE = new ErrorCode(1_050_300_008, "Default attendancesetting cannot be deleted.");

    // ========== attendance punch 1-050-300-003 ==========
    ErrorCode ATTENDANCE_CLOCK_NOT_EXISTS = new ErrorCode(1_050_300_003, "Clock-in record was not found.");
    ErrorCode ATTENDANCE_CLOCK_NON_MANUAL_MODIFY_FORBIDDEN = new ErrorCode(1_050_300_028,
            "Only manually entered clock-in records can be edited or deleted.");
    ErrorCode ATTENDANCE_CLOCK_TIME_INVALID = new ErrorCode(1_050_300_033,
            "Scheduled or actual clock-in time is outside the employee's shift window.");
    ErrorCode ATTENDANCE_CLOCK_REST_DAY = new ErrorCode(1_050_300_034, "Today is a day off. Clock-in is not required.");
    ErrorCode ATTENDANCE_CLOCK_NOT_ALLOWED = new ErrorCode(1_050_300_035, "Current is not in can clock-in time.");
    ErrorCode ATTENDANCE_CLOCK_POINT_INVALID = new ErrorCode(1_050_300_036, "Is not in attendance clock-in in the range of.");
    ErrorCode ATTENDANCE_CLOCK_WIFI_INVALID = new ErrorCode(1_050_300_037, "Not connect specified attendance WiFi.");
    ErrorCode ATTENDANCE_CLOCK_GROUP_NOT_EXISTS = new ErrorCode(1_050_300_038, "Not match to attendance group, cannot clock-in.");

    // ========== attendance holiday 1-050-300-006 ==========
    ErrorCode ATTENDANCE_HOLIDAY_NOT_EXISTS = new ErrorCode(1_050_300_006, "Attendance holiday was not found.");
    ErrorCode ATTENDANCE_HOLIDAY_DATE_DUPLICATE = new ErrorCode(1_050_300_029, "This date is already set as an attendance holiday.");

    // ========== 考勤请假 1-050-300-030 ==========
    ErrorCode ATTENDANCE_LEAVE_NOT_EXISTS = new ErrorCode(1_050_300_030, "Leave request was not found.");
    ErrorCode ATTENDANCE_LEAVE_TIME_CONFLICT = new ErrorCode(1_050_300_031, "Leave time overlaps an existing request.");
    ErrorCode ATTENDANCE_LEAVE_STATUS_INVALID = new ErrorCode(1_050_300_032, "Only approval leave request can cancel.");

    // ========== payrollsetting 1-050-400-000 ==========
    ErrorCode SALARY_CONFIG_NOT_EXISTS = new ErrorCode(1_050_400_000, "Payrollsetting was not found.");
    ErrorCode SALARY_CONFIG_EXISTS = new ErrorCode(1_050_400_022, "Payrollsetting already exists.");

    // ========== payroll group 1-050-400-001 ==========
    ErrorCode SALARY_GROUP_NOT_EXISTS = new ErrorCode(1_050_400_001, "Payroll group was not found.");
    ErrorCode SALARY_GROUP_NAME_DUPLICATE = new ErrorCode(1_050_400_002, "Payroll group name already exists.");
    ErrorCode SALARY_GROUP_EMPLOYEE_CONFLICT = new ErrorCode(1_050_400_020, "Selected employee already belong at its other payroll group.");
    ErrorCode SALARY_GROUP_DEPT_CONFLICT = new ErrorCode(1_050_400_021, "Selected department or its level department already belong at its other payroll group.");

    // ========== payroll item 1-050-400-003 ==========
    ErrorCode SALARY_OPTION_NOT_EXISTS = new ErrorCode(1_050_400_003, "Payroll item was not found.");
    ErrorCode SALARY_OPTION_CATEGORY_INVALID = new ErrorCode(1_050_400_028, "Payroll item category was not found or not can.");
    ErrorCode SALARY_OPTION_CODE_OCCUPIED = new ErrorCode(1_050_400_029,
            "Salary-item code {} is used by historical or custom data. Migrate first.");
    ErrorCode SALARY_OPTION_STANDARD_CANNOT_MODIFY =
            new ErrorCode(1_050_400_029, "Standard salary items cannot be edited or deleted.");

    // ========== 薪资计税规则 1-050-400-005 ==========
    ErrorCode SALARY_TAX_RULE_NOT_EXISTS = new ErrorCode(1_050_400_005, "Tax rule not found.");
    ErrorCode SALARY_TAX_RULE_NAME_DUPLICATE = new ErrorCode(1_050_400_023, "Tax rule name already exists.");
    ErrorCode SALARY_TAX_RULE_USED = new ErrorCode(1_050_400_027, "The tax rule is used by a salary group and cannot be deleted.");

    // ========== employeepayroll info 1-050-400-006 ==========
    ErrorCode SALARY_EMPLOYEE_INFO_NOT_EXISTS = new ErrorCode(1_050_400_006, "Employeepayroll info was not found.");
    ErrorCode SALARY_DATA_ILLEGAL = new ErrorCode(1_050_400_014, "Payroll data is invalid.");
    ErrorCode SALARY_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_050_400_015, "Importpayroll profile data is required.");

    // ========== Set SalarySalary Changerecord 1-050-400-007 ==========
    ErrorCode SALARY_CHANGE_RECORD_NOT_EXISTS = new ErrorCode(1_050_400_007, "Salary-change record not found.");
    ErrorCode SALARY_PENDING_CHANGE_RECORD_EXISTS = new ErrorCode(1_050_400_016, "The employee already has a pending salary change.");
    ErrorCode SALARY_CHANGE_RECORD_STATUS_INVALID = new ErrorCode(1_050_400_017, "This salary-change status does not allow that action.");
    ErrorCode SALARY_CHANGE_EFFECT_DATE_INVALID =
            new ErrorCode(1_050_400_030, "Salary-change effective date is required and cannot be earlier than the latest payroll month.");

    // ========== 月度工资表 1-050-400-008 ==========
    ErrorCode SALARY_MONTH_RECORD_NOT_EXISTS = new ErrorCode(1_050_400_008, "Monthly payroll not found.");
    ErrorCode SALARY_MONTH_RECORD_EXISTS = new ErrorCode(1_050_400_009, "A payroll for this month already exists.");
    ErrorCode SALARY_MONTH_EMP_RECORD_NOT_EXISTS = new ErrorCode(1_050_400_010, "Employee monthly payroll record not found.");
    ErrorCode SALARY_MONTH_RECORD_STATUS_INVALID = new ErrorCode(1_050_400_018, "This payroll status does not allow that action.");
    ErrorCode SALARY_MONTH_RECORD_NOT_LATEST =
            new ErrorCode(1_050_400_024, "Only the latest monthly payroll can be deleted.");
    ErrorCode SALARY_MONTH_RECORD_CANNOT_DELETE_ONLY =
            new ErrorCode(1_050_400_025, "Keep at least one monthly payroll.");

    // ========== 工资条 1-050-400-011 ==========
    ErrorCode SALARY_SLIP_TEMPLATE_NOT_EXISTS = new ErrorCode(1_050_400_011, "Payslip template not found.");
    ErrorCode SALARY_SLIP_RECORD_NOT_EXISTS = new ErrorCode(1_050_400_012, "Payslip issue record not found.");
    ErrorCode SALARY_SLIP_NOT_EXISTS = new ErrorCode(1_050_400_013, "Payslip not found.");
    ErrorCode SALARY_SLIP_ALREADY_SENT = new ErrorCode(1_050_400_030, "This payslip was already issued.");
    ErrorCode SALARY_SLIP_EMPLOYEE_ACCOUNT_NOT_EXISTS = new ErrorCode(1_050_400_031,
            "The selected employee has no admin account, so the payslip cannot be issued.");

    // ========== social security plan 1-050-500-000 ==========
    ErrorCode INSURANCE_SCHEME_NOT_EXISTS = new ErrorCode(1_050_500_000, "Social security plan was not found.");
    ErrorCode INSURANCE_SCHEME_NAME_DUPLICATE = new ErrorCode(1_050_500_001, "Social security plan name already exists.");
    ErrorCode INSURANCE_SCHEME_USED = new ErrorCode(1_050_500_002, "Social security plan is already used by employee used, cannot be deleted.");
    ErrorCode INSURANCE_SCHEME_PROJECT_EMPTY = new ErrorCode(1_050_500_011, "Social security plan at least need to need one social security item.");
    ErrorCode INSURANCE_SCHEME_PROJECT_TYPE_DUPLICATE = new ErrorCode(1_050_500_012, "Social security plan item type is duplicated.");
    ErrorCode INSURANCE_SCHEME_AREA_INVALID = new ErrorCode(1_050_500_024, "Insurance region must be a city or district.");

    // ========== employee social security info 1-050-500-003 ==========
    ErrorCode INSURANCE_EMPLOYEE_INFO_NOT_EXISTS = new ErrorCode(1_050_500_003, "Employee insurance record not found.");
    ErrorCode INSURANCE_EMPLOYEE_INFO_EMPLOYEE_MISMATCH = new ErrorCode(1_050_500_015,
            "The insurance record cannot be moved to another employee.");
    ErrorCode INSURANCE_EMP_STATUS_ILLEGAL = new ErrorCode(1_050_500_018, "Employee insurance status is invalid.");
    ErrorCode INSURANCE_EMPLOYEE_SCHEME_NOT_CONFIGURED = new ErrorCode(1_050_500_025,
            "The employee has no valid social-security plan.");

    // ========== 月度社保表 1-050-500-004 ==========
    ErrorCode INSURANCE_MONTH_RECORD_NOT_EXISTS = new ErrorCode(1_050_500_004, "Monthly social-security sheet not found.");
    ErrorCode INSURANCE_MONTH_RECORD_EXISTS = new ErrorCode(1_050_500_005, "A social-security sheet for this month already exists.");
    ErrorCode INSURANCE_MONTH_EMP_RECORD_NOT_EXISTS = new ErrorCode(1_050_500_006, "Employee monthly social-security record not found.");
    ErrorCode INSURANCE_DATA_ILLEGAL = new ErrorCode(1_050_500_007, "Social security data is invalid.");
    ErrorCode INSURANCE_MONTH_RECORD_ARCHIVED = new ErrorCode(1_050_500_009, "The monthly social-security sheet is archived and cannot be edited.");
    ErrorCode INSURANCE_MONTH_YEAR_MONTH_ILLEGAL = new ErrorCode(1_050_500_017, "Social-security sheet year/month is invalid.");
    ErrorCode INSURANCE_MONTH_RECORD_NOT_LATEST = new ErrorCode(1_050_500_020, "Only the latest monthly social-security sheet can be deleted.");
    ErrorCode INSURANCE_MONTH_RECORD_CANNOT_DELETE_ONLY = new ErrorCode(1_050_500_021,
            "Keep at least one monthly social-security sheet.");
    ErrorCode INSURANCE_FIRST_MONTH_RECORD_EXISTS = new ErrorCode(1_050_500_023,
            "A social-security sheet already exists. Create the next month instead.");
    ErrorCode INSURANCE_MONTH_EMPLOYEE_NOT_ELIGIBLE = new ErrorCode(1_050_500_026,
            "The employee is not eligible for insurance in the selected month.");

    // ========== 员工工资卡 1-050-500-008 ==========
    ErrorCode EMPLOYEE_SALARY_CARD_NOT_EXISTS = new ErrorCode(1_050_500_008, "Employee payroll card not found.");
    ErrorCode EMPLOYEE_SALARY_CARD_EMPLOYEE_MISMATCH = new ErrorCode(1_050_500_016,
            "The payroll card cannot be moved to another employee.");

    // ========== performance review template 1-050-600-000 ==========
    ErrorCode PERFORMANCE_ASSESSMENT_TEMPLATE_NOT_EXISTS = new ErrorCode(1_050_600_000, "Performance review template not found.");
    ErrorCode PERFORMANCE_ASSESSMENT_TEMPLATE_NAME_DUPLICATE =
            new ErrorCode(1_050_600_001, "Performance review template name already exists.");

    // ========== performance review resulttemplate 1-050-600-002 ==========
    ErrorCode PERFORMANCE_RESULT_TEMPLATE_NOT_EXISTS = new ErrorCode(1_050_600_002, "Performance review resulttemplate was not found.");
    ErrorCode PERFORMANCE_RESULT_TEMPLATE_NAME_DUPLICATE =
            new ErrorCode(1_050_600_003, "Performance review resulttemplate name already exists.");

    // ========== performance plan 1-050-600-004 ==========
    ErrorCode PERFORMANCE_PLAN_NOT_EXISTS = new ErrorCode(1_050_600_004, "Performance reviewplan was not found.");
    ErrorCode PERFORMANCE_PLAN_NAME_DUPLICATE = new ErrorCode(1_050_600_005, "Performance reviewplan name already exists.");
    ErrorCode PERFORMANCE_PLAN_STARTED_CANNOT_MODIFY =
            new ErrorCode(1_050_600_014, "After a performance plan starts, its settings and participants cannot change.");
    ErrorCode PERFORMANCE_PLAN_STATUS_NOT_ALLOW_DELETE =
            new ErrorCode(1_050_600_025, "Current status performance reviewplan is not alloweddelete.");

    // ========== employee performance review 1-050-600-006 ==========
    ErrorCode PERFORMANCE_ASSESSMENT_NOT_EXISTS = new ErrorCode(1_050_600_006, "Employee performance review not found.");
    ErrorCode PERFORMANCE_DATA_ILLEGAL = new ErrorCode(1_050_600_007, "Performance review data is invalid.");
    ErrorCode PERFORMANCE_RESULT_LEVEL_NOT_MATCH =
            new ErrorCode(1_050_600_028, "The performance score did not match a result grade. Check the result template.");

    // ========== performance reviewworkflow 1-050-600-008 ==========
    ErrorCode PERFORMANCE_STAGE_ACTION_INVALID = new ErrorCode(1_050_600_008, "This performance stage does not allow that action.");
    ErrorCode PERFORMANCE_PROCESS_RUNNING_CANNOT_MODIFY =
            new ErrorCode(1_050_600_009, "Performance reviewworkflow process, cannot edit current record.");
    ErrorCode PERFORMANCE_PROCESS_CONFIG_INVALID =
            new ErrorCode(1_050_600_024, "Performance reviewworkflowsetting is invalid.");
    ErrorCode PERFORMANCE_STAGE_NO_PERMISSION =
            new ErrorCode(1_050_600_027, "You are not the handler for this performance stage.");
    ErrorCode PERFORMANCE_STAGE_HANDLER_USER_NOT_BOUND =
            new ErrorCode(1_050_600_026, "Required performance handler [{}] has no admin account.");

    // ========== performance reviewScoring Stage 1-050-600-011 ==========
    ErrorCode PERFORMANCE_REVIEW_STAGE_CONFIG_INVALID = new ErrorCode(1_050_600_011, "Performance scoring workflow settings are invalid.");
    ErrorCode PERFORMANCE_REVIEW_STAGE_NOT_EXISTS = new ErrorCode(1_050_600_012, "Performance scoring task not found.");
    ErrorCode PERFORMANCE_REVIEW_STAGE_NO_PERMISSION =
            new ErrorCode(1_050_600_013, "You are not the rater for this performance stage.");
    ErrorCode PERFORMANCE_REVIEW_STAGE_REJECT_INVALID =
            new ErrorCode(1_050_600_015, "This scoring stage cannot reject the previous stage.");

    // ========== 绩效阶段流转 1-050-600-016 ==========
    ErrorCode PERFORMANCE_INTERVIEW_NOT_READY =
            new ErrorCode(1_050_600_016, "Result review is not finished, so the performance meeting cannot start.");
    ErrorCode PERFORMANCE_ARCHIVE_NOT_READY =
            new ErrorCode(1_050_600_017, "Meetings or appeals are still open, so the review cannot be archived.");
    ErrorCode PERFORMANCE_SCORING_NOT_READY =
            new ErrorCode(1_050_600_018, "Metric setup or goal confirmation is incomplete, so scoring cannot start.");

    // ========== performance review metric 1-050-600-019 ==========
    ErrorCode PERFORMANCE_QUOTA_SETTING_INVALID =
            new ErrorCode(1_050_600_019, "Performance metric setup data is invalid.");

    // ========== performance review target confirm 1-050-600-020 ==========
    ErrorCode PERFORMANCE_TARGET_CONFIRM_CONFIG_INVALID =
            new ErrorCode(1_050_600_020, "Performance review target confirm person setting is invalid.");
    ErrorCode PERFORMANCE_TARGET_CONFIRM_NO_PERMISSION =
            new ErrorCode(1_050_600_021, "Current user is not this performance review target confirm person.");

    // ========== HRM setting 1-050-800-000 ==========
    ErrorCode HRM_CONFIG_NOT_EXISTS = new ErrorCode(1_050_800_000, "HRM setting was not found.");

    // ========== Salary Changetemplate 1-050-800-002 ==========
    ErrorCode SALARY_CHANGE_TEMPLATE_NOT_EXISTS = new ErrorCode(1_050_800_002, "Salary-change template not found.");
    ErrorCode SALARY_CHANGE_TEMPLATE_DEFAULT_CANNOT_DELETE =
            new ErrorCode(1_050_800_003, "The default salary-change template cannot be deleted.");
    ErrorCode SALARY_CHANGE_TEMPLATE_OPTION_INVALID =
            new ErrorCode(1_050_800_004, "The salary-change template has invalid or duplicate salary items.");

    // ========== HRM Home 1-050-900-001 ==========
    ErrorCode HOME_CALENDAR_DATE_RANGE_ILLEGAL = new ErrorCode(1_050_900_001, "HRM home date range is invalid.");

}
