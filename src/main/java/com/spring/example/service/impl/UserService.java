package com.spring.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.example.persistence.dao.IUserDao;
import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.User;
import com.spring.example.service.IUserService;
import com.spring.example.service.common.AbstractService;

@Service
public class UserService extends AbstractService<User> implements IUserService {

	@Autowired(required=true)
    private IUserDao dao;
	
	@Autowired
	PasswordEncoder passwordEncoder; 

    public UserService() {
        super();
    }

	@Override
	protected IOperations<User> getDao() {
		 return dao;
	}

	@Override
    public void create(final User entity) {
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        getDao().create(entity);
    }

	@Override
	public List<User> listPaginatedUsers(int startIndex,int numberOfRecordsToFetch) {
		return dao.listPaginatedUsers(startIndex, numberOfRecordsToFetch);
	}
	
	@Override
	public User getUserById(String id) {
		List<User> list = dao.getUserById(id);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User setUserAccountAccessControl(User user) {
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		return user;
	}
}
