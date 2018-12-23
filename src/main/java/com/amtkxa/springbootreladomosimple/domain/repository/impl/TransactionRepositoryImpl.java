package com.amtkxa.springbootreladomosimple.domain.repository.impl;

import com.amtkxa.springbootreladomosimple.adapter.view.TransactionView;
import com.amtkxa.springbootreladomosimple.domain.entity.Transaction;
import com.amtkxa.springbootreladomosimple.domain.entity.TransactionFinder;
import com.amtkxa.springbootreladomosimple.domain.entity.TransactionList;
import com.amtkxa.springbootreladomosimple.domain.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * {@link TransactionRepository} to retrieve and update transaction data.
 */
@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

  @Override
  public TransactionList findByAccountId(int accountId) {
    return TransactionFinder.findMany(TransactionFinder.accountId().eq(accountId));
  }

  @Override
  public TransactionList create(TransactionView transactionView) {
    Transaction tansaction = new Transaction(transactionView);
    tansaction.insert();
    return new TransactionList(tansaction);
  }
}
