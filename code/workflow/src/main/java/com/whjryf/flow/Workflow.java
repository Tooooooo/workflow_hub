package com.whjryf.flow;

import com.whjryf.common.version.Version;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/14
 */
@Getter @Setter
public class Workflow {

    private Integer id;
    private String flowName;
    /**
     * 标识流程定义的编码，使多个流程对象在逻辑上的具有同一性(例如同一个流程对象有多个版本）.
     * 如用户不填写，自动取flowName汉字全拼.
     */
    private String flowCode;
    /**
     * 发布状态. 当流程被编辑(多次编辑)后自动转为未发布. 手动发布后状态转为'已发布'且自动升级版本号.
     */
    private Boolean published;
    /**
     * 因动态表单未到位，暂时对应到整型ID。部署流程时要顺着表单定义复制表单json.
     */
    private Integer form;
    /**
     * 对应 activiti 的 act_re_procdef 表中的 ID_ 字段.
     */
    private String processDefinitionId;
    private Map<String,FlowTask> tasks;
    private WorkflowType type;
    private Version version;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdate;
    private String creator;

}
