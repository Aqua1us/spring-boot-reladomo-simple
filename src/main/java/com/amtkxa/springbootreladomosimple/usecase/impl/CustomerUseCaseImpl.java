package com.amtkxa.springbootreladomosimple.usecase.impl;

import com.amtkxa.springbootreladomosimple.adapter.presenter.impl.CustomerPresenterImpl;
import com.amtkxa.springbootreladomosimple.adapter.view.CustomerView;
import com.amtkxa.springbootreladomosimple.domain.entity.CustomerList;
import com.amtkxa.springbootreladomosimple.domain.repository.impl.AccountRepositoryImpl;
import com.amtkxa.springbootreladomosimple.domain.repository.impl.CustomerRepositoryImpl;
import com.amtkxa.springbootreladomosimple.usecase.CustomerUseCase;
import com.gs.fw.common.mithra.MithraManagerProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerUseCaseImpl implements CustomerUseCase {
  @NonNull private final CustomerRepositoryImpl customerRepositoryImpl;
  @NonNull private final CustomerPresenterImpl customerPresenter;
  @NonNull private final AccountRepositoryImpl accountRepositoryImpl;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends CustomerView> findAll() {
    CustomerList customerList = customerRepositoryImpl.findAll();
    return customerPresenter.response(customerList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends CustomerView> findByCustomerId(int customerId) {
    CustomerList customerList = customerRepositoryImpl.findByCustomerId(customerId);
    return customerPresenter.response(customerList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends CustomerView> create(CustomerView customerView) {
    CustomerList customerList = MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      CustomerList txCustomerList = customerRepositoryImpl.create(customerView);
      return txCustomerList;
    });
    return customerPresenter.response(customerList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends CustomerView> update(CustomerView customerView) {
    CustomerList customerList = MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      CustomerList txCustomerList = customerRepositoryImpl.update(customerView);
      return txCustomerList;
    });
    return customerPresenter.response(customerList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void terminate(int customerId) {
    MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      customerRepositoryImpl.terminate(customerId);
      accountRepositoryImpl.terminate(customerId);
      return null;
    });
  }
}
