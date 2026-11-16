-- Bind CRM agent session id + persist stream payload (tools / approval).
ALTER TABLE `assistant_conversation`
  ADD COLUMN `agent_session_id` varchar(64) NULL DEFAULT NULL COMMENT 'CRM agent session id' AFTER `preview`;

ALTER TABLE `assistant_message`
  ADD COLUMN `payload` mediumtext NULL COMMENT 'Stream extras JSON: segments/approval' AFTER `files`;
