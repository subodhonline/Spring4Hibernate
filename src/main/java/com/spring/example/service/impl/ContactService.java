package com.spring.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.persistence.dao.IContactDao;
import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.Contact;
import com.spring.example.service.IContactService;
import com.spring.example.service.common.AbstractService;

@Service
public class ContactService extends AbstractService<Contact> implements IContactService {

	@Autowired(required=true)
    private IContactDao dao;

    public ContactService() {
        super();
    }

	@Override
	protected IOperations<Contact> getDao() {
		 return dao;
	}

}