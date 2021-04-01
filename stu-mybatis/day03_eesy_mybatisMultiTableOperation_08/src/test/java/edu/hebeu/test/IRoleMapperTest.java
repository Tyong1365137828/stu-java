package edu.hebeu.test;

import edu.hebeu.dao.IRoleMapper;
import edu.hebeu.entity.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IRoleMapperTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IRoleMapper iRoleMapper;

    @Before
    public void start() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        iRoleMapper = sqlSession.getMapper(IRoleMapper.class);
    }

    @After
    public void end() throws IOException{
        if (inputStream != null) {
            inputStream.close();
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void selectRoleAllTest() {
        List<Role> roles = iRoleMapper.selectRoleAll();
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void selectRoleAllMMTest() {
        List<Role> roles = iRoleMapper.selectRoleAllMM();
        for (Role role : roles) {
            System.out.println("一条role记录");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

}
