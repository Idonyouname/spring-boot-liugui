### MyBatis-plus逻辑删除操作流程 
MyBatis-plus版本：3.x以上

**1.新增字段以及注解 表也需要该字段**

    @TableLogic
    private int isDelete;
    
**2.新增配置**

    mybatis-plus.global-config.banner=false
    mybatis-plus.global-config.db-config.logic-delete-value=1
    mybatis-plus.global-config.db-config.logic-not-delete-value=0


### MyBatis-plus分页 Page对象


##### 本项目启动方式：直接test跑 不提供web操作