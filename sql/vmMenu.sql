-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Information', '2013', '1', 'vm', 'manage/vm/index', 1, 0, 'C', '0', '0', 'manage:vm:list', '#', 'admin', sysdate(), '', null, 'Vending Machine Information菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Information查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'manage:vm:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Information新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'manage:vm:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Information修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'manage:vm:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Information删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'manage:vm:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Information导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'manage:vm:export',       '#', 'admin', sysdate(), '', null, '');