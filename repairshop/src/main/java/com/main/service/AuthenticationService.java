package com.main.service;

import com.main.model.User;

public interface AuthenticationService {
	User login(String email, String password, String type);

	User register(String name, String email, String phone, String password, User createdBy, String type);
}
