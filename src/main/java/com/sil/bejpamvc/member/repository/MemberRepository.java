package com.sil.bejpamvc.member.repository;

import com.sil.bejpamvc.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByMemberId(String memberId);
	
}
