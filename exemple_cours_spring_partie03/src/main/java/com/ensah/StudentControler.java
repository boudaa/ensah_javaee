package com.ensah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ensah.service.IStudentService;

@Controller
//@RequestMapping("/students")
public class StudentControler {
	
	
	@Autowired
	private IStudentService service;
	

	@RequestMapping("/test")
	public String showMsg() {

		// Acceder a la base de données

		service.create();
		
		//On returne la vue 
		return "hello"; //==> preffix + bonjour + .jsp 
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {		
		
		Student s = new Student();
		
	    s.setFirstName("Boudaa");
	    s.setLastName("Tarik");
	    s.setEmail("tarikboudaa@yahoo.fr");
		
		
		model.addAttribute("student_model",s);	
		
		
		return "form";
	}

	@RequestMapping("/addStudent")
	public String process(@ModelAttribute("student_model") Student pStudent) {	
		
		//on va faire 
		
		System.out.println(pStudent);
		return "hello";
	}
}
