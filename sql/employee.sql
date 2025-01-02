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