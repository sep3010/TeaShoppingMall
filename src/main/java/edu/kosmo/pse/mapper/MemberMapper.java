package edu.kosmo.pse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.pse.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	// 유저 정보를 볼러온다.
	public MemberVO getMember(String userId);
	
	// 회원 가입시 입력한 정보를 저장.
	public void insertMember(MemberVO memberVO);
	
	// 가입시 권한 설정
	@Insert("insert into AUTHORITIES values(#{userId},'ROLE_USER')")
	public void insertAuthorities(MemberVO memberVO);
	
	// 전체 회원 목록을 불러오기
	public List<MemberVO> getMemberList();
}
