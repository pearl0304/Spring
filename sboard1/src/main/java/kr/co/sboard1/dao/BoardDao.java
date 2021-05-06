package kr.co.sboard1.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sboard1.vo.ArticleVo;
import kr.co.sboard1.vo.FileVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertArticle(ArticleVo vo) {
		// ���� insert ���� �� �ش� ���̺� ���� seq���� vo��ü seq����� ����
		// ��, ��� insert�� �� ��ȣ�� ����
		mybatis.insert("mapper.board.INSERT_ARTICLE", vo);
		return vo.getSeq();
	}
	
	public void insertFile(FileVo fvo) {
		mybatis.insert("mapper.board.INSERT_FILE", fvo);
	}
	
	public int selectCountArticle() {
		return mybatis.selectOne("mapper.board.SELECT_COUNT_ARTICLE");
	}
	
	public ArticleVo selectArticle(int seq) {
		return mybatis.selectOne("mapper.board.SELECT_ARTICLE", seq);
	}
	
	public List<ArticleVo> selectArticles(int start) {
		return mybatis.selectList("mapper.board.SELECT_ARTICLES", start);
	}
	
	
	
	
	
	public void updateArticle() {}
	public void deleteArticle() {}
}
