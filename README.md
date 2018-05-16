# open-capacity-platform 微服务能力开发平台 
 
简称ocp是基于layui+springcloud的企业级微服务框架(用户权限管理，配置中心管理，应用管理，....),其核心的设计目标是分离前后端，快速开发部署，学习简单，功能强大，提供快速接入核心接口能力，其目标是帮助企业搭建一套类似百度能力开放平台的框架；


 
##   技术介绍 
![](https://i.imgur.com/bFPHaj2.jpg)  
##   框架设计
![](https://i.imgur.com/vn03vIX.jpg)

## 开发环境  
redis3.X  
jdk1.8  
MySQL Server 5.6  
maven3.3.9  
sts-3.8.0.RELEASE  

##  框架使用资料   
链接：https://pan.baidu.com/s/10Kae9_YotU5GnneaCk_p5Q 
密码：xqjb




##  ocp项目演示
 
![](http://img1.ph.126.net/WAraEeweVw2SyTUSG1dT6Q==/3887169428474612491.gif) 


## 项目组织结构分析 

![](https://i.imgur.com/4JVSncp.jpg)




## 一. open-capacity-platform能力开放平台管理    
   
01.用户登录

![](https://i.imgur.com/694I3v5.jpg)

02.用户管理

![](https://i.imgur.com/UpDbMdf.jpg)

03.角色管理

![](https://i.imgur.com/GvI6o9f.jpg)

04.菜单管理

![](https://i.imgur.com/4oCFqfG.jpg)

05.角色菜单管理

![](https://i.imgur.com/4EJF9By.jpg)
   
06.注册中心   
![](https://i.imgur.com/7VNt5ju.png)

![](https://i.imgur.com/4zfyLCi.png)

07.配置中心   
![](https://i.imgur.com/VqK4iZB.jpg)    
![](https://i.imgur.com/h3Z0cfO.jpg)     


08.应用管理  
![](https://i.imgur.com/MB4E3ve.jpg)


09.认证服务器-->认证中心

![](https://i.imgur.com/os86Yvr.jpg) 

10.定时任务

![](https://i.imgur.com/boiJhNU.jpg)





## 部署 
1.cd /root/sop/eureka-server/bin/ &&  ./start.sh  启动注册中心服务   
2.cd /root/sop/config-center/configservice/bin/ &&  ./start.sh 启动配置中心configservice服务     
3.cd /root/sop/config-center/adminservice/bin/  &&  ./start.sh  启动配置中心adminservice 服务  
4.cd /root/sop/config-center/portalservice/bin/ &&  ./start.sh 启动配置中心portalservice服务   
5.cd /root/sop/apollo-zuul/bin/ &&  ./start.sh 启动演示apollo-zuul项目   


启动后效果预览   
![](https://i.imgur.com/H0CiqbD.jpg)


待续。。。。。。。。   


技术交流群:  
![](https://i.imgur.com/YowTMtG.jpg)



 