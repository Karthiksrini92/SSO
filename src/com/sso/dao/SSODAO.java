package com.sso.dao;
import java.util.List;


import com.sso.model.SSO;;
public interface SSODAO {
	public static void saveOrUpdate(SSO sso) {
		// TODO Auto-generated method stub
		
	}
    
    public void delete(int SSO_Request_ID);
     
    public SSO get(int SSO_Request_ID);
     
    public List<SSO> list();
}
