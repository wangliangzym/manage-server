package com.zym.service;

import com.github.pagehelper.PageInfo;
import com.zym.entity.BaseCustomer;

public interface IBaseCustomerService {
    PageInfo getUserList(BaseCustomer baseCustomer);

    Boolean insertBySelect(BaseCustomer baseCustomer);

    BaseCustomer getById(Integer id);

    Boolean updateBySelected(BaseCustomer baseCustomer);

    Boolean deleteById(Integer id);
}
