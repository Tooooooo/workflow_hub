package com.jryfzx.lowcode.form.dictionary;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/10
 */
@Getter @Setter
public class Dictionary {

    private Integer id;
    private DictionaryType type;
    private String name;
    private Map<Integer,String> items;

}
