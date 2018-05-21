# 认证服务器-->认证中心 


## OAuth2分为四个角色：资源拥有者、资源服务器、授权服务器、客户端 


![](https://i.imgur.com/MSPOyMJ.jpg)


## open-oauth-center  oauth2 认证服务器 资源服务器分离架构中心 

![](https://i.imgur.com/V9hvviQ.png)



## open-oauth-server 认证中心 
![](https://i.imgur.com/RWrGfa4.png)

## 客户端模式 
![](https://i.imgur.com/2otLKyU.png)

## 密码模式 
![](https://i.imgur.com/ky6gGPF.jpg)

## 授权码模式 
1.获取授权码
	http://localhost:8000/oauth/authorize?client_id=webApp&redirect_uri=http://www.baidu.com&state=abc&scope=app&response_type=code

2.授权码换token
![](https://i.imgur.com/01lpwCL.png)


## open-oauth-client  open-oauth-client-two  open-api-gateway 均为资源服务器  

![](https://i.imgur.com/WZZiWbm.png)



## 源码分析   
![](https://i.imgur.com/Cfm2bq6.jpg)

 
## 资源服务器校验核心逻辑 

![](https://i.imgur.com/ysrtPT9.png)
 
认证服务器 资源服务器统一实现配置tokenstore，同时直接连接redis校验token是否有效  
 ![](https://i.imgur.com/l19iTmo.png)  
RemoteTokenServices  
一般为单点登录sso时使用，此方式需要通过http方式连接认证中心，同时还需要访问redis，多一层网络连接，建议不采用此方式

