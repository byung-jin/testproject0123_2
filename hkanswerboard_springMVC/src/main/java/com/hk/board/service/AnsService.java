package com.hk.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.board.dtos.AnsDto;
import com.hk.board.imps.IAnsDao;

@Service
public class AnsService implements IAnsService{

	@Autowired
	private IAnsDao ansDao;
	
	@Override
	public List<AnsDto> getAllList() {
		return ansDao.getAllList();
	}

	@Override
	public AnsDto getBoard(int seq) {
		return ansDao.getBoard(seq);
	}

	@Override
	public boolean insertBoard(AnsDto dto) {
		return ansDao.insertBoard(dto);
	}

	@Override
	public boolean updateBoard(AnsDto dto) {
		return ansDao.updateBoard(dto);
	}

	@Override
	public boolean delBoard(int seq) {
		return ansDao.delBoard(seq);
	}
	
	@Override
	public boolean mulDelBoard(String[] seq) {
		return ansDao.mulDelBoard(seq);
	}

	@Override
	public boolean readCount(int seq) {
		return ansDao.readCount(seq);
	}

//	@Transactional
	@Override
	public boolean replyBoard(AnsDto dto) {
		int count=0;
		ansDao.replyBoardUpdate(dto.getSeq());
		count=ansDao.replyBoardInsert(dto);
		return count>0?true:false;
	}

	@Override
	public AnsDto getDetailAjax(int seq) {
		return ansDao.getDetailAjax(seq);
	}

}





