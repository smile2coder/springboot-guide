# springboot-guide
SpringBoot集成一些常用框架和工具


### 1. springboot-common
工程中用到的一些通用类或者工具类等

### 2. springboot-shiro
springboot集成shiro实现项目的权限控制

##### 主要功能：
 - 实现了登录、登出等接口。
 - 注解形式的定义接口权限
 - 全局异常捕获，不用再担心抛出权限异常
 - 定义了接口的统一返回格式
 - 跨域问题
 
 ### 3. springboot-shiro-cluster
 springboot集成shiro实现集群项目的权限控制。由于shiro默认是将登录的用户信息（session）存在本地缓存中，所以不能实现集群的session共享。本项目实现基于redis的全局session共享
 
 ##### 主要功能：
  - springboot-shiro项目的全部功能
  - 基于redis实现集群权限控制

 ### 4. springboot-event
 参考：https://www.cnblogs.com/rickiyang/p/12001524.html
 
 springboot项目中事件的发布与监听示例，以实现业务流程的解耦合
 
 ##### 主要功能：
  - 主业务完成后，发布完成事件，其它业务端监听到事件后作出相应的操作
  - 监听的程序可以按照一定的顺序接收事件、筛选事件和源数据。`SmartApplicationListener`
  - 注解支持
  - 异步事件的支持。springboot 事件机制默认是同步阻塞的。如果 ApplicationEventPublisher 发布事件之后他会一直阻塞等待listener 响应，多个 listener 的情况下前面的没有执行完后面的一直被阻塞。