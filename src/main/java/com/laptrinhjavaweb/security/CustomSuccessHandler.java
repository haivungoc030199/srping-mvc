package com.laptrinhjavaweb.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.laptrinhjavaweb.util.SecurityUtils;

public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		// if role is ADMIN to redirect to controller:/quan-tri/trang-chu
		// if role is USER to redirect to controller :/trang-chu
		List<String> roles = SecurityUtils.getAuthorities();
		if(isAdmin(roles))
		{
			url="/quan-tri/trang-chu";
		}else if(isUser(roles)) {
			url="/trang-chu";
		}
		return url;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	private Boolean isAdmin(List<String> roles) {
		if (roles.contains("ADMIN")) {
			return true;
		}
		return false;

	}

	private Boolean isUser(List<String> roles) {
		if (roles.contains("USER")) {
			return true;
		}
		return false;

	}
}
