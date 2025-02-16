package com.sil.bejpamvc.login.service;

import com.sil.bejpamvc.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails{

	@Serial
	private static final long serialVersionUID = -4309470659487143653L;
	private final Member member;
	
	public CustomUserDetails(Member member) {
		this.member = member;
	}
	
	/**
	 * 롤 반환
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {
				return member.getMemberRole();
			}
		});
		return collection;
	}

	@Override
	public String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getMemberId();
	}

}
