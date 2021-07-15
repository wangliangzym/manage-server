package com.zym.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zym.entity.BaseCustomer;
import com.zym.mapper.BaseCustomerMapper;
import com.zym.service.IBaseCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName : BaseCustomerServiceImpl
 * @Description : 客户
 * @Author : Wang Liang
 * @Date: 2021-07-15 10:59
 */
@Service
@Slf4j
public class BaseCustomerServiceImpl implements IBaseCustomerService {
    @Resource
    private BaseCustomerMapper customerMapper;

    /**
     * 查询用户列表
     * @param baseCustomer
     * @return
     */
    @Override
    public PageInfo<List<BaseCustomer>> getUserList(BaseCustomer baseCustomer) {
        log.info("客户列表查询参数---> {}",baseCustomer);
        PageHelper.startPage(baseCustomer.getPageNum(),baseCustomer.getPageSize());
        List<BaseCustomer> customerMapperList = customerMapper.getList(baseCustomer);
        return new PageInfo(customerMapperList);
    }

    /**
     * 添加用户
     * @param baseCustomer
     * @return
     */
    @Override
    public Boolean insertBySelect(BaseCustomer baseCustomer) {
        baseCustomer.setCreateTime(new Date());
        baseCustomer.setUpdateTime(new Date());
        log.info("新增用户信息---> {}",baseCustomer);
        return customerMapper.insertSelective(baseCustomer) > 0;
    }

    /**
     * 通过主键查询客户信息
     * @param id 主键
     * @return 客户信息
     */
    @Override
    public BaseCustomer getById(Integer id) {
        log.info("查询用户信息id---> {}",id);
        return customerMapper.selectByPrimaryKey(id);
    }
}
