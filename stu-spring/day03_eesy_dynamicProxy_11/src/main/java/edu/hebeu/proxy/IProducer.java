package edu.hebeu.proxy;

public interface IProducer {

    /**
     * 销售商品
     * @param money
     */
    void saleProduce(float money);

    /**
     * 售后
     * @param money
     */
    void saleAfterService(float money);
}
