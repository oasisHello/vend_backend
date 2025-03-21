DROP TABLE IF EXISTS QRTZ_FIRED_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_PAUSED_TRIGGER_GRPS;
DROP TABLE IF EXISTS QRTZ_SCHEDULER_STATE;
DROP TABLE IF EXISTS QRTZ_LOCKS;
DROP TABLE IF EXISTS QRTZ_SIMPLE_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_SIMPROP_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_CRON_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_BLOB_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_JOB_DETAILS;
DROP TABLE IF EXISTS QRTZ_CALENDARS;

-- ----------------------------
-- 1. Stores detailed information of each configured jobDetail
-- ----------------------------
CREATE TABLE QRTZ_JOB_DETAILS (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    job_name             VARCHAR(200)    NOT NULL            COMMENT 'Job Name',
    job_group            VARCHAR(200)    NOT NULL            COMMENT 'Job Group Name',
    description          VARCHAR(250)    NULL                COMMENT 'Description',
    job_class_name       VARCHAR(250)    NOT NULL            COMMENT 'Job Execution Class Name',
    is_durable           VARCHAR(1)      NOT NULL            COMMENT 'Whether Persistent',
    is_nonconcurrent     VARCHAR(1)      NOT NULL            COMMENT 'Whether Concurrent Execution is Allowed',
    is_update_data       VARCHAR(1)      NOT NULL            COMMENT 'Whether to Update Data',
    requests_recovery    VARCHAR(1)      NOT NULL            COMMENT 'Whether Recovery Execution is Accepted',
    job_data             BLOB            NULL                COMMENT 'Stores the Persistent Job Object',
    PRIMARY KEY (sched_name, job_name, job_group)
) ENGINE=InnoDB COMMENT = 'Job Detail Information Table';

-- ----------------------------
-- 2. Stores configured Trigger information
-- ----------------------------
CREATE TABLE QRTZ_TRIGGERS (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    trigger_name         VARCHAR(200)    NOT NULL            COMMENT 'Trigger Name',
    trigger_group        VARCHAR(200)    NOT NULL            COMMENT 'Trigger Group Name',
    job_name             VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_job_details.job_name',
    job_group            VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_job_details.job_group',
    description          VARCHAR(250)    NULL                COMMENT 'Description',
    next_fire_time       BIGINT(13)      NULL                COMMENT 'Next Trigger Time (milliseconds)',
    prev_fire_time       BIGINT(13)      NULL                COMMENT 'Previous Trigger Time (default -1 means no trigger)',
    priority             INTEGER         NULL                COMMENT 'Priority',
    trigger_state        VARCHAR(16)     NOT NULL            COMMENT 'Trigger State',
    trigger_type         VARCHAR(8)      NOT NULL            COMMENT 'Trigger Type',
    start_time           BIGINT(13)      NOT NULL            COMMENT 'Start Time',
    end_time            BIGINT(13)      NULL                COMMENT 'End Time',
    calendar_name        VARCHAR(200)    NULL                COMMENT 'Calendar Name',
    misfire_instr        SMALLINT(2)     NULL                COMMENT 'Misfire Policy',
    job_data             BLOB            NULL                COMMENT 'Stores the Persistent Job Object',
    PRIMARY KEY (sched_name, trigger_name, trigger_group),
    FOREIGN KEY (sched_name, job_name, job_group) REFERENCES QRTZ_JOB_DETAILS(sched_name, job_name, job_group)
) ENGINE=InnoDB COMMENT = 'Trigger Detail Information Table';

-- ----------------------------
-- 3. Stores simple Triggers including repeat count, interval, and triggered count
-- ----------------------------
CREATE TABLE QRTZ_SIMPLE_TRIGGERS (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    trigger_name         VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_triggers.trigger_name',
    trigger_group        VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_triggers.trigger_group',
    repeat_count         BIGINT(7)       NOT NULL            COMMENT 'Repeat Count',
    repeat_interval      BIGINT(12)      NOT NULL            COMMENT 'Repeat Interval Time',
    times_triggered      BIGINT(10)      NOT NULL            COMMENT 'Number of Times Triggered',
    PRIMARY KEY (sched_name, trigger_name, trigger_group),
    FOREIGN KEY (sched_name, trigger_name, trigger_group) REFERENCES QRTZ_TRIGGERS(sched_name, trigger_name, trigger_group)
) ENGINE=InnoDB COMMENT = 'Simple Trigger Information Table';

-- ----------------------------
-- 4. Stores Cron Triggers including Cron expression and timezone info
-- ----------------------------
CREATE TABLE QRTZ_CRON_TRIGGERS (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    trigger_name         VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_triggers.trigger_name',
    trigger_group        VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_triggers.trigger_group',
    cron_expression      VARCHAR(200)    NOT NULL            COMMENT 'Cron Expression',
    time_zone_id         VARCHAR(80)                         COMMENT 'Time Zone',
    PRIMARY KEY (sched_name, trigger_name, trigger_group),
    FOREIGN KEY (sched_name, trigger_name, trigger_group) REFERENCES QRTZ_TRIGGERS(sched_name, trigger_name, trigger_group)
) ENGINE=InnoDB COMMENT = 'Cron Trigger Table';

-- ----------------------------
-- 5. Stores Triggers as Blob type (for custom JDBC-created Triggers)
-- ----------------------------
CREATE TABLE QRTZ_BLOB_TRIGGERS (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    trigger_name         VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_triggers.trigger_name',
    trigger_group        VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_triggers.trigger_group',
    blob_data            BLOB            NULL                COMMENT 'Stores the Persistent Trigger Object',
    PRIMARY KEY (sched_name, trigger_name, trigger_group),
    FOREIGN KEY (sched_name, trigger_name, trigger_group) REFERENCES QRTZ_TRIGGERS(sched_name, trigger_name, trigger_group)
) ENGINE=InnoDB COMMENT = 'Blob Type Trigger Table';

