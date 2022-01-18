package com.whjryf.common.version;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * 版本记录对象。
 * 需要应用版本的对象，需要具备唯一性的编码属性(code)来标识某个逻辑上的实体（多个版本对应多条记录但都是同一个逻辑实体）.
 * 对应逻辑对象标识编码(code)在创建后就不可编辑.
 *
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/14
 */
@Getter @Setter
public class Version {

    private Integer id;
    private String versionName;

    public String getVersionName() {
        if (StringUtils.isBlank(this.versionName)) {
            return "V"+this.versionNumber;
        }
        return this.versionName;
    }

    /**
     * 版本注释.
     */
    private String notes;

    /*
     * 对应逻辑对象标识编码. 该编码在创建后就不可编辑.
     */
//    private String code;

    /**
     * 版本序号，为自然数递增.
     */
    private Integer versionNumber;
    /**
     * 启用/禁用状态.禁用状态的对象在业务流程中应不可见，不可操作.
     */
    private Boolean enabled;
    /**
     * 是否为当前正在使用的版本.其含义为新建一个新数据时按此版本的定义.
     * code 相同的多个版本中只允许一个为 current.
     */
    private Boolean current;
    private LocalDateTime commitTime;

}
