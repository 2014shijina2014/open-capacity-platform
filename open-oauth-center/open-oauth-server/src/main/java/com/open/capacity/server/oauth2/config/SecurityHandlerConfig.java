package com.open.capacity.server.oauth2.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.common.exceptions.RedirectMismatchException;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedResponseTypeException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 作者 owen E-mail: wang.wen@neusoft.com
 * @version 创建时间：2018年4月5日 下午7:52:21 类说明
 */
@Component
@Configuration
public class SecurityHandlerConfig {

	@Resource
	private ObjectMapper objectMapper; // springmvc启动时自动装配json处理类

	@Autowired
	private AuthorizationServerTokenServices authorizationServerTokenServices;

	@Autowired
	private ClientDetailsService clientDetailsService;

	@Autowired(required = false)
	private AuthenticationEntryPoint authenticationEntryPoint;

	/**
	 * 登陆成功，返回Token 装配此bean不支持授权码模式
	 * 
	 * @return
	 */
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new SavedRequestAwareAuthenticationSuccessHandler() {

			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {

				if (authenticationEntryPoint != null) {
					String clientId = request.getHeader("client_id");
					String clientSecret = request.getHeader("client_secret");

					try {

						if (clientId == null) {
							throw new UnapprovedClientAuthenticationException("请求头中无client_id信息");
						}

						if (clientSecret == null) {
							throw new UnapprovedClientAuthenticationException("请求头中无client_secret信息");
						}

						ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);

						if (clientDetails == null) {
							throw new UnapprovedClientAuthenticationException("clientId对应的信息不存在");
						} else if (!StringUtils.equals(clientDetails.getClientSecret(), clientSecret)) {
							throw new UnapprovedClientAuthenticationException("clientSecret不匹配");
						}

						TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, clientId,
								clientDetails.getScope(), "customer");

						OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

						OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request,
								authentication);

						OAuth2AccessToken oAuth2AccessToken = authorizationServerTokenServices
								.createAccessToken(oAuth2Authentication);

						response.setContentType("application/json;charset=UTF-8");
						response.getWriter().write(objectMapper.writeValueAsString(oAuth2AccessToken));
						response.getWriter().flush();
						response.getWriter().close();

					} catch (Exception e) {

						response.setStatus(HttpStatus.UNAUTHORIZED.value());

						response.setContentType("application/json;charset=UTF-8");

						Map<String, String> rsp = new HashMap<>();
						rsp.put("resp_code", HttpStatus.UNAUTHORIZED.value() + "");
						rsp.put("rsp_msg", e.getMessage());

						response.getWriter().write(objectMapper.writeValueAsString(rsp));
						response.getWriter().flush();
						response.getWriter().close();

					}

				} else {
					super.onAuthenticationSuccess(request, response, authentication);
				}

			}
		};
	}

	/**
	 * 登陆失败
	 * 
	 * @return
	 */
	@Bean
	public AuthenticationFailureHandler loginFailureHandler() {
		return new AuthenticationFailureHandler() {

			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				String msg = null;
				if (exception instanceof BadCredentialsException) {
					msg = "密码错误";
				} else {
					msg = exception.getMessage();
				}

				Map<String, String> rsp = new HashMap<>();

				response.setStatus(HttpStatus.UNAUTHORIZED.value());

				rsp.put("resp_code", HttpStatus.UNAUTHORIZED.value() + "");
				rsp.put("rsp_msg", msg);

				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().write(objectMapper.writeValueAsString(rsp));
				response.getWriter().flush();
				response.getWriter().close();

			}
		};

	}

	/**
	 * 未登录，返回401 装配此bean不支持授权码模式
	 * 
	 * @return
	 */
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationEntryPoint() {

			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {

				Map<String, String> rsp = new HashMap<>();

				rsp.put("resp_code", HttpStatus.UNAUTHORIZED.value() + "");
				rsp.put("rsp_msg", authException.getMessage());
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().write(objectMapper.writeValueAsString(rsp));
				response.getWriter().flush();
				response.getWriter().close();

			}
		};
	}

	@Bean
	public WebResponseExceptionTranslator webResponseExceptionTranslator() {
		return new DefaultWebResponseExceptionTranslator() {

			public static final String BAD_MSG = "坏的凭证";

			@Override
			public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
				// e.printStackTrace();
				OAuth2Exception oAuth2Exception;
				if (e.getMessage() != null && e.getMessage().equals(BAD_MSG)) {
					oAuth2Exception = new InvalidGrantException("用户名或密码错误", e);
				} else if (e instanceof InternalAuthenticationServiceException) {
					oAuth2Exception = new InvalidGrantException(e.getMessage(), e);
				} else if (e instanceof RedirectMismatchException) {
					oAuth2Exception = new InvalidGrantException(e.getMessage(), e);
				} else {
					oAuth2Exception = new UnsupportedResponseTypeException("服务内部错误", e);
				}

				ResponseEntity<OAuth2Exception> response = super.translate(oAuth2Exception);
				ResponseEntity.status(oAuth2Exception.getHttpErrorCode());
				response.getBody().addAdditionalInformation("resp_code", oAuth2Exception.getHttpErrorCode() + "");
				response.getBody().addAdditionalInformation("resp_msg", oAuth2Exception.getMessage());

				return response;
			}

		};
	}

}
