package edu.hebeu.dao.impl;

import edu.hebeu.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class IAccountDaoImpl1 implements IAccountDao {

    public void insertAccount() {
        System.out.println("添加账户成功！11111111111111111111");
    }
}
