package xyz.krevis.learn.dddstart.domain.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.krevis.learn.dddstart.domain.model.Customer;
import xyz.krevis.learn.dddstart.domain.model.Money;
import xyz.krevis.learn.dddstart.domain.model.OrderLine;
import xyz.krevis.learn.dddstart.domain.repository.CustomerRepository;
import xyz.krevis.learn.dddstart.exception.NoCustomerException;

@Service
@RequiredArgsConstructor
public class CalculateDiscountService {

    private final CustomerRepository customerRepository;

    private final RuleDiscounter ruleDiscounter;

    public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {

        Customer customer = findCustomer(customerId);

        return ruleDiscounter.applyRules(customer, orderLines);
    }

    private Customer findCustomer(String customerId) {

        Customer customer = customerRepository.findById(customerId);
        if (customer == null) {
            throw new NoCustomerException();
        }
        return customer;
    }
}
