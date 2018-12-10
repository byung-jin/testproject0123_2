package com.hk.board.service;

import java.util.List;

import com.hk.board.dtos.AnsDto;

public interface IAnsService {

	public List<AnsDto>getAllList();
	public AnsDto getBoard(int seq);
	public boolean insertBoard(AnsDto dto);
	public boolean updateBoard(AnsDto dto);
	public boolean delBoard(int seq);
	public boolean mulDelBoard(String[] seq);
	public boolean readCount(int seq);
	public boolean replyBoard(AnsDto dto);
	public AnsDto getDetailAjax(int seq);
}




