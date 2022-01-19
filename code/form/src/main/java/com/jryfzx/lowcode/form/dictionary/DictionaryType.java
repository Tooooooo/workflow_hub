package com.jryfzx.lowcode.form.dictionary;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/10
 */
@Getter
public enum DictionaryType {

    enumeration("枚举类型"),
    dbTable("数据表类型"),
    buildIn("固定类型");

    private String show;

    DictionaryType(String show) {
        this.show = show;
    }

    @JsonCreator
    public static DictionaryType of(String show) {
        for (DictionaryType dt : DictionaryType.values()) {
            if (dt.getShow().equals(show)) {
                return dt;
            }
        }
        return null;
    }
}
