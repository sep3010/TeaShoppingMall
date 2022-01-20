package edu.kosmo.pse.service;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kosmo.pse.mapper.MemberMapper;
import edu.kosmo.pse.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberService {
	
	@Inject
	private BCryptPasswordEncoder passwordEncoder;
	
	@Inject
	private MemberMapper memberMapper;
	
	//@Transactional(rollbackFor = Exception.class)
	public void readMember(String id) {
		log.info("readMember()...");
		
		MemberVO memberVO = memberMapper.readMember(id);
		memberVO.setAuthList(memberMapper.readAuthority(id));
	}
	
	
}
