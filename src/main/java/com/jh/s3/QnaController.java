package com.jh.s3;



import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jh.s3.model.board.QnaVO;
import com.jh.s3.service.board.QnaService;
import com.jh.s3.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {
		
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value = "qnaList")
	public void qnaList(Model model, Pager pager)throws Exception{
			List<QnaVO> ar = qnaService.qnaList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
	}
	
	
}
