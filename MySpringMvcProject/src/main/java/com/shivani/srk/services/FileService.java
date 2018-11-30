package com.shivani.srk.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivani.srk.dao.PersonDao;
import com.shivani.srk.pojos.ImageFile;


@Service
public class FileService {

	private @Autowired PersonDao personDAO;
	
	@Transactional
	public void insert(ImageFile file) {
		personDAO.create(file);

	}

	public ImageFile getData(int i) {
		return (ImageFile) personDAO.find(i);
	}

	public void delete(int i) {
		personDAO.delete(i);
	}
	
}
