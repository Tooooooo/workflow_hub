package com.jryfzx.lowcode.meta.restful;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/13
 */
@Getter @Setter
public class MetaInfo {

    @Schema(example = "app_user",description = "表或字段的名")
    private String entityName;

    @Schema(example = "用户姓名",description = "表或字段的注释")
    private String comment = "--";

}
