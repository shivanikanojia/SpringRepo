package com.shivani.srk.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shivani.srk.pojos.UserDetails;

@Repository
public class LoginDao extends GenericDaoImpl<UserDetails> {

	public UserDetails checkLogin(String userName, String userPassword){

		System.out.println("In Check login");

		//		Session session = sessionFactory.openSession();

//		boolean userFound = false;

		//Query using Hibernate Query Language

		String SQL_QUERY =" from UserDetails o where o.userName=:a and o.password=:b";

		Query query = (Query) this.em.createQuery(SQL_QUERY, UserDetails.class);

		query.setParameter("a",userName);
		query.setParameter("b",userPassword);
//		query.executeUpdate();

		UserDetails ud = (UserDetails) query.getSingleResult();

		return ud;              
	}


	}

