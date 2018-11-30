package com.shivani.srk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shivani.srk.dao.LoginDao;
import com.shivani.srk.pojos.UserDetails;

@Service
@ComponentScan("com.shivani.srk.dao")
public class LoginService {

		 @Autowired
		 private LoginDao loginDAO;

		   @Transactional
	      public UserDetails checkLogin(String userName, String userPassword){
	    	  
	             System.out.println("In Service class...Check Login");
	             return loginDAO.checkLogin(userName, userPassword);
	      
	      }
	}


