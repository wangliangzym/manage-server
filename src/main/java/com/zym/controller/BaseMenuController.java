package com.zym.controller;

import com.zym.VO.BaseMenuVO;
import com.zym.common.Result;
import com.zym.entity.BaseMenu;
import com.zym.service.IBaseMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName : BaseMenuController
 * @Description :
 * @Author : Wang Liang
 * @Date: 2021-07-14 10:27
 */
@RequestMapping("/api/menu")
@Controller
public class BaseMenuController {

    @Resource
    private IBaseMenuService baseMenuService;

    @RequestMapping("/getById")
    @ResponseBody
    public Result<BaseMenu> getById(Integer id){
        return Result.ok(baseMenuService.getById(id));
    }

    /**
     * 获取所有菜单信息
     * @return
     */
    @RequestMapping("/getMenuList")
    @ResponseBody
    public Result<List<BaseMenuVO>> getMenuList(){
        return Result.ok(baseMenuService.getMenuList());
    }

}
