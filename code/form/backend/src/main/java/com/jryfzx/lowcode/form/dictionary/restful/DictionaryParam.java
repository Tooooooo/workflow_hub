package com.jryfzx.lowcode.form.dictionary.restful;

import com.jryfzx.lowcode.form.dictionary.DictionaryType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/10
 */
@Getter @Setter
public class DictionaryParam {
    private Integer id;
    @Schema(example = "buildIn", description = "创建或被修改的数据字典的类型，备选值为 dbTable(数据表)/enumeration(枚举)/buildIn(内置)",
            allowableValues = {"dbTable","enumeration","buildIn"})
    private DictionaryType type;
    @Schema(example = "备选用户",description = "数据字典名称")
    private String dictionaryName;
    @Schema(example = "10", description = "内置字典的备选值，仅在创建或修改内置字典时有效。备选项在技术规范中描述。")
    private Integer buildInCode;
    @Schema(example = "select username as show_name,user_id as selected_value from user",
            description = "数据表字典的查询语句，仅在创建或修改数据表字典时有效。编写约定在技术规范中描述。")
    private String sql;
    @Schema(description = "枚举字典的枚举值，仅在创建或修改枚举字典时有效。")
    private Map<Integer,String> dictionaryItems;
}
