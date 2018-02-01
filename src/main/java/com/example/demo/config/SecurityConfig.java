package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
public class SecurityConfig {

    public SecurityConfig() {
        //making sonar happy
    }

    @Configuration
    @Profile("secure")
    @EnableResourceServer
    @EnableWebSecurity
    static class CloudConfig extends ResourceServerConfigurerAdapter {

//        @Value("${UAA_URI}/oauth/token")
//        private String trustedUrl;
//
//        @Value("${SERVICE_SCOPE}")
//        private String serviceScope;
//
//        @Value("${API_SCOPE}")
//        private String apiScope;
//
//        @Value("${ENVIRONMENT}")
//        private String envScope;
//
//        @Value("${security.maxSkewSeconds}")
//        private int maxSkewSeconds;

//        @Override
//        public void configure(ResourceServerSecurityConfigurer resources) {
//            resources
//                    .resourceId("gte")
//                    .stateless(true)
//                    .tokenServices(setFastTokenBean());
//        }
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http
//                    .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                    .requestMatchers().antMatchers("/api/**").and()
//                    .authorizeRequests()
//                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                    .antMatchers("/api/**").access("#oauth2.hasScope('" + apiScope + "') and  #oauth2.hasScope('" + envScope + "')");
//        }
//
//        @Bean
//        public FastTokenServices setFastTokenBean() {
//            FastTokenServices tokenService = new FastTokenServicesCreator().newInstance();
//            tokenService.setUseHttps(true);
//            tokenService.setStoreClaims(true);
//            List<String> uaaList = new ArrayList<>();
//            // Trusted UUA Url so we can validate token
//            uaaList.add(trustedUrl);
//            tokenService.setTrustedIssuers(uaaList);
//            tokenService.setMaxAcceptableClockSkewSeconds(maxSkewSeconds);
//            return tokenService;
//        }

    }

    @Configuration
    @Profile("!secure")
    @EnableResourceServer
    @EnableWebSecurity
    static class LocalConfig extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/**").permitAll();
        }

    }
}
