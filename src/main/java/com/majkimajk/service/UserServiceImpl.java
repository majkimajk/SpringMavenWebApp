package com.majkimajk.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.majkimajk.dao.UserDAO;
import com.majkimajk.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO user;
	
	@Override
	public List<User> getUsers() {
		
		List<User> theUsers = user.getUsers();
		
		return theUsers;
	}

	@Override
	public void saveUser(User theUser) {
		
		user.saveUser(theUser);

	}

	@Override
	public User getUser(int theId) {
		User theUser = user.getUser(theId);
		return theUser;
	}

	@Override
	public void deleteUser(int theId) {
		user.deleteUser(theId);

	}

}
