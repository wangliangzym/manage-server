package com.zym.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @ClassName : BaseCustomer
 * @Description : 客户信息
 * @Author : Wang Liang
 * @Date: 2021-07-15 10:52
 */
@Data
@Table(name = "base_customer")
public class BaseCustomer {

    /**
     * 主键id
     */
    @Id
    private Integer id;
    /**
     * 用户姓名
     */
    private String customerName;
    /**
     * 电话
     */
    private String tel;
    /**
     * 用户地址
     */
    private String address;
    /**
     * 用户类型
     */
    private Integer customerType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 更新人
     */
    private String updateUser;
    /**
     * 删除标记
     */
    private Integer delFlag;
    @Transient
    private Integer pageNum;
    @Transient
    private Integer pageSize;
    @Transient
    private String query;
}
