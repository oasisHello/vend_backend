-- Location Module


-- Region Table
Drop table if exists region;
CREATE TABLE region (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    remark TEXT,
    created_by VARCHAR(255),
    modified_by VARCHAR(255)
);


-- Vendor Table
Drop table if EXISTS vendor;
CREATE TABLE  vendor (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contactor VARCHAR(255),
    phone VARCHAR(50),
    ratio DECIMAL(10, 2),
    account VARCHAR(255),
    password VARCHAR(255),
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    remark TEXT,
    created_by VARCHAR(255),
    modified_by VARCHAR(255)
);

-- Operator Table
DROP TABLE if EXISTS operator;
CREATE TABLE operator (
    unique_id INT PRIMARY KEY,
    name VARCHAR(255),
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    remark TEXT,
    created_by VARCHAR(255),
    modified_by VARCHAR(255)
);

-- Location Table
CREATE TABLE location (
    id INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    business_area VARCHAR(255) NULL,
    region_id INT,
    vendor_id INT,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    remark TEXT,
    created_by VARCHAR(255),
    modified_by VARCHAR(255),
    FOREIGN KEY (region_id) REFERENCES region(id),
    FOREIGN KEY (vendor_id) REFERENCES vendor(id)
);

-- EMP Module

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


ALTER TABLE tb_emp
ADD CONSTRAINT fk_region_id FOREIGN KEY (region_id) REFERENCES region(id),
ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES tb_role(role_id);

INSERT INTO tb_role (role_id, role_code, role_name)
VALUES
(1, 'ADMIN', 'Administrator'),     -- Admin Role
(2, 'USER', 'Regular User'),       -- Regular User Role
(3, 'GUEST', 'Guest User');        -- Guest Role

-- VENDING MACHINE MENU
DROP TABLE IF EXISTS aisle;
DROP TABLE IF EXISTS vending_machine;
DROP TABLE IF EXISTS vm_type;
CREATE TABLE vm_type (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Type ID',
    name VARCHAR(50) NOT NULL COMMENT 'Type Name',
    code VARCHAR(20) COMMENT 'Code',
    image VARCHAR(255) COMMENT 'Image URL',
    row_count INT COMMENT 'Number of Rows',
    col_count INT COMMENT 'Number of Columns',
    aisle_max_capacity INT COMMENT 'Maximum Capacity per Aisle'
) COMMENT = 'Vending Machine Types';

CREATE TABLE vending_machine (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'Machine ID',
    inner_code VARCHAR(15) NOT NULL COMMENT 'Inner Code',
    aisle_max_capacity INT COMMENT 'Max Capacity',
    location_id INT COMMENT 'Location ID',
    address VARCHAR(100) COMMENT 'Address',
    last_supply_time DATETIME COMMENT 'Last Supply Time',
    business_area INT COMMENT 'Business Area',
    region_id INT COMMENT 'Region ID',
    vendor_id INT COMMENT 'Vendor ID',
    vm_type_id INT COMMENT 'Type ID',
    vm_status VARCHAR(100) COMMENT 'Machine Status',
    running_status VARCHAR(100) COMMENT 'Running Status',
    longitude DOUBLE COMMENT 'Longitude',
    latitude DOUBLE COMMENT 'Latitude',
    client_id BIGINT COMMENT 'Client ID',
    policy_id BIGINT COMMENT 'Policy ID',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Created Time',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated Time',
    FOREIGN KEY (location_id) REFERENCES location(id),
    FOREIGN KEY (vm_type_id) REFERENCES vm_type(id)
) COMMENT = 'Vending Machine Information';

