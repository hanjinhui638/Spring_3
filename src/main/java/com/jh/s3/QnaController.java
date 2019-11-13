package com.jh.s3;



import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s3.model.board.NoticeVO;
import com.jh.s3.model.board.QnaVO;
import com.jh.s3.service.board.NoticeService;
import com.jh.s3.service.board.QnaService;
import com.jh.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
		
	@Inject
	private QnaService qnaService;
	
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public String qnaReply(QnaVO qnaVO)throws Exception{
		int result = qnaService.qnaReply(qnaVO);
		return "redirect:./qnaList";
		
	}
	
	
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public void qnaReply(int num, Model model) throws Exception{
		model.addAttribute("num", num); /* 변수명 자체가 이름 작동이 잘 안될때도 있음 */
		
	}
	
	
	
	@RequestMapping("qnaSelect")
	public ModelAndView qnaSelect(int num)throws Exception{
		ModelAndView mv = new ModelAndView();
		QnaVO qnaVO	= qnaService.qnaSelect(num);
		
		if (qnaVO == null) {
			mv.addObject("msg", "존재하지 않는 글번호입니다.");
			mv.addObject("path", "qnaList");
			mv.setViewName("common/common_result");
		} else {
			mv.addObject("qnaVO", qnaVO);
			mv.setViewName("qna/qnaSelect");
		}
		
		
		return mv;
		
	}
	
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public String qnaWrite(QnaVO qnaVO)throws Exception{
		/*
		 * System.out.println(qnaVO.getTitle()); 
		 * System.out.println(qnaVO.getWriter());
		 * System.out.println(qnaVO.getContents());
		 */
		int result = qnaService.qnaWrite(qnaVO);
		return "redirect:./qnaList";
		
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public void qnaWrite()throws Exception{
					
	}
	
	
	@RequestMapping(value = "qnaList", method = RequestMethod.GET )
	public ModelAndView qnaList(Pager pager)throws Exception{
		/*
		 * System.out.println(pager.getKind()); 
		 * System.out.println(pager.getSearch());
		 */
			List<QnaVO> ar = qnaService.qnaList(pager);
			ModelAndView mv = new ModelAndView();
			mv.addObject("list", ar);
			mv.addObject("pager", pager);
			mv.setViewName("qna/qnaList");
			
			return mv;
		/*model.addAttribute("list", ar);*/
	}
	
	
	
	
}
