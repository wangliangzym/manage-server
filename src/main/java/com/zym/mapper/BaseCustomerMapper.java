package com.zym.mapper;

import com.zym.entity.BaseCustomer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BaseCustomerMapper extends Mapper<BaseCustomer> {
    /**
     * 查询列表
     * @param baseCustomer
     * @return
     */
    List<BaseCustomer> getList(BaseCustomer baseCustomer);
}
