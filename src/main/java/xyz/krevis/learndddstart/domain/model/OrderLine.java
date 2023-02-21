package xyz.krevis.learndddstart.domain.model;

import lombok.Getter;

/**
 * 주문 항목
 */
@Getter
public class OrderLine {

    private Product product;

    private Money price;

    private int quantity;

    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = new Money(price.getValue());
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    /**
     * 구매 가격을 정한다
     */
    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}
