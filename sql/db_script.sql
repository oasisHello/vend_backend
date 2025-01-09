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


-- 
-- Insert mock data into region table
INSERT INTO region (id, name, created_time, modified_time, remark, created_by, modified_by)
VALUES
(1, 'Tokyo', '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'Capital city of Japan', 'admin', 'admin');

-- Insert mock data into vendor table
INSERT INTO vendor (id, name, contactor, phone, ratio, account, password, created_time, modified_time, remark, created_by, modified_by)
VALUES
(1, 'Vendor A', 'John Doe', '123-456-7890', 10.00, 'vendorA', 'password123', '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'Primary vendor', 'admin', 'admin'),
(2, 'Vendor B', 'Jane Smith', '234-567-8901', 15.00, 'vendorB', 'password456', '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'Secondary vendor', 'admin', 'admin'),
(3, 'Vendor C', 'Alice Johnson', '345-678-9012', 20.00, 'vendorC', 'password789', '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'Tertiary vendor', 'admin', 'admin');


-- Insert mock data into operator table
INSERT INTO operator (unique_id, name, created_time, modified_time, remark, created_by, modified_by)
VALUES
(1, 'Operator 1', '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'First operator', 'admin', 'admin'),
(2, 'Operator 2', '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'Second operator', 'admin', 'admin');

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









