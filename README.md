# springboot-guide
SpringBoot集成一些常用框架和工具


### springboot-common
工程中用到的一些通用类或者工具类等

### springboot-shiro
springboot集成shiro实现项目的权限控制

##### 主要功能：
 - 实现了登录、登出等接口。
 - 全局异常捕获，不用再担心抛出权限异常
 - 定义了接口的统一返回格式
 - 跨域问题
 - 注解形式的定义接口权限
 
 ### springboot-shiro-cluster
 springboot集成shiro实现集群项目的权限控制。由于shiro默认是将登录的用户信息（session）存在本地缓存中，所以不能实现集群的session共享
 
 ##### 主要功能：
  - springboot-shiro项目的全部功能
  - 基于redis实现集群权限控制
