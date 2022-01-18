package com.whjryf.flow;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/14
 */
@Getter @Setter
public class WorkflowType {

    private Integer id;
    private String typeName;
    /**
     * 流程类型编码，如用户不填写，自动取汉字全拼大写首字母.
     */
    private String code;
    private LocalDateTime createTime;
    private String creator;

}
