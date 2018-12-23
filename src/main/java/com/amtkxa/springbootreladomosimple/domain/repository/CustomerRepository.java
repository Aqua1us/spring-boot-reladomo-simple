package com.amtkxa.springbootreladomosimple.domain.repository;

import com.amtkxa.springbootreladomosimple.adapter.view.CustomerView;
import com.amtkxa.springbootreladomosimple.domain.entity.Customer;
import com.amtkxa.springbootreladomosimple.domain.entity.CustomerList;

/**
 * Interface that represents a Repository for getting {@link Customer} related data.
 */
public interface CustomerRepository {

  CustomerList findAll();

  CustomerList findByCustomerId(int customerId);

  CustomerList create(CustomerView customerView);

  CustomerList update(CustomerView customerView);

  void terminate(int customerId);
}
