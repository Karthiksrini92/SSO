package com.sso.dao;


	import java.util.List;

	import com.sso.model.Technical_Contact;

	public interface Technical_ContactDAO {
	public void saveOrUpdate(Technical_Contact techcontact);
	    
	    public void delete(int technical_ID);
	     
	    public Technical_Contact get(int technical_ID);
	     
	    public List<Technical_Contact> list();
	}

