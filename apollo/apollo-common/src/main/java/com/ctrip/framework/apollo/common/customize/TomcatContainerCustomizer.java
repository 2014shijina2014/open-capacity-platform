package com.ctrip.framework.apollo.common.customize;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ProtocolHandler;
import org.apache.coyote.http11.Http11NioProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Component
public class TomcatContainerCustomizer implements EmbeddedServletContainerCustomizer {
  private static final Logger logger = LoggerFactory.getLogger(TomcatContainerCustomizer.class);
  private static final String TOMCAT_ACCEPTOR_COUNT = "server.tomcat.accept-count";
  @Autowired
  private Environment environment;

  @Override
  public void customize(ConfigurableEmbeddedServletContainer container) {
    if (!(container instanceof TomcatEmbeddedServletContainerFactory)) {
      return;
    }
    if (!environment.containsProperty(TOMCAT_ACCEPTOR_COUNT)) {
      return;
    }
    TomcatEmbeddedServletContainerFactory tomcat =
        (TomcatEmbeddedServletContainerFactory) container;
    tomcat.addConnectorCustomizers(new TomcatConnectorCustomizer() {
      @Override
      public void customize(Connector connector) {
        ProtocolHandler handler = connector.getProtocolHandler();
        if (handler instanceof Http11NioProtocol) {
          Http11NioProtocol http = (Http11NioProtocol) handler;
          int acceptCount = Integer.parseInt(environment.getProperty(TOMCAT_ACCEPTOR_COUNT));
          http.setBacklog(acceptCount);
          logger.info("Setting tomcat accept count to {}", acceptCount);
        }

      }
    });
  }
}
