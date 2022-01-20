package edu.kosmo.pse.vo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
public class MemberCustom extends User {
	
	@Setter(onMethod_ = @Autowired)
	private MemberVO memberVO;
	   
	public MemberCustom(String user_name, String password, Collection<? extends GrantedAuthority> authorities) {
		super(user_name, password, authorities);
	}

	public MemberCustom(MemberVO memberVO) {

		super(memberVO.getUser_name(), memberVO.getPassword(), getAuth(memberVO));

		this.memberVO = memberVO;
	}

	public static Collection<? extends GrantedAuthority> getAuth(MemberVO memberVO) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (AuthVO auth : memberVO.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}

		return authorities;
	}
}
