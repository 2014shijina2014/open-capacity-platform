<h1>系统状态</h1>
<div class="row">
  <div class="col-md-6">
    <table id='instances' class="table table-condensed table-striped table-hover">
      <#if amazonInfo??>
        <tr>
          <td>服务注册和发现</td>
          <td>AMI: ${amiId!}</td>
        </tr>
        <tr>
          <td>空间</td>
          <td>${availabilityZone!}</td>
        </tr>
        <tr>
          <td>示例Id</td>
          <td>${instanceId!}</td>
        </tr>
      </#if>
      <tr>
        <td>环境</td>
        <td>${environment!}</td>
      </tr>
      <tr>
        <td>数据中心</td>
        <td>${datacenter!}</td>
      </tr>
    </table>
  </div>
  <div class="col-md-6">
    <table id='instances' class="table table-condensed table-striped table-hover">
      <tr>
        <td>当前时间</td>
        <td>${currentTime}</td>
      </tr>
      <tr>
        <td>运行</td>
        <td>${upTime}</td>
      </tr>
      <tr>
        <td>启用租约到期时间</td>
        <td>${registry.leaseExpirationEnabled?c}</td>
      </tr>
      <tr>
        <td>续订阈值</td>
        <td>${registry.numOfRenewsPerMinThreshold}</td>
      </tr>
      <tr>
        <td>续订 (最后一分钟)</td>
        <td>${registry.numOfRenewsInLastMin}</td>
      </tr>
    </table>
  </div>
</div>

<#if isBelowRenewThresold>
    <#if !registry.selfPreservationModeEnabled>
        <h4 id="uptime"><font size="+1" color="red"><b>续订小于阈值。自保存模式已关闭。如果出现网络/其他问题, 这可能不会保护实例过期。</b></font></h4>
    <#else>
        <h4 id="uptime"><font size="+1" color="red"><b> 紧急!注册中心可能不正确地验证身份, 当他们没有的情况下。续订小于阈值, 因此实例不会过期, 只是为了安全起见。</b></font></h4>
    </#if>
<#elseif !registry.selfPreservationModeEnabled>
    <h4 id="uptime"><font size="+1" color="red"><b>自保存模式已关闭。如果出现网络/其他问题, 这可能不会保护实例过期。</b></font></h4>
</#if>

<h1>服务副本</h1>
<ul class="list-group">
  <#list replicas as replica>
    <li class="list-group-item"><a href="${replica.value}">${replica.key}</a></li>
  </#list>
</ul>

