package com.jryfzx.lowcode.form.dictionary.restful;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/10
 */
@Getter @Setter
public class DictionaryWVO {
    private Integer id;
    @Schema(description = "字典名称")
    private String showName;
    @Schema(description = "字典类型")
    private String type;
}