CREATE TABLE aisle (
    id BIGINT PRIMARY KEY COMMENT 'Channel ID',
    code VARCHAR(10) NOT NULL COMMENT 'aisle Code',
    sku_id BIGINT COMMENT 'SKU ID',
    vm_id BIGINT COMMENT 'Machine ID',
    inner_code VARCHAR(15) COMMENT 'Inner Code',
    max_capacity INT COMMENT 'Max Capacity',
    current_capacity INT COMMENT 'Current Capacity',
    last_supply_time DATETIME COMMENT 'Last Supply Time',
    create_time DATETIME COMMENT 'Created Time',
    update_time DATETIME COMMENT 'Updated Time',
    FOREIGN KEY (vm_id) REFERENCES vending_machine(id)
) COMMENT = 'Aisle Information';

ALTER TABLE vending_machine 
MODIFY COLUMN vm_status int COMMENT 'Machine Status';

ALTER TABLE aisle
MODIFY COLUMN id BIGINT	 AUTO_INCREMENT COMMENT	"Aisle ID";

ALTER TABLE aisle
MODIFY COLUMN sku_id BIGINT DEFAULT 0 COMMENT 'SKU ID';

-- Ensure aisle is deleted when the associated machine is deleted.
ALTER TABLE aisle
DROP FOREIGN KEY aisle_ibfk_1;

ALTER TABLE aisle
ADD CONSTRAINT fk_vm_id FOREIGN KEY (vm_id) REFERENCES vending_machine(id) 
ON DELETE CASCADE 
ON UPDATE CASCADE;

SET FOREIGN_KEY_CHECKS = 0; -- remove the foreign key check temporary　一時的に外部キーのチェックを無効にする
ALTER TABLE region 
MODIFY COLUMN id INT AUTO_INCREMENT;
SET FOREIGN_KEY_CHECKS = 1;-- resume the foreign key check 　外部キーのチェックを再開する


-- list location and its vm numbers
SELECT 
    l.id,
    l.name,
    l.address,
    l.business_area,
    l.region_id,
    l.vendor_id,
    l.created_time,
    l.modified_time,
    l.remark,
    l.created_by,
    l.modified_by,
    COUNT(vm.id) AS vm_count,
    r.`name` AS region_name,
    v.`name` AS vendor_name
FROM 
    location l
LEFT JOIN 
    vending_machine vm ON l.id = vm.location_id
LEFT JOIN 
		region r ON l.region_id = r.id
LEFT JOIN
		vendor v ON l.vendor_id= v.id
GROUP BY 
    l.id;


-- region query
SELECT * FROM region WHERE id =1;
-- shu_id -> good_id
ALTER TABLE aisle 
CHANGE COLUMN sku_id good_id BIGINT;

-- Product Type Table (good_type)
CREATE TABLE good_type (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Product type ID',
    name VARCHAR(50) NOT NULL COMMENT 'Name',
    code VARCHAR(20) NOT NULL COMMENT 'Code',
    parent_id INT DEFAULT NULL COMMENT 'Parent ID',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated date'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Product type table';

-- Product Table (good)
CREATE TABLE good (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Product ID',
    name VARCHAR(100) NOT NULL COMMENT 'Name',
    image VARCHAR(500) COMMENT 'Image URL',
    brand_name VARCHAR(50) COMMENT 'Brand name',
    unit VARCHAR(20) COMMENT 'Unit',
    price DECIMAL(10,2) NOT NULL COMMENT 'Price',
    good_type_id INT NOT NULL COMMENT 'Product type ID',
    is_discount TINYINT(1) DEFAULT 0 COMMENT 'Discount flag',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated date',
    CONSTRAINT fk_good_good_type FOREIGN KEY (good_type_id) REFERENCES good_type(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Product table';



-- vendor query
SELECT * FROM vendor WHERE id =1;

-- set a default value for last_supply_time
ALTER TABLE vending_machine
MODIFY COLUMN last_supply_time DATETIME DEFAULT '2025-01-01 00:00:00';

-- create policy table 
CREATE TABLE policy (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Policy ID',
    name VARCHAR(100) NOT NULL COMMENT 'Policy Name',
    code VARCHAR(50) NOT NULL COMMENT 'Policy Code',
    discount DECIMAL(5,2) COMMENT 'Discount Rate',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Created Time',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Updated Time'
) COMMENT='Policy Information Table';