package com.sso.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sso.dao.Technical_ContactDAO;
import com.sso.model.Technical_Contact;
public class TechnicalController {
	@Autowired
    private Technical_ContactDAO tech_contactDAO;
	
@RequestMapping(value="/")
	public ModelAndView listTechContact(ModelAndView model) throws IOException{
	    List<Technical_Contact> listtech = tech_contactDAO.list();
	    model.addObject("listTech", listtech);
	    model.setViewName("home");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newTechContact", method = RequestMethod.GET)
	public ModelAndView newTechContact(ModelAndView model) {
	    Technical_Contact newTechCon = new Technical_Contact();
	    model.addObject("Technical_Contact", newTechCon);
	    model.setViewName("Technical_ContactForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveTechContact", method = RequestMethod.POST)
	public ModelAndView saveTechContact(@ModelAttribute Technical_Contact tech_contact) {
		tech_contactDAO.saveOrUpdate(tech_contact);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteTechContact", method = RequestMethod.GET)
	public ModelAndView deleteTechContact(HttpServletRequest request) {
	    int techId = Integer.parseInt(request.getParameter("id"));
	    tech_contactDAO.delete(techId);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editTechContact", method = RequestMethod.GET)
	public ModelAndView editTechContact(HttpServletRequest request) {
	    int techId = Integer.parseInt(request.getParameter("id"));
	    Technical_Contact tech_contact = tech_contactDAO.get(techId);
	    ModelAndView model = new ModelAndView("tech_contactForm");
	    model.addObject("Tech_Contact", tech_contact);
	 
	    return model;
	}


}
