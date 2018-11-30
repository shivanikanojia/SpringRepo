package com.shivani.srk.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivani.srk.dao.PersonDao;
import com.shivani.srk.pojos.Address;

@Service
public class AddressService {
	
	private @Autowired PersonDao personDAO;
	
	@Transactional
	public void insert(Address address) {
		personDAO.create(address);

	}

	public Address getData(int i) {
		return (Address) personDAO.find(i);
	}

	public void delete(int i) {
		personDAO.delete(i);
	}

}
