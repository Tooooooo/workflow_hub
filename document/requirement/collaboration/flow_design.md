# 流程设计

> 依据需求概要，细化每项需求。为力求更细致的叙述，一个大的功能点需要拆分成多个小的功能点 要求但不局限于

- 涉及的用户角色
- 核心功能
  - 关联表单
  - 流程变量设置
  - 流程设计bpmn绘制
- 输入/输出内容
  - 流程分类
    - 流程分类列表查询
    ```http 
    /admin/flow/flowCategory/list
    ```
    - 流程分类添加
     ```http 
    /admin/flow/flowCategory/add
    ```
    - 流程分类修改
     ```http 
    /admin/flow/flowCategory/update
    ```
    - 流程分类删除
     ```http 
    /admin/flow/flowCategory/delete
    ```
  - 流程设计
    - 流程设计列表查询
    ```http 
    /admin/flow/flowEntry/list
    ```
    - 流程设计添加
    ```http
    /admin/flow/flowEntry/add
    ```
    - 流程设计修改
    ```http
    /admin/flow/flowEntry/update
    ```
    - 流程设计删除
    ```http
    /admin/flow/flowEntry/delete
    ```
- 异常处理逻辑
- 与其它功能的联系

在系统开发完成后，将依据以上的描述逐一评审完成度。
