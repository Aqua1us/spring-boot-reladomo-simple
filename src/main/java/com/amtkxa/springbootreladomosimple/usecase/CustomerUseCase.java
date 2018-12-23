package com.amtkxa.springbootreladomosimple.usecase;

import com.amtkxa.springbootreladomosimple.adapter.view.CustomerView;

import java.util.List;

public interface CustomerUseCase {

  /**
   * Retrieve all customer.
   *
   * @return list of CustomerView
   */
  List<? extends CustomerView> findAll();

  /**
   * Retrieve a customer with a customerId.
   *
   * @parm customerId
   * @return list of CustomerView
   */
  List<? extends CustomerView> findByCustomerId(int customerId);

  /**
   * Create a customer.
   *
   * @parm customerView
   * @return list of CustomerView
   */
  List<? extends CustomerView> create(CustomerView customerView);

  /**
   * Update a customer.
   *
   * @parm customerView
   * @return list of CustomerView
   */
  List<? extends CustomerView> update(CustomerView customerView);

  /**
   * Terminate a customer and customers all accounts.
   *
   * @parm customerId
   */
  void terminate(int customerId);
}
