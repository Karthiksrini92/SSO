package com.sso.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sso.dao.SSODAO;
import com.sso.model.*;


@Controller
public class HomeController {
	
	@Autowired
    private  SSODAO ssoDAO;

	
	@RequestMapping(value = "/newSSweewe",method = RequestMethod.GET)
	public ModelAndView listSSO(ModelAndView model) throws IOException{
		System.out.println("into");
	    List<SSO> listSSO = ssoDAO.list();
	    model.addObject("listSSO", listSSO);
	    model.setViewName("home");
	 System.out.println("inside");
	    return model;
	}
	
	@RequestMapping(value = "/newSSO.do", method = RequestMethod.GET)
	public ModelAndView newSSO(ModelAndView model) {
	    SSO newSSO = new SSO();
	    model.addObject("SSO", newSSO);
	    model.setViewName("home");
	    return model;
	}
	
	@RequestMapping(value = "/saveSSO", method = RequestMethod.POST)
	public ModelAndView saveSSO(@ModelAttribute SSO sso) {
	    SSODAO.saveOrUpdate(sso);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteSSO", method = RequestMethod.GET)
	public ModelAndView deleteSSO(HttpServletRequest request) {
	    int ssoId = Integer.parseInt(request.getParameter("id"));
	    ssoDAO.delete(ssoId);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editSSO", method = RequestMethod.GET)
	public ModelAndView editSSO(HttpServletRequest request) {
	    int ssoId = Integer.parseInt(request.getParameter("id"));
	    SSO sso = ssoDAO.get(ssoId);
	    ModelAndView model = new ModelAndView("SSOForm");
	    model.addObject("sso", sso);
	 
	    return model;
	}
	
}
