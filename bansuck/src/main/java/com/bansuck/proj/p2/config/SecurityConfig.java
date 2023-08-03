package com.bansuck.proj.p2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bansuck.proj.p2.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final CustomUserDetailsService customUserDetailsService;
    
    public SecurityConfig() {
        this.customUserDetailsService = new CustomUserDetailsService();
    }
    
    // /webjars/** 경로에 대한 요청은 인증/인가 처리하지 않도록 무시합니다.
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/webjars/**");
//    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
            .passwordEncoder(encoder());
    }

    // /, /main에 대한 요청은 누구나 할 수 있지만,
    // 그 외의 요청은 모두 인증 후 접근 가능합니다.
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // 나중 정상 서비스에서는 disable 삭제
//                .authorizeRequests()
//                .antMatchers("/", "/api/user/loginerror", "/api/user/login", "/user/login", "/user/sign-up", "/api/user/sign-up").permitAll() // 예외 경로
//                .antMatchers("/securepage", "/api/user/**", "/user/**").hasRole("USER") // 사용자 권한이 있는 사용자만 접속
//                .anyRequest().authenticated()
//                .and()
//                    .formLogin()
//                    .loginPage("/user/login") // 초기 로그인 경로
//                    .usernameParameter("userId")
//                    .passwordParameter("password")
//                    .loginProcessingUrl("/authenticate") // 지정경로
//                    .failureForwardUrl("/user/loginerror?login_error=1") // 에러 페이지
//                    .defaultSuccessUrl("/",true) // 기본값 경로
//                    .permitAll()
//                .and()
//                    .logout()
//                    .logoutUrl("/user/logout")
//                    .logoutSuccessUrl("/");
//    }

    // 패스워드 인코더를 빈으로 등록합니다. 암호를 인코딩하거나,
    // 인코딩된 암호와 사용자가 입력한 암호가 같은 지 확인할 때 사용합니다.
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
