package com.amtkxa.springbootreladomosimple.domain.entity;

import com.amtkxa.springbootreladomosimple.adapter.view.TransactionView;
import com.amtkxa.springbootreladomosimple.infrastructure.util.DateUtils;

public class Transaction extends TransactionAbstract {
  public Transaction() {
    super();
    // You must not modify this constructor. Mithra calls this internally.
    // You can call this constructor. You can also add new constructors.
  }

  public Transaction(TransactionView transactionView) {
    super();
    this.setAccountId(transactionView.getAccountId());
    this.setTransactionType(transactionView.getTransactionType().toString());
    this.setAmount(transactionView.getAmount());
    this.setProcessingDate(DateUtils.getCurrentTimestamp());
  }
}
