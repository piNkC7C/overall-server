-- =============================================================================
-- Wipe notify / schedule / CRM / AI-assistant, then seed ~10 US sales sets
-- Target: overall, tenant_id=1 | Owners: 1=Admin, 2=Tom, 249=Jerry
-- Run: mysql -uroot -p -h127.0.0.1 overall < crm_us_sales_demo_seed.sql
-- =============================================================================

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
SET @tid := 1;
SET @now := NOW();

-- ---------------------------------------------------------------------------
-- 0) Ensure AI assistant tables exist (empty after wipe)
-- ---------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `assistant_conversation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `title` varchar(128) NOT NULL DEFAULT '',
  `preview` varchar(512) NULL,
  `agent_session_id` varchar(64) NULL,
  `creator` varchar(64) NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updater` varchar(64) NULL DEFAULT '',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `tenant_id` bigint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `idx_assistant_conversation_user`(`user_id`, `update_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `assistant_message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `conversation_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `role` varchar(16) NOT NULL,
  `content` mediumtext NULL,
  `reasoning` mediumtext NULL,
  `status` tinyint NOT NULL DEFAULT 1,
  `files` text NULL,
  `payload` mediumtext NULL,
  `creator` varchar(64) NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updater` varchar(64) NULL DEFAULT '',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `tenant_id` bigint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `idx_assistant_message_conversation`(`conversation_id`, `id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `bpm_schedule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` tinyint NOT NULL,
  `priority` tinyint NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `remind` bit NOT NULL DEFAULT b'0',
  `remind_minutes` int NOT NULL DEFAULT 0,
  `reminded` bit NOT NULL DEFAULT b'0',
  `process_status` tinyint NOT NULL DEFAULT 0,
  `process_time` datetime DEFAULT NULL,
  `creator` varchar(64) DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updater` varchar(64) DEFAULT '',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` bit NOT NULL DEFAULT b'0',
  `tenant_id` bigint NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------
-- 1) Physical wipe (messages only — keep notify templates)
-- ---------------------------------------------------------------------------
TRUNCATE TABLE system_notify_message;
TRUNCATE TABLE bpm_schedule;
TRUNCATE TABLE assistant_message;
TRUNCATE TABLE assistant_conversation;

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
TRUNCATE TABLE crm_product;
TRUNCATE TABLE crm_product_category;
TRUNCATE TABLE crm_business_status;
TRUNCATE TABLE crm_business_status_type;
TRUNCATE TABLE crm_performance_config;
TRUNCATE TABLE crm_customer_limit_config;
TRUNCATE TABLE crm_customer_pool_config;
TRUNCATE TABLE crm_contract_config;

-- ---------------------------------------------------------------------------
-- 2) Minimal CRM config + catalog + pipeline
-- ---------------------------------------------------------------------------
INSERT INTO crm_customer_pool_config
(enabled, contact_expire_days, deal_expire_days, notify_enabled, notify_days,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES (b'1', 30, 90, b'1', 3, '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_contract_config
(notify_enabled, notify_days, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES (b'1', 14, '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_product_category (id, name, parent_id, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(1, 'Software Subscriptions', 0, '1', @now, '1', @now, b'0', @tid),
(2, 'Professional Services', 0, '1', @now, '1', @now, b'0', @tid),
(3, 'Hardware & Devices', 0, '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_product
(id, name, no, unit, price, status, category_id, description, owner_user_id,
 creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(1, 'CRM Cloud Pro (Annual)', 'SKU-CRM-PRO', 1, 12000, 1, 1, 'Full CRM seat bundle', 1, '1', @now, '1', @now, b'0', @tid),
(2, 'CRM Cloud Starter (Annual)', 'SKU-CRM-ST', 1, 4800, 1, 1, 'SMB starter seats', 1, '1', @now, '1', @now, b'0', @tid),
(3, 'AI Sales Copilot Add-on', 'SKU-AI-COP', 1, 3600, 1, 1, 'AI follow-up assistant seats', 1, '1', @now, '1', @now, b'0', @tid),
(4, 'Implementation Package', 'SKU-IMPL', 1, 15000, 1, 2, 'Onboarding + migration + training', 1, '1', @now, '1', @now, b'0', @tid),
(5, 'Success Retainer (Quarterly)', 'SKU-CSM-Q', 1, 4500, 1, 2, 'CSM hours per quarter', 1, '1', @now, '1', @now, b'0', @tid),
(6, 'Edge Gateway Device', 'SKU-EDGE', 1, 899, 1, 3, 'Retail / IoT edge device', 1, '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_business_status_type (id, name, dept_ids, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(1, 'Standard Sales Pipeline', NULL, '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_business_status (id, type_id, name, percent, sort, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(1, 1, 'Qualification', 10, 1, '1', @now, '1', @now, b'0', @tid),
(2, 1, 'Needs Analysis', 30, 2, '1', @now, '1', @now, b'0', @tid),
(3, 1, 'Proposal', 50, 3, '1', @now, '1', @now, b'0', @tid),
(4, 1, 'Negotiation', 70, 4, '1', @now, '1', @now, b'0', @tid);

-- ---------------------------------------------------------------------------
-- 3) Ten sales sets (US English)
-- industry 1 IT / 2 Finance / 3 Real estate / 4 Biz service / 5 Logistics / 6 Mfg / 8 Media
-- level 1A 2B 3C | source 2 Search 3 Ad 4 Referral 5 Register 8 Cold 9 Phone 10 Email
-- ---------------------------------------------------------------------------

-- ===== SET 1 BrightPath Healthcare — CLOSED WON =====
INSERT INTO crm_clue
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, transform_status, customer_id, mobile, telephone, email, detail_address,
 industry_id, level, source, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(1, 'BrightPath Healthcare — inbound', b'1', DATE_SUB(@now, INTERVAL 60 DAY), 'Qualified and converted', NULL, b'1',
 1, b'1', 1, '6175550111', '6175550101', 'vp.ops@brightpathhc.example', '1 Boston Medical Center Pl, Boston, MA 02118',
 4, 1, 4, 'SET1 converted lead', '1', DATE_SUB(@now, INTERVAL 70 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_customer
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, owner_time, pool_reminded, lock_status, deal_status,
 mobile, telephone, email, detail_address, industry_id, level, source, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(1, 'BrightPath Healthcare', b'1', DATE_SUB(@now, INTERVAL 3 DAY), 'QBR prep — expansion seats', DATE_ADD(CURDATE(), INTERVAL 5 DAY) + INTERVAL 10 HOUR, b'0',
 1, DATE_SUB(@now, INTERVAL 55 DAY), b'0', b'1', b'1',
 '6175550111', '6175550101', 'vp.ops@brightpathhc.example', '1 Boston Medical Center Pl, Boston, MA 02118',
 4, 1, 4, 'SET1 closed-won account', '1', DATE_SUB(@now, INTERVAL 55 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_contact
(id, name, customer_id, contact_last_time, contact_last_content, contact_next_time,
 owner_user_id, mobile, telephone, email, sex, master, post, detail_address, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(1, 'Dr. Sarah Mitchell', 1, DATE_SUB(@now, INTERVAL 3 DAY), 'Confirmed QBR agenda', DATE_ADD(CURDATE(), INTERVAL 5 DAY) + INTERVAL 10 HOUR,
 1, '6175550111', '6175550101', 's.mitchell@brightpathhc.example', 2, b'1', 'VP of Operations', 'Boston, MA', 'SET1 DM',
 '1', DATE_SUB(@now, INTERVAL 55 DAY), '1', @now, b'0', @tid),
(2, 'James Chen', 1, DATE_SUB(@now, INTERVAL 12 DAY), 'Security review OK', NULL,
 1, '6175550112', NULL, 'j.chen@brightpathhc.example', 1, b'0', 'IT Director', 'Boston, MA', 'SET1 tech buyer',
 '1', DATE_SUB(@now, INTERVAL 50 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_business
(id, name, customer_id, follow_up_status, contact_last_time, contact_next_time, contact_reminded,
 owner_user_id, status_type_id, status_id, end_status, end_remark, deal_time,
 total_product_price, discount_percent, total_price, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(1, 'BrightPath — CRM Pro + Implementation', 1, b'1', DATE_SUB(@now, INTERVAL 35 DAY), NULL, b'1',
 1, 1, 4, 1, 'Signed annual + implementation', DATE_SUB(@now, INTERVAL 30 DAY),
 27000, 5, 25650, 'SET1 won', '1', DATE_SUB(@now, INTERVAL 50 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_business_product (business_id, product_id, product_price, business_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(1, 1, 12000, 12000, 1, 12000, '1', @now, '1', @now, b'0', @tid),
(1, 4, 15000, 15000, 1, 15000, '1', @now, '1', @now, b'0', @tid);
INSERT INTO crm_contact_business (contact_id, business_id, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(1, 1, '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_contract
(id, name, no, customer_id, business_id, contact_last_time, contact_next_time, contact_reminded,
 owner_user_id, audit_status, order_date, start_time, end_time, expiry_reminded,
 total_product_price, discount_percent, total_price, sign_contact_id, sign_user_id, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(1, 'BrightPath FY26 Master Agreement', 'CT-2026-0001', 1, 1,
 DATE_SUB(@now, INTERVAL 3 DAY), DATE_ADD(CURDATE(), INTERVAL 14 DAY) + INTERVAL 10 HOUR, b'0',
 1, 20, DATE_SUB(@now, INTERVAL 30 DAY), DATE_SUB(@now, INTERVAL 30 DAY), DATE_ADD(@now, INTERVAL 335 DAY), b'0',
 27000, 5, 25650, 1, 1, 'SET1 active contract', '1', DATE_SUB(@now, INTERVAL 30 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_contract_product (contract_id, product_id, product_price, contract_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(1, 1, 12000, 11400, 1, 11400, '1', @now, '1', @now, b'0', @tid),
(1, 4, 15000, 14250, 1, 14250, '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_receivable_plan
(id, period, customer_id, contract_id, owner_user_id, return_time, return_type, price, receivable_id,
 remind_days, remind_time, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(1, 1, 1, 1, 1, DATE_SUB(@now, INTERVAL 25 DAY), 5, 12825, NULL, 3, DATE_SUB(@now, INTERVAL 28 DAY), 'SET1 50% signing', '1', @now, '1', @now, b'0', @tid),
(2, 2, 1, 1, 1, DATE_ADD(CURDATE(), INTERVAL 60 DAY), 5, 12825, NULL, 7, DATE_ADD(CURDATE(), INTERVAL 53 DAY), 'SET1 50% go-live', '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_receivable
(id, no, plan_id, customer_id, contract_id, owner_user_id, return_time, return_type, price, remark, audit_status,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(1, 'RCV-2026-0001', 1, 1, 1, 1, DATE_SUB(@now, INTERVAL 24 DAY), 5, 12825, 'SET1 first installment', 20,
 '1', DATE_SUB(@now, INTERVAL 24 DAY), '1', @now, b'0', @tid);
UPDATE crm_receivable_plan SET receivable_id=1 WHERE id=1;

-- ===== SET 2 Pacific Retail Co — CLOSED WON =====
INSERT INTO crm_clue
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, transform_status, customer_id, mobile, telephone, email, detail_address,
 industry_id, level, source, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(2, 'Pacific Retail — search inbound', b'1', DATE_SUB(@now, INTERVAL 90 DAY), 'Converted after pilot pitch', NULL, b'1',
 2, b'1', 2, '3105550177', '3105550167', 'it@pacificretail.example', '6801 Hollywood Blvd, Los Angeles, CA 90028',
 4, 1, 2, 'SET2 converted', '2', DATE_SUB(@now, INTERVAL 95 DAY), '2', @now, b'0', @tid);

INSERT INTO crm_customer
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, owner_time, pool_reminded, lock_status, deal_status,
 mobile, telephone, email, detail_address, industry_id, level, source, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(2, 'Pacific Retail Co', b'1', DATE_SUB(@now, INTERVAL 7 DAY), 'Phase-2 devices shipped', DATE_ADD(CURDATE(), INTERVAL 7 DAY) + INTERVAL 16 HOUR, b'0',
 2, DATE_SUB(@now, INTERVAL 85 DAY), b'0', b'1', b'1',
 '3105550177', '3105550167', 'it@pacificretail.example', '6801 Hollywood Blvd, Los Angeles, CA 90028',
 4, 1, 2, 'SET2 closed-won retail', '2', DATE_SUB(@now, INTERVAL 85 DAY), '2', @now, b'0', @tid);
INSERT INTO crm_contact
(id, name, customer_id, contact_last_time, contact_last_content, contact_next_time,
 owner_user_id, mobile, telephone, email, sex, master, post, detail_address, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(3, 'Priya Nair', 2, DATE_SUB(@now, INTERVAL 7 DAY), 'Store pilot metrics shared', DATE_ADD(CURDATE(), INTERVAL 7 DAY) + INTERVAL 16 HOUR,
 2, '3105550177', '3105550167', 'p.nair@pacificretail.example', 2, b'1', 'CIO', 'Los Angeles, CA', 'SET2 sponsor',
 '2', DATE_SUB(@now, INTERVAL 85 DAY), '2', @now, b'0', @tid);

INSERT INTO crm_business
(id, name, customer_id, follow_up_status, contact_last_time, contact_next_time, contact_reminded,
 owner_user_id, status_type_id, status_id, end_status, end_remark, deal_time,
 total_product_price, discount_percent, total_price, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(2, 'Pacific Retail — Cloud + Edge rollout', 2, b'1', DATE_SUB(@now, INTERVAL 40 DAY), NULL, b'1',
 2, 1, 4, 1, 'Phase 1 closed', DATE_SUB(@now, INTERVAL 35 DAY),
 17497, 0, 17497, 'SET2 won', '2', DATE_SUB(@now, INTERVAL 75 DAY), '2', @now, b'0', @tid);
INSERT INTO crm_business_product (business_id, product_id, product_price, business_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(2, 1, 12000, 12000, 1, 12000, '2', @now, '2', @now, b'0', @tid),
(2, 6, 899, 899, 5, 4495, '2', @now, '2', @now, b'0', @tid),
(2, 5, 4500, 4500, 1, 4500, '2', @now, '2', @now, b'0', @tid);
INSERT INTO crm_contact_business (contact_id, business_id, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(3, 2, '2', @now, '2', @now, b'0', @tid);

INSERT INTO crm_contract
(id, name, no, customer_id, business_id, contact_last_time, contact_next_time, contact_reminded,
 owner_user_id, process_instance_id, audit_status, order_date, start_time, end_time, expiry_reminded,
 total_product_price, discount_percent, total_price, sign_contact_id, sign_user_id, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(2, 'Pacific Retail Phase-1 Agreement', 'CT-2026-0002', 2, 2,
 DATE_SUB(@now, INTERVAL 7 DAY), DATE_ADD(CURDATE(), INTERVAL 10 DAY) + INTERVAL 16 HOUR, b'0',
 2, NULL, 20, DATE_SUB(@now, INTERVAL 35 DAY), DATE_SUB(@now, INTERVAL 35 DAY), DATE_ADD(@now, INTERVAL 150 DAY), b'0',
 17497, 0, 17497, 3, 2, 'SET2 retail contract', '2', DATE_SUB(@now, INTERVAL 35 DAY), '2', @now, b'0', @tid);
INSERT INTO crm_contract_product (contract_id, product_id, product_price, contract_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(2, 1, 12000, 12000, 1, 12000, '2', @now, '2', @now, b'0', @tid),
(2, 6, 899, 899, 5, 4495, '2', @now, '2', @now, b'0', @tid),
(2, 5, 4500, 4500, 1, 4500, '2', @now, '2', @now, b'0', @tid);

INSERT INTO crm_receivable_plan
(id, period, customer_id, contract_id, owner_user_id, return_time, return_type, price, receivable_id,
 remind_days, remind_time, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(3, 1, 2, 2, 2, DATE_SUB(@now, INTERVAL 30 DAY), 5, 8748.5, NULL, 3, DATE_SUB(@now, INTERVAL 33 DAY), 'SET2 deposit', '2', @now, '2', @now, b'0', @tid),
(4, 2, 2, 2, 2, DATE_ADD(CURDATE(), INTERVAL 20 DAY), 5, 8748.5, NULL, 5, DATE_ADD(CURDATE(), INTERVAL 15 DAY), 'SET2 balance', '2', @now, '2', @now, b'0', @tid);

INSERT INTO crm_receivable
(id, no, plan_id, customer_id, contract_id, owner_user_id, return_time, return_type, price, remark,
 process_instance_id, audit_status, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(2, 'RCV-2026-0002', 3, 2, 2, 2, DATE_SUB(@now, INTERVAL 29 DAY), 5, 8748.5, 'SET2 deposit received',
 NULL, 20, '2', DATE_SUB(@now, INTERVAL 29 DAY), '2', @now, b'0', @tid);UPDATE crm_receivable_plan SET receivable_id=2 WHERE id=3;

-- ===== SET 3 Meridian Biotech — CLOSED WON (recent) =====
INSERT INTO crm_clue
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, transform_status, customer_id, mobile, telephone, email, detail_address,
 industry_id, level, source, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(3, 'Meridian Biotech — referral', b'1', DATE_SUB(@now, INTERVAL 40 DAY), 'Converted after lab tour', NULL, b'1',
 1, b'1', 3, '8585550130', '8585550120', 'labs@meridianbio.example', '10996 Torreyana Rd, San Diego, CA 92121',
 6, 1, 4, 'SET3 converted', '1', DATE_SUB(@now, INTERVAL 50 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_customer
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, owner_time, pool_reminded, lock_status, deal_status,
 mobile, telephone, email, detail_address, industry_id, level, source, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(3, 'Meridian Biotech', b'1', DATE_SUB(@now, INTERVAL 5 DAY), 'Kickoff training scheduled', DATE_ADD(CURDATE(), INTERVAL 8 DAY) + INTERVAL 11 HOUR, b'0',
 1, DATE_SUB(@now, INTERVAL 38 DAY), b'0', b'1', b'1',
 '8585550130', '8585550120', 'labs@meridianbio.example', '10996 Torreyana Rd, San Diego, CA 92121',
 6, 1, 4, 'SET3 recent win', '1', DATE_SUB(@now, INTERVAL 38 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_contact
(id, name, customer_id, contact_last_time, contact_next_time, owner_user_id, mobile, email, sex, master, post, detail_address, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(4, 'Laura Kim', 3, DATE_SUB(@now, INTERVAL 5 DAY), DATE_ADD(CURDATE(), INTERVAL 8 DAY) + INTERVAL 11 HOUR,
 1, '8585550130', 'l.kim@meridianbio.example', 2, b'1', 'Head of Lab Ops', 'San Diego, CA', 'SET3 DM',
 '1', DATE_SUB(@now, INTERVAL 38 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_business
(id, name, customer_id, follow_up_status, contact_last_time, contact_reminded,
 owner_user_id, status_type_id, status_id, end_status, end_remark, deal_time,
 total_product_price, discount_percent, total_price, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(3, 'Meridian — Starter + Implementation', 3, b'1', DATE_SUB(@now, INTERVAL 12 DAY), b'1',
 1, 1, 4, 1, 'Won after competitive bake-off', DATE_SUB(@now, INTERVAL 10 DAY),
 19800, 0, 19800, 'SET3 won', '1', DATE_SUB(@now, INTERVAL 35 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_business_product (business_id, product_id, product_price, business_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(3, 2, 4800, 4800, 1, 4800, '1', @now, '1', @now, b'0', @tid),
(3, 4, 15000, 15000, 1, 15000, '1', @now, '1', @now, b'0', @tid);
INSERT INTO crm_contact_business (contact_id, business_id, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(4, 3, '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_contract
(id, name, no, customer_id, business_id, contact_next_time, contact_reminded,
 owner_user_id, audit_status, order_date, start_time, end_time, expiry_reminded,
 total_product_price, discount_percent, total_price, sign_contact_id, sign_user_id, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(3, 'Meridian Biotech Annual Agreement', 'CT-2026-0003', 3, 3,
 DATE_ADD(CURDATE(), INTERVAL 8 DAY) + INTERVAL 11 HOUR, b'0',
 1, 20, DATE_SUB(@now, INTERVAL 10 DAY), DATE_SUB(@now, INTERVAL 10 DAY), DATE_ADD(@now, INTERVAL 355 DAY), b'0',
 19800, 0, 19800, 4, 1, 'SET3 contract', '1', DATE_SUB(@now, INTERVAL 10 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_contract_product (contract_id, product_id, product_price, contract_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(3, 2, 4800, 4800, 1, 4800, '1', @now, '1', @now, b'0', @tid),
(3, 4, 15000, 15000, 1, 15000, '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_receivable_plan
(id, period, customer_id, contract_id, owner_user_id, return_time, return_type, price, remind_days, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(5, 1, 3, 3, 1, DATE_ADD(CURDATE(), INTERVAL 5 DAY), 5, 19800, 3, 'SET3 full payment due', '1', @now, '1', @now, b'0', @tid);

-- ===== SET 4 Acme Robotics — NEGOTIATION + draft contract =====
INSERT INTO crm_clue
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, transform_status, customer_id, mobile, telephone, email, detail_address,
 industry_id, level, source, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(4, 'Acme Robotics — phone inquiry', b'1', DATE_SUB(@now, INTERVAL 25 DAY), 'Converted after plant visit', NULL, b'1',
 1, b'1', 4, '4155550122', '4155550112', 'plant@acmerobotics.example', '500 Howard St, San Francisco, CA 94105',
 6, 1, 9, 'SET4 converted', '1', DATE_SUB(@now, INTERVAL 45 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_customer
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, owner_time, pool_reminded, lock_status, deal_status,
 mobile, telephone, email, detail_address, industry_id, level, source, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(4, 'Acme Robotics Inc', b'1', DATE_SUB(@now, INTERVAL 1 DAY), 'Legal redlines returned', DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 14 HOUR, b'0',
 1, DATE_SUB(@now, INTERVAL 40 DAY), b'0', b'0', b'0',
 '4155550122', '4155550112', 'plant@acmerobotics.example', '500 Howard St, San Francisco, CA 94105',
 6, 1, 9, 'SET4 negotiation', '1', DATE_SUB(@now, INTERVAL 40 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_contact
(id, name, customer_id, contact_last_time, contact_next_time, owner_user_id, mobile, email, sex, master, post, detail_address, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(5, 'Elena Vargas', 4, DATE_SUB(@now, INTERVAL 1 DAY), DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 14 HOUR,
 1, '4155550122', 'e.vargas@acmerobotics.example', 2, b'1', 'Plant Manager', 'San Francisco, CA', 'SET4 buyer',
 '1', DATE_SUB(@now, INTERVAL 40 DAY), '1', @now, b'0', @tid),
(6, 'Marcus Lee', 4, DATE_SUB(@now, INTERVAL 5 DAY), NULL,
 1, '4155550123', 'm.lee@acmerobotics.example', 1, b'0', 'Procurement Lead', 'San Francisco, CA', 'SET4 procurement',
 '1', DATE_SUB(@now, INTERVAL 35 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_business
(id, name, customer_id, follow_up_status, contact_last_time, contact_next_time, contact_reminded,
 owner_user_id, status_type_id, status_id, end_status, deal_time,
 total_product_price, discount_percent, total_price, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(4, 'Acme — Plant CRM + Copilot', 4, b'1', DATE_SUB(@now, INTERVAL 1 DAY), DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 14 HOUR, b'0',
 1, 1, 4, NULL, DATE_ADD(CURDATE(), INTERVAL 20 DAY),
 30600, 8, 28152, 'SET4 late negotiation', '1', DATE_SUB(@now, INTERVAL 38 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_business_product (business_id, product_id, product_price, business_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(4, 1, 12000, 12000, 1, 12000, '1', @now, '1', @now, b'0', @tid),
(4, 3, 3600, 3600, 1, 3600, '1', @now, '1', @now, b'0', @tid),
(4, 4, 15000, 15000, 1, 15000, '1', @now, '1', @now, b'0', @tid);
INSERT INTO crm_contact_business (contact_id, business_id, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(5, 4, '1', @now, '1', @now, b'0', @tid);

INSERT INTO crm_contract
(id, name, no, customer_id, business_id, contact_last_time, contact_next_time, contact_reminded,
 owner_user_id, audit_status, order_date, start_time, end_time, expiry_reminded,
 total_product_price, discount_percent, total_price, sign_contact_id, sign_user_id, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(4, 'Acme Robotics — Draft MSA', 'CT-2026-0004', 4, 4,
 DATE_SUB(@now, INTERVAL 1 DAY), DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 14 HOUR, b'0',
 1, 0, DATE_ADD(CURDATE(), INTERVAL 5 DAY), DATE_ADD(CURDATE(), INTERVAL 10 DAY), DATE_ADD(CURDATE(), INTERVAL 375 DAY), b'0',
 30600, 8, 28152, 5, 1, 'SET4 draft not submitted', '1', DATE_SUB(@now, INTERVAL 2 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_contract_product (contract_id, product_id, product_price, contract_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(4, 1, 12000, 11040, 1, 11040, '1', @now, '1', @now, b'0', @tid),
(4, 3, 3600, 3312, 1, 3312, '1', @now, '1', @now, b'0', @tid),
(4, 4, 15000, 13800, 1, 13800, '1', @now, '1', @now, b'0', @tid);

-- ===== SET 5 Cascade FinTech — PROPOSAL =====
INSERT INTO crm_clue
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_reminded,
 owner_user_id, transform_status, customer_id, mobile, telephone, email, detail_address,
 industry_id, level, source, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(5, 'Cascade FinTech — email inquiry', b'1', DATE_SUB(@now, INTERVAL 15 DAY), 'Converted after compliance call', b'1',
 249, b'1', 5, '2065550188', '2065550178', 'risk@cascadefintech.example', '1201 3rd Ave, Seattle, WA 98101',
 2, 1, 10, 'SET5 converted', '249', DATE_SUB(@now, INTERVAL 30 DAY), '249', @now, b'0', @tid);

INSERT INTO crm_customer
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, owner_time, pool_reminded, lock_status, deal_status,
 mobile, telephone, email, detail_address, industry_id, level, source, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(5, 'Cascade FinTech', b'1', DATE_SUB(@now, INTERVAL 2 DAY), 'Security questionnaire in progress', DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 11 HOUR, b'0',
 249, DATE_SUB(@now, INTERVAL 28 DAY), b'0', b'0', b'0',
 '2065550188', '2065550178', 'risk@cascadefintech.example', '1201 3rd Ave, Seattle, WA 98101',
 2, 1, 10, 'SET5 proposal stage', '249', DATE_SUB(@now, INTERVAL 28 DAY), '249', @now, b'0', @tid);

INSERT INTO crm_contact
(id, name, customer_id, contact_last_time, contact_next_time, owner_user_id, mobile, email, sex, master, post, detail_address, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(7, 'Daniel Brooks', 5, DATE_SUB(@now, INTERVAL 2 DAY), DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 11 HOUR,
 249, '2065550188', 'd.brooks@cascadefintech.example', 1, b'1', 'Head of Risk', 'Seattle, WA', 'SET5 compliance',
 '249', DATE_SUB(@now, INTERVAL 28 DAY), '249', @now, b'0', @tid);

INSERT INTO crm_business
(id, name, customer_id, follow_up_status, contact_last_time, contact_next_time, contact_reminded,
 owner_user_id, status_type_id, status_id, deal_time,
 total_product_price, discount_percent, total_price, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(5, 'Cascade — Pro + Copilot', 5, b'1', DATE_SUB(@now, INTERVAL 2 DAY), DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 11 HOUR, b'0',
 249, 1, 3, DATE_ADD(CURDATE(), INTERVAL 35 DAY),
 15600, 0, 15600, 'SET5 proposal out', '249', DATE_SUB(@now, INTERVAL 25 DAY), '249', @now, b'0', @tid);

INSERT INTO crm_business_product (business_id, product_id, product_price, business_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(5, 1, 12000, 12000, 1, 12000, '249', @now, '249', @now, b'0', @tid),
(5, 3, 3600, 3600, 1, 3600, '249', @now, '249', @now, b'0', @tid);
INSERT INTO crm_contact_business (contact_id, business_id, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(7, 5, '249', @now, '249', @now, b'0', @tid);

-- ===== SET 6 Northstar Logistics — NEEDS ANALYSIS =====
INSERT INTO crm_clue
(id, name, follow_up_status, contact_last_time, contact_reminded,
 owner_user_id, transform_status, customer_id, mobile, telephone, email, detail_address,
 industry_id, level, source, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(6, 'Northstar Logistics — referral', b'1', DATE_SUB(@now, INTERVAL 20 DAY), b'1',
 1, b'1', 6, '3125550144', '3125550134', 'ops@northstarlogistics.example', '233 S Wacker Dr, Chicago, IL 60606',
 5, 2, 4, 'SET6 converted', '1', DATE_SUB(@now, INTERVAL 22 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_customer
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, owner_time, pool_reminded, lock_status, deal_status,
 mobile, telephone, email, detail_address, industry_id, level, source, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(6, 'Northstar Logistics LLC', b'1', DATE_SUB(@now, INTERVAL 4 DAY), 'Warehouse pilot scoping', DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL 13 HOUR, b'0',
 1, DATE_SUB(@now, INTERVAL 20 DAY), b'0', b'0', b'0',
 '3125550144', '3125550134', 'ops@northstarlogistics.example', '233 S Wacker Dr, Chicago, IL 60606',
 5, 2, 4, 'SET6 needs analysis', '1', DATE_SUB(@now, INTERVAL 20 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_contact
(id, name, customer_id, contact_last_time, contact_next_time, owner_user_id, mobile, email, sex, master, post, detail_address, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(8, 'Olivia Grant', 6, DATE_SUB(@now, INTERVAL 4 DAY), DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL 13 HOUR,
 1, '3125550144', 'o.grant@northstarlogistics.example', 2, b'1', 'Director of Operations', 'Chicago, IL', 'SET6 champion',
 '1', DATE_SUB(@now, INTERVAL 20 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_business
(id, name, customer_id, follow_up_status, contact_last_time, contact_next_time, contact_reminded,
 owner_user_id, status_type_id, status_id, deal_time,
 total_product_price, discount_percent, total_price, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(6, 'Northstar — Warehouse pilot', 6, b'1', DATE_SUB(@now, INTERVAL 4 DAY), DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL 13 HOUR, b'0',
 1, 1, 2, DATE_ADD(CURDATE(), INTERVAL 45 DAY),
 19800, 10, 17820, 'SET6 needs analysis', '1', DATE_SUB(@now, INTERVAL 18 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_business_product (business_id, product_id, product_price, business_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(6, 1, 12000, 12000, 1, 12000, '1', @now, '1', @now, b'0', @tid),
(6, 4, 15000, 7800, 1, 7800, '1', @now, '1', @now, b'0', @tid);
INSERT INTO crm_contact_business (contact_id, business_id, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(8, 6, '1', @now, '1', @now, b'0', @tid);

-- ===== SET 7 Atlas Construction — PROPOSAL =====
INSERT INTO crm_clue
(id, name, follow_up_status, contact_last_time, contact_reminded,
 owner_user_id, transform_status, customer_id, mobile, telephone, email, detail_address,
 industry_id, level, source, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(7, 'Atlas Construction — phone', b'1', DATE_SUB(@now, INTERVAL 18 DAY), b'1',
 249, b'1', 7, '2145550121', '2145550111', 'estimating@atlascp.example', '2100 Ross Ave, Dallas, TX 75201',
 3, 2, 9, 'SET7 converted', '249', DATE_SUB(@now, INTERVAL 20 DAY), '249', @now, b'0', @tid);

INSERT INTO crm_customer
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, owner_time, pool_reminded, lock_status, deal_status,
 mobile, telephone, email, detail_address, industry_id, level, source, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(7, 'Atlas Construction Partners', b'1', DATE_SUB(@now, INTERVAL 6 DAY), 'Field offline mode requested', DATE_ADD(CURDATE(), INTERVAL 6 DAY) + INTERVAL 15 HOUR, b'0',
 249, DATE_SUB(@now, INTERVAL 18 DAY), b'0', b'0', b'0',
 '2145550121', '2145550111', 'estimating@atlascp.example', '2100 Ross Ave, Dallas, TX 75201',
 3, 2, 9, 'SET7 proposal drafting', '249', DATE_SUB(@now, INTERVAL 18 DAY), '249', @now, b'0', @tid);

INSERT INTO crm_contact
(id, name, customer_id, contact_last_time, contact_next_time, owner_user_id, mobile, email, sex, master, post, detail_address, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(9, 'Hannah Cole', 7, DATE_SUB(@now, INTERVAL 6 DAY), DATE_ADD(CURDATE(), INTERVAL 6 DAY) + INTERVAL 15 HOUR,
 249, '2145550121', 'h.cole@atlascp.example', 2, b'1', 'Chief Estimator', 'Dallas, TX', 'SET7 primary',
 '249', DATE_SUB(@now, INTERVAL 18 DAY), '249', @now, b'0', @tid);

INSERT INTO crm_business
(id, name, customer_id, follow_up_status, contact_last_time, contact_next_time, contact_reminded,
 owner_user_id, status_type_id, status_id, deal_time,
 total_product_price, discount_percent, total_price, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(7, 'Atlas — Field CRM', 7, b'1', DATE_SUB(@now, INTERVAL 6 DAY), DATE_ADD(CURDATE(), INTERVAL 6 DAY) + INTERVAL 15 HOUR, b'0',
 249, 1, 3, DATE_ADD(CURDATE(), INTERVAL 40 DAY),
 19500, 5, 18525, 'SET7 proposal', '249', DATE_SUB(@now, INTERVAL 16 DAY), '249', @now, b'0', @tid);

INSERT INTO crm_business_product (business_id, product_id, product_price, business_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(7, 1, 12000, 12000, 1, 12000, '249', @now, '249', @now, b'0', @tid),
(7, 4, 15000, 7500, 1, 7500, '249', @now, '249', @now, b'0', @tid);
INSERT INTO crm_contact_business (contact_id, business_id, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(9, 7, '249', @now, '249', @now, b'0', @tid);

-- ===== SET 8 Horizon EduTech — QUALIFICATION =====
INSERT INTO crm_clue
(id, name, follow_up_status, contact_last_time, contact_reminded,
 owner_user_id, transform_status, customer_id, mobile, telephone, email, detail_address,
 industry_id, level, source, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(8, 'Horizon EduTech — website signup', b'1', DATE_SUB(@now, INTERVAL 12 DAY), b'1',
 2, b'1', 8, '3035550199', '3035550189', 'dean@horizonedutech.example', '1700 Broadway, Denver, CO 80202',
 1, 2, 5, 'SET8 converted', '2', DATE_SUB(@now, INTERVAL 14 DAY), '2', @now, b'0', @tid);

INSERT INTO crm_customer
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, owner_time, pool_reminded, lock_status, deal_status,
 mobile, telephone, email, detail_address, industry_id, level, source, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(8, 'Horizon EduTech', b'0', DATE_SUB(@now, INTERVAL 10 DAY), 'Intro call completed', DATE_ADD(CURDATE(), INTERVAL 4 DAY) + INTERVAL 9 HOUR, b'0',
 2, DATE_SUB(@now, INTERVAL 12 DAY), b'0', b'0', b'0',
 '3035550199', '3035550189', 'dean@horizonedutech.example', '1700 Broadway, Denver, CO 80202',
 1, 2, 5, 'SET8 early qualification', '2', DATE_SUB(@now, INTERVAL 12 DAY), '2', @now, b'0', @tid);

INSERT INTO crm_contact
(id, name, customer_id, contact_last_time, contact_next_time, owner_user_id, mobile, email, sex, master, post, detail_address, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(10, 'Noah Patel', 8, DATE_SUB(@now, INTERVAL 10 DAY), DATE_ADD(CURDATE(), INTERVAL 4 DAY) + INTERVAL 9 HOUR,
 2, '3035550199', 'n.patel@horizonedutech.example', 1, b'1', 'Dean of Digital Learning', 'Denver, CO', 'SET8 evaluator',
 '2', DATE_SUB(@now, INTERVAL 12 DAY), '2', @now, b'0', @tid);

INSERT INTO crm_business
(id, name, customer_id, follow_up_status, contact_last_time, contact_next_time, contact_reminded,
 owner_user_id, status_type_id, status_id, deal_time,
 total_product_price, discount_percent, total_price, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(8, 'Horizon — Starter evaluation', 8, b'0', DATE_SUB(@now, INTERVAL 10 DAY), DATE_ADD(CURDATE(), INTERVAL 4 DAY) + INTERVAL 9 HOUR, b'0',
 2, 1, 1, DATE_ADD(CURDATE(), INTERVAL 60 DAY),
 4800, 0, 4800, 'SET8 qualification', '2', DATE_SUB(@now, INTERVAL 11 DAY), '2', @now, b'0', @tid);

INSERT INTO crm_business_product (business_id, product_id, product_price, business_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(8, 2, 4800, 4800, 1, 4800, '2', @now, '2', @now, b'0', @tid);
INSERT INTO crm_contact_business (contact_id, business_id, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(10, 8, '2', @now, '2', @now, b'0', @tid);

-- ===== SET 9 Vertex AI Labs — HOT LEAD (not converted) =====
INSERT INTO crm_clue
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, transform_status, customer_id, mobile, telephone, email, detail_address,
 industry_id, level, source, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(9, 'Vertex AI Labs — enterprise interest', b'1', DATE_SUB(@now, INTERVAL 1 DAY), 'CTO asked for SOC2 + SSO details',
 DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 15 HOUR, b'0',
 1, b'0', NULL, '2125550198', '2125550188', 'cto@vertexailabs.example', '350 5th Ave, New York, NY 10118',
 1, 1, 10, 'SET9 hot lead', '1', DATE_SUB(@now, INTERVAL 3 DAY), '1', @now, b'0', @tid);

-- ===== SET 10 GreenLeaf Organics — NEW LEAD + BlueRiver LOST (nurture) as customer-only lost path =====
INSERT INTO crm_clue
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, transform_status, customer_id, mobile, telephone, email, detail_address,
 industry_id, level, source, remark, creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(10, 'GreenLeaf Organics — inbound demo', b'1', DATE_SUB(@now, INTERVAL 2 DAY), 'Discovery call booked via website',
 DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 10 HOUR, b'0',
 1, b'0', NULL, '5035550142', '5035550100', 'buyer@greenleaforganics.example', '1200 NW Lovejoy St, Portland, OR 97209',
 6, 2, 5, 'SET10 new MQL', '1', DATE_SUB(@now, INTERVAL 5 DAY), '1', @now, b'0', @tid),
(11, 'Ironclad Security — cold outreach', b'0', NULL, NULL,
 DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL 11 HOUR, b'0',
 2, b'0', NULL, '6025550133', NULL, 'ops@ironcladsec.example', '2201 E Camelback Rd, Phoenix, AZ 85016',
 4, 3, 8, 'SET10 cold lead', '2', DATE_SUB(@now, INTERVAL 1 DAY), '2', @now, b'0', @tid);

-- Lost deal account (nurture) — still counts toward diversity of funnel
INSERT INTO crm_customer
(id, name, follow_up_status, contact_last_time, contact_last_content, contact_next_time, contact_reminded,
 owner_user_id, owner_time, pool_reminded, lock_status, deal_status,
 mobile, telephone, email, detail_address, industry_id, level, source, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(9, 'BlueRiver Analytics', b'1', DATE_SUB(@now, INTERVAL 20 DAY), 'Chose competitor after POC', DATE_ADD(CURDATE(), INTERVAL 30 DAY) + INTERVAL 10 HOUR, b'0',
 1, DATE_SUB(@now, INTERVAL 70 DAY), b'0', b'0', b'0',
 '6465550102', '6465550103', 'ceo@blueriver.example', '85 Broad St, New York, NY 10004',
 1, 2, 2, 'SET10 lost nurture', '1', DATE_SUB(@now, INTERVAL 70 DAY), '1', @now, b'0', @tid),
(10, 'Summit Media Group', b'0', DATE_SUB(@now, INTERVAL 45 DAY), 'No owner — public pool', NULL, b'0',
 NULL, NULL, b'0', b'0', b'0',
 '5125550155', '5125550145', 'studio@summitmedia.example', '500 W 2nd St, Austin, TX 78701',
 8, 3, 3, 'SET10 public pool', '1', DATE_SUB(@now, INTERVAL 100 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_contact
(id, name, customer_id, contact_last_time, owner_user_id, mobile, email, sex, master, post, detail_address, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(11, 'Ryan Soto', 9, DATE_SUB(@now, INTERVAL 20 DAY), 1, '6465550102', 'r.soto@blueriver.example', 1, b'1', 'CEO', 'New York, NY', 'SET10 lost contact',
 '1', DATE_SUB(@now, INTERVAL 70 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_business
(id, name, customer_id, follow_up_status, contact_last_time, contact_reminded,
 owner_user_id, status_type_id, status_id, end_status, end_remark, deal_time,
 total_product_price, discount_percent, total_price, remark,
 creator, create_time, updater, update_time, deleted, tenant_id)
VALUES
(9, 'BlueRiver — Enterprise POC (lost)', 9, b'1', DATE_SUB(@now, INTERVAL 20 DAY), b'1',
 1, 1, 3, 2, 'Selected Competitor X after POC', DATE_SUB(@now, INTERVAL 18 DAY),
 36000, 0, 36000, 'SET10 lost', '1', DATE_SUB(@now, INTERVAL 65 DAY), '1', @now, b'0', @tid);

INSERT INTO crm_business_product (business_id, product_id, product_price, business_price, count, total_price, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(9, 1, 12000, 12000, 2, 24000, '1', @now, '1', @now, b'0', @tid),
(9, 3, 3600, 3600, 2, 7200, '1', @now, '1', @now, b'0', @tid),
(9, 4, 15000, 4800, 1, 4800, '1', @now, '1', @now, b'0', @tid);
INSERT INTO crm_contact_business (contact_id, business_id, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(11, 9, '1', @now, '1', @now, b'0', @tid);

-- ---------------------------------------------------------------------------
-- 4) Follow-ups
-- ---------------------------------------------------------------------------
INSERT INTO crm_follow_up_record
(biz_type, biz_id, type, content, next_time, business_ids, contact_ids, creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(1, 9, 1, 'Called Vertex AI Labs CTO — SOC2 packet needed before security review.', DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 15 HOUR, NULL, NULL, '1', DATE_SUB(@now, INTERVAL 1 DAY), '1', @now, b'0', @tid),
(1, 10, 4, 'Sent GreenLeaf demo agenda and trial workspace invite.', DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 10 HOUR, NULL, NULL, '1', DATE_SUB(@now, INTERVAL 2 DAY), '1', @now, b'0', @tid),
(2, 4, 1, 'Legal call with Acme — liability cap redlines mostly accepted.', DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 14 HOUR, '4', '5', '1', DATE_SUB(@now, INTERVAL 1 DAY), '1', @now, b'0', @tid),
(2, 6, 3, 'On-site warehouse walkthrough with Olivia; mapped 3 pilot docks.', DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL 13 HOUR, '6', '8', '1', DATE_SUB(@now, INTERVAL 4 DAY), '1', @now, b'0', @tid),
(4, 4, 1, 'Negotiation: 8% discount approved if annual prepaid.', DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 14 HOUR, '4', '5,6', '1', DATE_SUB(@now, INTERVAL 1 DAY), '1', @now, b'0', @tid),
(4, 5, 4, 'Shared proposal PDF + security questionnaire with Cascade risk team.', DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 11 HOUR, '5', '7', '249', DATE_SUB(@now, INTERVAL 2 DAY), '249', @now, b'0', @tid),
(2, 1, 1, 'BrightPath QBR prep — expansion seats + AI Copilot interest.', DATE_ADD(CURDATE(), INTERVAL 5 DAY) + INTERVAL 10 HOUR, '1', '1', '1', DATE_SUB(@now, INTERVAL 3 DAY), '1', @now, b'0', @tid),
(5, 1, 1, 'Confirmed go-live milestone and second invoice timing.', DATE_ADD(CURDATE(), INTERVAL 14 DAY) + INTERVAL 10 HOUR, NULL, '1', '1', DATE_SUB(@now, INTERVAL 3 DAY), '1', @now, b'0', @tid),
(2, 5, 1, 'Compliance workshop scheduled for tomorrow morning.', DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 11 HOUR, '5', '7', '249', DATE_SUB(@now, INTERVAL 2 DAY), '249', @now, b'0', @tid),
(2, 2, 3, 'Visited LA flagship store; edge gateways online.', DATE_ADD(CURDATE(), INTERVAL 7 DAY) + INTERVAL 16 HOUR, '2', '3', '2', DATE_SUB(@now, INTERVAL 7 DAY), '2', @now, b'0', @tid);

-- ---------------------------------------------------------------------------
-- 5) Permissions (owner level=1)
-- ---------------------------------------------------------------------------
INSERT INTO crm_permission (biz_type, biz_id, user_id, level, creator, create_time, updater, update_time, deleted, tenant_id)
SELECT 1, id, owner_user_id, 1, '1', @now, '1', @now, b'0', @tid FROM crm_clue WHERE owner_user_id IS NOT NULL
UNION ALL
SELECT 2, id, owner_user_id, 1, '1', @now, '1', @now, b'0', @tid FROM crm_customer WHERE owner_user_id IS NOT NULL
UNION ALL
SELECT 3, id, owner_user_id, 1, '1', @now, '1', @now, b'0', @tid FROM crm_contact WHERE owner_user_id IS NOT NULL
UNION ALL
SELECT 4, id, owner_user_id, 1, '1', @now, '1', @now, b'0', @tid FROM crm_business WHERE owner_user_id IS NOT NULL
UNION ALL
SELECT 5, id, owner_user_id, 1, '1', @now, '1', @now, b'0', @tid FROM crm_contract WHERE owner_user_id IS NOT NULL
UNION ALL
SELECT 7, id, owner_user_id, 1, '1', @now, '1', @now, b'0', @tid FROM crm_receivable WHERE owner_user_id IS NOT NULL
UNION ALL
SELECT 8, id, owner_user_id, 1, '1', @now, '1', @now, b'0', @tid FROM crm_receivable_plan WHERE owner_user_id IS NOT NULL;

-- ---------------------------------------------------------------------------
-- 6) My Schedule (BPM，仅创建人；~aligned with follow-ups)
-- ---------------------------------------------------------------------------
INSERT INTO bpm_schedule
(type, priority, title, description, start_time, end_time, remind, remind_minutes, reminded, process_status,
 creator, create_time, updater, update_time, deleted, tenant_id) VALUES
(1, 3, 'Call Vertex AI Labs (Lead)', 'SET9 SOC2 follow-up',
 DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 15 HOUR, DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 15 HOUR + INTERVAL 30 MINUTE,
 b'1', 15, b'0', 0, '1', @now, '1', @now, b'0', @tid),
(1, 2, 'Acme Robotics negotiation call', 'SET4 MSA redlines with Elena',
 DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 14 HOUR, DATE_ADD(CURDATE(), INTERVAL 0 DAY) + INTERVAL 15 HOUR,
 b'1', 30, b'0', 0, '1', @now, '1', @now, b'0', @tid),
(1, 2, 'Cascade FinTech compliance workshop', 'SET5 proposal review',
 DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 11 HOUR, DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 12 HOUR,
 b'1', 30, b'0', 0, '249', @now, '249', @now, b'0', @tid),
(1, 1, 'GreenLeaf Organics product demo', 'SET10 discovery demo',
 DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 10 HOUR, DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL 11 HOUR,
 b'1', 15, b'0', 0, '1', @now, '1', @now, b'0', @tid),
(1, 2, 'Northstar warehouse pilot sync', 'SET6 customer #6',
 DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL 13 HOUR, DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL 14 HOUR,
 b'1', 15, b'0', 0, '1', @now, '1', @now, b'0', @tid),
(1, 1, 'BrightPath QBR', 'SET1 expansion discussion',
 DATE_ADD(CURDATE(), INTERVAL 5 DAY) + INTERVAL 10 HOUR, DATE_ADD(CURDATE(), INTERVAL 5 DAY) + INTERVAL 11 HOUR,
 b'1', 60, b'0', 0, '1', @now, '1', @now, b'0', @tid),
(1, 1, 'Horizon EduTech follow-up', 'SET8 qualification call',
 DATE_ADD(CURDATE(), INTERVAL 4 DAY) + INTERVAL 9 HOUR, DATE_ADD(CURDATE(), INTERVAL 4 DAY) + INTERVAL 10 HOUR,
 b'1', 15, b'0', 0, '2', @now, '2', @now, b'0', @tid),
(1, 2, 'Atlas Construction proposal review', 'SET7 field CRM proposal',
 DATE_ADD(CURDATE(), INTERVAL 6 DAY) + INTERVAL 15 HOUR, DATE_ADD(CURDATE(), INTERVAL 6 DAY) + INTERVAL 16 HOUR,
 b'1', 30, b'0', 0, '249', @now, '249', @now, b'0', @tid);

SET FOREIGN_KEY_CHECKS = 1;

-- Summary
SELECT 'wipe+seed done' AS message,
 (SELECT COUNT(*) FROM system_notify_message) AS notify_msg,
 (SELECT COUNT(*) FROM assistant_conversation) AS ai_conv,
 (SELECT COUNT(*) FROM assistant_message) AS ai_msg,
 (SELECT COUNT(*) FROM bpm_schedule) AS schedules,
 (SELECT COUNT(*) FROM crm_clue) AS clues,
 (SELECT COUNT(*) FROM crm_customer) AS customers,
 (SELECT COUNT(*) FROM crm_contact) AS contacts,
 (SELECT COUNT(*) FROM crm_business) AS opportunities,
 (SELECT COUNT(*) FROM crm_contract) AS contracts,
 (SELECT COUNT(*) FROM crm_receivable) AS receivables,
 (SELECT COUNT(*) FROM crm_follow_up_record) AS follow_ups;
