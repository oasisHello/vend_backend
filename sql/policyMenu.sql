-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Policy Information', '2082', '1', 'policy', 'manage/policy/index', 1, 0, 'C', '0', '0', 'manage:policy:list', '#', 'admin', sysdate(), '', null, 'Policy Information菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Policy Information查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'manage:policy:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Policy Information新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'manage:policy:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Policy Information修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'manage:policy:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Policy Information删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'manage:policy:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Policy Information导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'manage:policy:export',       '#', 'admin', sysdate(), '', null, '');