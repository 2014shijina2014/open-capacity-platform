//package com.open.capacity.filter;
//
//import java.util.ArrayList;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
///**
// * 简单实现IP白名单功能
// * @author HP
// */
//@Component
//public class IPFilter extends ZuulFilter {
//
//	Logger logger = LoggerFactory.getLogger(getClass());
//
//	@Override
//	public String filterType() {
//		return "pre";
//	}
//
//	@Override
//	public int filterOrder() {
//		return 0;
//	}
//
//	@Override
//	public boolean shouldFilter() {
//		return true;
//	}
//
//	@Override
//	public Object run() {
//		RequestContext ctx = RequestContext.getCurrentContext();
//		HttpServletRequest req = ctx.getRequest();
//		String ipAddr = this.getIpAddr(req);
//		logger.info("请求IP地址为：[{}]", ipAddr);
//		// 配置本地IP白名单，生产环境可放入数据库或者redis中
//		List<String> ips = new ArrayList<String>();
//		ips.add("127.0.0.1");
//
//		if (!ips.contains(ipAddr)) {
//			logger.info("IP地址校验不通过！！！");
//			ctx.setResponseStatusCode(401);
//			ctx.setSendZuulResponse(false);
//			ctx.setResponseBody("IpAddr is forbidden!");
//		}
//		logger.info("IP校验通过。");
//		return null;
//	}
//
//	/**
//	 * 获取Ip地址
//	 * 
//	 * @param request
//	 * @return
//	 */
//	public String getIpAddr(HttpServletRequest request) {
//
//		String ip = request.getHeader("X-Forwarded-For");
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("WL-Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("HTTP_CLIENT_IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getRemoteAddr();
//		}
//		return ip;
//	}
//}