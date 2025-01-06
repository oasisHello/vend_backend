CREATE TABLE tb_role (
    role_id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key for role',
    role_code VARCHAR(50) NOT NULL COMMENT 'Role code',
    role_name VARCHAR(50) NOT NULL COMMENT 'Role name'
) COMMENT='Role table';

CREATE TABLE tb_emp (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key for employee',
    user_name VARCHAR(50) NOT NULL COMMENT 'Employee name',
    region_id INT NOT NULL COMMENT 'Associated region ID',
    region_name VARCHAR(50) COMMENT 'Region name',
    role_id INT NOT NULL COMMENT 'Associated role ID',
    role_code VARCHAR(10) COMMENT 'Role code',
    role_name VARCHAR(50) COMMENT 'Role name',
    mobile VARCHAR(15) COMMENT 'Mobile phone number',
    image VARCHAR(500) COMMENT 'Profile picture',
    status TINYINT(1) DEFAULT 1 COMMENT 'Status (1 active, 0 inactive)',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation time',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Last updated time'
) COMMENT='Employee table';

CREATE TABLE tb_region (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key for region',
    region_name VARCHAR(255) NOT NULL COMMENT 'Region name',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation time',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Last updated time',
    create_by VARCHAR(64) COMMENT 'Created by',
    update_by VARCHAR(64) COMMENT 'Updated by',
    remark TEXT COMMENT 'Remarks'
) COMMENT='Region table';

ALTER TABLE tb_emp
ADD CONSTRAINT fk_region_id FOREIGN KEY (region_id) REFERENCES tb_region(id),
ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES tb_role(role_id);

INSERT INTO tb_role (role_id, role_code, role_name)
VALUES
(1, 'ADMIN', 'Administrator'),     -- Admin Role
(2, 'USER', 'Regular User'),       -- Regular User Role
(3, 'GUEST', 'Guest User');        -- Guest Role

INSERT INTO tb_region (id, region_name)
VALUES
(1, 'North America'),   -- North America
(2, 'Europe'),          -- Europe
(3, 'Asia'),            -- Asia
(4, 'Africa'),          -- Africa
(5, 'South America');   -- South America

DROP TABLE IF EXISTS tb_aisle;
DROP TABLE IF EXISTS tb_vending_machine;
DROP TABLE IF EXISTS tb_vm_type;
DROP TABLE IF EXISTS tb_node;

CREATE TABLE tb_node (
    id INT PRIMARY KEY COMMENT 'Node ID',
    node_name VARCHAR(255) NOT NULL COMMENT 'Node Name',
    address VARCHAR(255) COMMENT 'Address',
    business_type INT COMMENT 'Business Type',
    region_id INT COMMENT 'Region ID',
    partner_id INT COMMENT 'Partner ID',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Created Time',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated Time',
    create_by VARCHAR(64) COMMENT 'Created By',
    update_by VARCHAR(64) COMMENT 'Updated By',
    remark TEXT COMMENT 'Remark'
) COMMENT = 'Node Information';

CREATE TABLE tb_vm_type (
    id INT PRIMARY KEY COMMENT 'Type ID',
    name VARCHAR(15) NOT NULL COMMENT 'Type Name',
    model VARCHAR(20) COMMENT 'Model',
    image VARCHAR(50) COMMENT 'Image',
    vm_row INT COMMENT 'Rows',
    vm_col INT COMMENT 'Columns',
    aisle_max_capacity INT COMMENT 'Max Capacity'
) COMMENT = 'Vending Machine Types';

CREATE TABLE tb_vending_machine (
    id BIGINT PRIMARY KEY COMMENT 'Machine ID',
    inner_code VARCHAR(15) NOT NULL COMMENT 'Inner Code',
    aisle_max_capacity INT COMMENT 'Max Capacity',
    node_id INT COMMENT 'Node ID',
    addr VARCHAR(100) COMMENT 'Address',
    last_supply_time DATETIME COMMENT 'Last Supply Time',
    business_type INT COMMENT 'Business Type',
    region_id INT COMMENT 'Region ID',
    partner_id INT COMMENT 'Partner ID',
    vm_type_id INT COMMENT 'Type ID',
    vm_status VARCHAR(100) COMMENT 'Machine Status',
    running_status VARCHAR(100) COMMENT 'Running Status',
    longitude DOUBLE COMMENT 'Longitude',
    latitude DOUBLE COMMENT 'Latitude',
    client_id BIGINT COMMENT 'Client ID',
    policy_id BIGINT COMMENT 'Policy ID',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Created Time',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated Time',
    FOREIGN KEY (node_id) REFERENCES tb_node(id),
    FOREIGN KEY (vm_type_id) REFERENCES tb_vm_type(id)
) COMMENT = 'Vending Machine Information';

CREATE TABLE tb_aisle (
    id BIGINT PRIMARY KEY COMMENT 'Channel ID',
    aisle_code VARCHAR(10) NOT NULL COMMENT 'Channel Code',
    sku_id BIGINT COMMENT 'SKU ID',
    vm_id BIGINT COMMENT 'Machine ID',
    inner_code VARCHAR(15) COMMENT 'Inner Code',
    max_capacity INT COMMENT 'Max Capacity',
    current_capacity INT COMMENT 'Current Capacity',
    last_supply_time DATETIME COMMENT 'Last Supply Time',
    create_time DATETIME COMMENT 'Created Time',
    update_time DATETIME COMMENT 'Updated Time',
    FOREIGN KEY (vm_id) REFERENCES tb_vending_machine(id)
) COMMENT = 'Channel Information';

ALTER TABLE tb_vm_type modify COLUMN image VARCHAR(255) COMMENT 'Image';
ALTER TABLE tb_vm_type MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE tb_vm_type modify COLUMN name VARCHAR(50) NOT NULL COMMENT 'Name'