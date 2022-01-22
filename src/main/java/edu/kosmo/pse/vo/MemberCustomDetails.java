package edu.kosmo.pse.vo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
public class MemberCustomDetails implements UserDetails {
	
	@Setter(onMethod_ = @Autowired)
	private MemberVO memberVO;
	
	private String password;
	private final String userId;
	private final Collection<? extends GrantedAuthority> authorities;
	private final boolean accountNonExpired;
	private final boolean accountNonLocked;
	private final boolean credentialsNonExpired;
	private final boolean enabled;

	public MemberCustomDetails(MemberVO memberVO) {
		this(memberVO.getUserId(), memberVO.getPassword(), true, true, true, true, getAuth(memberVO));
		this.memberVO = memberVO;
	}
	
	public MemberCustomDetails(String userId, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

		if (((userId == null) || "".equals(userId)) || (password == null)) {
			throw new IllegalArgumentException(
					"Cannot pass null or empty values to constructor");
		}
		this.userId = userId;
		this.password = password;
		this.enabled = enabled; // true로 설정
		this.accountNonExpired = accountNonExpired; // true로 설정
		this.credentialsNonExpired = credentialsNonExpired; // true로 설정
		this.accountNonLocked = accountNonLocked; // true로 설정
		this.authorities = authorities;
		
	}	
	
	private static Collection<? extends GrantedAuthority> getAuth(MemberVO memberVO) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (AuthVO auth : memberVO.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}
		return authorities;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	   
	
}