package edu.kosmo.pse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.pse.mapper.MemberMapper;
import edu.kosmo.pse.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Transactional(rollbackFor = Exception.class)	
	public void addMember(MemberVO memberVO) {
		log.info("addMember()...");
		String password = memberVO.getPassword();
		String encode = passwordEncoder.encode(password);
		
		memberVO.setPassword(encode);
		
		String purchaseGrade = "BRONZE";
		memberVO.setPurchaseGrade(purchaseGrade);
		
		memberMapper.insertMember(memberVO);
		memberMapper.insertAuthorities(memberVO);
		
	}
	
	
}