-- ----------------------------
-- 6. Stores calendar information as Blob type, which defines a scheduling range
-- ----------------------------
CREATE TABLE QRTZ_CALENDARS (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    calendar_name        VARCHAR(200)    NOT NULL            COMMENT 'Calendar Name',
    calendar             BLOB            NOT NULL            COMMENT 'Stores the Persistent Calendar Object',
    PRIMARY KEY (sched_name, calendar_name)
) ENGINE=InnoDB COMMENT = 'Calendar Information Table';

-- ----------------------------
-- 7. Stores information of paused Trigger groups
-- ----------------------------
CREATE TABLE QRTZ_PAUSED_TRIGGER_GRPS (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    trigger_group        VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_triggers.trigger_group',
    PRIMARY KEY (sched_name, trigger_group)
) ENGINE=InnoDB COMMENT = 'Paused Trigger Table';

-- ----------------------------
-- 8. Stores state information of fired Triggers and related Job execution details
-- ----------------------------
CREATE TABLE QRTZ_FIRED_TRIGGERS (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    entry_id             VARCHAR(95)     NOT NULL            COMMENT 'Scheduler Instance ID',
    trigger_name         VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_triggers.trigger_name',
    trigger_group        VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to qrtz_triggers.trigger_group',
    instance_name        VARCHAR(200)    NOT NULL            COMMENT 'Scheduler Instance Name',
    fired_time           BIGINT(13)      NOT NULL            COMMENT 'Trigger Fire Time',
    sched_time           BIGINT(13)      NOT NULL            COMMENT 'Scheduled Time',
    priority             INTEGER         NOT NULL            COMMENT 'Priority',
    state                VARCHAR(16)     NOT NULL            COMMENT 'State',
    job_name             VARCHAR(200)    NULL                COMMENT 'Job Name',
    job_group            VARCHAR(200)    NULL                COMMENT 'Job Group Name',
    is_nonconcurrent     VARCHAR(1)      NULL                COMMENT 'Whether Concurrent Execution is Allowed',
    requests_recovery    VARCHAR(1)      NULL                COMMENT 'Whether Recovery Execution is Accepted',
    PRIMARY KEY (sched_name, entry_id)
) ENGINE=InnoDB COMMENT = 'Fired Trigger Table';

-- ----------------------------
-- 9. Stores minimal Scheduler state information, useful for cluster environments
-- ----------------------------
CREATE TABLE QRTZ_SCHEDULER_STATE (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    instance_name        VARCHAR(200)    NOT NULL            COMMENT 'Instance Name',
    last_checkin_time    BIGINT(13)      NOT NULL            COMMENT 'Last Check-in Time',
    checkin_interval     BIGINT(13)      NOT NULL            COMMENT 'Check-in Interval',
    PRIMARY KEY (sched_name, instance_name)
) ENGINE=InnoDB COMMENT = 'Scheduler State Table';

-- ----------------------------
-- 10. Stores information of pessimistic locks (in case pessimistic locks are used)
-- ----------------------------
CREATE TABLE QRTZ_LOCKS (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    lock_name            VARCHAR(40)     NOT NULL            COMMENT 'Pessimistic Lock Name',
    PRIMARY KEY (sched_name, lock_name)
) ENGINE=InnoDB COMMENT = 'Table to store pessimistic lock information';

-- ----------------------------
-- 11. Row lock table for implementing synchronization mechanism in Quartz cluster
-- ----------------------------
CREATE TABLE QRTZ_SIMPROP_TRIGGERS (
    sched_name           VARCHAR(120)    NOT NULL            COMMENT 'Scheduler Name',
    trigger_name         VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to trigger_name in qrtz_triggers table',
    trigger_group        VARCHAR(200)    NOT NULL            COMMENT 'Foreign Key to trigger_group in qrtz_triggers table',
    str_prop_1           VARCHAR(512)    NULL                COMMENT 'First String parameter of the trigger',
    str_prop_2           VARCHAR(512)    NULL                COMMENT 'Second String parameter of the trigger',
    str_prop_3           VARCHAR(512)    NULL                COMMENT 'Third String parameter of the trigger',
    int_prop_1           INT             NULL                COMMENT 'First Integer parameter of the trigger',
    int_prop_2           INT             NULL                COMMENT 'Second Integer parameter of the trigger',
    long_prop_1          BIGINT          NULL                COMMENT 'First Long parameter of the trigger',
    long_prop_2          BIGINT          NULL                COMMENT 'Second Long parameter of the trigger',
    dec_prop_1           NUMERIC(13,4)   NULL                COMMENT 'First Decimal parameter of the trigger',
    dec_prop_2           NUMERIC(13,4)   NULL                COMMENT 'Second Decimal parameter of the trigger',
    bool_prop_1          VARCHAR(1)      NULL                COMMENT 'First Boolean parameter of the trigger',
    bool_prop_2          VARCHAR(1)      NULL                COMMENT 'Second Boolean parameter of the trigger',
    PRIMARY KEY (sched_name, trigger_name, trigger_group),
    FOREIGN KEY (sched_name, trigger_name, trigger_group) REFERENCES QRTZ_TRIGGERS(sched_name, trigger_name, trigger_group)
) ENGINE=InnoDB COMMENT = 'Row Lock Table for Synchronization Mechanism in Quartz Cluster';

COMMIT;

