package com.sso.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sso.dao.Requester_ContactDAO;

import com.sso.model.Requester_Contact;


public class RequestController {
	@Autowired
    private Requester_ContactDAO requester_contactDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listReqContact(ModelAndView model) throws IOException{
	    List<Requester_Contact> listreq = requester_contactDAO.list();
	    model.addObject("listReq", listreq);
	    model.setViewName("home");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newReqContact", method = RequestMethod.GET)
	public ModelAndView newReqContact(ModelAndView model) {
	    Requester_Contact newReqCon = new Requester_Contact();
	    model.addObject("Requester_Contact", newReqCon);
	    model.setViewName("Requester_ContactForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveReqContact", method = RequestMethod.POST)
	public ModelAndView saveReqContact(@ModelAttribute Requester_Contact req_contact) {
		requester_contactDAO.saveOrUpdate(req_contact);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteReqContact", method = RequestMethod.GET)
	public ModelAndView deleteReqContact(HttpServletRequest request) {
	    int requesterId = Integer.parseInt(request.getParameter("id"));
	    requester_contactDAO.delete(requesterId);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editReqContact", method = RequestMethod.GET)
	public ModelAndView editReqContact(HttpServletRequest request) {
	    int requesterId = Integer.parseInt(request.getParameter("id"));
	    Requester_Contact req_contact = requester_contactDAO.get(requesterId);
	    ModelAndView model = new ModelAndView("Req_contactForm");
	    model.addObject("Requester_Contact", req_contact);
	 
	    return model;
	}

	

}
