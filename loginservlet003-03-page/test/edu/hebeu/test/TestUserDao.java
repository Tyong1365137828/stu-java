package edu.hebeu.test;

import java.sql.Date;

import org.junit.Ignore;
import org.junit.Test;

import edu.hebeu.dao.UserDao;
import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.entity.User;

public class TestUserDao {

	/*
	public static void main(String[] args) {
		UserDao userDao=new UserDaoImpl();
        User user=userDao.findAll("龚炳江", "******");
        System.out.println(user);
	}
    */
	@Ignore
	@Test
	public void findAllTest(){
		UserDao userDao=new UserDaoImpl();
        User user=userDao.findByNameAndPwd("龚炳江", "******");
        System.out.println(user);
	}
	@Test
	public void saveTest(){
		User user=new User("1009","刘硕","123456",20,98.9,Date.valueOf("2017-09-01"),"游泳，音乐，跑步");
		UserDao userDao=new UserDaoImpl();
		int n=userDao.save(user);
		System.out.println(n);
	}
}
