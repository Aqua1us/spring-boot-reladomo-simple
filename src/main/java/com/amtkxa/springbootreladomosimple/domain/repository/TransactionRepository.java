package com.amtkxa.springbootreladomosimple.domain.repository;

import com.amtkxa.springbootreladomosimple.adapter.view.TransactionView;
import com.amtkxa.springbootreladomosimple.domain.entity.Transaction;
import com.amtkxa.springbootreladomosimple.domain.entity.TransactionList;

/**
 * Interface that represents a Repository for getting {@link Transaction} related data.
 */
public interface TransactionRepository {

  TransactionList findByAccountId(int accountId);

  TransactionList create(TransactionView transactionView);

}
