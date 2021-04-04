package edu.hebeu.test;

import org.junit.Test;

import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.po.User;

public class TestUserDao {
	
	@Test
    public void findUser(){
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		User user=userDaoImpl.findUserByNameAndPassword("admin","000000");
        System.out.println(user);
    }
}
