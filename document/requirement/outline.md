# 需求概要

本文档仅给出需求提纲，各位开发同学需在相应的共创文档中细化，最后整理出具备目标指导效果的简要需求说明。

## 动态表单

按照特定的业务需求和数据架构,在项目运行时通过管理界面配置出的一种结构化数据。该结构由对应的程序解析成为需要按一定规则填写的表单。

表单是用户向业务逻辑提交数据的载体。系统的业务逻辑依据填写在表单上的数据做相对应的处理，并且信息会按照其对应的数据架构保存到数据库。

以下是动态表单要实现的功能框架：

### 表单列表。依据特定**顺序**列举表单**关键信息**。提供操作入口。

### 创建新表单。拖拽组织表单形式，针对不同输入项设置其业务属性。

### 编辑已有表单。拖拽组织表单形式，针对不同输入项改变其业务属性。

### 删除已有表单

### 发布表单


## 工作流程设计

工作流是将一组**任务**组织起来以实现某种业务目标的过程。工作流定义了任务的触发**顺序**和触发**条件**，每个任务可以由一个或多个软件系统完成，也可以由一个或一组人完成，还可以由一个或多个人与软件系统协作完成。

工作流程设计是通过绘制**BPMN图形**，定义为完成某个工作目标所需的不同工作任务，以及如何通过这些工作任务来实现工作目标的过程。

### 流程分类管理。
流程分类是对流程的归类，

### 流程列表。依据特定**顺序**列举已有流程**关键信息**。提供操作入口。

### 创建流程。按照BPMN标准描绘流程图，并在其基础上增加业务功能

### 编辑已有流程。按照BPMN标准编辑流程图，并在其基础上修改业务功能

### 发布流程


## 工作流程管理

读取工作流程的定义，将其付诸实施。在实施过程中要根据实施发生时的各种因素做出对应的处理。这些因素可能包括：实施人、实施时间、实施当时系统所处的状态、外部干涉等

### 流程实例管理。查询并处理系统中已发起的流程。

### 工单管理

### 工作任务办理(待办/已办/历史)


## 非功能性需求

### 与宿主系统的整合方式

### 完成流程定制的所需的技术水平

### 定制流程所需的工作量

### 与其它系统模块的耦合程度

### 集成操作日志记录组件
