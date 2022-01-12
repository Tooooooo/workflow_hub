package com.jryfzx.lowcode.form.dictionary;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/10
 */
@Slf4j
public class DictionaryBuilder {

    Dictionary build(DictionaryDVO dvo){
        Dictionary dict = null;
        switch (dvo.getType()) {
            case enumeration:
                dict = buildEnumerationDictionary(dvo);
            case dbTable:
                dict = buildDbTableDictionary(dvo);
            case buildIn:
                dict = buildBuildInDictionary(dvo);
        }
        return dict;

    }

    /**
     * 依据 dvo 中保存的信息，构建"固定类型"的数据字典.
     * @param dvo 保存有所有字典构建信息的值对象.
     * @return 一个"固定类型"的Dictionary对象
     */
    protected Dictionary buildBuildInDictionary(DictionaryDVO dvo) {
        return null;
    }

    /**
     * 依据 dvo 中保存的信息，构建"固定类型"的数据字典.
     * @param dvo 保存有所有字典构建信息的值对象.
     * @return 一个"固定类型"的Dictionary对象
     */
    protected Dictionary buildDbTableDictionary(DictionaryDVO dvo) {
        return null;
    }

    /**
     * 依据 dvo 中保存的信息，构建"固定类型"的数据字典.
     * @param dvo 保存有所有字典构建信息的值对象.
     * @return 一个"固定类型"的Dictionary对象
     */
    protected Dictionary buildEnumerationDictionary(DictionaryDVO dvo) {
        return null;
    }


}
