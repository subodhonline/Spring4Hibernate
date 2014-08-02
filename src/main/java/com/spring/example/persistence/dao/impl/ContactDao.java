package com.spring.example.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.spring.example.persistence.dao.IContactDao;
import com.spring.example.persistence.dao.common.AbstractHibernateDao;
import com.spring.example.persistence.model.Contact;

@Repository
public class ContactDao extends AbstractHibernateDao<Contact> implements IContactDao {

	public ContactDao() {
        super();
        setClazz(Contact.class);
    }
	
}