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

-- Location Table
Drop table if exists location;
CREATE TABLE location (
    id INT PRIMARY KEY,
    business_area VARCHAR(255) NOT NULL,
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

-- Vendor Table
CREATE TABLE vendor (
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
CREATE TABLE operator (
    unique_id INT PRIMARY KEY,
    name VARCHAR(255),
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    remark TEXT,
    created_by VARCHAR(255),
    modified_by VARCHAR(255)
);

--- 
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

-- Insert mock data into location table
INSERT INTO location (id, business_area, region_id, vendor_id, created_time, modified_time, remark, created_by, modified_by)
VALUES
(1, 'Shinjuku', 1, 1, '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'Business district', 'admin', 'admin'),
(2, 'Shibuya', 1, 2, '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'Shopping area', 'admin', 'admin'),
(3, 'Harajuku', 1, 3, '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'Fashion hub', 'admin', 'admin');

-- Insert mock data into operator table
INSERT INTO operator (unique_id, name, created_time, modified_time, remark, created_by, modified_by)
VALUES
(1, 'Operator 1', '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'First operator', 'admin', 'admin'),
(2, 'Operator 2', '2024-12-01 10:00:00', '2024-12-01 10:00:00', 'Second operator', 'admin', 'admin');



-- region customzation
SELECT r.id AS num,
       r.name AS region_name,
       COUNT(l.id) AS location_count
FROM region r
LEFT JOIN LOCATION l ON r.id = l.region_id
GROUP BY r.id
ORDER BY r.id;

SELECT * FROM location
