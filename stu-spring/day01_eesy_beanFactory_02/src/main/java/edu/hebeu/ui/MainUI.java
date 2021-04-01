package edu.hebeu.ui;

import edu.hebeu.service.IAccountService;
import util.factory.BeanFactory;

public class MainUI {

    public static void main(String[] args) {
        System.out.println("欢迎来到！");
        IAccountService iAccountService = (IAccountService) BeanFactory.getBeanForBeans("iAccountService");
        iAccountService.addAccount();

    }

}
