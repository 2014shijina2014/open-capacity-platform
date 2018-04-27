<#import "/spring.ftl" as spring />
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
  <head>
    <base href="<@spring.url basePath/>">
    <title>注册中心-事件</title>
    <link rel="stylesheet" type="text/css" href="eureka/css/wro.css">
  </head>
  <body id="three">

    <!--[if lt IE 7]>
    <p>您使用的是旧版本的浏览器。请升级您的浏览器以改善您的体验。</p>
    <![endif]-->

    <#include "header.ftl">

    <div class="container-fluid xd-container">
      <#include "navbar.ftl">

    <div id="xd-jobs" class="tab-pane active col-md-12">
        <ul class="nav nav-tabs" role="tablist" id="myTab">
          <li class="active"><a data-toggle="tab" href="#cancelled">最后1000个取消的租约</a></li>
          <li><a data-toggle="tab" href="#registered">最近1000份新注册租约</a></li>
        </ul>
        <div class="tab-content">
          <div class="tab-pane" id="cancelled">
            <table id='lastNCanceled' class="table table-striped table-hover">
              <thead>
                <tr><th>租约</th><th>时间戳</th></tr>
              </thead>
              <tbody>
                <#if lastNCanceled?has_content>
	                <#list lastNCanceled as entry>
	                  <tr><td>${entry.date?datetime}</td><td>${entry.id}</td></tr>
	                </#list>
	            <#else>
	              <tr><td colspan="2">没有可用的资源</td></tr>
	            </#if>
              <tbody>
            </table>
          </div>
          <div class="tab-pane" id="registered">
            <table id='lastNRegistered' class="table table-striped table-hover">
              <thead>
                <tr><th>租约</th><th>时间戳</th></tr>
              </thead>
              <tbody>
                <#if lastNRegistered?has_content>
                  <#list lastNRegistered as entry>
                    <tr><td>${entry.date?datetime}</td><td>${entry.id}</td></tr>
                  </#list>
                <#else>
	              <tr><td colspan="2">没有可用的资源</td></tr>
	            </#if>
              </tbody>
            </table>
          </div>
      </div>
    </div>
    </div>
    <script type="text/javascript" src="eureka/js/wro.js" ></script>
    <script type="text/javascript">
      $(function () {
        $('#myTab a:last').tab('show')
      })
    </script>
  </body>
</html>
