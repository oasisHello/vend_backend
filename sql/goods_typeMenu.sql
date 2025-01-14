-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product type table', '2084', '1', 'goods_type', 'manage/goods_type/index', 1, 0, 'C', '0', '0', 'manage:goods_type:list', '#', 'admin', sysdate(), '', null, 'Product type table菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product type table查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'manage:goods_type:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product type table新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'manage:goods_type:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product type table修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'manage:goods_type:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product type table删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'manage:goods_type:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('Product type table导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'manage:goods_type:export',       '#', 'admin', sysdate(), '', null, '');