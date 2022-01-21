package edu.kosmo.pse.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.pse.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	public MemberVO getMember(String userId);
	
	// public void insertMember(MemberVO memberVO);
	
	
}
