package com.spring.example.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.spring.example.persistence.dao.IRoleDao;
import com.spring.example.persistence.dao.common.AbstractHibernateDao;
import com.spring.example.persistence.model.Role;

@Repository
public class RoleDao extends AbstractHibernateDao<Role> implements IRoleDao {

	public RoleDao() {
        super();
        setClazz(Role.class);
    }
	
}