package edu.hebeu.test;

import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.po.User;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		User user=userDaoImpl.findUserByNameAndPassword("admin","000000");
        System.out.println(user);
	}

}
