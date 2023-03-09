package xyz.krevis.learn.dddstart.exception;

import xyz.krevis.learn.dddstart.domain.model.OrderNumber;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(OrderNumber number) {
        super(number.toString());
    }
}
