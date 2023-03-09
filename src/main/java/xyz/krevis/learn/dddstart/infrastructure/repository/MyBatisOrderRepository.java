package xyz.krevis.learn.dddstart.infrastructure.repository;

import xyz.krevis.learn.dddstart.domain.model.Order;
import xyz.krevis.learn.dddstart.domain.model.OrderNumber;
import xyz.krevis.learn.dddstart.domain.repository.OrderRepository;

public class MyBatisOrderRepository implements OrderRepository {

    @Override
    public Order findByNumber(OrderNumber number) {
        return null;
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void delete(Order order) {

    }
}
