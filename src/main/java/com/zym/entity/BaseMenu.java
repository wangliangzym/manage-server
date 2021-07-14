package com.zym.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "base_menu")
public class BaseMenu {

    /**
     * '主键'
     */
    @Id
    private Integer id;
    /**
     * '编码'
     */
    private String code;
    /**
     * '菜单名称'
     */
    private String name;
    /**
     * '跳转路径'
     */
    private String path;
    /**
     * '菜单级别'
     */
    private Integer level;
    /**
     * '父级菜单'
     */
    private Integer parentId;
    /**
     * '图标'
     */
    private String icon;
    /**
     * 顺序
     */
    private Integer menuOrder;
    /**
     * '创建时间'
     */
    private Date createTime;
    /**
     * '更新时间'
     */
    private Date updateTime;
    /**
     * '创建人'
     */
    private String createUser;
    /**
     * '修改人'
     */
    private String updateUser;
    /**
     * '删除标记'
     */
    private Integer delFlag;
}
