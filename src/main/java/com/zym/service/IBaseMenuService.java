package com.zym.service;

import com.zym.VO.BaseMenuVO;
import com.zym.entity.BaseMenu;

import java.util.List;

public interface IBaseMenuService {
    /**
     * 通过id查询
     * @param id
     * @return
     */
    BaseMenu getById(Integer id);

    /**
     * 获取所有的菜单列表
     * @return
     */
    List<BaseMenuVO> getMenuList();
}
