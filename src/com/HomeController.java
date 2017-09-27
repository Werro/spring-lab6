package com;
	//import javax.inject.Inject;
	import java.util.Map;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	//import com.habuma.spitter.service.SpitterService;
	
@Controller // �������� ��� ����������	
public class HomeController {
	
	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
	
	@RequestMapping({"/","/home"}) 
	// ������� ��������
	public String showHomePage(Map<String, Object> model) {
	//model.put("spittles", spitterService.getRecentSpittles(
	//DEFAULT_SPITTLES_PER_PAGE)); 
	System.out.println("test");
	return "home"; 
	}
	
}
