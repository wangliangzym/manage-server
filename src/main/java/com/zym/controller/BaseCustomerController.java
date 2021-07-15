package com.zym.controller;

import com.zym.common.Result;
import com.zym.entity.BaseCustomer;
import com.zym.service.IBaseCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ClassName : BaseCustomerController
 * @Description :
 * @Author : Wang Liang
 * @Date: 2021-07-15 11:00
 */
@RequestMapping("/api/customer")
@Controller
public class BaseCustomerController {

    @Resource
    private IBaseCustomerService baseCustomerService;

    /**
     * 查询客户列表
     * @param baseCustomer
     * @return
     */
    @RequestMapping("/customerList")
    @ResponseBody
    public Result getList(BaseCustomer baseCustomer){
        return Result.ok(baseCustomerService.getUserList(baseCustomer));
    }

    /**
     * 添加客户信息
     * @param baseCustomer
     * @return
     */
    @RequestMapping("/addCustomer")
    @ResponseBody
    public Result addCustomer(@RequestBody BaseCustomer baseCustomer){
        return baseCustomerService.insertBySelect(baseCustomer) ?
                Result.ok("添加成功") : Result.error(500,"添加失败");
    }
}
