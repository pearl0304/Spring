package kr.co.kmarket.dao;


import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.TermsVo;

@Repository
public interface MemberDao {
	
	public MemberVo	selectMember(MemberVo vo);
	public void insertMember(MemberVo vo);
	public TermsVo selectTerms(TermsVo vo);

}
