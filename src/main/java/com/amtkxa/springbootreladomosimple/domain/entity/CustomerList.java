package com.amtkxa.springbootreladomosimple.domain.entity;

import com.gs.fw.finder.Operation;

import java.util.Collection;

public class CustomerList extends CustomerListAbstract {
  public CustomerList() {
    super();
  }

  public CustomerList(Customer customer) {
    super();
    this.add(customer);
  }

  public CustomerList(int initialSize) {
    super(initialSize);
  }

  public CustomerList(Collection c) {
    super(c);
  }

  public CustomerList(Operation operation) {
    super(operation);
  }
}
