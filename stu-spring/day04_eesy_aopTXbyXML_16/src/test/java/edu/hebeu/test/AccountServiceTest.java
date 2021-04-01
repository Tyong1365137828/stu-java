package edu.hebeu.test;

import edu.hebeu.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void transferTest() {
        accountService.transfer("aaa", "ccc", 10000f);
    }

}
