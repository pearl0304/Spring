package kr.co.sboard1.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard1.dao.BoardDao;
import kr.co.sboard1.vo.ArticleVo;
import kr.co.sboard1.vo.FileVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public int insertArticle(ArticleVo vo) {
		return dao.insertArticle(vo);
	}
	
	public void insertFile(FileVo fvo) {
		dao.insertFile(fvo);
	}
		
	public int selectCountArticle() {
		return dao.selectCountArticle();
	}
	public ArticleVo selectArticle(int seq) {
		return dao.selectArticle(seq);
	}
	
	public List<ArticleVo> selectArticles(int start) {
		return dao.selectArticles(start);
	}
	
	public void updateArticle() {}
	public void deleteArticle() {}
	
	// �Խ��� ����Ʈ ������ ��ȣ ó������ �޼���
	public int getPageStartNum(int total, int start) {
		return total - start;
	}
	
	// �Խ��� ����Ʈ ������ ó������ �޼���
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		
		int groupCurrent = (int) Math.ceil(currentPage / 10.0);
		int groupStart   = (groupCurrent - 1) * 10 + 1;
		int groupEnd     = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
	// �Խ��� ����Ʈ ������ ó������ �޼���
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	// �Խ��� ����Ʈ ������ ó������ �޼���
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
	}
	// �Խ��� ����Ʈ ������ ó������ �޼���
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		
		return lastPageNum;
	}
	
	// ���� ���ε�
	public FileVo fileUpload(HttpServletRequest req, MultipartFile file, int seq) {
		
		// spring-context.xml - '/resources/file/' ��� �������
		String path = req.getSession().getServletContext().getRealPath("/resources/file/");
		
		if(!file.isEmpty()) {
			// ���� ÷�� ������
			String oName = file.getOriginalFilename();
			String ext = oName.substring(oName.lastIndexOf("."));
			
			// �������ϸ� ����
			String uName = UUID.randomUUID().toString()+ext;
			
			// ���� ����
			try {
				file.transferTo(new File(path+uName));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			FileVo vo = new FileVo();
			vo.setParent(seq);
			vo.setOldName(oName);
			vo.setNewName(uName);
			
			return vo;
			
		}else {
			// ���� ÷�� ��������
			return null;
		}	
	}
	
	
	// ���� �ٿ�ε�
	public void fileDownload() {
		
	}
	
}
