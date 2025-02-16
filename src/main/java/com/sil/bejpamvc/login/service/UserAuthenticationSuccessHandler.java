package com.sil.bejpamvc.login.service;

import com.sil.bejpamvc.login.repository.LoginRepository;
import com.sil.bejpamvc.member.entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

/**
 * 로그인 성공시 핸들러
 */
@Slf4j
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    // 생성자로 하면 secureconfig 에서 문제생겨서 걍 했음
    @Autowired private LoginRepository loginRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        super.onAuthenticationSuccess(request, response, authentication);

        // TODO: 성공시 할거 세션등록등
        log.debug("onAuthenticationSuccess 아싸 로그인 성공했다");

        Member member = loginRepository.findByMemberId(authentication.getName());

    }
}
