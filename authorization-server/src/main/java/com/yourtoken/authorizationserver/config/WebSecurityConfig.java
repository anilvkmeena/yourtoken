package com.yourtoken.authorizationserver.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@EnableWebSecurity
@EnableAutoConfiguration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		 http.csrf().disable();
		//super.configure(http);
	}

	@Autowired 
	 DataSource dataSource;
	 	//this bean use by spring to authenticate user 
	 @Bean
	 @Override
	 public UserDetailsService userDetailsService() 
	 {
		 return new JdbcUserDetailsManager(this.dataSource);
	 }
	    
	    //data source object is created using properties file
	 @Bean
	 @Primary
	 @ConfigurationProperties("spring.datasource")
	 public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}
	
	    //this bean is used by spring to store token in database
    @Bean
    public JdbcTokenStore jdbcTokenStore()
    {
    	return new JdbcTokenStore(dataSource);
    }
 
}
