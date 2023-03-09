package xyz.krevis.learn.dddstart.application.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import xyz.krevis.learn.dddstart.domain.model.Money;
import xyz.krevis.learn.dddstart.domain.model.OrderLine;
import xyz.krevis.learn.dddstart.domain.repository.CustomerRepository;
import xyz.krevis.learn.dddstart.domain.service.CalculateDiscountService;
import xyz.krevis.learn.dddstart.domain.service.RuleDiscounter;
import xyz.krevis.learn.dddstart.exception.NoCustomerException;

class CalculateDiscountServiceTest {

    @Test
    void noCustomer_thenExceptionShouldBeThrown() {
        List<OrderLine> someLines = Arrays.asList(new OrderLine(null, new Money(0), 0));

        // 테스트 목적의 대역 객체
        CustomerRepository stubRepo = mock(CustomerRepository.class);
        when(stubRepo.findById("noCustomerId")).thenReturn(null);

        RuleDiscounter stubRule = (customer, orderLines) -> null;

        // 대용 객체를 주입받아 테스트 진행
        CalculateDiscountService service = new CalculateDiscountService(stubRepo, stubRule);
        assertThrows(NoCustomerException.class, () -> service.calculateDiscount(someLines, "noCustomerId"));
    }
}
