package com.zym.enums;

/**
 * Flag 枚举类
 */
public enum FlagEnum {

    NO(0, "否"),
    YES(1, "是"),

    ;
    //属性
    private Integer code;
    private String description;

    //构造方法
    FlagEnum(Integer code, String description) {
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

    public static FlagEnum getByCode(Integer code){
        for (FlagEnum flagEnum : FlagEnum.values()){
            if(code == flagEnum.getcode()){
                return flagEnum;
            }
        }
        return null;
    }
}
