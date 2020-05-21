package com.system.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.service.securityLogin.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    UserService userService;

    @Resource
    CustomMetadataSource metadataSource;

    @Resource
    UrlAccessDecisionManger urlAccessDecisionManger;

    @Resource
    AuthenticationAccessDeniedHandler deniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html" , "/static/**" , "/login_p");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(metadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManger);
                        return o;
                    }
                }).and().formLogin().loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resq, AuthenticationException e) throws IOException, ServletException {
                        resq.setContentType("application/json;charset=UTF-8");
                        PrintWriter out = resq.getWriter();
                        resq.setStatus(401);
                        Map<String , Object> map = new HashMap<>();
                        map.put("status" , 401);
                        if (e instanceof LockedException){
                            map.put("msg" , "账户被锁定，登录失败");
                        } else if(e instanceof BadCredentialsException){
                            map.put("msg" , "账户名或密码输入错误，登录失败");
                        } else {
                            map.put("msg" , "登录失败");
                        }
                        ObjectMapper om = new ObjectMapper();
                        out.write(om.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resq, Authentication auth) throws IOException, ServletException {
                        Object principal = auth.getPrincipal();
                        resq.setContentType("application/json;charset=UTF-8");
                        PrintWriter out = resq.getWriter();
                        resq.setStatus(200);
                        Map<String , Object> map = new HashMap<>();
                        map.put("status" , 200);
                        map.put("msg" , principal);
                        ObjectMapper om = new ObjectMapper();
                        out.write(om.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll().and()
                .logout().permitAll()
                .and()
                .csrf().disable().exceptionHandling().accessDeniedHandler(deniedHandler);

    }

}
