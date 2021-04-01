package edu.hebeu.proxy;

public class Producer implements IProducer{

    public void saleProduce(float money) {
        System.out.println("销售商品成功！获取金额：$" + money);
    }

    public void saleAfterService(float money) {
        System.out.println("进行售后服务，赚取：$" + money);
    }
}
