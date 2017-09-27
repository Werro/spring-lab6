package com;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.catalog.Catalog;
@Controller
public class SearchController {
	Logger log = Logger.getLogger(SearchController.class.getName());
	
	@Autowired
	public Catalog catalog ;
	
	@RequestMapping(value = "/search.do" )
	
	public String getResults(){
		System.out.println("=============>	public String getResults() 2");
		System.out.println(catalog.findById(3L).getTitle());
		
		return "searchForm";
	}
	//  search3.do
	// /search3.do
	@RequestMapping(value = "/search3.do" ,  method = RequestMethod.POST)
	//public String processSearch(HttpServletRequest request ,HttpServletResponse response  ) {
	public ModelAndView processSearch(@RequestParam(value = "keyword" ,required = true) String keyword ,HttpServletRequest request ) {

		ModelAndView mav = new ModelAndView("searchResults") ;
		mav.addObject("testmodel",catalog.findByKeyword(keyword));
       // List<UserForm> userForms = yourDatabaseCall();
	//return null;
		//return "searchResults";
		System.out.println("return new model_view");
		return mav;// new ModelAndView("searchResults","results",catalog.findByKeyword(keyword));
	}

	
	
}
