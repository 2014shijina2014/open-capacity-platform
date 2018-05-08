# open-capacity-platform 微服务能力开发平台 #

技术交流群:  
	![](https://i.imgur.com/YowTMtG.jpg)

项目简介
 
![](http://img1.ph.126.net/WAraEeweVw2SyTUSG1dT6Q==/3887169428474612491.gif) 

框架使用资料   
链接：https://pan.baidu.com/s/10Kae9_YotU5GnneaCk_p5Q 
密码：xqjb


项目组织结构分析  
├	apollo -- 阿波罗配置中心  
├   	 ├── apollo-adminservice    
├   	 ├── apollo-assembly     
├   	 ├── apollo-biz   
├    	 ├── apollo-buildtools    
├   	 ├── apollo-client    
├    	 ├── apollo-common     
├    	 ├── apollo-configservice    
├    	 ├── apollo-core  
├    	 ├── apollo-demo  
├	 	 ├── apollo-portal   
├	     └── apollo-zuul    整合zuul案例  
├	cachecloud-open-parent -- 搜狐redis云平台   
├    		├── cachecloud-open-client    
├    		├── cachecloud-open-common   
├   		└── cachecloud-open-web   
├	open-api-gateway -- 服务网关[9200]   
├	open-config-cloud  --基于spring cloud config 的配置中心   
├    		├── config-bus    --基于spring cloud bus的服务总线[8201]  
├    		├── config-client ----基于spring cloud client端[7001]   
├    		├── config-server ----基于spring cloud server端[7201]    
├   		└── config-zuul  ----基于config-client项目整合网关[5555]   
├ 	open-db-core     -- 数据库逻辑封装   
├	open-layui-web   --  基于token的layui后台管理系统    
├ 	open-zipkin-cloud  -- 链路跟踪   
├          ├── open-zipkin-kafka-server  -- kafka链路跟踪服务端[9411]  
├          ├── open-zipkin-kafka-client  -- kafka链路跟踪客户端[9412]  
├          ├── open-zipkin-memery-server -- 内存跟踪服务端[9411]  
└          └─ open-zipkin-memery-client -- 内存链路跟踪客户端[9412]  




一. open-capacity-platform能力开放平台管理   
   
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

![](https://i.imgur.com/ye3kyrJ.jpg)      

07.配置中心   
![](https://i.imgur.com/VqK4iZB.jpg)    
![](https://i.imgur.com/h3Z0cfO.jpg)     


08.应用管理  
![](https://i.imgur.com/MB4E3ve.jpg)


09.认证服务器-->认证中心


09.1本认证中心采取的的数据库管理应用信息的方式来管理client_id client_secret,同时token的生成方式支持redis集群或者jwt
![](https://i.imgur.com/LpxeaC3.jpg)


09.2由于spring security oauth 默认定义的/oauth/token 会验证client_id以及client_secret,如果不在数据库中会弹框,所以根据源码，自定义/user/token节点以password方式的获取token，并给出友好提示 效果如下
![](https://i.imgur.com/KUjyHu2.jpg)


10.认证中心集成swagger

10.1 请求/user/token
![](https://i.imgur.com/rdmECb2.jpg)
10.1 请求/users节点
![](https://i.imgur.com/YAWt8dG.jpg)

11.认证服务器-->认证中心

11.1.1无效的client_id
![](https://i.imgur.com/jjGeHy4.jpg)

11.1.2无效的client_secret
![](https://i.imgur.com/adBHsJz.jpg)

11.1.3用户名密码错误
![](https://i.imgur.com/JwioaAW.jpg)

11.1.4成功
![](https://i.imgur.com/os86Yvr.jpg)

![](https://i.imgur.com/7j7dpjr.png)



二. 阿波罗配置中心详解  

1. 前言  
携程 Apollo 配置中心 学习笔记， Windows 系统搭建基于携程Apollo配置中心分布式模式， 在此基础上，介绍如何使用阿波罗整合zuul实现动态路由。

2.环境搭建 


- 效果预览  
	![](https://i.imgur.com/wKDxAod.png)


- 	apollo-configservice    
修改如下配置将apollo-configservice 注册到已有的eureka服务器，同时提供提供配置的读取、推送等功能.
	![](https://i.imgur.com/PpSpZeR.png)
修改apollo-configservice的数据源
	![](https://i.imgur.com/jj89nvM.png)
-  apollo-adminservice    
修改apollo-adminservice的数据源
	![](https://i.imgur.com/htBHxX2.png)
	
- apollo-portal    
修改apollo-portal代码及数据源    
	![](https://i.imgur.com/THrU361.png)
	![](https://i.imgur.com/GAI3voO.png)

- apollo-core    
修改开发环境环境读取配置文件的地址，填入apollo-configservice注册到eureka服务器的地址，如果apollo-configservice启动多台，可以引入nginx负载均衡    
![](https://i.imgur.com/fsrF22z.png)

3.阿波罗整合zuul服务注册中心    
	

- 效果预览    
	![](https://i.imgur.com/GgvUisl.png)    
 访问http://127.0.0.1:9999/test163即可读取阿波罗页面配置参数，页面修改后可刷新所有阿波罗客户端


- apollo-zuul   
apollo-zuul项目用的是Eureka作为服务注册与发现，因此这里我加入了Eureka Client的依赖，同时需要加入zuul网关的依赖实现微服务的路由
  pom.xml文件加入以下依赖
 
		<dependencies>
              <dependency>
                     <groupId>org.springframework.cloud</groupId>
                     <artifactId>spring-cloud-starter-eureka</artifactId>
              </dependency>
              <dependency>
                     <groupId>com.ctrip.framework.apollo</groupId>
                     <artifactId>apollo-client</artifactId>
                     <version>0.10.0-SNAPSHOT</version>
              </dependency>
 
              <dependency>
                     <groupId>org.springframework.boot</groupId>
                     <artifactId>spring-boot-starter-test</artifactId>
                     <scope>test</scope>
              </dependency>
 
              <dependency>
                     <groupId>org.springframework.boot</groupId>
                     <artifactId>spring-boot-starter-actuator</artifactId>
                     <scope>true</scope>
              </dependency>
              <dependency>
                    <groupId>org.springframework.cloud</groupId>
                          <artifactId>spring-cloud-starter-zuul</artifactId>
              </dependency>
       </dependencies>
 
 
3.1.1 下载项目
 
在官方github项目中，把项目下载下来  https://github.com/ctripcorp/apollo，导入到Eclipse工程中。如下图
       	![](https://i.imgur.com/voOCGQv.png)      
由于官方给出的分布式搭建需要加入很多启动参数，过于繁琐，可以考虑https://gitee.com/234gdfgsdf/open-capacity-platform/tree/master/apollo-master下载    
 项目组织结构(功能)[端口]    
├── apollo -- 阿波罗配置中心    
├    ├── apollo-configservice  (提供配置的修改、发布等功能，服务对象是Apollo Portal) [8080]    
├    ├── apollo-adminservice  (提供配置的读取、推送等功能，服务对象是Apollo客户端)[8090]    
├    ├── apollo-portal               (管理界面) [8070]    
├    └── apollo-zuul                  (阿波罗整合zuul网关)    
└── open-eureka-server         (服务注册中心)[1111]    
 
3.2 application.properties 配置写入到Apollo配置中心
3.2.1 application.properties
如下原本是写在spring boot 工程中的配置信息，接下来写入到配置中心中。    
spring.application.name=sop-api-gateway    
server.port=9999    
zuul.ignored-services="*"    
 
3.2.2 创建apollo项目
      
![](https://i.imgur.com/VHyErnx.png)

 
这里我已经创建好了，就不做过多演示了。
 
![](https://i.imgur.com/zStELyl.png)

将信息上传写入到配置文件中，然后在把工程中的application.properties文件删除。
3.2.3 新建app.properties文件
 ![](https://i.imgur.com/igyNgM1.png)


3.2.4
配置刷新zuul配置    
![](https://i.imgur.com/4P7pxsu.png)    
配置页面发布即时更新zuul配置    
![](https://i.imgur.com/XgRNhQj.png)    
application.java启动类    
@RestController    
@EnableZuulProxy    
@EnableApolloConfig    
@EnableDiscoveryClient    
@SpringBootApplication    
public class ApiGateWayApp {    
 
       public static void main(String[] args) {
              SpringApplication.run(ApiGateWayApp.class, args);
       }
}



注意加注解。    
然后直接启动即可。。。。。。。    
 
 
         
三. 搜狐cachecloud云平台管理    
- 修改配置    
 ![](https://i.imgur.com/TVWXVhd.jpg)    
- 项目编译    
![](https://i.imgur.com/ugsdZoF.jpg)    
- 项目运行    
 ![](https://i.imgur.com/HVLPI7y.jpg)    

- 主机规划     
19   ls    
20 mkdir -p /opt/cachecloud    
21 ls    
22 cd /opt/cachecloud    
23 ls    
24 vi init.sh    
25 ls    
26 chmod 777 init.sh    
27 ./init.sh    
28 cd /opt/cachecloud/    
29 ls    
30 ./init.sh root    
31 ./init.sh cachecloud        
32 ll    
33 chown cachecloud.cachecloud -R /opt/cachecloud    
34 ls    
35 ll    
36 ls    
37 cd data    
38 ls    
39 cd ..    
40 ls
41 cd conf    
42 ls    
43 cd ..    
44 ls    
45 cd redis/    
46 ls    
47 ifconfig    
48 history    

- 效果预览   
 ![](https://i.imgur.com/5Dij6ix.png)

详细搭建可以参考http://www.ywnds.com/?p=10610





4.部署   
1.cd /root/sop/eureka-server/bin/ &&  ./start.sh  启动注册中心服务   
2.cd /root/sop/config-center/configservice/bin/ &&  ./start.sh 启动配置中心configservice服务     
3.cd /root/sop/config-center/adminservice/bin/  &&  ./start.sh  启动配置中心adminservice 服务  
4.cd /root/sop/config-center/portalservice/bin/ &&  ./start.sh 启动配置中心portalservice服务   
5.cd /root/sop/apollo-zuul/bin/ &&  ./start.sh 启动演示apollo-zuul项目   





启动后效果预览   
![](https://i.imgur.com/H0CiqbD.jpg)


待续。。。。。。。。   






 