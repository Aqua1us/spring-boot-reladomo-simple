package com.amtkxa.springbootreladomosimple.domain.entity;

import com.gs.fw.finder.Operation;

import java.util.Collection;

public class TransactionList extends TransactionListAbstract {
  public TransactionList() {
    super();
  }

  public TransactionList(Transaction transaction) {
    super();
    this.add(transaction);
  }

  public TransactionList(int initialSize) {
    super(initialSize);
  }

  public TransactionList(Collection c) {
    super(c);
  }

  public TransactionList(Operation operation) {
    super(operation);
  }
}
