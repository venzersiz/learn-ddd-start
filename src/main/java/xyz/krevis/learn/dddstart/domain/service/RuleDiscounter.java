package xyz.krevis.learn.dddstart.domain.service;

import java.util.List;
import xyz.krevis.learn.dddstart.domain.model.Customer;
import xyz.krevis.learn.dddstart.domain.model.Money;
import xyz.krevis.learn.dddstart.domain.model.OrderLine;

public interface RuleDiscounter {

    Money applyRules(Customer customer, List<OrderLine> orderLines);
}
