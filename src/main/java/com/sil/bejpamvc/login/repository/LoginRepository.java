package com.sil.bejpamvc.login.repository;

import com.sil.bejpamvc.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Member, Long>{

    // 아이디 존재하는지 여부
    boolean existsByMemberId(String memberId);
    Member findByMemberId(String memberId);
}
