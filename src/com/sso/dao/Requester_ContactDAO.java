package com.sso.dao;

import java.util.List;

import com.sso.model.Requester_Contact;

public interface Requester_ContactDAO {
	public void saveOrUpdate(Requester_Contact reqcontact);
    
    public void delete(int requester_ID);
     
    public Requester_Contact get(int requester_ID);
     
    public List<Requester_Contact> list();
}
