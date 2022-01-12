package com.jryfzx.lowcode.form.dictionary;

import com.jryfzx.base.CodeBasedEnum;
import lombok.Getter;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/10
 */
@Getter
public enum DictionaryType implements CodeBasedEnum {

    enumeration(1,"枚举类型"),
    dbTable(2,"数据表类型"),
    buildIn(3,"固定类型");

    private String show;
    private Integer code;


    DictionaryType(Integer code,String show) {
        this.code = code;
        this.show = show;
    }

    public static DictionaryType of(Integer code) {
        switch (code) {
            case 1:
                return enumeration;
            case 2:
                return dbTable;
            case 3:
                return buildIn;
            default:
                throw new IllegalArgumentException("未知的字典类型: " + code);

        }
    }
}
