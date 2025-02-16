package com.sil.bejpamvc.member.service;

import com.sil.bejpamvc.common.util.UtilMessage;
import com.sil.bejpamvc.member.dto.MemberResponseDto;
import com.sil.bejpamvc.member.entity.Member;
import com.sil.bejpamvc.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FileName    : IntelliJ IDEA
 * Author      : Seowon
 * Date        : 2025-01-21
 * Description :
 */
@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final UtilMessage utilMessage;
    private final MemberRepository memberRepository;

    /**
     * 회원정보상세
     */
    public MemberResponseDto getMember(Long memberSeq) {
        Member member = memberRepository.findById(memberSeq).get();
        return MemberResponseDto.toDto(member);
    }

}
