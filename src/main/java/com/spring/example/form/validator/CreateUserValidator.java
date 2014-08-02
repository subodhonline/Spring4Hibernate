package com.spring.example.form.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.example.persistence.model.User;

public class CreateUserValidator implements Validator{

	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		System.out.println("=========== hi =========");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastname.required");
	}


}
