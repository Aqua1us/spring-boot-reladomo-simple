package com.amtkxa.springbootreladomosimple.domain.entity;

import com.gs.fw.finder.Operation;

import java.util.Collection;

public class AccountList extends AccountListAbstract {
  public AccountList() {
    super();
  }

  public AccountList(Account account) {
    super();
    this.add(account);
  }

  public AccountList(int initialSize) {
    super(initialSize);
  }

  public AccountList(Collection c) {
    super(c);
  }

  public AccountList(Operation operation) {
    super(operation);
  }
}
