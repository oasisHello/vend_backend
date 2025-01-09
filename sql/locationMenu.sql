-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('location', '2000', '1', 'location', 'manage/location/index', 1, 0, 'C', '0', '0', 'manage:location:list', '#', 'admin', sysdate(), '', null, 'location菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('location查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'manage:location:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('location新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'manage:location:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('location修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'manage:location:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('location删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'manage:location:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('location导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'manage:location:export',       '#', 'admin', sysdate(), '', null, '');