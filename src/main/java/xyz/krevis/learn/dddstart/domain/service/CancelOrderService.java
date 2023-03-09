package xyz.krevis.learn.dddstart.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import xyz.krevis.learn.dddstart.domain.model.Order;
import xyz.krevis.learn.dddstart.domain.model.OrderNumber;
import xyz.krevis.learn.dddstart.domain.repository.OrderRepository;
import xyz.krevis.learn.dddstart.exception.OrderNotFoundException;

@RequiredArgsConstructor
public class CancelOrderService {

    private final OrderRepository orderRepository;

    @Transactional // 응용 서비스는 트랜잭션을 관리한다
    public void cancel(OrderNumber number) {

        Order order = findByNumber(number);
        if (order == null) {
            throw new OrderNotFoundException(number);
        }
        order.cancel();
    }

    private Order findByNumber(OrderNumber number) {
        // TODO
        return null;
    }
}
