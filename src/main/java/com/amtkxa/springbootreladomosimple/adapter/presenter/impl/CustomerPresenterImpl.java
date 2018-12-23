package com.amtkxa.springbootreladomosimple.adapter.presenter.impl;

import com.amtkxa.springbootreladomosimple.adapter.presenter.CustomerPresenter;
import com.amtkxa.springbootreladomosimple.adapter.view.CustomerView;
import com.amtkxa.springbootreladomosimple.domain.entity.CustomerList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerPresenterImpl implements CustomerPresenter {
  /** {@inheritDoc} */
  public List<? extends CustomerView> response(CustomerList customerList) {
    return customerList
        .stream()
        .filter(c -> c != null)
        .map(c -> CustomerView.fromCustomer(c))
        .collect(Collectors.toList());
  }
}
