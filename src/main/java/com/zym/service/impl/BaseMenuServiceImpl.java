package com.zym.service.impl;

import com.zym.VO.BaseMenuVO;
import com.zym.common.Fn;
import com.zym.entity.BaseMenu;
import com.zym.enums.FlagEnum;
import com.zym.enums.MenuLevelEnum;
import com.zym.mapper.BaseMenuMapper;
import com.zym.service.IBaseMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName : BaseMenuServiceImpl
 * @Description :
 * @Author : Wang Liang
 * @Date: 2021-07-14 10:20
 */
@Service
@Slf4j
public class BaseMenuServiceImpl implements IBaseMenuService {

    @Resource
    private BaseMenuMapper baseMenuMapper;

    /**
     *
     * @param id 主键id
     * @return BaseMenu
     */
    @Override
    public BaseMenu getById(Integer id) {
        return baseMenuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有有效的菜单栏
     * @return
     */
    @Override
    public List<BaseMenuVO> getMenuList() {
        Example example = new Example(BaseMenu.class);
        example.createCriteria().andEqualTo(Fn.getName(BaseMenu::getDelFlag), FlagEnum.NO.getcode());
        example.orderBy(Fn.getName(BaseMenu::getMenuOrder)).asc();
        List<BaseMenu> menuList = baseMenuMapper.selectByExample(example);
        log.info("查询的信息为---> {}", menuList);
        //转换为vo封装
        List<BaseMenuVO> voList = new ArrayList<>();
        menuList.forEach(k -> {
            BaseMenuVO baseMenuVO = new BaseMenuVO();
            BeanUtils.copyProperties(k, baseMenuVO);
            voList.add(baseMenuVO);
        });
        //获取所有一级菜单
        List<BaseMenuVO> oneLevelMenu
                = voList.stream()
                .filter(k -> MenuLevelEnum.ONE.getcode().equals(k.getLevel()))
                .collect(Collectors.toList());
        //获取所有二级菜单，并根据所属父级菜单分组
        Map<Integer, List<BaseMenuVO>> twoLevelMap = voList.stream()
                .filter(k -> MenuLevelEnum.TWO.getcode().equals(k.getLevel()))
                .collect(Collectors.groupingBy(BaseMenuVO::getParentId));
        //结果构造
        List<BaseMenuVO> finalMenu = new ArrayList<>();
        oneLevelMenu.forEach(k -> {
            BaseMenuVO menuVO = new BaseMenuVO();
            BeanUtils.copyProperties(k, menuVO);
            if(!CollectionUtils.isEmpty(twoLevelMap.get(k.getId()))){
                menuVO.setChildList(twoLevelMap.get(k.getId()));
            }
            finalMenu.add(menuVO);
        });
        return finalMenu;

    }
}
