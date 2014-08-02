package com.spring.example.service;

import java.util.Map;

import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.Role;

public interface IRoleService extends IOperations<Role>{
	Map<String,String> getAllRole();
}
