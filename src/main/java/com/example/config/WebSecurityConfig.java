package com.example.config;

import com.example.provider.DatabaseAuthenticationProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DatabaseAuthenticationProvider databaseAuthenticationProvider;

    public WebSecurityConfig(DatabaseAuthenticationProvider databaseAuthenticationProvider) {
        this.databaseAuthenticationProvider = databaseAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
              .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
              .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
              .and()
                    .rememberMe()
              .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(databaseAuthenticationProvider);
    }
}
