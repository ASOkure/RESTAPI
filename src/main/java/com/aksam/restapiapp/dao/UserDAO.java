package com.aksam.restapiapp.dao;

import java.util.List;

import com.aksam.restapiapp.exception.CustomException;
import com.aksam.restapiapp.model.User;

public interface UserDAO {
	
	
	List<User> getAllUsers() throws CustomException;

	User getUserById(long userId) throws CustomException;

	User getUserByName(String userName) throws CustomException;

	/**
	 * @param user:
	 * user to be created
	 * @return userId generated from insertion. return -1 on error
	 */
	long insertUser(User user) throws CustomException;

	int updateUser(Long userId, User user) throws CustomException;

	int deleteUser(long userId) throws CustomException;


}
