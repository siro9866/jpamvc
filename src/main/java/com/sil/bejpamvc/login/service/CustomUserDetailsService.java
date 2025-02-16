package com.sil.bejpamvc.login.service;

import com.sil.bejpamvc.login.repository.LoginRepository;
import com.sil.bejpamvc.member.entity.Member;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private final LoginRepository loginRepository;

	public CustomUserDetailsService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

		Member entity = loginRepository.findByMemberId(memberId);
		
		if(entity != null) {
			return new CustomUserDetails(entity);
		}
		
		return null;
	}

}
