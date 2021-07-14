package com.zym.enums;

/**
 * 菜单栏等级枚举
 */
public enum MenuLevelEnum {

    ONE(1, "一级菜单"),
    TWO(2, "二级菜单"),

    ;
    //属性
    private Integer code;
    private String description;

    //构造方法
    MenuLevelEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getcode() {
        return code;
    }

    public void setcode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static MenuLevelEnum getByCode(Integer code){
        for (MenuLevelEnum menuLevelEnum : MenuLevelEnum.values()){
            if(code == menuLevelEnum.getcode()){
                return menuLevelEnum;
            }
        }
        return null;
    }
}
