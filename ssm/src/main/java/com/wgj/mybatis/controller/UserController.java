package com.wgj.mybatis.controller;

import com.wgj.mybatis.inter.IUserOperation;
import com.wgj.mybatis.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/article")
public class UserController {
	@Autowired
	IUserOperation userMapper;

	@RequestMapping("/list")
	public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) {
		List<Article> articles = userMapper.getUserArticles(1);
		System.out.println(articles);
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("articles", articles);
		return mav;
	}
}
