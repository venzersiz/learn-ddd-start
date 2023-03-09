package xyz.krevis.learn.dddstart.infrastructure;

import java.util.List;
import xyz.krevis.learn.dddstart.domain.model.Customer;
import xyz.krevis.learn.dddstart.domain.model.Money;
import xyz.krevis.learn.dddstart.domain.model.OrderLine;
import xyz.krevis.learn.dddstart.domain.service.RuleDiscounter;

public class DroolsRuleDiscounter implements RuleDiscounter {

    @Override
    public Money applyRules(Customer customer, List<OrderLine> orderLines) {
        return null;
    }
}
