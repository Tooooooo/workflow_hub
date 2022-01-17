package com.jryfzx.lowcode.form.dictionary;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/10
 */
@Getter @Setter
public class DictionaryDVO {

    private Integer id;
    private DictionaryType type;
    private String sql;
    private String enumeration;
    private String buildInDictionaryKey;
    private LocalDateTime createTime;
    private String operator;

}
