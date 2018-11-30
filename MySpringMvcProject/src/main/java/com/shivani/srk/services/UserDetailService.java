package com.shivani.srk.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivani.srk.dao.PersonDao;
import com.shivani.srk.pojos.Address;
import com.shivani.srk.pojos.ImageFile;
import com.shivani.srk.pojos.UserDetails;

@Service
public class UserDetailService {

	private @Autowired PersonDao personDAO;
	
	@Transactional
	public void insert(UserDetails person) {
		personDAO.create(person);

	} 

	@Transactional
	public UserDetails getData(int i) {
		return (UserDetails) personDAO.find(i);
	}

	@Transactional
	public void delete(int i) {
		personDAO.delete(i);
	}

	@Transactional
	public List<Address> getAddress(Integer attribute) {
		// TODO Auto-generated method stub
		return personDAO.getAddress(attribute);
	}

	@Transactional
	public List<ImageFile> getFile(Integer attribute) {
		// TODO Auto-generated method stub
		return personDAO.getFile(attribute);
	}

	public List<UserDetails> findAll(Integer integer) {
		return personDAO.findAll(integer);
	}
} 	


