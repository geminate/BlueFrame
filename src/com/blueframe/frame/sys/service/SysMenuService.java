package com.blueframe.frame.sys.service;

import org.springframework.stereotype.Service;

import com.blueframe.frame.base.service.TreeService;
import com.blueframe.frame.sys.dao.SysMenuDao;
import com.blueframe.frame.sys.model.SysMenu;

@Service
public class SysMenuService extends TreeService<SysMenuDao, SysMenu> {
}
