<#import "/spring.ftl" as spring />
<nav class="navbar navbar-default" role="navigation" >
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="<@spring.url dashboardPath/>"><span></span></a>
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">切换导航</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a href="<@spring.url dashboardPath/>">主页</a>
        </li>
        <li>
          <a href="<@spring.url dashboardPath/>/lastn">最近启动的1000个服务</a>
        </li>
      </ul>
    </div>
  </div>
</nav>


