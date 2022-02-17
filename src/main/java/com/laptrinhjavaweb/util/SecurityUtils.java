package com.laptrinhjavaweb.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.laptrinhjavaweb.dto.MyUser;

public class SecurityUtils {
	//hàm get ra myUser trong jpa lưu ở princinpal
	public static MyUser getPrincipal() {
		MyUser myUser=(MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		return myUser;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities(){
		//hàm put thông tin user vào
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
		return results;
		
		
	}

}
