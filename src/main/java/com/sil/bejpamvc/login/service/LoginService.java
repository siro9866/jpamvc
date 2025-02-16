package com.sil.bejpamvc.login.service;

import com.sil.bejpamvc.login.repository.LoginRepository;
import com.sil.bejpamvc.member.dto.MemberCreateDto;
import com.sil.bejpamvc.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoginService {

    private final LoginRepository loginRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void joinProcess(MemberCreateDto memberCreateDto) throws Exception {

        // 아이디 중복 확인
        if(loginRepository.existsByMemberId(memberCreateDto.getMemberId())){
            throw new Exception("이미 가입된 회원");
        }

        Member member = memberCreateDto.toEntity();
        // 비밀번호 암호화
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        // ROLE
        member.setMemberRole("ROLE_MEMBER");

        loginRepository.save(member);
    }

}
