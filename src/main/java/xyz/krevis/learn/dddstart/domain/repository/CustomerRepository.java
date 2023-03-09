package xyz.krevis.learn.dddstart.domain.repository;

import xyz.krevis.learn.dddstart.domain.model.Customer;

public interface CustomerRepository {

    Customer findById(String id);
}
