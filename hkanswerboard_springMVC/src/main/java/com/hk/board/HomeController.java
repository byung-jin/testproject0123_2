package com.hk.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.board.dtos.AnsDto;
import com.hk.board.service.AnsService;
import com.hk.board.service.IAnsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IAnsService ansService;//객체생성안하고 스프링이 만들어서 넣어줄거임

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		System.out.println(formattedDate);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/boardlist.do" , method=RequestMethod.GET)
	public String boardList(HttpServletRequest request, Locale locale,Model model) {
		logger.info("글목록조회 {}.", locale);
		
		//---조회수를 증가시킨 글번호를 초기화한다.(삭제)
		request.getSession().removeAttribute("readcount");
		
		List<AnsDto> list=ansService.getAllList();
		model.addAttribute("list", list);
		return "boardlist";
	}
	
	@RequestMapping(value="/detailboard.do" , method=RequestMethod.GET)
	public String detailBoard(HttpServletRequest request, Locale locale,Model model,String seq) {
		logger.info("글상세조회 {}.", locale);
		int sseq=Integer.parseInt(seq);
		//---조회수 증가에 대한 처리
		String rseq=(String)request.getSession().getAttribute("readcount");
		if(rseq==null) {
			ansService.readCount(sseq);
		}
		request.getSession().setAttribute("readcount", seq);
		//---조회수증가 처리 종료
		
		AnsDto dto=ansService.getBoard(sseq);
		model.addAttribute("dto", dto);
		return "boarddetail";
	}
	
	@RequestMapping(value="/updateform.do" , method=RequestMethod.GET)
	public String updateForm(Locale locale,Model model,String seq) {
		logger.info("글수정폼이동 {}.", locale);
		int sseq=Integer.parseInt(seq);
		AnsDto dto=ansService.getBoard(sseq);
		model.addAttribute("dto", dto);
		return "boardupdate";
	}
	
	@RequestMapping(value="/delboard.do" , method=RequestMethod.GET)
	public String delBoard(Locale locale,Model model,String seq) {
		logger.info("글삭제하기 {}.", locale);
		int sseq=Integer.parseInt(seq);
		boolean isS=ansService.delBoard(sseq);
		if(isS) {
			//바로 페이지로 이동한다면 그냥 "페이지이름"만 작성하면 되고 
			//controller를 들렸다가 가야 되는 경우이면 boardlist.do 라고 요청해야 되고
			//기존에 페이지 이동방식으로 즉, viewResolver가 실행되지 않고 가야 되므로
			//"redirect"를 붙여줘야 한다
			return "redirect:boardlist.do";
		}else {
			model.addAttribute("msg", "글삭제실패");
			return "error";
		}
	}
	
	@RequestMapping(value="/replyboard.do" , method=RequestMethod.POST)
	public String replyBoard(Locale locale,Model model,AnsDto dto) {
		logger.info("답글달기 {}.", locale);
		boolean isS=ansService.replyBoard(dto);
		if(isS) {
			return "redirect:boardlist.do";
		}else {
			model.addAttribute("msg", "답글달기실패");
			return "error";
		}
	}
	
	@RequestMapping(value="/boardupdate.do" , method=RequestMethod.POST)
	public String updateBoard(Locale locale,Model model,AnsDto dto) {
		logger.info("글수정하기 {}.", locale);
		boolean isS=ansService.updateBoard(dto);
		if(isS) {
			return "redirect:detailboard.do?seq="+dto.getSeq();
		}else {
			model.addAttribute("msg", "수정하기실패");
			return "error";
		}
	}
	
	@RequestMapping(value="/insertform.do" , method=RequestMethod.GET)
	public String insertform(Locale locale) {
		logger.info("글추가폼이동 {}.", locale);
		return "boardinsert";
	}
	
	@RequestMapping(value="/insertboard.do" , method=RequestMethod.POST)
	public String insertBoard(Locale locale,Model model,AnsDto dto) {
		logger.info("글추가하기 {}.", locale);
		boolean isS=ansService.insertBoard(dto);
		if(isS) {
			return "redirect:boardlist.do";
		}else {
			model.addAttribute("msg", "글추가하기실패");
			return "error";
		}
	}
	@RequestMapping(value="/muldel.do" , method=RequestMethod.POST)
	public String mulDel(Locale locale,Model model,String[] chk) {
		logger.info("글여러개삭제하기 {}.", locale);
		boolean isS=ansService.mulDelBoard(chk);
		if(isS) {
			return "redirect:boardlist.do";
		}else {
			model.addAttribute("msg", "글여러개삭제하기실패");
			return "error";
		}
	}
	
	//viewResolver를 실행하지 않고 리턴값을 요청했던 페이지로 값을 보내준다.
	@ResponseBody
	@RequestMapping(value="/detailajax.do" , method=RequestMethod.POST)
	public Map<String, AnsDto> detailAjax(String seq,Locale locale,Model model) {
		logger.info("글내용미리보기 {}.", locale);
		int sseq=Integer.parseInt(seq);
		AnsDto aDto=ansService.getDetailAjax(sseq);
		Map<String,AnsDto>map=new HashMap<>();
		map.put("dto", aDto);
		return map;
	}
}







