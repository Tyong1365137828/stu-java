package edu.hebeu.controller;

import edu.hebeu.entity.Account;
import edu.hebeu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 表现层
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/add")
    public void addC(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Account account = new Account();
//        String name = UUID.randomUUID().toString();
//        name = name.substring(name.length() - 5);
//        account.setName(name);
//        account.setMoney(5855259895.03);

        accountService.addAccount(account);

        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return;
    }

    @RequestMapping("/findAll")
    public String findAllC(Model model) {
        List<Account> accounts = accountService.findAccount();
        model.addAttribute("accountList", accounts);
        return "success";
    }
}
