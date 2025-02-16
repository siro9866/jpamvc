package com.sil.bejpamvc.common.config;

import com.sil.bejpamvc.login.service.UserAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * 비밀번호암호화
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserAuthenticationSuccessHandler getSuccessHandler() {
        return new UserAuthenticationSuccessHandler();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/login", "/join", "/joinProcess").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")
                        .anyRequest().authenticated()
                );

        http
                .formLogin((auth) -> auth.loginPage("/login")
                        .loginProcessingUrl("/loginProcess")
                        .usernameParameter("memberId")
                        .passwordParameter("password")
                        .successHandler(getSuccessHandler())
                        .permitAll()
                );

        http
                .logout((auth) -> auth.logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                );


//        http.csrf(AbstractHttpConfigurer::disable);



        http
                .sessionManagement((auth) -> auth
                        .maximumSessions(1) // 중복로그인 가능 갯수
                        .maxSessionsPreventsLogin(true) // max 사이즈를 초과했을 시 처리방법(true: 새로운 로그인 차단, false: 기존 세션 하나 삭제)
                );

        // 세션고정보호(세션탈취대비)
        http
                .sessionManagement((auth) -> auth
                        .sessionFixation().changeSessionId()       // none: 로그인시 세션정보 변경 안함, newSession: 로그인시 세션 새로 생성, changeSessionId: 로그인시 동일한 세션에 대한 id 변경
                );

        return http.build();
    }


}
