package edu.kosmo.pse.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kosmo.pse.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberService {
	
	@Inject
	private BCryptPasswordEncoder passwordEncoder;
	
	@Inject
	private MemberMapper memberMapper;
	
	//@Transactional(rollbackFor = Exception.class)
	public void addMember(String id) {
		log.info("addMember()...");
		
		
	}
	
	
}
