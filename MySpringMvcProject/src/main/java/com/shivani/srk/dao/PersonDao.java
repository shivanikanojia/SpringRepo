package com.shivani.srk.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.shivani.srk.pojos.Address;
import com.shivani.srk.pojos.ImageFile;
import com.shivani.srk.pojos.UserDetails;

@Repository
//@Transactional
public class PersonDao extends GenericDaoImpl<UserDetails> {

	public List<Address> getAddress(Integer attribute) {
	
//		return em.createQuery("from Address as a where a.userId=:userId").setParameter("userId", attribute).getResultList();
		return find(attribute).getAddress();
	}

	public List<ImageFile> getFile(Integer attribute) {
		return find(attribute).getFile();
	}

	public List<UserDetails> findAll(Integer integer) {
		System.out.println("In findAll()");

		String SQL_QUERY =" from UserDetails as u where u.userId <> :a ";

		Query query = (Query) this.em.createQuery(SQL_QUERY, UserDetails.class);
		query.setParameter("a", integer);
		return query.list();   
	}

	public UserDetails resetPass(String username) {
		System.out.println("In resetPass()");

		String SQL_QUERY =" from UserDetails as u where u.userName=:a ";
		Query query = (Query) this.em.createQuery(SQL_QUERY, UserDetails.class);

		query.setParameter("a", username);
		return (UserDetails) query.getSingleResult(); 
	}
	
} 