# <H1 align="center">open-capacity-platform 微服务能力开发平台</H1 > 

<p align="center">
 <img src="https://img.shields.io/circleci/project/vuejs/vue/dev.svg" alt="Build Status">
  <img src="https://img.shields.io/badge/Spring%20Cloud-Edgware.SR3-blue.svg" alt="Coverage Status">
  <img src="https://img.shields.io/badge/Spring%20Boot-1.5.9-blue.svg" alt="Downloads">
  <img src="https://img.shields.io/npm/l/vue.svg" alt="License">
</p>

### 欢迎进群（群内领资料）

`一键加群`

<a target="_blank" href="https://jq.qq.com/?_wv=1027&k=5JSjd5D"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="open-capacity-platform交流" title="open-capacity-platform交流"></a>

![](https://i.imgur.com/kxpc628.png)



### 简介

​        简称ocp是基于layui+springcloud的企业级微服务框架(用户权限管理，配置中心管理，应用管理，....),其核心的设计目标是分离前后端，快速开发部署，学习简单，功能强大，提供快速接入核心接口能力，其目标是帮助企业搭建一套类似百度能力开放平台的框架。



### 基于OCP的企业微服务体验地址

http://127.0.0.1:8066/

用户名/密码：admin/admin



### 组织结构

open-capacity-platform

```
├    open-db-core  -- 数据库逻辑封装    
├    open-eureka-center    -- eureka服务注册发现套件   
├       ├── open-eureka-server   --服务注册中心[1111]    
├       └── open-eureka-client    --注册服务样例工程[7768]  
├    open-config-center   -- 配置中心   
├         ├──  apollo    -- 阿波罗配置中心  
├         ├       ├── apollo-adminservice      --[8090]    
├         ├       ├── apollo-assembly     
├         ├       ├── apollo-biz   
├         ├       ├── apollo-buildtools    
├         ├       ├── apollo-client    
├         ├       ├── apollo-common     
├         ├       ├── apollo-configservice     --[8080] 
├         ├       ├── apollo-core  
├         ├       └── apollo-demo  
├         └      apollo-gateway  -- 阿波罗整合网关样例工程[9000]  
├    open-oauth-center --oauth2套件   
├       ├── open-oauth-server   --oauth认证中心[8000]  
├       ├── open-oauth-client    --oauth资源服务器样例工程[8100]   
├       ├── open-capacity-client-two  --oauth资源服务器样例工程[8200]    
├       └── open-oauth-sso  --oauth sso样例工程[9997]  
├    open-api-gateway  -- 服务网关[9200]  
├    open-layui-web  --  基于jwt spring security的layui后台管理系统     
├    open-xxl-job  -- 分布式调度任务
├       ├── xxl-job-core  --核心库
├       ├── xxl-job-admin   --job管理器    
├       └── xxl-job-demo    --job执行器
├     open-monitor-center  -- 监控中心
├       ├── open-admin-server  -- spring boot admin server[9998]  
├       ├    cachecloud-open-parent  -- 搜狐redis云平台   
├       ├        ├── cachecloud-open-client    
├       ├        ├── cachecloud-open-common   
├       ├        └── cachecloud-open-web    
├       └─  open-zipkin-center   -- zipkin链路跟踪[9412]  
├               ├── open-zipkin-server-kafka   --zipkin链路跟踪服务端
└               └── open-zipkin-client-kafka    --zipkin链路跟踪客户端  
```



#### 开发工具:

- MySql: 数据库
- Tomcat: 应用服务器
- SVN|Git: 版本管理
- Nginx: 反向代理服务器
- IntelliJ IDEA/STS-3.8.0.RELEASE : 开发IDE/STS
- Navicat for MySQL: 数据库客户端

 

### 开发环境

JDK8+  

READIS 3.X  

MySQL 5.6 + 

MAVEN 3.3.9  




###   技术介绍 
![](https://i.imgur.com/29QKUkG.png)  
###   框架设计
![](https://i.imgur.com/vn03vIX.jpg)



##  ocp项目演示

![](http://img1.ph.126.net/WAraEeweVw2SyTUSG1dT6Q==/3887169428474612491.gif) 


## 阿波罗配置中心演示  
![](http://img2.ph.126.net/-cKtj6Wia_q6YiZKV-IOsQ==/295548725646480248.gif)


## oauth认证方式    
![](https://i.imgur.com/MUCa4x6.gif)
## oauth单点登录   
![](https://i.imgur.com/PwcuvoC.gif)




## 一. open-capacity-platform能力开放平台管理    

01.用户登录



<img src="https://i.imgur.com/Wpo9STn.png" />

02.用户管理

![](https://i.imgur.com/Ud65k7j.png)

03.角色管理

![](https://i.imgur.com/Vl4n8Wr.png)

04.菜单管理
![](https://i.imgur.com/DXFAsUy.png)



05.注册中心   
![](https://i.imgur.com/L1RMEoq.png)

 ![](https://i.imgur.com/IKHAQ1c.png)

06.配置中心   
![](https://i.imgur.com/PrHbd6P.png)
![](https://i.imgur.com/Zyy4XjQ.png)


07.服务管理

![](https://i.imgur.com/eDqMHBF.png)  

08.应用管理  
![](https://i.imgur.com/BKN06Te.png)


09.定时任务

![](https://i.imgur.com/boiJhNU.jpg)





## 部署 
1.cd /root/sop/eureka-server/bin/ &&  ./start.sh  启动注册中心服务   
2.cd /root/sop/config-center/configservice/bin/ &&  ./start.sh 启动配置中心configservice服务     
3.cd /root/sop/config-center/adminservice/bin/  &&  ./start.sh  启动配置中心adminservice 服务  
4.cd /root/sop/config-center/portalservice/bin/ &&  ./start.sh 启动配置中心portalservice服务   
5.cd /root/sop/apollo-zuul/bin/ &&  ./start.sh 启动演示apollo-zuul项目   


启动后效果预览   
![](https://i.imgur.com/H0CiqbD.jpg)







