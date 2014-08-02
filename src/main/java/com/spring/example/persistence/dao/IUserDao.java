package com.spring.example.persistence.dao;

import java.util.List;

import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.User;

public interface IUserDao extends IOperations<User>{
	List<User> listPaginatedUsers(int startIndex , int numberOfRecordsToFetch);
	List<User> getUserById(String id);
}

