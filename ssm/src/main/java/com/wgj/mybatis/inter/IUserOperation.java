package com.wgj.mybatis.inter;

import java.util.List;

import com.wgj.mybatis.model.Article;
import com.wgj.mybatis.model.User;

public interface IUserOperation {
	public User selectUserByID(int id);

	public List<User> selectUsers(String userName);

	public void addUser(User user);

	public void updateUser(User user);

	public boolean deleteUser(int id);
	
	public List<Article> getUserArticles(int id);

}