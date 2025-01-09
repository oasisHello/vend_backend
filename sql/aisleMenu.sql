-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Aisle Information', '2013', '1', 'aisle', 'manage/aisle/index', 1, 0, 'C', '0', '0', 'manage:aisle:list', '#', 'admin', sysdate(), '', null, 'Aisle Information菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Aisle Information查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'manage:aisle:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Aisle Information新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'manage:aisle:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Aisle Information修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'manage:aisle:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Aisle Information删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'manage:aisle:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Aisle Information导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'manage:aisle:export',       '#', 'admin', sysdate(), '', null, '');