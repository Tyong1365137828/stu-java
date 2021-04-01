package edu.hebeu.dao.impl;

import edu.hebeu.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class IAccountDaoImpl2 implements IAccountDao {

    public void insertAccount() {
        System.out.println("插入账户成功！2222222222222222222");
    }
}
