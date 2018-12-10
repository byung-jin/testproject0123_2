package com.hk.board.imps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.board.dtos.AnsDto;

@Repository
public class AnsDao implements IAnsDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace="com.hk.ansboard.";
	
	@Override
	public List<AnsDto> getAllList() {
		return sqlSession.selectList(namespace+"getAllContent");
	}

	@Override
	public AnsDto getBoard(int seq) {
		return sqlSession.selectOne(namespace+"getBoard", seq);
	}

	@Override
	public boolean insertBoard(AnsDto dto) {
		
		int count=0;
		count=sqlSession.insert(namespace+"insertBoard", dto);
		return count>0?true:false;
	}

	@Override
	public boolean updateBoard(AnsDto dto) {
		int count=0;
		count=sqlSession.update(namespace+"updateBoard", dto);
		return count>0?true:false;
	}

	@Override
	public boolean delBoard(int seq) {
		int count=0;
		count=sqlSession.update(namespace+"delBoard", seq);
		return count>0?true:false;
	}

	@Override
	public boolean mulDelBoard(String[] seq) {
		Map<String, String[]>map=new HashMap<String, String[]>();
		map.put("seqs", seq);
		int count=0;
		count=sqlSession.update(namespace+"mulDelBoard", map);
		return count>0?true:false;
	}

	@Override
	public boolean readCount(int seq) {
		int count=0;
		count=sqlSession.update(namespace+"readCount", seq);
		return count>0?true:false;
	}

	@Override
	public int replyBoardUpdate(int seq) {
		return sqlSession.update(namespace+"replyBoard", seq);
	}

	@Override
	public int replyBoardInsert(AnsDto dto) {
		return sqlSession.insert(namespace+"replyInsert", dto);
	}

	@Override
	public AnsDto getDetailAjax(int seq) {
		return sqlSession.selectOne(namespace+"datailAjax", seq);
	}

}




