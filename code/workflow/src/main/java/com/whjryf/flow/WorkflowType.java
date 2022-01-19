package com.whjryf.flow;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/14
 */
@Getter @Setter
@TableName(value = "flow_category")
public class WorkflowType {

    @Schema(example = "1234",description = "主键id")
    @TableId(value = "category_id", type = IdType.AUTO)
    private Long id;

    @Schema(example = "1A2B111",description = "显示的主键id")
    @TableField(exist = false)
    private String workFlowTypeId;

    @Schema(example = "测试",description = "流程类型名称")
    @TableField(value = "name")
    private String typeName;
    /**
     * 流程类型编码，如用户不填写，自动取汉字全拼大写首字母.
     */
    @Schema(example = "test",description = "流程类型编码（如用户不填写，自动取汉字全拼大写首字母.）")
    @TableField(value = "code")
    private String code;

    @Schema(example = "2021-12-12 12:12:12",description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(example = "12345",description = "创建人ID")
    @TableField(value = "create_user_id")
    private String creator;

    @Schema(example = "2021-12-12 12:12:12",description = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Schema(example = "12345",description = "修改人ID")
    @TableField(value = "update_user_id")
    private String updater;

}
