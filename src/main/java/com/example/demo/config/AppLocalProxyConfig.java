package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Configuration
@Profile("local")
public class AppLocalProxyConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppLocalProxyConfig.class);

    @Value("${http.proxy.set}")
    private Boolean httpProxySet;

    @Value("${http.proxy}")
    private String httpProxy;

    @Value("${http.proxy.port}")
    private String httpProxyPort;

    @Value("${https.proxy.set}")
    private Boolean httpsProxySet;

    @Value("${http.proxy}")
    private String httpsProxy;

    @Value("${http.proxy.port}")
    private String httpsProxyPort;

    @PostConstruct
    public void init() {
        LOGGER.debug(" AppLocalProxyConfig -Started");
        Properties props = System.getProperties();
        if (Boolean.TRUE.equals(httpsProxySet)) {
            props.setProperty("https.proxySet", String.valueOf(httpsProxySet));
            props.setProperty("https.proxyHost", httpsProxy);
            props.setProperty("https.proxyPort", httpsProxyPort);
        }

        if (Boolean.TRUE.equals(httpProxySet)) {
            props.setProperty("http.proxySet", String.valueOf(httpProxySet));
            props.setProperty("http.proxyHost", httpProxy);
            props.setProperty("http.proxyPort", httpProxyPort);
        }
        LOGGER.debug(" AppLocalProxyConfig -Completed");

    }
}