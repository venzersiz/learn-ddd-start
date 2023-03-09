package xyz.krevis.learn.dddstart.domain.repository;

import xyz.krevis.learn.dddstart.domain.model.Order;
import xyz.krevis.learn.dddstart.domain.model.OrderNumber;

public interface OrderRepository {

    Order findByNumber(OrderNumber number);

    void save(Order order);

    void delete(Order order);
}
