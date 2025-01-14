-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product table', '2084', '1', 'goods', 'manage/goods/index', 1, 0, 'C', '0', '0', 'manage:goods:list', '#', 'admin', sysdate(), '', null, 'Product table菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product table查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'manage:goods:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product table新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'manage:goods:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product table修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'manage:goods:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product table删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'manage:goods:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product table导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'manage:goods:export',       '#', 'admin', sysdate(), '', null, '');