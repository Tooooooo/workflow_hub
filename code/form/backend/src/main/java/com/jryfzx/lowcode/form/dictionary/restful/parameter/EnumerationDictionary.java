package com.jryfzx.lowcode.form.dictionary.restful.parameter;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/10
 */
@Getter @Setter
public class EnumerationDictionary extends DictionaryParam {
    private Map<Integer,String> dictionaryItems;
}
