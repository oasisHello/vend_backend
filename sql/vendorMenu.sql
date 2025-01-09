-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('vendor', '2000', '1', 'vendor', 'manage/vendor/index', 1, 0, 'C', '0', '0', 'manage:vendor:list', '#', 'admin', sysdate(), '', null, 'vendor菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('vendor查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'manage:vendor:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('vendor新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'manage:vendor:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('vendor修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'manage:vendor:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('vendor删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'manage:vendor:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('vendor导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'manage:vendor:export',       '#', 'admin', sysdate(), '', null, '');