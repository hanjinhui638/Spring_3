package com.jh.s3;

import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import com.jh.s3.model.board.NoticeVO;
import com.jh.s3.service.board.NoticeService;
import com.jh.s3.util.Pager;
import com.jh.s3.util.RowMaker;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {

	@Inject
	private NoticeService noticeService;

	// List : /notice/noticeList GET
	// View : /WEB-INF/views/notice/noticeList.jsp

	/* Delete */

	@RequestMapping("noticeDelete")
	public ModelAndView noticeDelete(int num) throws Exception {
		int result = noticeService.noticeDelete(num);
		ModelAndView mv = new ModelAndView();

		if (result > 0) {
			mv.addObject("msg", "delete Success");
		} else {
			mv.addObject("msg", "delete Fail");
		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");

		return mv;
	}

	/* Update */
	@RequestMapping("noticeUpdate")
	public void noticeUpdate(Model model, int num) throws Exception {
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		model.addAttribute("noticeVO", noticeVO);
	}

	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeVO noticeVO) throws Exception {

		int result = noticeService.noticeUpdate(noticeVO);
		ModelAndView mv = new ModelAndView();

		if (result > 0) {
			mv.addObject("msg", "Update Success");

		} else {
			mv.addObject("msg", "Update Fail");

		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");

		return mv;
	}

	/* write */
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeVO noticeVO) throws Exception {
		int result = noticeService.noticeInsert(noticeVO);
		ModelAndView mv = new ModelAndView();

		if (result > 0) {
			mv.addObject("msg", "Write Success");

		} else {
			mv.addObject("msg", "Write Fail");

		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");

		return mv;
	}

	@RequestMapping("noticeWrite")
	public void noticeWrite() throws Exception {

	}

	// Select
	@RequestMapping("noticeSelect")
	public ModelAndView noticeSelect(int num) throws Exception {
		ModelAndView mv = new ModelAndView();
		NoticeVO noticeVO = noticeService.noticeSelect(num);

		if (noticeVO == null) {
			mv.addObject("msg", "존재하지 않는 글번호입니다.");
			mv.addObject("path", "noticeList");
			mv.setViewName("common/common_result");
		} else {
			mv.addObject("noticeVO", noticeVO);
			mv.setViewName("notice/noticeSelect");
		}

		return mv;
	}

	// List
	@RequestMapping(value = "noticeList", method = RequestMethod.GET) /* pager 객체 생성 */
	public void noticeList(Model model, Pager pager, RowMaker rowMaker) throws Exception {
		List<NoticeVO> ar = noticeService.noticeList(pager, rowMaker);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		model.addAttribute("rowMaker", rowMaker);
		
		
		
	}

}
