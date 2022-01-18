package com.whjryf.flow;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/16
 */
@Getter @Setter
public class FlowTask {

    private Integer id;
    private String taskId;
    private String taskName;
    private Integer workflowId;
    private FormPresentCustom formPresentCustom;

}
