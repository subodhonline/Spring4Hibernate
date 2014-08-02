package com.spring.example.service;

import java.util.List;

import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.User;

public interface IUserService extends IOperations<User>{
	List<User> listPaginatedUsers(int startIndex , int numberOfRecordsToFetch);
	User getUserById(String id);
	User setUserAccountAccessControl(User user);
}
