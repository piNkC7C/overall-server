-- 清理 Overall 演示业务数据（保留配置型数据）
-- 保留：用户/角色/菜单/部门、消息模板、字典、CRM 产品与配置、商机状态定义、BPM 流程模型定义
-- 清除：线索/客户/联系人/商机/合同/回款/跟进、日程、站内信消息、助手会话、审批运行/历史实例
-- 禁止：aimonitor_project（与算法侧绑定；删本地须先走平台 DELETE→算法归档，禁止裸 TRUNCATE）
-- 幂等：可重复执行

SET FOREIGN_KEY_CHECKS = 0;

-- ========== CRM 业务（保留 product / category / *config / business_status*）==========
TRUNCATE TABLE crm_follow_up_record;
TRUNCATE TABLE crm_owner_record;
TRUNCATE TABLE crm_permission;
TRUNCATE TABLE crm_receivable;
TRUNCATE TABLE crm_receivable_plan;
TRUNCATE TABLE crm_contract_product;
TRUNCATE TABLE crm_contract;
TRUNCATE TABLE crm_business_product;
TRUNCATE TABLE crm_contact_business;
TRUNCATE TABLE crm_business;
TRUNCATE TABLE crm_contact;
TRUNCATE TABLE crm_customer;
TRUNCATE TABLE crm_clue;

-- ========== 我的日程 ==========
TRUNCATE TABLE bpm_schedule;

-- ========== 站内信消息（保留 system_notify_template）==========
TRUNCATE TABLE system_notify_message;

-- ========== 助手对话 ==========
TRUNCATE TABLE assistant_message;
TRUNCATE TABLE assistant_conversation;

-- ========== BPM 运行态抄送等（保留模型定义表）==========
TRUNCATE TABLE bpm_process_instance_copy;
TRUNCATE TABLE bpm_oa_leave;

-- ========== Flowable：清运行/历史实例，保留仓库定义 ACT_RE_* ==========
TRUNCATE TABLE ACT_RU_VARIABLE;
TRUNCATE TABLE ACT_RU_IDENTITYLINK;
TRUNCATE TABLE ACT_RU_TASK;
TRUNCATE TABLE ACT_RU_ACTINST;
TRUNCATE TABLE ACT_RU_ENTITYLINK;
TRUNCATE TABLE ACT_RU_EVENT_SUBSCR;
TRUNCATE TABLE ACT_RU_JOB;
TRUNCATE TABLE ACT_RU_TIMER_JOB;
TRUNCATE TABLE ACT_RU_SUSPENDED_JOB;
TRUNCATE TABLE ACT_RU_DEADLETTER_JOB;
TRUNCATE TABLE ACT_RU_EXTERNAL_JOB;
TRUNCATE TABLE ACT_RU_HISTORY_JOB;
TRUNCATE TABLE ACT_RU_EXECUTION;

TRUNCATE TABLE ACT_HI_VARINST;
TRUNCATE TABLE ACT_HI_IDENTITYLINK;
TRUNCATE TABLE ACT_HI_TASKINST;
TRUNCATE TABLE ACT_HI_ACTINST;
TRUNCATE TABLE ACT_HI_PROCINST;
TRUNCATE TABLE ACT_HI_DETAIL;
TRUNCATE TABLE ACT_HI_COMMENT;
TRUNCATE TABLE ACT_HI_ATTACHMENT;
TRUNCATE TABLE ACT_HI_ENTITYLINK;
TRUNCATE TABLE ACT_HI_TSK_LOG;

-- 运行产生的字节（无 deployment 关联）；部署资源保留
DELETE FROM ACT_GE_BYTEARRAY WHERE DEPLOYMENT_ID_ IS NULL;

-- ========== 操作/登录日志（演示噪音）==========
TRUNCATE TABLE system_operate_log;
TRUNCATE TABLE system_login_log;

SET FOREIGN_KEY_CHECKS = 1;

SELECT 'demo business data cleaned' AS message,
  (SELECT COUNT(*) FROM crm_customer) AS customers,
  (SELECT COUNT(*) FROM crm_clue) AS clues,
  (SELECT COUNT(*) FROM crm_product) AS products,
  (SELECT COUNT(*) FROM bpm_schedule) AS schedules,
  (SELECT COUNT(*) FROM system_notify_message) AS notify_msg,
  (SELECT COUNT(*) FROM system_notify_template WHERE deleted=0) AS notify_templates,
  (SELECT COUNT(*) FROM assistant_conversation) AS assistant_conv,
  (SELECT COUNT(*) FROM ACT_HI_PROCINST) AS hi_proc,
  (SELECT COUNT(*) FROM ACT_RE_PROCDEF) AS proc_defs;
