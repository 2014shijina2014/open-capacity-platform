认证服务器-->认证中心


本认证中心采取的的数据库管理应用信息的方式来管理client_id client_secret
![](https://i.imgur.com/LpxeaC3.jpg)

同时token的生成方式支持redis集群或者jwt




由于spring security oauth 默认定义的/oauth/token 会验证client_id以及client_secret,如果不在数据库中会弹框 效果如下
![](https://i.imgur.com/KUjyHu2.jpg)


所以根据源码，自定义/oauth2/token节点以password方式的获取token，并给出友好提示

一.错误的打开方式

1无效的client_id
![](https://i.imgur.com/jD1576e.jpg)

2.无效的client_secret
![](https://i.imgur.com/jJENc8c.jpg)

3.用户名密码错误
![](https://i.imgur.com/UXCyPiv.jpg)

二.正确的打开方式

![](https://i.imgur.com/2IjVYNY.jpg)

![](https://i.imgur.com/7j7dpjr.png)

