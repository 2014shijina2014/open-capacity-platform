此项目源码采用spring boot开发，使用spring security进行权限控制。前后端基于json进行交互，接口通过JWT无状态token进行权限校验，使用redis或者数据库进行token缓存，接口完全采用Restful的风格，实现按钮级权限控制，做为此能力开放平台的页面管理框架。


技术  
jdk1.8 + spring boot1.5.9 + spring security4 + mysql + mybatis + redis + layui + json + quartz + datatables。

该源码是标准的maven项目

![](https://i.imgur.com/UaAgHp3.png)

spring security 全注解式的权限管理  
动态配置权限，角色和资源，权限控制到按钮粒度   
采用JWT无状态token进行权限校验，禁用session，未登录返回401，权限不足返回403

内置功能：

用户管理：用户查询、添加用户、修改用户、给用户分配角色  
菜单管理：菜单列表、添加菜单、修改菜单、删除菜单、权限配置、菜单图标设置、菜单排序  
角色管理：角色查询、添加角色、修改角色、删除角色  
代码生成：根据表生成bean、controller、dao、Mapper.xml、查询列表页、分页、新增页、修改页  
job集群：创建job、取消job、查询job、下拉搜索spring bean  
数据源监控：druid  
接口swagger文档  
日志查询  
邮件管理：发送邮件、搜索邮件  
文件管理：上传文件、文件列表、文件删除  
公告管理：公告未读提醒、发布公告、查询公告、公告阅读人列表  
excel下载：自定义sql导出excel、也可在页面展示sql结果数据  
字典管理：一些常量字典的维护  
个人信息修改  
修改密码  
头像修改  
注册中心  
配置中心  
应用中心  


