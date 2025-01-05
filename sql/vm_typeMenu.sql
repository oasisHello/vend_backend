-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Types', '2013', '1', 'vm_type', 'manage/vm_type/index', 1, 0, 'C', '0', '0', 'manage:vm_type:list', '#', 'admin', sysdate(), '', null, 'Vending Machine Types菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Types查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'manage:vm_type:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Types新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'manage:vm_type:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Types修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'manage:vm_type:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Types删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'manage:vm_type:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Vending Machine Types导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'manage:vm_type:export',       '#', 'admin', sysdate(), '', null, '');