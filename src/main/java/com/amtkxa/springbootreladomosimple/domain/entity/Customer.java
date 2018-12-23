package com.amtkxa.springbootreladomosimple.domain.entity;

import com.amtkxa.springbootreladomosimple.adapter.view.CustomerView;

import java.sql.Timestamp;

public class Customer extends CustomerAbstract {
  public Customer(Timestamp processingDate) {
    super(processingDate);
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public Customer() {
    this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
  }

  public Customer(Timestamp businessDate, String name, String country) {
		this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
    this.setName(name);
    this.setCountry(country);
  }

  public Customer(CustomerView customerView) {
		this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
    this.setName(customerView.getName());
    this.setCountry(customerView.getCountry());
  }
}
