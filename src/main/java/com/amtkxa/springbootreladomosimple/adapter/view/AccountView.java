package com.amtkxa.springbootreladomosimple.adapter.view;

import com.amtkxa.springbootreladomosimple.domain.entity.Account;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountView implements Serializable {
  @ApiModelProperty(value = "Account ID.")
  private int accountId;

  @ApiModelProperty(value = "Customer ID.")
  private int customerId;

  @ApiModelProperty(value = "Customer's balance.")
  private double balance;

  public static AccountView fromAccount(Account account) {
    return AccountView.builder()
        .customerId(account.getCustomerId())
        .balance(account.getBalance())
        .build();
  }
}
