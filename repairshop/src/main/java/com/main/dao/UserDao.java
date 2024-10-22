package com.main.dao;

import java.util.List;

import com.main.model.User;

public interface UserDao extends BasicDao<User> {
	User findByEmail(String email, String type);

	List<User> findByName(String name, String type);
}
