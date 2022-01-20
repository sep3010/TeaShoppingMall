package edu.kosmo.pse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.pse.vo.AuthVO;
import edu.kosmo.pse.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	@Select("SELECT * FROM member WHERE user_id = #{id}")
	public MemberVO readMember(String id);
	
	@Select("SELECT au.authority FROM member m, authorities au WHERE m.grade_id = au.grade_id and m.user_id = #{id}")
	public List<AuthVO> readAuthority(String id);
	
}
