-- CRM 手机/电话改为国际自由格式：去掉中国号段校验后，字段略加长
ALTER TABLE `crm_customer`
  MODIFY COLUMN `mobile` varchar(32) NULL COMMENT 'Mobile number',
  MODIFY COLUMN `telephone` varchar(32) NULL COMMENT 'Phone';

ALTER TABLE `crm_contact`
  MODIFY COLUMN `mobile` varchar(32) NULL COMMENT 'Mobile number',
  MODIFY COLUMN `telephone` varchar(32) NULL COMMENT 'Phone';

ALTER TABLE `crm_clue`
  MODIFY COLUMN `mobile` varchar(32) NULL COMMENT 'Mobile number',
  MODIFY COLUMN `telephone` varchar(32) NULL COMMENT 'Phone';
