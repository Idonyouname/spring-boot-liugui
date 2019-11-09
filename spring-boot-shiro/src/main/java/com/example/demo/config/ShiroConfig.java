package com.example.demo.config;

import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Auther liugui
 * @Create 2019/8/30 14:08
 */
@Configuration
public class ShiroConfig {

	@Bean
	MyRealm myRealm() {
		return new MyRealm();
	}

	@Bean
	DefaultWebSecurityManager  securityManager() {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(myRealm());
		return manager;
	}

	@Bean
	ShiroFilterChainDefinition shiroFilterChainDefinition() {
		DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
		definition.addPathDefinition("/doLogin", "anon");
		definition.addPathDefinition("/**", "authc");
		return definition;
	}
}
