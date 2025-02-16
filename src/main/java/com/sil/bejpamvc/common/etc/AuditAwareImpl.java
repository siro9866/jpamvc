package com.sil.bejpamvc.common.etc;

import com.sil.bejpamvc.login.service.CustomUserDetails;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * 등록/수정자정보 자동자정
 */
public class AuditAwareImpl implements AuditorAware<String> {
	@NotNull
	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null == authentication || !authentication.isAuthenticated()) {
			return Optional.empty();
		}
		if("anonymousUser".equalsIgnoreCase(authentication.getName())) {
			return Optional.empty();
		}
		CustomUserDetails detail = (CustomUserDetails) authentication.getPrincipal();
		return Optional.of(detail.getUsername());
	}
}