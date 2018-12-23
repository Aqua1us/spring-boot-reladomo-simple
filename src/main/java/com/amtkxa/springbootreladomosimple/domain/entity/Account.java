package com.amtkxa.springbootreladomosimple.domain.entity;

import com.amtkxa.springbootreladomosimple.adapter.view.AccountView;

import java.sql.Timestamp;

public class Account extends AccountAbstract {
  public Account(Timestamp processingDate) {
    super(processingDate);
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public Account() {
    this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
  }

  public Account(int customerId, double balance) {
    this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
    this.setCustomerId(customerId);
    this.setBalance(balance);
  }

  public Account(AccountView accountView) {
    this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
    this.setCustomerId(accountView.getCustomerId());
    this.setBalance(accountView.getBalance());
  }
}
