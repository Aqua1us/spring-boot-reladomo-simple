package com.amtkxa.springbootreladomosimple.domain.repository.impl;

import com.amtkxa.springbootreladomosimple.adapter.view.CustomerView;
import com.amtkxa.springbootreladomosimple.domain.entity.Customer;
import com.amtkxa.springbootreladomosimple.domain.entity.CustomerFinder;
import com.amtkxa.springbootreladomosimple.domain.entity.CustomerList;
import com.amtkxa.springbootreladomosimple.domain.repository.CustomerRepository;
import com.gs.fw.common.mithra.finder.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * {@link CustomerRepository} to retrieve and update customer data.
 */
@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
  @Override
  public CustomerList findAll() {
    return CustomerFinder.findMany(CustomerFinder.processingDate().equalsInfinity());
  }

  @Override
  public CustomerList findByCustomerId(int customerId) {
    Operation op1 = CustomerFinder.customerId().eq(customerId);
    Operation op2 = CustomerFinder.processingDate().equalsInfinity();
    return CustomerFinder.findMany(op1.and(op2));
  }

  @Override
  public CustomerList create(CustomerView customerView) {
    Customer customer = new Customer(customerView);
    customer.insert();
    return new CustomerList(customer);
  }

  @Override
  public CustomerList update(CustomerView customerView) {
    Operation op1 = CustomerFinder.customerId().eq(customerView.getCustomerId());
    Operation op2 = CustomerFinder.processingDate().equalsInfinity();
    Customer customer = CustomerFinder.findOne(op1.and(op2));
    customer.setName(customerView.getName());
    customer.setCountry(customerView.getCountry());
    return new CustomerList(customer);
  }

  @Override
  public void terminate(int customerId) {
    Operation op1 = CustomerFinder.customerId().eq(customerId);
    Operation op2 = CustomerFinder.processingDate().equalsInfinity();
    Customer customer = CustomerFinder.findOne(op1.and(op2));
    customer.terminate();
  }

}
